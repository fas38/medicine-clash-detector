package com.example.mint.mcdone

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.mint.mcdone.fragment.AddMedicineFragment
import com.example.mint.mcdone.fragment.EditProfileFragment
import com.example.mint.mcdone.fragment.UserHomeFragment
import com.example.mint.mcdone.util.FirestoreUtil
import com.example.mint.mcdone.util.replaceFragmenty
import com.firebase.ui.auth.AuthUI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.nav_header_main.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask

//import com.google.firebase.auth.FirebaseAuth
//import android.widget.Toast

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        setNavbarUsername()

        replaceFragmenty(
                fragment = UserHomeFragment(),
                allowStateLoss = true,
                containerViewId = R.id.mainContent
        )
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
//                replaceFragment(UserHomeFragment())
//                var name : String?
//
//                FirestoreUtil.getCurrentUser {
//                    name = it?.name
//                    user_name_navbar.setText(name)
//                }

                replaceFragmenty(
                        fragment = UserHomeFragment(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
//                setTitle("Import")
            }
            R.id.nav_edit_profile -> {
                // Handle the item
//                sample_text.setText("Edit is pressed")
                replaceFragmenty(
                        fragment = EditProfileFragment(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )

            }
            R.id.nav_add_medicine-> {
                replaceFragmenty(
                        fragment = AddMedicineFragment(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
            }
            R.id.nav_remove_medicine -> {
                // Handle the item
            }
            R.id.nav_show_medicine -> {
                val intent = Intent(this@MainActivity, ShowMedicineListActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_status -> {
                // Handle the item
            }
            R.id.nav_delete_account -> {
                // Handle the item
            }
            R.id.nav_logout -> {
                AuthUI.getInstance()
                        .signOut(this@MainActivity)
                        .addOnCompleteListener{
                            startActivity(intentFor<SignInActivity>().newTask().clearTask())
                        }
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun setNavbarUsername(){
        var name : String?
        FirestoreUtil.getCurrentUser {
            name = it?.name
            user_name_navbar.setText(name)
        }
    }

}

