package cmps312.lab.coroutinesexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity_"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn.setOnClickListener {
            GlobalScope.launch {
                jump()
                Log.d(TAG, "Coroutine Thread Name ${Thread.currentThread().name}")
            }
        }
        Log.d(TAG, "mainthread Thread Name ${Thread.currentThread().name}")
    }
    fun jump(){
        repeat(1000){
            val imageId = resources.getIdentifier("jump${it%12+1}" , "drawable" , packageName)
            jumpImg.setImageResource(imageId)
        }
    }

    fun run(){
        repeat(1000){
            val imageId = resources.getIdentifier("jump${it%12+1}" , "drawable" , packageName)
            jumpImg.setImageResource(imageId)
        }
    }

    fun playDead(){
        repeat(1000){
            val imageId = resources.getIdentifier("jump${it%12+1}" , "drawable" , packageName)
            jumpImg.setImageResource(imageId)
        }
    }
}



/*
 val imageID = resources.getIdentifier("nameOfImage", "drawable", packageName)
 */