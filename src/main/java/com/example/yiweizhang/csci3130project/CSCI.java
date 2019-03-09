package com.example.yiweizhang.csci3130project;

/**
 * Created by Shuo Yang on 2018/3/21.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class CSCI extends AppCompatActivity{
    private Button course1;
    private Button course2;
    private Button course3;
    private Button course4;
    private Button course5;
    private Button course6;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.csci_csci);
        course1 = findViewById(R.id.cs1000);
        course2 = findViewById(R.id.cs2000);
        course3 = findViewById(R.id.cs3000);
        course4 = findViewById(R.id.cs4000);
        course5 = findViewById(R.id.cs5000);
        course5 = findViewById(R.id.cs6000);

    }
}
