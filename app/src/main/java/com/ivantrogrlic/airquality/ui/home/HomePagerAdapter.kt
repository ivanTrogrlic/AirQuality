package com.ivantrogrlic.airquality.ui.home

import android.app.Fragment
import android.app.FragmentManager
import android.support.v13.app.FragmentPagerAdapter
import com.ivantrogrlic.airquality.ui.cities.CitiesFragment


/**
 * Created by ivan on 8/23/2017.
 */

class HomePagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int = 1

    override fun getItem(position: Int): Fragment? =
            when (position) {
                0 -> CitiesFragment()

                else -> throw IllegalStateException("Invalid fragment position")
            }

}
