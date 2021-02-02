package no.uia.ikt205.pomodoro

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import no.uia.ikt205.pomodoro.util.millisecondsToDescriptiveTime

class MainActivity : AppCompatActivity() {


    //note: required to set every single variable, else it crashes?
    private lateinit var timer:CountDownTimer
    private lateinit var timerPause:CountDownTimer
    private lateinit var startButton:Button
    private lateinit var countdownDisplay:TextView
    private lateinit var seekBar: SeekBar
    private lateinit var antallRep: EditText
    var timetoInMs = 0L
    var timetoInMsPause = 0L
    val timeTicks = 1000L
    val timeTicksPause = 1000L
    var countdownRunning=false
    var pauseCountdownRun=false
    var rep = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // seekbar for arbeidstid i minutter
        antallRep = findViewById(R.id.repetisjoner)
        seekBar = findViewById(R.id.inputarbeidMinutter)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                timetoInMs = progress * 60000L
                updateCountDownDisplay(timetoInMs)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                updateCountDownDisplay(timetoInMs)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                updateCountDownDisplay(timetoInMs)
            }

        })

        seekBar = findViewById(R.id.inputpauseMinutter)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                timetoInMsPause = progress * 60000L
                updateCountDownDisplay(timetoInMsPause)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                updateCountDownDisplay(timetoInMsPause)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                updateCountDownDisplay(timetoInMsPause)
            }
        })


        startButton = findViewById(R.id.startCountdownButton)
        startButton.setOnClickListener {
            if (!countdownRunning && !pauseCountdownRun){
                rep = antallRep.text.toString().toInt()
                startCountDown(it)
                return@setOnClickListener}
            Toast.makeText(this@MainActivity,"Arbeidsøkt pågår", Toast.LENGTH_SHORT).show()
        }


        countdownDisplay = findViewById(R.id.countDownView)
    }

    fun startCountDown(v: View){

        timer = object : CountDownTimer(timetoInMs,timeTicks) {
            override fun onFinish() {
                Toast.makeText(this@MainActivity,"Arbeidsøkt ferdig", Toast.LENGTH_SHORT).show()
                if (!pauseCountdownRun && rep >0){
                    startCountDownPause(v)
                }

                rep --
                countdownRunning = false
            }

            override fun onTick(millisUntilFinished: Long) {
                updateCountDownDisplay(millisUntilFinished)
                countdownRunning = true
                pauseCountdownRun = false
            }
        }

        timer.start()
    }

    fun startCountDownPause(v: View){
        timerPause = object : CountDownTimer(timetoInMsPause,timeTicksPause) {
            override fun onFinish() {
                Toast.makeText(this@MainActivity,"Pause ferdig", Toast.LENGTH_SHORT).show()
                if (!countdownRunning && rep > 0)
                    startCountDown(v)
                pauseCountdownRun = false
            }


            override fun onTick(millisUntilFinished: Long) {
                updateCountDownDisplay(millisUntilFinished)
                pauseCountdownRun = true
                countdownRunning = false
            }
        }

        timerPause.start()
    }

    fun updateCountDownDisplay(timeInMs:Long){
        countdownDisplay.text = millisecondsToDescriptiveTime(timeInMs)
    }
}