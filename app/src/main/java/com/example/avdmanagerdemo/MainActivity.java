package com.example.avdmanagerdemo;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression; //Using Math  for all complicated calculation.

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.Toast;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView ValueT;
    private EditText ValueB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ValueT = findViewById(R.id.ValueTTV);
        ValueB = findViewById(R.id.ValueBTV);

        ValueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(ValueB.getText().toString())){
                    ValueB.setText("");
                    Toast.makeText(MainActivity.this, "Add" , Toast.LENGTH_LONG).show();
                }
            }
        });

        ValueB.setShowSoftInputOnFocus(false);
    }

    public void ZeroBut(View view){
        Frosh("0");
    }

    public void OneBut(View view){
        Frosh("1");
    }

    public void TwoBut(View view){
        Frosh("2");
    }

    public void ThreeBut(View view){
        Frosh("3");
    }

    public void FourBut(View view){
        Frosh("4");
    }

    public void FiveBut(View view){
        Frosh("5");
    }

    public void SixBut(View view){
        Frosh("6");
    }

    public void SevenBut(View view){
        Frosh("7");
    }

    public void EightBut(View view){
        Frosh("8");
    }

    public void NineBut(View view){
        Frosh("9");
    }

    public void DivBut(View view){
        Frosh("÷");
        ValueT.setText(ValueB.getText().toString());
        ValueB.setText("");
    }

    public void MulBut(View view){
        Frosh("×");
        ValueT.setText(ValueB.getText().toString());
        ValueB.setText("");
    }

    public void SubBut(View view){
        Frosh("-");
        ValueT.setText(ValueB.getText().toString());
        ValueB.setText("");
    }

    public void AddBut(View view){
        Frosh("+");
        ValueT.setText(ValueB.getText().toString());
        ValueB.setText("");
    }

    public void EQBut(View view){
        String UE = ValueT.getText().toString() + ValueB.getText().toString();
        ValueT.setText(ValueT.getText().toString() + ValueB.getText().toString() + " = "); //Final Calculation Display
        UE = UE.replaceAll("÷", "/");
        UE = UE.replaceAll("×", "*");

        Expression exp = new Expression(UE);
        String results = String.valueOf(exp.calculate());

        ValueB.setText(results);
        ValueB.setSelection(results.length());
    }

    public void ExpBut (View view){
        Frosh("^");
        ValueT.setText(ValueB.getText().toString());
        ValueB.setText("");
    }

    public void CBut(View view){
        ValueB.setText("");
    }

    public void CEBut(View view){
        ValueT.setText("");
        ValueB.setText("");
    }

    public void PercBut(View view){
        Frosh("%");
        ValueT.setText(ValueB.getText().toString());
        ValueB.setText("");
    }
    public void DotesBut(View view){
        Frosh(".");
    }

    public void PorMBut(View view){ Frosh("-");
    }

    public void DelBut(View view){
        int cursorP = ValueB.getSelectionStart();
        int textLine = ValueB.getText().length();

        if(cursorP != 0 && textLine != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) ValueB.getText();
            selection.replace(cursorP - 1, cursorP, "");
            ValueB.setText(selection);
            ValueB.setSelection(cursorP - 1);
        }
    }

    private void Frosh(String strToAdd){
        String oldStr = ValueB.getText().toString();
        int cursorP = ValueB.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorP);
        String rightStr = oldStr.substring(cursorP);
        if(getString(R.string.display).equals(ValueB.getText().toString())){
            ValueB.setText(strToAdd);
            ValueB.setSelection(cursorP + 1);
        }
        else{
            ValueB.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            ValueB.setSelection(cursorP + 1);
        }
    }
}