package aliabbas.com.scalablecodebaseapp.ui.activity

import aliabbas.com.scalablecodebaseapp.R
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

class HomeActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}