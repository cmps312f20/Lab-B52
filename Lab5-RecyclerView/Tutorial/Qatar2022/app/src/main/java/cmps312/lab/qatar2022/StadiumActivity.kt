package cmps312.lab.qatar2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import cmps312.lab.qatar2022.adapter.StadiumAdapter
import cmps312.lab.qatar2022.model.StadiumRepository
import com.example.qatar2022.R
import kotlinx.android.synthetic.main.activity_stadium.*


class StadiumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stadium)

        StadiumRepository.initStadiums(this)

        stadiumsRv.apply {
            adapter = StadiumAdapter(StadiumRepository.stadiums, context)
            layoutManager = LinearLayoutManager(context)
        }
    }
}