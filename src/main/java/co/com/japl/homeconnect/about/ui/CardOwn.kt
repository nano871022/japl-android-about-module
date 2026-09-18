package co.com.japl.homeconnect.about.ui

import android.content.Intent
import android.net.Uri
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import co.com.japl.homeconnect.about.R

@Composable
fun CardOwn() {
    val context = LocalContext.current.applicationContext
    val urlGit = stringResource(id = R.string.url_app_github)
    val urlJAPL = stringResource(id = R.string.url_japl)
    val urlLinkedIn = stringResource(id = R.string.url_app_linkedin)
    val urlGooglePlay = stringResource(id = R.string.url_app_googleplay)
    val txt = stringResource(R.string.own_detail)
    val html = remember { HtmlCompat.fromHtml(txt, HtmlCompat.FROM_HTML_MODE_COMPACT) }
    val color = MaterialTheme.colorScheme.onSurface
    Card(modifier = Modifier.padding(10.dp)) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.design),
                contentDescription =
                    stringResource(
                        id = R.string.fiances,
                    ),
                modifier = Modifier.width(150.dp),
            )

            AndroidView(
                factory = {
                    TextView(it).apply {
                        movementMethod = LinkMovementMethod.getInstance()
                    }
                },
                update = {
                    it.text = html
                    it.setTextColor(color.toArgb())
                },
                modifier = Modifier.padding(20.dp),
            )
        }

        Row(modifier = Modifier.padding(10.dp)) {
            IconButton(
                onClick = {
                    val link = urlGit
                    val uri = Uri.parse(link)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                },
                modifier =
                    Modifier
                        .width(100.dp)
                        .height(100.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.github_logo),
                    contentDescription =
                        stringResource(
                            id = R.string.own_detail,
                        ),
                )
            }

            IconButton(
                onClick = {
                    val link = urlLinkedIn
                    val uri = Uri.parse(link)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                },
                modifier =
                    Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .padding(start = 10.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.linkedin2),
                    contentDescription =
                        stringResource(
                            id = R.string.own_detail,
                        ),
                )
            }

            IconButton(
                onClick = {
                    val link = urlGooglePlay
                    val uri = Uri.parse(link)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                },
                modifier =
                    Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .padding(start = 10.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.googleplay),
                    contentDescription =
                        stringResource(
                            id = R.string.own_detail,
                        ),
                )
            }

            IconButton(
                onClick = {
                    val uri = Uri.parse(urlJAPL)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                },
                modifier =
                    Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .padding(start = 10.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_japl),
                    modifier = Modifier.width(40.dp).height(40.dp),
                    contentDescription = urlJAPL,
                )
            }
        }
    }
}