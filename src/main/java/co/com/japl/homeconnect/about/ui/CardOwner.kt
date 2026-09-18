package co.com.japl.homeconnect.about.ui

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import co.com.japl.homeconnect.about.R

@Composable
fun Owner(
    @DrawableRes logo: Int,
    @StringRes descriptionLogo: Int,
    link: String,
    modifierLogo: Modifier,
) {
    val context = LocalContext.current
    Image(
        painter = painterResource(id = logo),
        contentDescription = stringResource(id = descriptionLogo),
        contentScale = ContentScale.FillBounds,
        modifier = modifierLogo,
    )

    Image(
        painter = painterResource(id = R.drawable.googleplay),
        contentDescription = "Google Play",
        modifier =
            Modifier
                .width(150.dp)
                .clickable {
                    val uri = Uri.parse(link)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                },
    )
}