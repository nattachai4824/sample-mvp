package ns.example.mvp_sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.kittinunf.fuel.httpGet
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()

        if (validate(username, password)) {
            // Continue the login
        } else {
            // Show a warning message
        }


    }

    private fun validate(username: String, password: String): Boolean {
        if (username.length >= 8 && password.length >= 8) {
            return true
        } else {
            return false
        }
    }
}
