package com.example.artbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private  lateinit var binding : ActivityMainBinding
   private  lateinit var list : MutableList<Art>
   private  lateinit var  adapter : ArtAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList<Art>()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
         adapter = ArtAdapter(list)
        binding.recyclerView.adapter =adapter


//        binding.helelik.setOnClickListener {
          try {
              val DB = this.openOrCreateDatabase("MyDatabase", MODE_PRIVATE,null)
              Log.e("ILK setir","Ilk")
              var cursor = DB.rawQuery("SELECT * from arts ", null)
              Log.e("Ikinci setir","IKINCI")
              Log.e("TAG" ,"Is database open : ${DB.isOpen}")
              var nameIx = cursor.getColumnIndex("artName")
              Log.e("Index","$nameIx")

              var idIx = cursor.getColumnIndex("id")



             while (cursor.moveToNext()) {
                 var name = cursor.getString(nameIx)
                 var id = cursor.getInt(idIx)
                 val item = Art(name,id)
                 list.add(item)
                Log.e("TAG","Databasedeki adi beledi : $name")
              }
              adapter.notifyDataSetChanged()

          } catch (e:Exception) {
              e.printStackTrace()
          }
//        }
//
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.art_item){
            val intent = Intent(this,ArtActivity::class.java)
            intent.putExtra("create", "create")
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

}