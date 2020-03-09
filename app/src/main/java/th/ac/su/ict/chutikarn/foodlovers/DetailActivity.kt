package th.ac.su.ict.chutikarn.foodlovers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val cocktailName = intent.getStringExtra("cocktailName")
        val description = intent.getStringExtra("description")
        val cocktailFile = intent.getStringExtra("cocktailFile")
        val place = intent.getStringExtra("place")
        val price = intent.getStringExtra("price")
        cockName.setText(cocktailName)

        cost.setText(price)
        des.setText(description)

        val res = resources
        val drawableId:Int = res.getIdentifier(cocktailFile,"drawable",packageName)

        picCock.setImageResource(drawableId)



    }
}
