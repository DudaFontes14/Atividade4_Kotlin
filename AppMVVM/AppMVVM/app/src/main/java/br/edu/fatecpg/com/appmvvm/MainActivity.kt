package br.edu.fatecpg.com.appmvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.com.appmvvm.databinding.ActivityMainBinding
import br.edu.fatecpg.com.appmvvm.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val lvm:LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnReg.setOnClickListener{
            val login = binding.edtLogin.text.toString()
            val pass = binding.edtPassword.text.toString()
            val result = lvm.register(login, pass)
            Log.d("Cadastro", result.toString())
        }
        
        binding.btnEnter.setOnClickListener{
            val login = binding.edtLogin.text.toString()
            val pass = binding.edtPassword.text.toString()
            val result = lvm.login(login, pass)
            Log.d("Logado", result.toString())
        }
    }
}