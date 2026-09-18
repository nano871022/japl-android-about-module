package co.com.japl.homeconnect.about.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import co.com.japl.homeconnect.about.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardRideConnect() {
    val context = LocalContext.current.applicationContext
    val url = stringResource(id = R.string.url_app_ride_connect)
    Card(
        onClick = {
            val link = url
            val uri = Uri.parse(link)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        },
        modifier =
            Modifier
                .width(115.dp)
                .padding(5.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ride_connect),
            contentDescription =
                stringResource(
                    id = R.string.ride_connect,
                ),
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally).size(115.dp),
        )

        HorizontalDivider(modifier = Modifier.padding(top = 2.dp, bottom = 10.dp))

        Text(
            text = stringResource(id = R.string.ride_connect),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface,
            modifier =
                Modifier
                    .align(
                        alignment = Alignment.CenterHorizontally,
                    ).padding(5.dp),
        )
    }
}
