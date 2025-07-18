package co.com.japl.homeconnect.about

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import co.com.japl.homeconnect.about.ui.About
import co.com.japl.ui.theme.MaterialThemeComposeUI

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val context = LocalContext.current.applicationContext
            MaterialThemeComposeUI {
                About("Module sin version","torressansebastian")
            }
        }
    }
}