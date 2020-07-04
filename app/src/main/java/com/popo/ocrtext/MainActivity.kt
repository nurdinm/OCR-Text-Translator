package com.popo.ocrtext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.popo.ocrtext.main.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mInterstitialAd: InterstitialAd
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commit()
        }


        MobileAds.initialize(this) {}

        mInterstitialAd = InterstitialAd(this).apply {
            adUnitId = "ca-app-pub-2222929001248918/6566958602"
            adListener = (object : AdListener() {
                override fun onAdLoaded() {

                }

                override fun onAdFailedToLoad(errorCode: Int) {

                }

                override fun onAdClosed() {
                    finish()
                }
            })
        }
    }

    private fun showInterstitial() {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        } else {
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_LONG).show()
        if (!mInterstitialAd.isLoading && !mInterstitialAd.isLoaded) {
            // Create an ad request.
            val adRequest = AdRequest.Builder().build()

            mInterstitialAd.loadAd(adRequest)
        }
        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
        showInterstitial()

    }


}