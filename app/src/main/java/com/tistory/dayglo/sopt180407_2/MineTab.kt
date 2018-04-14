package com.tistory.dayglo.sopt180407_2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_mine_tab.*
import kotlinx.android.synthetic.main.fragment_mine_tab.view.*

/**
 * Created by user on 2018-04-07.
 */
class MineTab : Fragment(), View.OnClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_mine_tab, container, false)

        addFragment(MyAllFragment())

        clearSelected(inflater, container)
        v.ib_mine_all.isSelected = true

        v.ib_mine_all.setOnClickListener(this)
        v.ib_mine_list.setOnClickListener(this)
        v.ib_mine_tag.setOnClickListener(this)
        v.ib_mine_save.setOnClickListener(this)

        return v
    }

    override fun onClick(v: View?) {
        when(v) {
            ib_mine_all -> {

                ib_mine_all.isSelected = true
                replaceFragment(MyAllFragment())
            }
            ib_mine_list -> {

                ib_mine_list.isSelected = true
                replaceFragment(MyListFragment())
            }
            ib_mine_tag -> {

                ib_mine_tag.isSelected = true
                replaceFragment(MyTagFragment())
            }
            ib_mine_save -> {

                ib_mine_save.isSelected = true
                replaceFragment(MyNewsFragment())
            }
        }
    }


    fun addFragment(mFragment: Fragment) {
        val fm = activity.supportFragmentManager
        val mTransaction = fm.beginTransaction()

        mTransaction.add(R.id.mine_fragment, mFragment)
        mTransaction.addToBackStack(null)
        mTransaction.commit()
    }

    fun replaceFragment(mFragment: Fragment) {
        val fm = activity.supportFragmentManager
        val mTransaction = fm.beginTransaction()

        mTransaction.replace(R.id.mine_fragment, mFragment)
        mTransaction.commit()
    }

    fun clearSelected(inflater: LayoutInflater, container: ViewGroup?){
        val v = inflater.inflate(R.layout.fragment_mine_tab, container, false)

        v.ib_mine_all.isSelected = false
        v.ib_mine_list.isSelected = false
        v.ib_mine_tag.isSelected = false
        v.ib_mine_save.isSelected = false
    }
}