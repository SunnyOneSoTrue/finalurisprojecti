package com.example.registrationandlogin.Fragments

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.registrationandlogin.R
import kotlinx.android.synthetic.main.fragment_coin.*
import java.util.*


class CoinFragment: Fragment(R.layout.fragment_coin) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onCoinTap()
    }

    public fun onCoinTap() {
        CoinView.setOnClickListener {
            val RandomNumber=(1..1000).random()

            if(RandomNumber<499){
                flipCoin(R.drawable.ic_heads, "საფასური")
            }
            else if (RandomNumber in 500..998){
                flipCoin(R.drawable.ic_tails, "ბორჯღალი")
            }
            else{
                flipCoin(R.drawable.coinside_background, "გვერდზე დაეცა, ნიჩიაა")
            }
        }
    }

    private fun flipCoin(imageId:Int, CoinSide: String) = iv_view_coin.animate().apply {
        duration=1000
        rotationYBy(1800f)
        iv_view_coin.isClickable=false

    }.withEndAction{
        iv_view_coin.setImageResource(imageId)
        Toast.makeText(requireContext(),CoinSide ,Toast.LENGTH_SHORT).show()
        iv_view_coin.isClickable=true

    }.start()

}

