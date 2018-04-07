package com.tistory.dayglo.sopt180407_2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    var mImage : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        mImage = intent.getIntExtra("add_image", 0) // main에서 지정한 key값
        add_image.setImageResource(mImage)
    }
}
