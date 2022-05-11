package ikhwan.binar.protodatastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        viewModel.data.observe(this) {
            tv_name.text = it.name
        }

        btn_save.setOnClickListener {
            val name = et_nama.text.toString()

            viewModel.updateData(name)
        }

        btn_delete.setOnClickListener {
            viewModel.clearData()
        }
    }
}