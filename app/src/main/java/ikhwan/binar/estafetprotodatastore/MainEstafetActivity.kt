package ikhwan.binar.estafetprotodatastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ikhwan.binar.protodatastore.R
import kotlinx.android.synthetic.main.activity_main_estafet.*

class MainEstafetActivity : AppCompatActivity() {

    private lateinit var viewModel: EstafetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_estafet)

        viewModel = ViewModelProvider(this)[EstafetViewModel::class.java]

        viewModel.data.observe(this){
            val username = it.username
            val password = it.password
            val txt = "username:${username}\n password:${password}"
            tv_username.text = txt
        }

        btn_save.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()

            viewModel.updateData(username, password)
        }

    }
}