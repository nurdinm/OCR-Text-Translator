package com.popo.ocrtext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds

class SplashScreen : AppCompatActivity() {

//    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

//        MobileAds.initialize(this) {}
//
//        mInterstitialAd = InterstitialAd(this).apply {
//            adUnitId = "ca-app-pub-2222929001248918/6566958602"
//            adListener = (object : AdListener() {
//                override fun onAdLoaded() {
//
//                }
//
//                override fun onAdFailedToLoad(errorCode: Int) {
//
//                }
//
//                override fun onAdClosed() {
//                    finish()
//                }
//            })
//        }
//
//        showIntent()

    }

//    private fun showIntent(){
//        if (!mInterstitialAd.isLoading && !mInterstitialAd.isLoaded) {
//            // Create an ad request.
//            val adRequest = AdRequest.Builder().build()
//
//            mInterstitialAd.loadAd(adRequest)
//        }
//        Handler().postDelayed({
//            val intent = Intent(this@SplashScreen, MainActivity::class.java)
//            startActivity(intent)
//            showInterstitial()
//            finish()
//        }, 3000)
//
//    }
//
//    private fun showInterstitial() {
//        if (mInterstitialAd.isLoaded) {
//            mInterstitialAd.show()
//        } else {
//        }
//    }
}