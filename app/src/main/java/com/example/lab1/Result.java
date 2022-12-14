package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;

public class Result extends AppCompatActivity {
    private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        int area = getIntent().getIntExtra("area", 0);

        ((TextView) findViewById(R.id.textView6)).setText(area);

        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = "x1: " + getIntent().getIntExtra("x1", 0) + "\n" +
                        "x2: " + getIntent().getIntExtra("x2", 0) + "\n" +
                        "x3: " + getIntent().getIntExtra("x2", 0) + "\n" +
                        "x4: " + getIntent().getIntExtra("x4", 0) + "\n" +
                        "y1: " + getIntent().getIntExtra("y1", 0) + "\n" +
                        "y2: " + getIntent().getIntExtra("y2", 0) + "\n" +
                        "y3: " + getIntent().getIntExtra("y3", 0) + "\n" +
                        "y4: " + getIntent().getIntExtra("y4", 0) + "\n";
                writeToFile("file.txt", result);
            }
        });
    }

    public void writeToFile(String fileName, String content){
        File path = getApplicationContext().getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, fileName));
            writer.write(content.getBytes());
            writer.close();
            Toast.makeText(getApplicationContext(), "Збережено у файл: " + fileName,Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
