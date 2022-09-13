package net.ivanvega.mirollerb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etiqueta: TextView
    lateinit var boton : Button
    lateinit var img : ImageView
    lateinit var img2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_roller)

        img = findViewById(R.id.imgRoller)
        img2 = findViewById(R.id.Img_Roller2)
        boton = findViewById(R.id.btnClick)
        etiqueta = findViewById(R.id.lblRoller)

        img.setImageResource(R.drawable.empty_dice)
        img2.setImageResource(R.drawable.empty_dice)

        val dra = resources.getDrawable(R.drawable.dice_3)
        //img.setImageDrawable(dra)

        //forma larga de asignar listener
        /*
        boton.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,
                "Boton presionado", Toast.LENGTH_LONG ).show()
        })*/

        boton.setOnClickListener {
            Toast.makeText(applicationContext,
                "Boton presionado", Toast.LENGTH_LONG ).show()

            val aleatorio = diceRoller()
            val aleatorio2 = diceRoller()

            etiqueta.text = "Alatorio ${aleatorio}"

            val imgAleId =  when (aleatorio) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.empty_dice
            }
            img.setImageResource(imgAleId)

            val imgAleId2 =  when (aleatorio2) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.empty_dice
            }
            img2.setImageResource(imgAleId2)
        }
    }

    fun diceRoller(par: Int = 0): Int{
        return (1..6).random()
    }

}