package com.lunathemes.travelnews

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import com.lunathemes.travelnews.R
import com.lunathemes.travelnews.ui.PlacesFragment
import com.lunathemes.travelnews.ui.NewsFragment
import com.lunathemes.travelnews.ui.WishlistFragment
import androidx.core.view.GravityCompat

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var drawer: DrawerLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawer = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        //drawer.addDrawerListener(toggle)
        toggle.syncState()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                PlacesFragment()
            ).commit()
            navigationView.setCheckedItem(R.id.nav_places)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_places -> supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                PlacesFragment()
            ).commit()
            R.id.nav_news -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    NewsFragment()
                ).commit()
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    WishlistFragment()
                ).commit()
            }
            R.id.nav_wishlist -> supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                WishlistFragment()
            ).commit()
        }
        drawer!!.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer!!.isDrawerOpen(GravityCompat.START)) {
            drawer!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}