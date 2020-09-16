package cmps312.lab.qatar2022

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cmps312.lab.qatar2022.model.StadiumRepository
import com.example.qatar2022.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_stadium.*

class MainActivity : AppCompatActivity() {
    var currentIndex = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StadiumRepository.initStadiums(this)
        displayStadium()

        nextBtn.setOnClickListener {
            currentIndex++
            displayStadium()
        }

        prevBtn.setOnClickListener {
            currentIndex--
            displayStadium()
        }
    }


    fun displayStadium() {
        StadiumRepository.apply {

            currentIndex = (currentIndex + stadiums.size) % stadiums.size //java+c++

            nameTv.text = stadiums[currentIndex].name
            cityTv.text = stadiums[currentIndex].city
            statusTv.text = stadiums[currentIndex].status

            val imageName = stadiums[currentIndex].imageName
            val imageId = resources.getIdentifier(imageName, "drawable", packageName)
            stadiumIv.setImageResource(imageId)

            currentIndexTv.text = "${currentIndex + 1} of ${stadiums.size}"
        }

    }


}