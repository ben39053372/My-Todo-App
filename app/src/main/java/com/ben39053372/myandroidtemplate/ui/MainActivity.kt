package com.ben39053372.myandroidtemplate.ui

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.ben39053372.myandroidtemplate.R
import com.ben39053372.myandroidtemplate.utils.BaseActivity
import com.google.android.material.navigation.NavigationView
import timber.log.Timber

class MainActivity : BaseActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var toolbar: Toolbar

    // region Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        // for splash screen
        setupOnPreDrawListener()

        setContentView(R.layout.activity_main)

        // region define component
        toolbar = findViewById(R.id.my_toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        drawerLayout = findViewById(R.id.drawer_layout)
        // endregion

        // setup navigation ui
        setupNavigationUI()

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        actionBarDrawerToggle.syncState()
    }
    //endregions

    //region functions
    /**
     * setup drawer and toolbar
     */
    private fun setupNavigationUI() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        navigationView.setupWithNavController(navController)

        // set Toolbar to ActionBar
        // ** must before set actionBarDrawerToggle
        setSupportActionBar(toolbar)

        // ** must after setSupportActionBar
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
    }

    private fun setupOnPreDrawListener() {
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                val num = 5
                var curr = 0
                override fun onPreDraw(): Boolean {
                    return if(curr < num) {
                        curr++
                        Timber.d("curr++")
                        Thread.sleep(500)
                        false
                    } else {
                        true
                    }
                }
            }
        )
    }

    private fun preLoadingData() {

    }

    //endregion

}