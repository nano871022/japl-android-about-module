package co.com.japl.homeconnect.about.util

enum class KindApp (private val app: String) {
    FINANCES("myapplication"),
    ALAMEDA181("alameda181"),
    TORRES_SAN_SEBASTIAN("torressansebastian"),
    SYNAPSEFIT("synapsefit"),
    RIDE_CONNECT("ride_connect");

    companion object {
        fun get(applicationId: String): KindApp? =
            entries.find { key ->
                key.app.contains(applicationId.lowercase())
            }
        fun getDifferent(applicationId: String): KindApp? =
            entries.find { key ->
                !key.app.contains(applicationId.lowercase())
            }
    }
}