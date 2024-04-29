package co.com.alameda181.unidadresidencialalameda181.about.UI

import android.content.Intent
import android.net.Uri
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.com.alameda181.unidadresidencialalameda181.about.R

@Composable
fun About(versionDetail:String){
        val linkGP = stringResource(id = R.string.url_app_finance)
        val context = LocalContext.current
        Column (
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
                , modifier = Modifier
                        .fillMaxWidth().verticalScroll(rememberScrollState())
        ){
                Row {
                        Column {
                                Image(
                                        painter = painterResource(id = R.drawable.finanzaspersonales),
                                        contentDescription = stringResource(id = R.string.fiances),
                                        contentScale = ContentScale.FillBounds,
                                        modifier = Modifier
                                                .width(150.dp)
                                                .height(130.dp)
                                                .padding(top = 5.dp)
                                )
                                Image(
                                        painter = painterResource(id = R.drawable.googleplay)
                                        , contentDescription = "Google Play"
                                        ,modifier = Modifier
                                                .width(150.dp)
                                                .clickable {
                                                        val uri = Uri.parse(linkGP)
                                                        val intent = Intent(Intent.ACTION_VIEW, uri)
                                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                                        context.startActivity(intent)
                                                }
                                )
                        }

                        Text(stringResource(id = R.string.description)
                                ,color= MaterialTheme.colorScheme.onPrimary
                                ,modifier=Modifier.padding(start=10.dp))

                }

                Text(text=versionDetail
                        , color = MaterialTheme.colorScheme.onPrimary
                        ,modifier = Modifier.padding(top = 20.dp, start=10.dp))

                Text(stringResource(id = R.string.copy_right)
                        , color = MaterialTheme.colorScheme.onPrimary
                        , modifier = Modifier
                                .align(Alignment.End)
                                .padding(top = 20.dp))

                Divider(modifier=Modifier.padding(10.dp))

                Row() {
                        CardTorres()
                        CardFinanzas()

                }

                CardOwn()

        }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTorres(){
        val context = LocalContext.current.applicationContext
        val url = stringResource(id = R.string.url_app_urtss)
        val name = stringResource(id = R.string.urtss)
        val nameFormat = remember { HtmlCompat.fromHtml(name, HtmlCompat.FROM_HTML_MODE_COMPACT)}
        Card(
                onClick = {
                        val link = url
                        val uri = Uri.parse(link)
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        context.startActivity(intent)
                },
                modifier = Modifier
                        .width(120.dp)
                        .padding(5.dp)
        ) {

                Image(painter= painterResource(id = R.drawable.torressansebastian_logo)
                        ,contentDescription = stringResource(
                        id = R.string.urtss
                ),
                        Modifier
                                .align(
                                        alignment = Alignment.CenterHorizontally
                                ))
                Divider(modifier=Modifier.padding(top=10.dp, bottom=10.dp))

                Text(text = nameFormat.toString()
                        , color = MaterialTheme.colorScheme.onPrimary
                        ,textAlign = TextAlign.Center)
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardFinanzas(){
        val context = LocalContext.current.applicationContext
        val url = stringResource(id = R.string.url_app_uralameda181)
        Card( onClick = {
                val link = url
                val uri = Uri.parse(link)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
        },modifier = Modifier
                .width(105.dp)
                .padding(5.dp)) {

                Image(painter= painterResource(id = R.drawable.img),
                        contentDescription = stringResource(
                        id = R.string.fiances
                )
                        , contentScale = ContentScale.FillBounds
                        , modifier = Modifier
                                .height(90.dp)
                                .width(110.dp)
                                .align(alignment = Alignment.CenterHorizontally)
                        )

                Divider(modifier=Modifier.padding(top=10.dp, bottom=10.dp))

                Text(text = stringResource(id = R.string.name_app_uralameda_181)
                        ,textAlign = TextAlign.Center
                        , color = MaterialTheme.colorScheme.onPrimary
                        )


        }
}

@Composable
fun CardOwn(){
        val context = LocalContext.current.applicationContext
        val urlGit = stringResource(id = R.string.url_app_github)
        val urlLinkedIn = stringResource(id = R.string.url_app_linkedin)
        val urlGooglePlay = stringResource(id = R.string.url_app_googleplay)
        val txt = stringResource(R.string.own_detail)
        val html = remember { HtmlCompat.fromHtml(txt, HtmlCompat.FROM_HTML_MODE_COMPACT)}
        Card(modifier=Modifier.padding(10.dp)){

                Row {

                        Image(painter= painterResource(id = R.drawable.design),
                                contentDescription = stringResource(
                                        id = R.string.fiances
                                ),modifier=Modifier.width(150.dp))

                        AndroidView(
                                factory = {
                                        TextView(it).apply {
                                                movementMethod = LinkMovementMethod.getInstance()
                                        }
                                },
                                update = { it.text = html },
                                modifier = Modifier.padding(20.dp)
                        )
                }

                Row(modifier=Modifier.padding(10.dp)) {

                        IconButton(onClick = {
                                val link = urlGit
                                val uri = Uri.parse(link)
                                val intent = Intent(Intent.ACTION_VIEW, uri)
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                context.startActivity(intent)
                        }, modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)) {
                                Image(
                                        painter = painterResource(id = R.drawable.github_logo),
                                        contentDescription = stringResource(
                                                id = R.string.own_detail
                                        )
                                )
                        }

                        IconButton(onClick = {
                                val link = urlLinkedIn
                                val uri = Uri.parse(link)
                                val intent = Intent(Intent.ACTION_VIEW, uri)
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                context.startActivity(intent)
                        }, modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .padding(start = 10.dp)) {
                                Image(
                                        painter = painterResource(id = R.drawable.linkedin2),
                                        contentDescription = stringResource(
                                                id = R.string.own_detail
                                        )
                                )
                        }

                        IconButton(onClick = {
                                val link = urlGooglePlay
                                val uri = Uri.parse(link)
                                val intent = Intent(Intent.ACTION_VIEW, uri)
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                context.startActivity(intent)
                        }, modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .padding(start = 10.dp)) {
                                Image(
                                        painter = painterResource(id = R.drawable.googleplay),
                                        contentDescription = stringResource(
                                                id = R.string.own_detail
                                        )
                                )
                        }
                }
        }
}

@Preview(showBackground = true)
@Composable
fun preview(){
        MaterialThemeComposeUI {
                About(versionDetail="V1.0.0 Primera version de la app")
        }
}

