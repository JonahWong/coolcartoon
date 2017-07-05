package tarena.com.coolcartoon.extension

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

/**
 * Created by jonah on 03/07/2017.
 */
class Extension {
    fun AppCompatActivity.replaceFragment(containerId: Int, tag: String, args: Bundle? = null) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(containerId, Fragment.instantiate(this, tag, args))
        transaction.commit()
    }

    fun AppCompatActivity.replaceFragment(action: () -> Unit) {
        val transaction = supportFragmentManager.beginTransaction()
        action()
        transaction.commit()
    }
}