package com.example.android.networking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user.*

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import java.net.URL
import java.util.logging.Level.parse


class userActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val id=intent.getStringExtra("ID")

        GlobalScope.launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO){client.api.getUserById(id)}
            if(response.isSuccessful) {
                response.body()?.let {
                    tv1.text=it.login
                    tv2.text=it.id.toString()
                    Picasso.get().load(it.avatar_url).into(imgmain1)
                    tv3.text=it.followers_url
                    tv4.text=it.repos_url
                    
            }
        }

    }
    }

}