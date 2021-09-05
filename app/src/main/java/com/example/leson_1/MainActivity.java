package com.example.leson_1;

import android.os.Bundle;
import android.os.Handler;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//good practice
//switch
//xml-landscape

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int seconds = 0;
    private boolean running = false;
    //private boolean wasRunning;
    private Button resetButton;
    private Button startButton;
    private Button stopButton;

    @Override
    /*
    * Bundle savedInstanceState это надо для переворота Leson_2 1:12:00
    * */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            Log.i("MainActivity", "savedInstanceState");
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }

        resetButton = (Button) findViewById(R.id.reset_button);
        startButton = (Button) findViewById(R.id.start_button);
        stopButton = (Button) findViewById(R.id.stop_button);
        resetButton.setOnClickListener(this);
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        runTimer();
    }

    @Override
    public void onClick(View view) {
        if (view.equals(resetButton)) {
            running = false;
            seconds = 0;
            return;
        }
        if (view.equals(startButton)) {
            running = true;
        }
        if (view.equals(stopButton)) {
            running = false;
        }
    }

    //Запуск таймера в отдельном потоке
    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.textView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                Log.i("MainActivity", "seconds" + secs);
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);//Период с которым вызывается функция run()
            }
        });
    }

    @Override
    protected void onStart() {
        Log.i("MainActivity", "onStart");
        Log.i("MainActivity", "wasRunning");

        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i("MainActivity", "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("MainActivity", "onPause");
        Log.i("MainActivity", "running " + running);
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("MainActivity", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("MainActivity", "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.i("MainActivity", "onRestart");
        super.onRestart();
    }

    @Override
    /*
    * Вызывается при пересоздании активити
    * */
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i("MainActivity", "onSaveInstanceState");
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
    }

}
