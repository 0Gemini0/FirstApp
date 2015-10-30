package com.example.gemini.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // generate a random number
        Random generator = new Random();
        final int randomNumber = generator.nextInt(101);


        final TextView firstTextView = (TextView) findViewById(R.id.textView);
        Button firstButton = (Button) findViewById(R.id.firstButton);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean correctTrue = false;
                EditText input = (EditText) findViewById(R.id.editText);
                int guessNumber = Integer.parseInt(input.getText().toString());
                if (guessNumber == randomNumber) {
                    firstTextView.setText("Correct!");
                    correctTrue = true;
                }
                else if (guessNumber < 0 || guessNumber > 100) {
                    firstTextView.setText("Wrong input!");
                }
                else if (guessNumber < randomNumber) {
                    firstTextView.setText("Higher");
                }
                else if (guessNumber > randomNumber) {
                    firstTextView.setText("Lower");
                }
                input.setText("");
                if (correctTrue == true) {
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    recreate();
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
