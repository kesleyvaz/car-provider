package com.example.mycompany

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.digitalinnovationone.person_provider.*
import com.example.mycompany.databinding.*
import java.util.*
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var currentCar: Car

    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialStatus()

        with(binding) {
            btFastCar.setOnClickListener {
                startActionsWith(CarFactory.getCar(CarType.FAST))
            }
            btSlowCar.setOnClickListener {
                startActionsWith(CarFactory.getCar(CarType.SLOW))
            }
            btStopCar.setOnClickListener {
                timer.cancel()
                initialStatus()
            }
        }
    }

    private fun initialStatus() {
        changeStopButtonStatus(enable = false)
        changePersonButtonsStatus(enable = true)
        binding.tvCarState.text = ""
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    private fun startActionsWith(car: Car) {
        currentCar = car
        changeStopButtonStatus(enable = true)
        changePersonButtonsStatus(enable = false)
        initTask()
    }

    private fun initTask() {
        timer = Timer().apply {
            schedule(
                object : TimerTask() {
                    override fun run() {
                        performRandomAction()
                    }
                },
                1000,
                1500
            )
        }
    }

    private fun changePersonButtonsStatus(enable: Boolean) {
        with(binding) {
            btSlowCar.isEnabled = enable
            btFastCar.isEnabled = enable
        }
    }

    private fun changeStopButtonStatus(enable: Boolean) {
        with(binding) {
            btStopCar.isEnabled = enable
        }
    }

    private fun performRandomAction() {

        when (nextInt(5)) {
            0 -> currentCar.brake()
            1 -> currentCar.speedUp()
            2 -> currentCar.turnRight()
            3 -> currentCar.turnLeft()
            4 -> currentCar.backUp()
        }

        runOnUiThread {
            binding.tvCarState.text = currentCar.state
        }
    }
}
