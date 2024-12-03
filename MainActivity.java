package com.example.myapplicati;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
 private TextView tvResult;
 private String currentInput = "";
 private double firstValue = 0;
 private String operator = "";
 private boolean isOperatorPressed = false;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 tvResult = findViewById(R.id.tvResult);
 View.OnClickListener listener = view -> {
 Button button = (Button) view;
 String buttonText = button.getText().toString();
 switch (buttonText) {
 case "C":
 clear();
 break;
 case "=":
 calculate();
 break;
 case "+":
 case "-":
 case "*":
 case "/":
 setOperator(buttonText);
 break;
 default:
 appendNumber(buttonText);
 break;
 }
 };
 int[] buttonIds = {
 R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
 R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnAdd, R.id.btnSubtract,
 R.id.btnMultiply, R.id.btnDivide, R.id.btnClear, R.id.btnEqual
 };
 for (int id : buttonIds) {
 findViewById(id).setOnClickListener(listener);
    }
 }
 private void appendNumber(String number) {
 if (isOperatorPressed) {
 currentInput = "";
 isOperatorPressed = false;
 }
 currentInput += number;
 tvResult.setText(currentInput);
 }
 private void setOperator(String op) {
 firstValue = Double.parseDouble(currentInput);
 operator = op;
 isOperatorPressed = true;
 }
 @SuppressLint("SetTextI18n")
 private void calculate() {
 double secondValue = Double.parseDouble(currentInput);
 double result = 0;
 switch (operator) {
 case "+":
 result = firstValue + secondValue;
 break;
 case "-":
 result = firstValue - secondValue;
 break;
 case "*":
 result = firstValue * secondValue;
 break;
 case "/":
 if (secondValue != 0) result = firstValue / secondValue;
 else tvResult.setText("Error");
 break;
 }
 currentInput = String.valueOf(result);
 tvResult.setText(currentInput);
 }
 private void clear() {
 currentInput = "0";
 firstValue = 0;
 operator = "";
 isOperatorPressed = false;
   tvResult.setText(currentInput);
 }
}
