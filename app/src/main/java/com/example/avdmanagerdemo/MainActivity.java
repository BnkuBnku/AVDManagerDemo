package com.example.avdmanagerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.*;
import org.mariuszgromada.math.mxparser.Expression;


public class MainActivity extends AppCompatActivity {

    private TextView NumbersTop;
    private EditText Numbers;

    private String SumNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumbersTop = findViewById(R.id.Number2TextView);
        Numbers = findViewById(R.id.NumbersTextView);
        Numbers.setShowSoftInputOnFocus(false);

        Numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(Numbers.getText().toString())){
                    Numbers.setText("");
                }
            }
        });
    }

    private void UpString(String strToAdd){
        String oldStr = Numbers.getText().toString();
        int cursorP = Numbers.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorP);
        String rightStr = oldStr.substring(cursorP);
        if(getString(R.string.display).equals(Numbers.getText().toString())){
            Numbers.setText(strToAdd);
            Numbers.setSelection(cursorP + 1);
        }
        else{
            Numbers.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            Numbers.setSelection(cursorP + 1);
        }
    }

    public void ZeroButton(View view){
        UpString("0");
    }

    public void OneButton(View view){
        UpString("1");
    }

    public void TwoButton(View view){
        UpString("2");
    }

    public void ThreeButton(View view){
        UpString("3");
    }

    public void FourButton(View view){
        UpString("4");
    }

    public void FiveButton(View view){
        UpString("5");
    }

    public void SixButton(View view){
        UpString("6");
    }

    public void SevenButton(View view){
        UpString("7");
    }

    public void EightButton(View view){
        UpString("8");
    }

    public void NineButton(View view){
        UpString("9");
    }

    public void DeleteButton(View view){
        int cursorP = Numbers.getSelectionStart();
        int textLine = Numbers.getText().length();

        if(cursorP != 0 && textLine != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) Numbers.getText();
            selection.replace(cursorP - 1, cursorP, "");
            Numbers.setText(selection);
            Numbers.setSelection(cursorP - 1);
        }
    }

    public void DivisionButton(View view){
        UpString("÷");
        NumbersTop.setText(Numbers.getText().toString());
        Numbers.setText("");
    }

    public void MultiButton(View view){
        UpString("×");
        NumbersTop.setText(Numbers.getText().toString());
        Numbers.setText("");
    }

    public void SubtractButton(View view){
        UpString("-");
        NumbersTop.setText(Numbers.getText().toString());
        Numbers.setText("");
    }

    public void AddButton(View view){
        UpString("+");
        NumbersTop.setText(Numbers.getText().toString());
        Numbers.setText("");
    }

    public void equalButton(View view){
        String UE = NumbersTop.getText().toString() + Numbers.getText().toString();
        NumbersTop.setText(NumbersTop.getText().toString() + Numbers.getText().toString() + " = "); //Final Calculation Display
        UE = UE.replaceAll("÷", "/");
        UE = UE.replaceAll("×", "*");

        Expression exp = new Expression(UE);
        String results = String.valueOf(exp.calculate());

        Numbers.setText(results);
        Numbers.setSelection(results.length());
    }

    public void exponentButton (View view){
        UpString("^");
        NumbersTop.setText(Numbers.getText().toString());
        Numbers.setText("");
    }

    public void CButton(View view){
        Numbers.setText("");
    }

    public void CEButton(View view){
        NumbersTop.setText("");
        Numbers.setText("");
    }

    public void PercentButton(View view){
        UpString("%");
        NumbersTop.setText(Numbers.getText().toString());
        Numbers.setText("");
    }

    public void DotButton(View view){
        UpString(".");
    }

    public void PlusorMinus(View view){ UpString("-");
    }
}