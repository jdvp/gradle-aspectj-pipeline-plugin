package com.ibotta.gradle.aop.mixed

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), MessageListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.b_button_kotlin).setOnClickListener {
            findViewById<TextView>(R.id.tv_message).text = ""
            KotlinTargetExample().demonstrateKotlinAOP(this)
        }

        findViewById<TextView>(R.id.b_button_java).setOnClickListener {
            findViewById<TextView>(R.id.tv_message).text = ""
            JavaTargetExample().demonstrateJavaAOP(this)
        }
    }

    override fun onMessage(message: String, callerType: CallerType) {
        findViewById<TextView>(R.id.tv_message).append("$message\n")
    }
}