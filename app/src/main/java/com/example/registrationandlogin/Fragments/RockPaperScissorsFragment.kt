package com.example.registrationandlogin.Fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.ViewCompat.animate
import androidx.fragment.app.Fragment
import com.example.registrationandlogin.R
import kotlinx.android.synthetic.main.fragment_coin.*
import kotlinx.android.synthetic.main.fragment_dice.*
import kotlinx.android.synthetic.main.fragment_rockpapersc.*
import java.util.*

class RockPaperScissorsFragment: Fragment(R.layout.fragment_rockpapersc) {
    val choices = Array(3){"rock"; "paper";"scissors"}
    var RoundEnd:Boolean=false
    lateinit var playerChoice:String
    lateinit var winner:String


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        game()
        reset()
    }
// *********************************************************შესასწორებელია მარტო მაკრატელი გამოაქვს**************************************************************
    fun game()= imageView.animate().apply {
        if(!RoundEnd){
            RockButton.setOnClickListener{
                RockButton.isClickable=false
                PaperButton.isClickable=false
                ScissorsButton.isClickable=false
                battle("rock")
            }

            PaperButton.setOnClickListener{
                RockButton.isClickable=false
                PaperButton.isClickable=false
                ScissorsButton.isClickable=false
                battle("paper")
            }

            ScissorsButton.setOnClickListener{
                RockButton.isClickable=false
                PaperButton.isClickable=false
                ScissorsButton.isClickable=false
                battle("scissors")
            }
        }

    }

    private fun battle(Choice:String){
        playerChoice=Choice
        var programChoice:String = choices.random()

        if(playerChoice=="rock" && programChoice == "paper"){
            animation(R.drawable.ic_paper)
            Toast.makeText(requireContext(),"Winner is:$programChoice", Toast.LENGTH_SHORT).show()
            RoundEnd=true
        }
        else if(playerChoice=="rock" && programChoice == "scissors"){
            animation(R.drawable.ic_scissors)
            Toast.makeText(requireContext(),"Winner is:$playerChoice", Toast.LENGTH_SHORT).show()
            RoundEnd=true
        }
        else if(playerChoice=="scissors" && programChoice == "rock"){
            animation(R.drawable.ic_rock)
            Toast.makeText(requireContext(),"Winner is:$programChoice", Toast.LENGTH_SHORT).show()
            RoundEnd=true
        }
        else if(playerChoice=="scissors" && programChoice == "paper"){
            animation(R.drawable.ic_paper)
            Toast.makeText(requireContext(),"Winner is:$playerChoice", Toast.LENGTH_SHORT).show()
            RoundEnd=true
        }
        else if(playerChoice=="paper" && programChoice == "scissors"){
            animation(R.drawable.ic_scissors)
            Toast.makeText(requireContext(),"Winner is:$programChoice", Toast.LENGTH_SHORT).show()
            RoundEnd=true
        }
        else if(playerChoice=="paper" && programChoice == "rock"){
            animation(R.drawable.ic_rock)
            Toast.makeText(requireContext(),"Winner is:$playerChoice", Toast.LENGTH_SHORT).show()
            RoundEnd=true
        }
        else if(playerChoice==programChoice){

            Toast.makeText(requireContext(),"No one is winner", Toast.LENGTH_SHORT).show()
            RoundEnd=true
        }

    }

    fun reset(){
        ResetButton.setOnClickListener{
            imageView.setImageResource(R.drawable.ic_rock_paper_scissors)
            RockButton.isClickable=true
            PaperButton.isClickable=true
            ScissorsButton.isClickable=true
            RoundEnd=false
        }
    }

    fun animation(imageId:Int)= imageView.animate().apply {
        duration=500
        rotationYBy(1800f)
    }.withEndAction {
        imageView.setImageResource(imageId)
    }.start()

    fun onTapButton(id:String){

    }
}