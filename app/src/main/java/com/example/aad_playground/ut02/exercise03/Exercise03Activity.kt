package com.example.aad_playground.ut02.exercise03


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import com.example.aad_playground.R
import com.example.aad_playground.commons.GsonSerializer
import com.example.aad_playground.ut02.exercise03.data.AppModel
import com.example.aad_playground.ut02.exercise03.data.AppRepository
import com.example.aad_playground.ut02.exercise03.data.SharPrefLocalStorage

/**
 * El ejercicio lleva un README.md con la información detallada de lo que se pide.
 * Ten presente los objetivos que se trabajan para la resolución de la tarea.
 */
class Exercise03Activity : AppCompatActivity() {

    private val TAG = Exercise03Activity::class.java.simpleName
    private lateinit var appRatingBar: RatingBar

    private lateinit var appRepository: AppRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise03)
        setupView()
        isFirstTime()
        setRatingValue()
    }

    private fun setupView() {
        appRepository = AppRepository(SharPrefLocalStorage(this, GsonSerializer()))
        findViewById<Button>(R.id.action_reset).setOnClickListener {
            actionResetClicked()
        }
        appRatingBar = findViewById(R.id.action_rating)
        appRatingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            kotlin.run {
                if (fromUser) {
                    onChangeRating(rating)
                }
            }
        }
    }

    /**
     * Método que me indica TRUE si es la primera vez que abro la aplicación o FALSE si ya la
     * he abierto más de una vez. Si la aplicación se cierra, debe seguir conservando la información.
     */
    private fun isFirstTime() {
        val model = appRepository.fetch()

        if (model != null) {
            if (model.isFirstTime == true) {
                Log.d(TAG, "Primera vez que se abre")
                model.isFirstTime = false
                appRepository.save(model)
            } else {
                Log.d(TAG, "No es la primera vez que se abre ")
            }
        }
    }


    /**
     * Método que se ejecuta cada vez que se pulsa el botón reset
     * Debería reiniciar las estrellas a 0.
     */
    private fun actionResetClicked() {
        val model = appRepository.fetch()
        if (model != null) {
            model.rating = 0f
            appRepository.save(model)
            appRatingBar.rating = 0f
        }
    }

    /**
     * Método que se ejecuta cuando el usuario cambia el valor del rating
     * En este método debemos almacenar el valor
     */
    private fun onChangeRating(newValue: Float) {
        Log.d(TAG, "El usuario está cambiando el valor: ${newValue.toString()}")
        val model = appRepository.fetch()
        if (model != null) {
            model.rating = newValue
            appRepository.save(model)
        }
    }

    /**
     * Método que actualiza el rating.
     * Obtener el valor del repositorio y actualizar en el RatingBarr
     */
    private fun setRatingValue() {
        val model = appRepository.fetch()
        if (model != null) {
            appRatingBar.rating = model.rating
        }

    }
}