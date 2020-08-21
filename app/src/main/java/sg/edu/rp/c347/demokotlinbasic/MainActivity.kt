package sg.edu.rp.c347.demokotlinbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetAge.setOnClickListener {
            val userDOB = etDOB.text.toString()
            if(userDOB.isNotEmpty()){
                val year = Calendar.getInstance().get(Calendar.YEAR)
                val age = year - userDOB.toInt()
                var output = ""
                when(age){
                    in 0..17 -> output = "Underage"
                    in 18..65 -> output = "Young People"
                    in 66..79 -> output = "Middle-Aged"
                    in 80..99 -> output = "Elderly"
                    else -> {
                        output = "Long-Lived Elderly"
                    }
                }

                tvShowAge.text = "Your age is $age\n$output"
            }else{
                Toast.makeText(applicationContext, "Please enter our birth year", Toast.LENGTH_LONG).show()
            }
        }

    }
}