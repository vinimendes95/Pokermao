package br.com.devlfernando.pokermao.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import br.com.devlfernando.pokermao.R
import br.com.devlfernando.pokermao.view.main.MainActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashViewModel.checkHealth()
        splashViewModel.messageError.observe(this, Observer {
            if(it == "") {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
