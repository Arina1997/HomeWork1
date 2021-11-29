package projects.khoreva.homework1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList as mutableListOf
import kotlin.collections.forEach as forEach1

class MainActivity : AppCompatActivity() {

    lateinit var resultTextView: TextView
    lateinit var stringButton: Button
    lateinit var mutableListOfButton: Button
    lateinit var listOfButton: Button
    lateinit var letterByLetterButton: Button
    lateinit var cleanButton: Button
    private val lineAbc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private val listLetter = mutableListOf<Char>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.result)
        stringButton = findViewById(R.id.button_string)
        mutableListOfButton = findViewById(R.id.button_mutableListOf)
        listOfButton = findViewById(R.id.button_listOf)
        letterByLetterButton = findViewById(R.id.button_letter_by_letter)
        cleanButton = findViewById(R.id.button_clean)
        resultTextView.text = ""

        listOfButtonClick()
        latterByLatterButtonClick()
        mutableListOfButtonClick()
        stringButtonClick()
        cleanButtonClick()

        var i = 1
        while (i <= lineAbc.length - 1) {
            listLetter.add(lineAbc[i])
            i += 2
        }
    }

    fun latterByLatterButtonClick() {

        letterByLetterButton.setOnClickListener {
            var count = resultTextView.text.length
            if (resultTextView.text == "") {
                resultTextView.text = listLetter[0].toString()
                Toast.makeText(
                    applicationContext,
                    "Осталось вывести " + (listLetter.size - 1).toString() + " символ(а)!",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (count < listLetter.size) {
                resultTextView.text =
                    resultTextView.text.toString() + listLetter[count].toString()
                if (listLetter.size != resultTextView.text.length)
                    Toast.makeText(
                        applicationContext,
                        "Осталось вывести " + (listLetter.size - resultTextView.text.length).toString() + " символ(а)!",
                        Toast.LENGTH_SHORT
                    ).show()
            } else Toast.makeText(
                applicationContext,
                "Все буквы выведенны!",
                Toast.LENGTH_LONG
            ).show()
        }
    }


    fun mutableListOfButtonClick() {
        mutableListOfButton.setOnClickListener {
            resultTextView.text = listLetter.toString()
        }
    }

    fun cleanButtonClick() {
        cleanButton.setOnClickListener {
            resultTextView.text = ""
        }
    }

    fun listOfButtonClick() {
        listOfButton.setOnClickListener()
        {
            var result = ""
            listOf('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z').filterIndexed { index, _ ->
                index % 2 != 0
            }.forEach1 {
                result += it.toString()
            }
            resultTextView.text = result
        }

    }

    fun stringButtonClick() {
        stringButton.setOnClickListener {
            var a = ""
            val k = lineAbc.length - 1
            for (i in 1..k step 2) {
                a += lineAbc[i]
            }
            resultTextView.text = a
        }

    }

}
