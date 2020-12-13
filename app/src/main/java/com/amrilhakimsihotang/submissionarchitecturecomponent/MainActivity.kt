package com.amrilhakimsihotang.submissionarchitecturecomponent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.amrilhakimsihotang.submissionarchitecturecomponent.databinding.ActivityMainBinding
import com.amrilhakimsihotang.submissionarchitecturecomponent.ui.main.SectionPagerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        val toolbar: Toolbar = activityMainBinding.toolbar
        setSupportActionBar(toolbar)
        viewPagerAll()


        //kirim email
         activityMainBinding.fab.setOnClickListener {
            val eBody: String = resources.getString(R.string.body)
            val eSubject: String = resources.getString(R.string.subject)
            val eAddress: String = resources.getString(R.string.email)
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:" + eAddress)
                putExtra(Intent.EXTRA_SUBJECT, eSubject)
                putExtra(Intent.EXTRA_TEXT, eBody)
            }
            startActivity(Intent.createChooser(emailIntent, R.string.title.toString()))
        }//akhir kirim email

    }

    private fun viewPagerAll() {
        //aktifkan tablayout
        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        activityMainBinding.viewpager.adapter = sectionPagerAdapter
        activityMainBinding.tabs.setupWithViewPager(activityMainBinding.viewpager)
        supportActionBar?.elevation = 0f
        //akhir tablayout
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(itemId: Int) {
        when (itemId) {
            R.id.change_language -> {
                val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
                startActivity(mIntent)
            }
        }
    }
}