package com.example.registrationandlogin.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.graphics.rotationMatrix
import androidx.fragment.app.Fragment
import com.example.registrationandlogin.R
import kotlinx.android.synthetic.main.fragment_dice.*

class DiceFragment: Fragment(R.layout.fragment_dice) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onDiceButtonTap()
    }

    public fun onDiceButtonTap() {
        DiceRollButton.setOnClickListener {
            val RandomNumber=(1..6).random()

            if(RandomNumber==1){
                DiceRoll(R.drawable.ic_dice1, "ONE")
            }
            else if (RandomNumber==2){
                DiceRoll(R.drawable.ic_dice2, "TWO")
            }
            else if (RandomNumber==3){
                DiceRoll(R.drawable.ic_dice3, "THREE")
            }
            else if (RandomNumber==4){
                DiceRoll(R.drawable.ic_dice4, "FOUR")
            }
            else if (RandomNumber==5){
                DiceRoll(R.drawable.ic_dice5, "FIVE")
            }
            else{
                DiceRoll(R.drawable.ic_dice6, "SIX")
            }

        }
    }

    private fun DiceRoll(imageId:Int, diceSide: String)= DiceView.animate().apply {
        var direction:Boolean=true
        if(direction) {
            duration = 1000
            rotationYBy(720f)
            direction=false
        }

       if(!direction) {
           duration = 1000
           rotationXBy(360f)
           direction=true
       }



        DiceRollButton.isClickable=false

    }.withEndAction{
        DiceView.setImageResource(imageId)
        Toast.makeText(requireContext(),diceSide ,Toast.LENGTH_SHORT).show()
        DiceRollButton.isClickable=true

    }.start()

}
