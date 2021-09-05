package com.example.leson_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private ColorSpec spec = new ColorSpec();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickColorEffect(View view) {
        Log.d("MainActivity", "onClickColorEffect");
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        TextView text2 = (TextView) findViewById(R.id.textView2);//нейминг!!!
        String color = String.valueOf(spinner.getSelectedItem());
        String result = spec.getEffect(color);//getEffect это функция класса  ColorSpec
        text2.setText(result);
    }

}