package com.tistory.dayglo.sopt180407_2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by user on 2018-04-07.
 */
class MineTab : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        addFragment(MyAllFragment())

        return inflater.inflate(R.layout.fragment_mine_tab, container, false)
    }

    fun addFragment(mFragment: Fragment) {
        val fm = fragmentManager
        val mTransaction = fm.beginTransaction()

        mTransaction.add(R.id.mine_fragment, mFragment)
        mTransaction.addToBackStack(null)
        mTransaction.commit()
    }
}