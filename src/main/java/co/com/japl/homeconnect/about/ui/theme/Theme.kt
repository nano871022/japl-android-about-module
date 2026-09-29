package co.com.japl.homeconnect.about.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun MaterialThemeComposeUI(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}
