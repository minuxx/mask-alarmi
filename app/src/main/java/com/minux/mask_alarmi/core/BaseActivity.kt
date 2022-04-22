package com.minux.mask_alarmi.core

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B: ViewDataBinding>(@LayoutRes val layoutRes: Int): AppCompatActivity() {
    lateinit var binding: B
    private lateinit var imm : InputMethodManager

    abstract fun initDataBinding()
    abstract fun initAfterBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutRes)
        imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        initDataBinding()
        initAfterBinding()
    }

    open fun startNextActivity(activity: Class<*>?) {
        val intent = Intent(this, activity)
        startActivity(intent)
    }

    open fun startActivityWithClear(activity: Class<*>?) {
        val intent = Intent(this, activity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    fun hideKeyboard(v: View) {
        imm.hideSoftInputFromWindow(v.windowToken, 0)
    }
}