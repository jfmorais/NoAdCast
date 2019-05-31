package com.curymorais.noadcast

import android.content.Context
import com.example.noadcast.R
import com.google.android.gms.cast.framework.CastOptions
import com.google.android.gms.cast.framework.OptionsProvider
import com.google.android.gms.cast.framework.SessionProvider

class CastOptionsProvider: OptionsProvider {
    override fun getCastOptions(p0: Context?): CastOptions {
        val c : CastOptions = CastOptions.Builder().setReceiverApplicationId(p0?.getString(R.string.app_name)).build()
        return c
    }

    override fun getAdditionalSessionProviders(p0: Context?): MutableList<SessionProvider>? {
        return null
    }
}