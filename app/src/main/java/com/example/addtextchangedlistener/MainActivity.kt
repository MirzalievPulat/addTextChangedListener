package com.example.addtextchangedlistener

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var weight = 2.20462
    lateinit var kg:EditText
    lateinit var lbs:EditText
    lateinit var email: EditText
    lateinit var password:EditText
    lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.et_email)
        password = findViewById(R.id.et_password)
        button = findViewById(R.id.button)

        kg = findViewById(R.id.kg)
        lbs = findViewById(R.id.lbs)

        email.addTextChangedListener(loginTextWatcher)
        password.addTextChangedListener(loginTextWatcher)

        kg.setOnKeyListener(View.OnKeyListener{v, keyCode,event ->
            var temp_kg = kg.text.toString()
            if (temp_kg.isEmpty()){
                lbs.setText("")
            }else{
                var num:Double = (kg.text.toString()).toDouble()*weight
                lbs.setText("$num")
            }
            false
        })

        lbs.setOnKeyListener(View.OnKeyListener{v, keyCode,event ->
            var temp_lbs = lbs.text.toString()
            if (temp_lbs.isEmpty()){
                kg.setText("")
            }else{
                var num:Double = (lbs.text.toString()).toDouble()/weight
                kg.setText("$num")
            }
            false
        })
    }
    private var loginTextWatcher:TextWatcher = object :TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            var emailInput = email.text.toString()
            var passwordInput = password.text.toString()

            button.isEnabled = emailInput.isNotEmpty() && passwordInput.isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {
        }

    }
}



