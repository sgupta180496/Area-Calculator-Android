/*
Assignment# 2 (In Class 02)
Name: Renju Hanna Robin, Saloni Gupta
Group 28
 */

package com.example.area_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_shape;
    private TextView tv_result;
    private Button button_calculate;
    private Button button_clear;
    private ImageView iv_triangle;
    private ImageView iv_square;
    private ImageView iv_circle;
    private EditText et_length1;
    private EditText et_length2;
    private String selectedshape ="";
    //private TextView tv_length1;
    private TextView tv_length2;
    double length1;
    double length2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Area Calculator");

        et_length1 = findViewById(R.id.et_length1);
        et_length2 = findViewById(R.id.et_length2);
        tv_result = findViewById(R.id.tv_result);
        tv_shape = findViewById(R.id.tv_shape);
        button_calculate = findViewById(R.id.button_calculate);
        button_clear = findViewById(R.id.button_clear);
        iv_circle = findViewById(R.id.iv_circle);
        iv_square = findViewById(R.id.iv_square);
        iv_triangle = findViewById(R.id.iv_triangle);

        tv_length2 = findViewById(R.id.length2);
        length1 = 0.0;
        length2 = 0.0;

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton();
            }
        });

        setParametersOnSelection();
        calculateAreaBasedOnShapeSelection();

    }

    public void clearButton() {
        et_length1.setVisibility(View.VISIBLE);
        et_length2.setVisibility(View.VISIBLE);
        tv_length2.setVisibility(View.VISIBLE);
        et_length1.setText("");
        et_length2.setText("");
        tv_shape.setText("Select a shape");
        tv_result.setText("");
        et_length1.setError(null);
        et_length2.setError(null);
        selectedshape = "none";
    }

    public void setParametersOnSelection(){
        iv_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedshape = "triangle";
                tv_shape.setText("Triangle");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.VISIBLE);
                tv_length2.setVisibility(View.VISIBLE);
                tv_result.setText("");
                length1 = 0.0;
                length2 = 0.0;
            }
        });

        iv_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedshape = "square";
                tv_shape.setText("Square");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.GONE);
                tv_length2.setVisibility(View.GONE);
                tv_result.setText("");
                length1 = 0.0;
                length2 = 0.0;
            }
        });

        iv_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedshape = "circle";
                tv_shape.setText("Circle");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.GONE);
                tv_length2.setVisibility(View.GONE);
                tv_result.setText("");
                length1 = 0.0;
                length2 = 0.0;
            }
        });
    }
    public void calculateAreaBasedOnShapeSelection() {
        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double result = 0.0;
                tv_result.setText("");

                /*
                if (et_length1.getText().toString().equals("")) {
                    et_length1.setError("Provide Value");
                } else if (selectedshape.equals("triangle") && et_length2.getText().toString().equals("")) {
                    et_length2.setError("Provide Value");
                    */
                 if(selectedshape.equals("triangle") && (et_length1.getText().toString().equals("") || et_length2.getText().toString().equals(""))){
                     if((et_length1.getText().toString().equals(""))) {
                         et_length1.setError("Provide Value");
                     }
                     if(et_length2.getText().toString().equals("")) {
                         et_length2.setError("Provide Value");
                     }
                 } else  if(selectedshape.equals("square") && et_length1.getText().toString().equals("") ||
                         selectedshape.equals("circle") && et_length1.getText().toString().equals("")){
                     et_length1.setError("Provide Value");
                 } else {

//                    Log.d("demo", "I'm here");
                    String tempLength1 = et_length1.getText().toString();
                    String tempLength2 = et_length2.getText().toString();
                    if (tempLength1 != null && !tempLength1.equals(""))
                        length1 = Double.parseDouble((tempLength1));
                    if (tempLength2 != null && !tempLength2.equals(""))
                        length2 = Double.parseDouble(tempLength2);

                    switch (selectedshape) {
                        case "triangle":
                            result = 0.5 * length1 * length2;
                            tv_result.setText(result + "");
                            break;

                        case "square":
                            result = length1 * length1;
                            tv_result.setText(result + "");
                            break;

                        case "circle":
                            result = 3.1416 * length1 * length1;
                            tv_result.setText(result + "");
                            break;
                    }
                }
            }
        });
    }
}
