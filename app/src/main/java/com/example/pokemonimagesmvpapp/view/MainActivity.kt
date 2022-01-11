package com.example.pokemonimagesmvpapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import coil.api.load
import com.example.pokemonimagesmvpapp.R
import com.example.pokemonimagesmvpapp.interfaces.Contract
import com.example.pokemonimagesmvpapp.model.Model
import com.example.pokemonimagesmvpapp.presenter.Presenter

class MainActivity : AppCompatActivity(), Contract.View {
    // creating object of TextView class
    private var imageView: ImageView? = null

    // creating object of Button class
    private var button: Button? = null

    // creating object of ProgressBar class
    private var progressBar: ProgressBar? = null

    // creating object of Presenter interface in Contract
    var presenter: Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assigning ID of the TextView
        imageView = findViewById(R.id.imageView2)

        // assigning ID of the Button
        button = findViewById(R.id.button)

        // assigning ID of the ProgressBar
        progressBar = findViewById(R.id.progressBar)

        // instantiating object of Presenter Interface
        presenter = Presenter(this, Model())

        // operations to be performed when
        // user clicks the button
        this.button!!.setOnClickListener(View.OnClickListener { presenter!!.onButtonClick() })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }

    // method to display the Course Detail TextView
    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        imageView!!.visibility = View.INVISIBLE
    }

    // method to hide the Course Detail TextView
    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
        imageView!!.visibility = View.VISIBLE
    }

    // method to set random string
    // in the Course Detail TextView
    override fun setImage(string: String?) {
        imageView!!.load(string)
    }
}
