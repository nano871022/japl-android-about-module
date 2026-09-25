import co.com.japl.homeconnect.about.util.KindApp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.com.japl.homeconnect.about.ui.CardCRAlameda181
import co.com.japl.homeconnect.about.ui.CardFinanzas
import co.com.japl.homeconnect.about.ui.CardOwn
import co.com.japl.homeconnect.about.ui.CardRideConnect
import co.com.japl.homeconnect.about.ui.CardSynapseFit
import co.com.japl.homeconnect.about.ui.CardTorres

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AppBrothers(applicationId: String) {
    val appsToDisplay = KindApp.getDifferent(applicationId)

    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.padding(5.dp),
    ) {
        Box(
            modifier = Modifier
                .widthIn(min = 80.dp)
                .weight(1f)
        ) {
            appsToDisplay?.let {
                when (it) {
                    KindApp.FINANCES -> CardFinanzas()
                    KindApp.ALAMEDA181 -> CardCRAlameda181()
                    KindApp.TORRES_SAN_SEBASTIAN -> CardTorres()
                    KindApp.SYNAPSEFIT -> CardSynapseFit()
                    KindApp.RIDE_CONNECT -> CardRideConnect()
                }
            }

        }
    }

    CardOwn()
}