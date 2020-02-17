package com.msad.mysimplenotewear

import android.content.Context
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAmbientEnabled()
        val sharedPreferences = this.getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val a: String? = sharedPreferences.getString("note", "")
        editText.setText(a)
    }

    override fun onPause() {
        super.onPause()
        val sharedPreferences = this.getSharedPreferences(packageName, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("note", editText.text.toString()).apply()
    }
}
