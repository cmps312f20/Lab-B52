package cmps312.lab.coroutinesexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var job : Job
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn.setOnClickListener {
            job = CoroutineScope(Dispatchers.IO).launch {
                val j = async { jump() }.await()
                val r = async { run() }.await()
                val p = async { playDead() }.await()

                Log.d(TAG, "Jumping is completed: $j")
                Log.d(TAG, "Runnning is completed: $r")
                Log.d(TAG, "Playing Dead is completed: $p")
            }
        }
        Log.d(TAG, "mainthread Thread Name ${Thread.currentThread().name}")

        stopBtn.setOnClickListener {
            job.cancel()
        }
    }

    override fun onPause() {
        finish();§
        super.onPause()
    }

    suspend fun jump() = withContext(Dispatchers.IO) {
        repeat(1000) {
            val imageId = resources.getIdentifier("jump${it % 12 + 1}", "drawable", packageName)
            jumpImg.setImageResource(imageId)

//            delay(10)
//            Log.d(TAG, "jump: ")
        }
    }

    suspend fun run() = withContext(Dispatchers.IO) {
        repeat(1000) {
            val imageId = resources.getIdentifier("run${it % 8 + 1}", "drawable", packageName)
            withContext(Dispatchers.Main) {
                runImg.setImageResource(imageId)
            }
//            delay(10)
//            Log.d(TAG, "run: ")
        }
    }

    suspend fun playDead() = withContext(Dispatchers.IO) {
        repeat(1000) {
            val imageId = resources.getIdentifier("dead${it % 8 + 1}", "drawable", packageName)
            withContext(Dispatchers.Main) {
                deadImg.setImageResource(imageId)
            }
//            delay(50)
//            Log.d(TAG, "playDead: ")
        }
    }
}


/*
 val imageID = resources.getIdentifier("nameOfImage", "drawable", packageName)
 */