package ir.fbscodes.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainViewModel = MainViewModel()
        mainViewModel.getStudentsLiveData().observe(this
        ) {
            println(it)
        }

        mainViewModel.getErrorLiveData().observe(this) {
            println(it)
        }
    }
}
