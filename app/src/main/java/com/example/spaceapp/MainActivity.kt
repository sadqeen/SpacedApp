package com.example.spaceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.spaceapp.base.BaseActivity
import com.example.spaceapp.databinding.ActivityMainBinding
import com.example.spaceapp.ui.HomeFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(HomeFragment(), HomeFragment::class.simpleName!!)

    }


    private fun replaceFragment(fragment: Fragment, tag: String) {
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainContainer, fragment)
        transaction.commit()

    }
}