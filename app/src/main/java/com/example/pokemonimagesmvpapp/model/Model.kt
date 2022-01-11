package com.example.pokemonimagesmvpapp.model

import android.os.Handler
import com.example.pokemonimagesmvpapp.interfaces.Contract
import java.util.*

class Model : Contract.Model {

    // this method will invoke when
    // user clicks on the button
    // and it will take a delay of
    // 1200 milliseconds to display next course detail
    override fun getNextCourse(onFinishedListener: Contract.Model.OnFinishedListener?) {
        Handler().postDelayed({ onFinishedListener!!.onFinished(getRandomString) }, 1200)
    }


    // method to select random url strings
    private val getRandomString: String
        private get() {
            val random = Random()
            val index = random.nextInt(10)
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${index}.png"
        }
}