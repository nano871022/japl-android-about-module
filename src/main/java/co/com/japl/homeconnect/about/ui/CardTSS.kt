package co.com.japl.homeconnect.about.ui

import android.content.Intent
import android.net.Uri
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import co.com.japl.homeconnect.about.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTorres() {
    val context = LocalContext.current.applicationContext
    val url = stringResource(id = R.string.url_app_urtss)
    val name = stringResource(id = R.string.urtss)
    val nameFormat = remember { HtmlCompat.fromHtml(name, HtmlCompat.FROM_HTML_MODE_COMPACT) }
    val color = MaterialTheme.colorScheme.onSurface
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
                .width(120.dp)
                .padding(5.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.torressansebastian_logo),
            contentDescription =
                stringResource(
                    id = R.string.urtss,
                ),
            contentScale = ContentScale.FillBounds,
            modifier =
                Modifier
                    .width(80.dp)
                    .height(90.dp)
                    .align(
                        alignment = Alignment.CenterHorizontally,
                    ),
        )
        HorizontalDivider(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))

        AndroidView(
            factory = {
                TextView(it).apply {
                }
            },
            update = {
                it.text = nameFormat
                it.setTextColor(color.toArgb())
            },
            modifier =
                Modifier
                    .align(
                        alignment = Alignment.CenterHorizontally,
                    )
                    .padding(5.dp).align (alignment = Alignment.CenterHorizontally),
        )
    }
}