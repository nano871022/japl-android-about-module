package co.com.japl.homeconnect.about.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AppBrothers(applicationId: String) {
    val list = arrayListOf<String>(
        "torressansebastian",
        "myapplication",
        "alameda181",
        "synapsefit",
        "ride_connect"
    ).filter { app -> !applicationId.lowercase().contains(app)}

    FlowRow (
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.padding(5.dp),
    ) {
        list.forEach { appKey ->

            Box(
                modifier = Modifier
                    .widthIn(min = 80.dp)
                    .weight(1f)
            ) {
                when (appKey) {
                    "torressansebastian" -> CardTorres()
                    "myapplication" -> CardFinanzas()
                    "alameda181" -> CardCRAlameda181()
                    "synapsefit" -> CardSynapseFit()
                    "ride_connect" -> CardRideConnect()
                }
            }
        }
    }

    CardOwn()
}