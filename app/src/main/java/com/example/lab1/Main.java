package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    private EditText editTextNumber2, editTextNumber3, editTextNumber4, editTextNumber5,
            editTextNumber10, editTextNumber11, editTextNumber12, editTextNumber13;
    private Button calculate;
    private Object objectToBuild = Object.CIRCLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextNumber3 = findViewById(R.id.editTextNumber3);
        editTextNumber4 = findViewById(R.id.editTextNumber4);
        editTextNumber5 = findViewById(R.id.editTextNumber5);
        editTextNumber10 = findViewById(R.id.editTextNumber10);
        editTextNumber11 = findViewById(R.id.editTextNumber11);
        editTextNumber12 = findViewById(R.id.editTextNumber12);
        editTextNumber13 = findViewById(R.id.editTextNumber13);
        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, Result.class);

                try {
                    int x1 = Integer.parseInt(editTextNumber2.getText().toString());
                    int x2 = Integer.parseInt(editTextNumber4.getText().toString());
                    int y1 = Integer.parseInt(editTextNumber3.getText().toString());
                    int y2 = Integer.parseInt(editTextNumber5.getText().toString());
                    int x3 = 0;
                    int x4 = 0;
                    int y3 = 0;
                    int y4 = 0;
                    int area = 0;

                    switch (objectToBuild) {
                        case RECTANGLE:
                            x3 = Integer.parseInt(editTextNumber10.getText().toString());
                            x4 = Integer.parseInt(editTextNumber12.getText().toString());
                            y3 = Integer.parseInt(editTextNumber11.getText().toString());
                            y4 = Integer.parseInt(editTextNumber13.getText().toString());
                            area = Math.abs(x1*y2 + x2*y3 + x3*y4 + x4*y1 - y1*x2 - y2*x3 - y3*x4 - y4*x1)/2;
                            intent.putExtra("x3", x3);
                            intent.putExtra("x4", x4);
                            intent.putExtra("y3", y3);
                            intent.putExtra("y4", y4);
                            break;
                        case TRIANGLE:
                            x3 = Integer.parseInt(editTextNumber10.getText().toString());
                            y3 = Integer.parseInt(editTextNumber11.getText().toString());
                            area = Math.abs(x1*y2 + x2*y3 + x3*y1 - y1*x2 - y2*x3 - y3*x1)/2;
                            intent.putExtra("x3", x3);
                            intent.putExtra("y3", y3);
                            break;
                        case CIRCLE:
                            area = (int) (Math.pow(Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2)), 2) * 3.14);
                            break;
                        case ELIPS:
                            x3 = Integer.parseInt(editTextNumber10.getText().toString());
                            y3 = Integer.parseInt(editTextNumber11.getText().toString());
                            area = (int) ((int) Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2)) * Math.sqrt(Math.pow((x1-x3), 2) + Math.pow((y1-y3), 2)) * 3.14);
                            intent.putExtra("x3", x3);
                            intent.putExtra("y3", y3);
                            break;
                    }

                    intent.putExtra("area", area);
                    intent.putExtra("x1", x1);
                    intent.putExtra("x2", x2);
                    intent.putExtra("y1", y1);
                    intent.putExtra("y2", y2);

                    startActivity(intent);
                } catch (Exception e) {
                    findViewById(R.id.textView14).setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void showRectangle(View view) {
        findViewById(R.id.editTextNumber10).setVisibility(View.VISIBLE);
        findViewById(R.id.editTextNumber11).setVisibility(View.VISIBLE);
        findViewById(R.id.editTextNumber12).setVisibility(View.VISIBLE);
        findViewById(R.id.editTextNumber13).setVisibility(View.VISIBLE);
        findViewById(R.id.textView10).setVisibility(View.VISIBLE);
        findViewById(R.id.textView11).setVisibility(View.VISIBLE);
        findViewById(R.id.textView12).setVisibility(View.VISIBLE);
        findViewById(R.id.textView13).setVisibility(View.VISIBLE);
        objectToBuild = Object.RECTANGLE;
    }

    public void showTriangle(View view) {
        findViewById(R.id.editTextNumber10).setVisibility(View.VISIBLE);
        findViewById(R.id.editTextNumber11).setVisibility(View.VISIBLE);
        findViewById(R.id.editTextNumber12).setVisibility(View.INVISIBLE);
        findViewById(R.id.editTextNumber13).setVisibility(View.INVISIBLE);
        findViewById(R.id.textView10).setVisibility(View.VISIBLE);
        findViewById(R.id.textView11).setVisibility(View.VISIBLE);
        findViewById(R.id.textView12).setVisibility(View.INVISIBLE);
        findViewById(R.id.textView13).setVisibility(View.INVISIBLE);
        objectToBuild = Object.TRIANGLE;
    }

    public void showElips(View view) {
        findViewById(R.id.editTextNumber10).setVisibility(View.VISIBLE);
        findViewById(R.id.editTextNumber11).setVisibility(View.VISIBLE);
        findViewById(R.id.editTextNumber12).setVisibility(View.INVISIBLE);
        findViewById(R.id.editTextNumber13).setVisibility(View.INVISIBLE);
        findViewById(R.id.textView10).setVisibility(View.VISIBLE);
        findViewById(R.id.textView11).setVisibility(View.VISIBLE);
        findViewById(R.id.textView12).setVisibility(View.INVISIBLE);
        findViewById(R.id.textView13).setVisibility(View.INVISIBLE);
        objectToBuild = Object.ELIPS;
    }

    public void showCircle(View view) {
        findViewById(R.id.editTextNumber10).setVisibility(View.INVISIBLE);
        findViewById(R.id.editTextNumber11).setVisibility(View.INVISIBLE);
        findViewById(R.id.editTextNumber12).setVisibility(View.INVISIBLE);
        findViewById(R.id.editTextNumber13).setVisibility(View.INVISIBLE);
        findViewById(R.id.textView10).setVisibility(View.INVISIBLE);
        findViewById(R.id.textView11).setVisibility(View.INVISIBLE);
        findViewById(R.id.textView12).setVisibility(View.INVISIBLE);
        findViewById(R.id.textView13).setVisibility(View.INVISIBLE);
        objectToBuild = Object.CIRCLE;
    }
}
