package com.example.artbook

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.artbook.databinding.ActivityArtBinding
import com.google.android.material.snackbar.Snackbar
import java.io.ByteArrayOutputStream

class ArtActivity : AppCompatActivity() {

    lateinit var binding : ActivityArtBinding
    lateinit var activityResultLauncher : ActivityResultLauncher<Intent>
    lateinit var permissionLauncher : ActivityResultLauncher<String>
    var selectedBitmap : Bitmap? =  null
    private  lateinit var database : SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding =  ActivityArtBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerLauncher()


        val intent = intent

        if(intent.getStringExtra("old").equals("old")) {
            binding.button.visibility = View.INVISIBLE
            val id = intent.getIntExtra("id",1)
            println("ID BELEDI  ----->   $id")
            database = this.openOrCreateDatabase("MyDatabase", MODE_PRIVATE,null)
            println("ARRAY ID :  ${ arrayOf(id.toString())}")


            val cursor = database.rawQuery("SELECT * FROM arts WHERE id = ?", arrayOf(id.toString()))

            val artNameIx = cursor.getColumnIndex("artName")
            val artistNameIx = cursor.getColumnIndex("artistName")
            val yearIx = cursor.getColumnIndex("year")
            val imageIx = cursor.getColumnIndex("image")

            while (cursor.moveToNext()) {
                val byteArray =  cursor.getBlob(imageIx)
                var bitmap = BitmapFactory.decodeByteArray(byteArray,0,byteArray.size)
                binding.apply {
                    imageView.setImageBitmap(bitmap)
                    artName.setText( cursor.getString(artNameIx))
                    artistName.setText(cursor.getString(artistNameIx))
                    year.setText(cursor.getString(yearIx))

                }
            }
            cursor.close()

        }
        else {

        }


        binding.button.setOnClickListener {
            saveOnClick()
        }

    }

    fun saveOnClick () {

        val artName = binding.artName.text.toString()
        val artistName = binding.artistName.text.toString()
        val year = binding.year.text.toString()

        if(selectedBitmap != null) {
            val scaledBitmap = makeSmallerBitmap(selectedBitmap!!,300)

            val outputsream = ByteArrayOutputStream()
            scaledBitmap.compress( Bitmap.CompressFormat.PNG ,50,outputsream )
            val byteArray = outputsream.toByteArray()

            try {

                val mydatabase = this.openOrCreateDatabase("MyDatabase", MODE_PRIVATE,null)
                mydatabase.execSQL("CREATE TABLE IF NOT EXISTS  arts " +
                        "(id INTEGER PRIMARY KEY, artName VARCHAR ,artistName VARCHAR , year VARCHAR , image BLOB)")

            var stringSQL = "INSERT INTO arts (artName,artistName,year,image) VALUES ( ?, ? , ? ,?)"
                var statement = mydatabase.compileStatement(stringSQL)
                statement.bindString(1,artName)
                statement.bindString(2,artistName)
                statement.bindString(3,year)
                statement.bindBlob(4,byteArray)
                statement.execute()

            } catch ( e : Exception) {
                e.printStackTrace()
            }

            val intent  = Intent(this,MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

    }

    fun imageOnClick (view : View) {
        if (ContextCompat.checkSelfPermission(
                this,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)) {
                 Snackbar.make(view,"Permission needed for gallery",Snackbar.LENGTH_INDEFINITE).setAction("Give permission", View.OnClickListener {
                     permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                 }).show()
            }
            else {
                permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }


        }else {
            val intentToGallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            activityResultLauncher.launch(intentToGallery)
        }
    }



    fun registerLauncher (){
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->

            if(result.resultCode == RESULT_OK){
                  var intentFromResult = result.data
                if(intentFromResult !=null) {
                    val imageData = intentFromResult.data
                    if(imageData!= null){


                        try {
                            if(Build.VERSION.SDK_INT >= 28) {
                                val source = ImageDecoder.createSource(contentResolver, imageData)
                                selectedBitmap =  ImageDecoder.decodeBitmap(source)
                                binding.imageView.setImageBitmap(selectedBitmap)
                            }
                            else {
                                selectedBitmap= MediaStore.Images.Media.getBitmap(contentResolver,imageData)
                                binding.imageView.setImageBitmap(selectedBitmap)
                            }

                        }catch (e : Exception){
                            e.printStackTrace()
                        }

                    }

                }
            }

        }

        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            result->
            if(result){
                val intentToGallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToGallery)
            }else {
                 Toast.makeText(this,"Permission required",Toast.LENGTH_SHORT).show()
            }
        }

    }


    private fun makeSmallerBitmap (bitmap : Bitmap , maximumSize : Int) : Bitmap{

        var width = bitmap.width
        var height = bitmap.height

        val bitmapRatio = width.toDouble() / height.toDouble()

        if(bitmapRatio > 1){
            width =  maximumSize
            val scaledHeight = width / bitmapRatio
            height = scaledHeight.toInt()
        }else {
            height = maximumSize
            val scaledWidth = height * bitmapRatio
            width = scaledWidth.toInt()
        }

        return Bitmap.createScaledBitmap(bitmap,width,height,true)
    }

}