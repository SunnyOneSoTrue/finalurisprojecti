package com.example.registrationandlogin.Fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.graphics.rotationMatrix
import androidx.core.view.ViewCompat.animate
import androidx.fragment.app.Fragment
import com.example.registrationandlogin.R
import kotlinx.android.synthetic.main.fragment_rockpapersc.*
import java.util.*
import kotlin.random.Random

class RockPaperScissorsFragment: Fragment(R.layout.fragment_rockpapersc) {
    val choices = Array(3){"rock"; "paper";"scissors"}
    var RoundEnd:Boolean=false
    lateinit var playerChoice:String
    lateinit var programChoice:String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        game()
//        reset()
    }


    fun game()= imageView.animate().apply {
        if(!RoundEnd){
            RockButton.setOnClickListener{
                battle("rock")
            }

            PaperButton.setOnClickListener{
                battle("paper")
            }

            ScissorsButton.setOnClickListener{
                battle("scissors")
            }
        }
    }

    private fun battle(Choice:String){
        playerChoice=Choice
        var determinant = (1..3).random()
        if (determinant==1){
            programChoice = "rock"
        }
        else if(determinant==2){
            programChoice="paper"
        }
        else{
            programChoice="scissors"
        }


        if(playerChoice=="rock" && programChoice == "paper"){
            animation(R.drawable.ic_paper)
            Toast.makeText(requireContext(),"Winner is: $programChoice", Toast.LENGTH_SHORT).show()
        }
        else if(playerChoice=="rock" && programChoice == "scissors"){
            animation(R.drawable.ic_scissors)
            Toast.makeText(requireContext(),"Winner is: $playerChoice", Toast.LENGTH_SHORT).show()
        }
        else if(playerChoice=="scissors" && programChoice == "rock"){
            animation(R.drawable.ic_rock)
            Toast.makeText(requireContext(),"Winner is: $programChoice", Toast.LENGTH_SHORT).show()
        }
        else if(playerChoice=="scissors" && programChoice == "paper"){
            animation(R.drawable.ic_paper)
            Toast.makeText(requireContext(),"Winner is: $playerChoice", Toast.LENGTH_SHORT).show()
        }
        else if(playerChoice=="paper" && programChoice == "scissors"){
            animation(R.drawable.ic_scissors)
            Toast.makeText(requireContext(),"Winner is: $programChoice", Toast.LENGTH_SHORT).show()
        }
        else if(playerChoice=="paper" && programChoice == "rock"){
            animation(R.drawable.ic_rock)
            Toast.makeText(requireContext(),"Winner is: $playerChoice", Toast.LENGTH_SHORT).show()
        }
        else if(playerChoice==programChoice){
            if(playerChoice=="rock"){
                animation(R.drawable.ic_rock)
            }
            else if(playerChoice=="paper"){
                animation(R.drawable.ic_paper)
            }
            else{
                animation(R.drawable.ic_scissors)
            }

            Toast.makeText(requireContext(),"No one is winner", Toast.LENGTH_SHORT).show()
        }

    }

//    fun reset(){
//        ResetButton.setOnClickListener{
//            imageView.setImageResource(R.drawable.ic_rock_paper_scissors)
//            RockButton.isClickable=true
//            PaperButton.isClickable=true
//            ScissorsButton.isClickable=true
//            RoundEnd=false
//        }
//    }

    fun animation(imageId:Int)= imageView.animate().apply {
        duration=500
        rotationYBy(1800f)
    }.withEndAction {
        imageView.setImageResource(imageId)
    }.start()
}