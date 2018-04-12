package com.example.android.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_main);
        // Find the View that shows the test category
        TextView test = findViewById(R.id.testbutton);

        // Set a click listener on that View
        test.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the test category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent numbersIntent = new Intent(TestActivity.this, PlayerActivity.class);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });
    }
}
