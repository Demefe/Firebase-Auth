package br.edu.fatecpg.appkotlinfatec

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword("davi@gmail.com", "davi12345")
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    Log.i("FIREBASE", "LOGADO COM SUCESSO!" )
                }else{
                    Log.i("FIREBASE", "ERRO AO LOGAR ${task.exception}")
                }
            }
    }
}