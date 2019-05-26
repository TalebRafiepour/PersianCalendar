package com.taleb.iraniancalendar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.taleb.jalalicalendar.PersianCalendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar = PersianCalendar()
        val time = calendar.persianShortDateTime
        val date = calendar.persianShortDate
    }
}
