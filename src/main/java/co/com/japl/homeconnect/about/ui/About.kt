package co.com.japl.homeconnect.about.ui

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Build
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
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
import androidx.compose.material3.HorizontalDivider
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
fun About(
    versionDetail: String,
    applicationId: String,
) {
    val linkWebSiteApp = stringResource(id = R.string.url_website)
    val context = LocalContext.current
    val color = MaterialTheme.colorScheme.onBackground
    val description =
        if (applicationId.lowercase().contains("myapplication")) {
            R.string.description_finances
        } else if (applicationId.lowercase().contains("alameda181")) {
            R.string.description_alameda181
        } else {
            R.string.urtss_label_title
        }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier =
            Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
    ) {
        Row {
            Column {
                if (applicationId.lowercase().contains("myapplication")) {
                    Owner(
                        logo = R.drawable.finanzaspersonales,
                        descriptionLogo = R.string.fiances,
                        link = stringResource(id = R.string.url_app_finance),
                        modifierLogo =
                            Modifier.width(150.dp).height(130.dp)
                                .padding(top = 5.dp),
                    )
                }
                if (applicationId.lowercase().contains("alameda181")) {
                    Owner(
                        logo = R.drawable.img,
                        descriptionLogo = R.string.alameda181,
                        link = stringResource(id = R.string.url_app_uralameda181),
                        modifierLogo =
                            Modifier.width(150.dp).height(130.dp)
                                .padding(top = 5.dp),
                    )
                }
                if (applicationId.lowercase().contains("torressansebastian")) {
                    Owner(
                        logo = R.drawable.torressansebastian_logo,
                        descriptionLogo = R.string.urtss,
                        link = stringResource(id = R.string.url_app_urtss),
                        modifierLogo =
                            Modifier.width(110.dp).height(130.dp)
                                .padding(top = 5.dp),
                    )
                }
                if (applicationId.lowercase().contains("synapsefit")) {
                    Owner(
                        logo = R.drawable.synapsefit,
                        descriptionLogo = R.string.synapsefit,
                        link = stringResource(id = R.string.url_app_synapsefit),
                        modifierLogo =
                            Modifier.width(110.dp).height(130.dp)
                                .padding(top = 5.dp),
                    )
                }
                if (applicationId.lowercase().contains("ride_connect")) {
                    Owner(
                        logo = R.drawable.ride_connect,
                        descriptionLogo = R.string.ride_connect,
                        link = stringResource(id = R.string.url_app_ride_connect),
                        modifierLogo =
                            Modifier.width(110.dp).height(130.dp)
                                .padding(top = 5.dp),
                    )
                }

                Button(onClick = {
                    val uri = Uri.parse(linkWebSiteApp)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                }) {
                    Text(stringResource(id = R.string.website))
                }
            }

            Text(
                stringResource(id = description),
                color = color,
                modifier = Modifier.padding(start = 10.dp),
            )
        }

        Text(
            text = versionDetail,
            color = color,
            modifier = Modifier.padding(top = 20.dp, start = 10.dp),
        )

        Text(
            stringResource(id = R.string.copy_right),
            color = color,
            modifier =
                Modifier
                    .align(Alignment.End)
                    .padding(top = 20.dp),
        )

        AppBrothers(applicationId)
    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    device = "id:pixel_5",
    backgroundColor = 0xFFFFFFFF,
)
@Composable
fun preview() {
    MaterialThemeComposeUI {
        About(versionDetail = "V1.0.0 Primera version de la app", applicationId = "torressansebastian")
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    device = "id:pixel_5",
    backgroundColor = 0x00000000,
)
@Composable
fun previewDark() {
    MaterialThemeComposeUI {
        About(versionDetail = "V1.0.0 Primera version de la app", applicationId = "torressansebastian")
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    device = "id:pixel_5",
    backgroundColor = 0xFFFFFFFF,
)
@Composable
fun previewFinances() {
    MaterialThemeComposeUI {
        About(versionDetail = "V1.0.0 Primera version de la app", applicationId = "myapplication")
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    device = "id:pixel_5",
    backgroundColor = 0x00000000,
)
@Composable
fun previewDarkFinances() {
    MaterialThemeComposeUI {
        About(versionDetail = "V1.0.0 Primera version de la app", applicationId = "myapplication")
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    device = "id:pixel_5",
    backgroundColor = 0xFFFFFFFF,
)
@Composable
fun previewAlameda181() {
    MaterialThemeComposeUI {
        About(versionDetail = "V1.0.0 Primera version de la app", applicationId = "unidadresidencialalameda181")
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    device = "id:pixel_5",
    backgroundColor = 0x00000000,
)
@Composable
fun previewDarkAlameda181() {
    MaterialThemeComposeUI {
        About(versionDetail = "V1.0.0 Primera version de la app", applicationId = "unidadresidencialalameda181")
    }
}
@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    device = "id:pixel_5",
    backgroundColor = 0x00000000,
)
@Composable
fun previewDarkRideConnect() {
    MaterialThemeComposeUI {
        About(versionDetail = "V1.0.0 Primera version de la app", applicationId = "co.japl.android.ev_ride_connect")
    }
}
@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    device = "id:pixel_5",
    backgroundColor = 0x00000000,
)
@Composable
fun previewDarkSynapseFit() {
    MaterialThemeComposeUI {
        About(versionDetail = "V1.0.0 Primera version de la app", applicationId = "co.japl.android.synapsefit")
    }
}
