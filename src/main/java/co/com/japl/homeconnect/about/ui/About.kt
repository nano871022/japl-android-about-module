package co.com.japl.homeconnect.about.ui

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Build
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.annotation.RequiresApi
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
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import co.com.japl.homeconnect.about.R
import co.com.japl.ui.theme.MaterialThemeComposeUI

@Composable
fun About(versionDetail:String,applicationId:String){
        val linkGP = stringResource(id = R.string.url_app_finance)
        val linkWebSiteApp = stringResource(id = R.string.url_website)
        val context = LocalContext.current
        val color = MaterialTheme.colorScheme.onBackground

        Column (
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
                , modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
        ){
                Row() {
                        Column {
                                if(applicationId.lowercase().contains("finances")) {
                                        Image(
                                                painter = painterResource(id = R.drawable.finanzaspersonales),
                                                contentDescription = stringResource(id = R.string.fiances),
                                                contentScale = ContentScale.FillBounds,
                                                modifier = Modifier.width(150.dp).height(130.dp)
                                                        .padding(top = 5.dp)
                                        )
                                }
                                if(applicationId.lowercase().contains("alameda181")) {
                                        Image(
                                                painter = painterResource(id = R.drawable.img),
                                                contentDescription = stringResource(id = R.string.alameda181),
                                                contentScale = ContentScale.FillBounds,
                                                modifier = Modifier.width(150.dp).height(130.dp)
                                                        .padding(top = 5.dp)
                                        )
                                }
                                if(applicationId.lowercase().contains("torressansebastian")) {
                                        Image(
                                                painter = painterResource(id = R.drawable.torressansebastian_logo),
                                                contentDescription = stringResource(id = R.string.urtss),
                                                contentScale = ContentScale.FillBounds,
                                                modifier = Modifier.width(110.dp).height(130.dp)
                                                        .padding(top = 5.dp)
                                        )
                                }

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

                                Button(onClick = {
                                        val uri = Uri.parse(linkWebSiteApp)
                                        val intent = Intent(Intent.ACTION_VIEW, uri)
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                        context.startActivity(intent)
                                }){
                                        Text(stringResource(id = R.string.website))
                                }
                        }

                        Text(stringResource(id = R.string.description),
                        color=color,
                        modifier=Modifier.padding(start=10.dp))

                }

                Text(text=versionDetail,
                		color=color,
                		modifier = Modifier.padding(top = 20.dp, start=10.dp))

                Text(stringResource(id = R.string.copy_right), 
		                color=color,
		                modifier = Modifier
                                .align(Alignment.End)
                                .padding(top = 20.dp))

                AppBrothers(applicationId)

        }

}

@Composable
fun AppBrothers(applicationId:String){
        Divider(modifier=Modifier.padding(10.dp))

        Row() {
                if(!applicationId.lowercase().contains("torressansebastian")){
                        CardTorres()
                }
                if(!applicationId.lowercase().contains("finances")) {
                        CardFinanzas()
                }
                if(!applicationId.lowercase().contains("alameda181")) {
                        CardCRAlameda181()
                }

        }

        CardOwn()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTorres(){
        val context = LocalContext.current.applicationContext
        val url = stringResource(id = R.string.url_app_urtss)
        val name = stringResource(id = R.string.urtss)
        val nameFormat = remember { HtmlCompat.fromHtml(name, HtmlCompat.FROM_HTML_MODE_COMPACT)}
        val color = MaterialTheme.colorScheme.onSurface
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

                Image(painter= painterResource(id = R.drawable.torressansebastian_logo),contentDescription = stringResource(
                        id = R.string.urtss
                ), contentScale = ContentScale.FillBounds,
                       modifier= Modifier
                       			.width(80.dp)
                       			.height(90.dp)
                                .align(
                                        alignment = Alignment.CenterHorizontally
                                ))
                Divider(modifier = Modifier.padding(top=10.dp, bottom=10.dp))

                AndroidView(
                        factory= {
                                TextView(it).apply{

                                }
                                 },
                        update = {
                                it.text = nameFormat
                                it.setTextColor(color.toArgb())
                                 },
                        modifier = Modifier
                                .align(
                                        alignment = Alignment.CenterHorizontally
                                )
                                .padding(5.dp))


        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardCRAlameda181(){
        val context = LocalContext.current.applicationContext
        val url = stringResource(id = R.string.url_app_uralameda181)
        val name = stringResource(id = R.string.alameda181)
        val nameFormat = remember { HtmlCompat.fromHtml(name, HtmlCompat.FROM_HTML_MODE_COMPACT)}
        val color = MaterialTheme.colorScheme.onSurface
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

                Image(painter= painterResource(id = R.drawable.img),contentDescription = stringResource(
                        id = R.string.urtss
                ), contentScale = ContentScale.FillBounds,
                        modifier= Modifier
                                .width(80.dp)
                                .height(90.dp)
                                .align(
                                        alignment = Alignment.CenterHorizontally
                                ))
                Divider(modifier = Modifier.padding(top=10.dp, bottom=10.dp))

                AndroidView(
                        factory= {
                                TextView(it).apply{

                                }
                        },
                        update = {
                                it.text = nameFormat
                                it.setTextColor(color.toArgb())
                        },
                        modifier = Modifier
                                .align(
                                        alignment = Alignment.CenterHorizontally
                                )
                                .padding(5.dp))


        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardFinanzas(){
        val context = LocalContext.current.applicationContext
        val url = stringResource(id = R.string.url_app_finance)
        Card( onClick = {
                val link = url
                val uri = Uri.parse(link)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
        },modifier = Modifier
                .width(115.dp)
                .padding(5.dp)) {

                Image(painter= painterResource(id = R.drawable.finanzaspersonales),
                        contentDescription = stringResource(
                        id = R.string.fiances
                ), modifier = Modifier.align(alignment = Alignment.CenterHorizontally))

                Divider(modifier=Modifier.padding(top=10.dp, bottom=10.dp))

                Text(text = stringResource(id = R.string.fiances),modifier= Modifier
                        .align(
                                alignment = Alignment.CenterHorizontally
                        )
                        .padding(5.dp))


        }
}

@Composable
fun CardOwn(){
        val context = LocalContext.current.applicationContext
        val urlGit = stringResource(id = R.string.url_app_github)
        val urlJAPL = stringResource(id = R.string.url_japl)
        val urlLinkedIn = stringResource(id = R.string.url_app_linkedin)
        val urlGooglePlay = stringResource(id = R.string.url_app_googleplay)
        val txt = stringResource(R.string.own_detail)
        val html = remember { HtmlCompat.fromHtml(txt, HtmlCompat.FROM_HTML_MODE_COMPACT)}
        val color = MaterialTheme.colorScheme.onSurface
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
                                update = { it.text = html
                                        it.setTextColor(color.toArgb())
                                         },
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
                        
                        IconButton(onClick = {
                                val uri = Uri.parse(urlJAPL)
                                val intent = Intent(Intent.ACTION_VIEW, uri)
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                context.startActivity(intent)}, modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .padding(start = 10.dp)) {
                                Image( painter = painterResource(id = R.drawable.icon_japl),
                                        modifier = Modifier.width(40.dp).height(40.dp),
                                        contentDescription = urlJAPL)
                                
                        }
                }
        }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview( showSystemUi = true,  uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, device = "id:pixel_5", backgroundColor = 0xFFFFFFFF)
@Composable
fun preview(){
    MaterialThemeComposeUI {
                About(versionDetail="V1.0.0 Primera version de la app",applicationId="torressansebastian")
        }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview( showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, device = "id:pixel_5", backgroundColor = 0x00000000)
@Composable
fun previewDark(){
        MaterialThemeComposeUI {
                About(versionDetail="V1.0.0 Primera version de la app",applicationId="torressansebastian")
        }
}
@RequiresApi(Build.VERSION_CODES.S)
@Preview( showSystemUi = true,  uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, device = "id:pixel_5", backgroundColor = 0xFFFFFFFF)
@Composable
fun previewFinances(){
        MaterialThemeComposeUI {
                About(versionDetail="V1.0.0 Primera version de la app",applicationId="finances")
        }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview( showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, device = "id:pixel_5", backgroundColor = 0x00000000)
@Composable
fun previewDarkFinances(){
        MaterialThemeComposeUI {
                About(versionDetail="V1.0.0 Primera version de la app",applicationId="finances")
        }
}
@RequiresApi(Build.VERSION_CODES.S)
@Preview( showSystemUi = true,  uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, device = "id:pixel_5", backgroundColor = 0xFFFFFFFF)
@Composable
fun previewAlameda181(){
        MaterialThemeComposeUI {
                About(versionDetail="V1.0.0 Primera version de la app",applicationId="unidadresidencialalameda181")
        }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview( showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, device = "id:pixel_5", backgroundColor = 0x00000000)
@Composable
fun previewDarkAlameda181(){
        MaterialThemeComposeUI {
                About(versionDetail="V1.0.0 Primera version de la app",applicationId="unidadresidencialalameda181")
        }
}

