package com.ddt.gitrepomanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    private val actionBar: ActionBar? = null
    var previousMenuItem: MenuItem? = null
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.nav_view)

        initToolbar()
        initNavigationMenu()

    }
    private fun initNavigationMenu() {
        val nav_view = findViewById<View>(R.id.nav_view) as NavigationView
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout

        val view: View = nav_view.getHeaderView(0)

        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener {

            if (previousMenuItem != null) {
                previousMenuItem?.isChecked = false
            }

            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

//            when (it.itemId) {
//                R.id.nav_home -> {
//                    openDashboard()
//                    drawer.closeDrawers()
//                }
//                R.id.nav_profile -> {
//                    openProfile()
//                    drawer.closeDrawers()
//                }
//                R.id.nav_favourite -> {
//                    openFavourite()
//                    drawer.closeDrawers()
//                }
//                R.id.nav_orderHistory -> {
//                    openOrderHistory()
//                    drawer.closeDrawers()
//                }
//                R.id.nav_faq -> {
//                    openFaq()
//                    drawer.closeDrawers()
//                }
//                R.id.nav_logout -> {
//                    openLogout()
//                    drawer.closeDrawers()
//                }
//
//
//            }

            true
        }

        // open drawer at start
//        drawer.openDrawer(GravityCompat.START)
    }
    private fun initToolbar() {
        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeButtonEnabled(true)
        actionBar.title = "Git Repo Manager"
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_add_24)
        // display icon in the toolbar
    }

}