package com.tistory.dayglo.sopt180407_2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home_tab.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // 개쩐다!
    override fun onClick(v: View?) {
        when(v) {
            btn_main_home -> {
                clearSelected()
                btn_main_home.isSelected = true
                replaceFragment(HomeTab())
            }
            btn_main_mine -> {
                clearSelected()
                btn_main_mine.isSelected = true
                replaceFragment(MineTab())
            }
            btn_main_add -> {
                clearSelected()
                btn_main_add.isSelected = true

                val mIntent = Intent(applicationContext, AddActivity::class.java)
                mIntent.putExtra("add_image", R.drawable.add_image) // key : value
                startActivity(mIntent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(HomeTab()) // == addFragment(new HomeTab())

        clearSelected()
        btn_main_home.isSelected = true
//        방법1
//        btn_main_home.setOnClickListener {
//            replaceFragment(HomeTab())
//        }
//
//        btn_main_mine.setOnClickListener {
//            replaceFragment(MineTab())
//        }

//        방법2
        btn_main_home.setOnClickListener(this) // 이 액티비티에 정의된 onClick 메소드를 사용하겠다!
        btn_main_mine.setOnClickListener(this)
        btn_main_add.setOnClickListener(this)
    }

    // 프래그먼트 적용
    fun addFragment(mFragment: Fragment) {  // Unit == void, 생략 가능
        val fm = supportFragmentManager
        val mTransaction = fm.beginTransaction()

        mTransaction.add(R.id.main_frame_layout, mFragment)
        mTransaction.addToBackStack(null)
        mTransaction.commit()
    }

    fun replaceFragment(mFragment: Fragment) {
        val fm = supportFragmentManager
        val mTransaction = fm.beginTransaction()

        mTransaction.replace(R.id.main_frame_layout, mFragment)
        mTransaction.commit()
    }

    fun clearSelected(){
        btn_main_home.isSelected = false
        btn_main_add.isSelected = false
        btn_main_search.isSelected = false
        btn_main_news.isSelected = false
        btn_main_mine.isSelected = false
    }
}
