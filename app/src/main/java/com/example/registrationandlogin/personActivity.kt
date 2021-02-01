package com.example.registrationandlogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.registrationandlogin.Fragments.CoinFragment
import com.example.registrationandlogin.Fragments.DiceFragment
import com.example.registrationandlogin.Fragments.RockPaperScissorsFragment
import kotlinx.android.synthetic.main.activity_person.*

class personActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)


        val firstFragment=CoinFragment()
        val secondFragment=DiceFragment()
        val thirdFragment=RockPaperScissorsFragment()

        setCurrentFragment(firstFragment)

        nav_view.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.coin_flip->setCurrentFragment(firstFragment)
                R.id.dice_roll->setCurrentFragment(secondFragment)
                R.id.rock_paper_sc->setCurrentFragment(thirdFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment,fragment)
            commit()
        }
}