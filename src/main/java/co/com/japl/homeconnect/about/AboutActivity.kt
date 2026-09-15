package co.com.japl.homeconnect.about

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import co.com.japl.homeconnect.about.ui.About
import co.com.japl.ui.theme.MaterialThemeComposeUI

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialThemeComposeUI {
                About("Module sin version", "torressansebastian")
            }
        }
    }
}
