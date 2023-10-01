package com.example.businesscard

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.content.Intent.ACTION_SENDTO
import android.content.Intent.ACTION_VIEW
import android.content.Intent.EXTRA_EMAIL
import android.content.Intent.EXTRA_SUBJECT
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import java.lang.Exception


class MainActivity : ComponentActivity() {
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    BusinessCard(
                        name = getString(R.string.name),
                        description = getString(R.string.description),
                        phone = getString(R.string.phone),
                        phoneClick = {phone-> dialPhone(phone) },
                        email = getString(R.string.email),
                        emailClick = {email-> composeEmail(addresses = arrayOf(email), subject = "Greeting email")},
                        gitHub = getString(R.string.github),
                        gitHubClick = {gitHub-> webBrowse(gitHub)  },
                        linkedIn = getString(R.string.linkedIn),
                        linkedInClick = {linkedIn -> webBrowse(linkedIn) }

                    )
                }
            }
        }

    }

}

fun Context.composeEmail(addresses: Array<String>, subject: String) {
    //Log.e("tag", "I've been clicked")
    val intent = Intent(ACTION_SENDTO).apply {
        data = Uri.parse("mailto:")
        putExtra(EXTRA_EMAIL, addresses)
        putExtra(EXTRA_SUBJECT, subject)
    }
    //if(intent.resolveActivity(context.packageManager) != null) {
        //Log.e("tag", "start activity")

    try{
        startActivity(intent)
        //Toast.makeText(this, "here's a toast", Toast.LENGTH_LONG).show()
    } catch (e: Exception){
        //no op
    }
//}
}

fun Context.dialPhone(phone: String){
    val intent = Intent(ACTION_DIAL).apply {
        data = Uri.parse("tel:$phone")
    }
    try {
        startActivity(intent)
    } catch (e: Exception){
        //no op
    }
}

fun Context.webBrowse(url: String) {
    val webpage: Uri = Uri.parse(url)
    val intent = Intent(ACTION_VIEW, webpage)
    try {
        startActivity(intent)
    } catch (e: Exception){
        //no op
    }
}

@Composable
fun BusinessCard(
    name: String,
    description: String,
    phone: String,
    phoneClick: (phone: String)-> Unit,
    email: String,
    emailClick: (email: String)-> Unit,
    gitHub: String,
    gitHubClick: (gitHub: String)-> Unit,
    linkedIn: String,
    linkedInClick: (linkedIn: String)-> Unit,
    modifier: Modifier = Modifier) {
    //create an image that will be used
    val image = painterResource(R.drawable._638421957986__1_)
    //val context = LocalContext.current
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
        modifier = modifier
            .background(Color.LightGray)

    ){
        Image(
            painter = image,
            contentDescription = "Android Image",
            alignment = BottomCenter,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(Color.Transparent)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp
        )
        Text(
            text = description,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
    }
    Column (
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(20.dp)
    ){
        Text(
            text = "Contact me!",
            textDecoration = TextDecoration.Underline
        )
      ClickableText(
          text = AnnotatedString("Phone: $phone"),
          onClick = {phoneClick(phone)}
      )
       ClickableText(
           text = AnnotatedString("Email: $email"),
           onClick = {emailClick(email)}
       )
      ClickableText(
          text = AnnotatedString("GitHub"),
          onClick = {gitHubClick(gitHub)}
      )
      ClickableText(
          text = AnnotatedString("LinkedIn"),
          onClick = {linkedInClick(linkedIn)})
    }

}