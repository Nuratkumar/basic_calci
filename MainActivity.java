package com.example.basic_calci;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView result, solution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        result = findViewById(R.id.result);
        solution = findViewById(R.id.solution);

        assignId(R.id.btn_c1);
        assignId(R.id.btn_c2);
        assignId(R.id.btn_c3);
        assignId(R.id.btn_c4);
        assignId(R.id.btn_c5);
        assignId(R.id.btn_c6);
        assignId(R.id.btn_c7);
        assignId(R.id.btn_c8);
        assignId(R.id.btn_c9);
        assignId(R.id.btn_c10);
        assignId(R.id.btn_c11);
        assignId(R.id.btn_c12);
        assignId(R.id.btn_c13);
        assignId(R.id.btn_c14);
        assignId(R.id.btn_c15);
        assignId(R.id.btn_c16);
        assignId(R.id.btn_c17);
        assignId(R.id.btn_c18);
        assignId(R.id.btn_c19);
        assignId(R.id.btn_c20);
    }

    private void assignId(int id) {
        MaterialButton button = findViewById(id);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton btn = (MaterialButton) view;
        String buttonText = btn.getText().toString();

        switch (buttonText) {
            case "AC":
                solution.setText("");
                result.setText("0");
                break;
            case "=":
                String dataToCalculate = solution.getText().toString();
                result.setText(getResult(dataToCalculate));
                break;
            case "C":
                String data = solution.getText().toString();
                if (!data.isEmpty()) {
                    solution.setText(data.substring(0, data.length() - 1));
                }
                break;
            default:
                solution.append(buttonText);
                break;
        }
    }

    private String getResult(String data) {
        // Initialize variables
        double result = 0;
        String operator = "";
        String[] elements;

        // Split the input data by arithmetic operators
        if (data.contains("+")) {
            elements = data.split("\\+");
            operator = "+";
        } else if (data.contains("-")) {
            elements = data.split("-");
            operator = "-";
        } else if (data.contains("*")) {
            elements = data.split("\\*");
            operator = "*";
        } else if (data.contains("/")) {
            elements = data.split("/");
            operator = "/";
        } else {
            return data; // If no operator found, return input as result
        }

        // Perform arithmetic operations
        double operand1 = Double.parseDouble(elements[0]);
        double operand2 = Double.parseDouble(elements[1]);

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    return "Error: undefined";
                }
                break;
        }

        // Format and return the result
        return String.valueOf(result);
    }


}
