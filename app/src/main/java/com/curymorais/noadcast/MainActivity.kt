package com.curymorais.noadcast

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.curymorais.noadcast.videocast.VideoCastFragment
import com.example.noadcast.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contract.View, View.OnClickListener {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initComponents()
        setComponentListeners()
    }

    override fun initComponents() {
        var frag = VideoCastFragment()
        loadFragment(frag)
    }

    private fun loadFragment(fragment : Fragment?) : Boolean{
        if (fragment != null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
            return  true
        }
        return false
    }

    override fun onClick(v: View?) {
        when(v?.id){
            fab.id -> Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()

        }
    }

    override fun setComponentListeners() {
        fab.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
