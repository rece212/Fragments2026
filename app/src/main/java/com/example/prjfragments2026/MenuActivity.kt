package com.example.prjfragments2026

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private val Frag1 = FirstFragment()
private val Frag2 = SecondFragment()
private val Frag3 = DuckFragment()
class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        replaceFrag(Frag3)
        val bottomBar =findViewById<BottomNavigationView>(R.id.NavBar)
        bottomBar.setOnItemSelectedListener {
            when (it.itemId)
            {
                R.id.ic_home->replaceFrag(Frag3)
                R.id.ic_setting->replaceFrag(Frag2)
                R.id.ic_duck->replaceFrag(Frag1)
            }
            true
        }

    }
    private fun replaceFrag(fragment: Fragment)
    {
        if(fragment!=null)
        {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout,fragment)
            transaction.commit()
        }
    }
}