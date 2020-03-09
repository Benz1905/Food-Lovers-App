package th.ac.su.ict.chutikarn.foodlovers
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.ict.chutikarn.foodlovers.Utils.getJsonDataFromAsset
import th.ac.su.ict.chutikarn.foodlovers.data.cocktail
import th.ac.su.ict.chutikarn.foodlovers.data.cocktailAdapter

class MainActivity : AppCompatActivity() {

    var itemList:ArrayList<cocktail> = ArrayList<cocktail>()
    lateinit var arrayAdapter: ArrayAdapter<cocktail>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext,"cocktail.json")
        Log.i("data",jsonFileString)


        val gson = Gson()
        val listItemType = object: TypeToken<ArrayList<cocktail>>(){}.type
        var cocktailist:  ArrayList<cocktail> = gson.fromJson(jsonFileString,listItemType)

        itemList = cocktailist

        val adapter = cocktailAdapter(this@MainActivity,itemList)

        list_itemView.adapter = adapter


        list_itemView.setOnItemClickListener { parent, view, position, id ->

            var intent = Intent(this@MainActivity,DetailActivity::class.java)    //ต้นทางไปปลายททาง
            intent.putExtra("cocktailName",itemList[position].cocktailName)
            intent.putExtra("description",itemList[position].description)
            intent.putExtra("cocktailFile",itemList[position].cocktailFile)
            intent.putExtra("price",itemList[position].price)
            intent.putExtra("price",itemList[position]. price)



            startActivity(intent)   //ส่งค่า
        }








    }



}
