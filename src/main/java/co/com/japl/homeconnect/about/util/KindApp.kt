package co.com.japl.homeconnect.about.util

import android.util.Log
import androidx.annotation.StringRes
import co.com.japl.homeconnect.about.R

enum class KindApp (private val app: String,@StringRes val linkweb: Int) {

    FINANCES("myapplication", R.string.url_website_finances),
    ALAMEDA181("alameda181", R.string.url_website_alameda181),
    TORRES_SAN_SEBASTIAN("torressansebastian", R.string.url_website_tss),
    SYNAPSEFIT("synapsefit", R.string.url_website_synapsefit),
    RIDE_CONNECT("ride_connect", R.string.url_app_ride_connect);

    companion object {
        fun get(applicationId: String): KindApp? =
        entries.find { key ->
            applicationId.lowercase().contains(key.app.lowercase())
            }

        fun getDifferent(applicationId: String): List<KindApp> =
            entries.filter { key ->
                !applicationId.lowercase().contains(key.app.lowercase())
            }
    }
}