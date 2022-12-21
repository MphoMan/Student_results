package com.example.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText num1, num2, num3, num4;
    Button btn;
    private TextView errors, results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.etnumber1);
        num2 = (EditText)findViewById(R.id.etnumber2);
        num3 = (EditText)findViewById(R.id.etnumber3);
        num4 = (EditText)findViewById(R.id.etnumber4);

        btn = (Button)findViewById(R.id.btncalculate);

        errors = (TextView)findViewById(R.id.txterrors);
        results = (TextView)findViewById(R.id.txtpercentage);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    int firstNum = Integer.parseInt(num1.getText().toString());
                    int secondNum = Integer.parseInt(num2.getText().toString());
                    int thirdNum = Integer.parseInt(num3.getText().toString());
                    int examNum = Integer.parseInt(num4.getText().toString());

                    double sum = firstNum * .15 + secondNum * .35 + thirdNum * .50;
                    double finalMark = sum * .49 + examNum * .51;

                    if ((firstNum <= 100) && (secondNum <= 100) && (thirdNum <= 100)) {
                        if ((finalMark >= 0) && (finalMark < 50)) {
                            results.setText(String.valueOf(Math.round (finalMark)) + "% F");
                        } else if ((finalMark >= 50) && (finalMark < 75)) {
                            results.setText(String.valueOf(Math.round (finalMark)) + "% P");
                        } else if ((finalMark >= 75) && (finalMark <= 100)) {
                            results.setText(String.valueOf(Math.round (finalMark)) + "% D");
                        }
                    } else {
                        errors.setText("Field can't be empty or above 100");
                    }
                }catch (Exception e){

                    errors.setText("Enter your Marks");
                }
            }
        });

    }
}