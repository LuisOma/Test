package com.meta.graphqlTest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meta.graphqlTest.ui.view.launches.LaunchesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LaunchesFragment())
                .commitNow()
        }
    }
}