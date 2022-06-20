package com.example.thecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayText);

        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();

        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring((cursorPos));

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroBTNPush(View view) {
        updateText(getResources().getString(R.string.zeroText));
    }

    public void clearPush(View view) {
        display.setText("");
        previousCalculation.setText("");
    }

    public void oneBTNPush(View view) {
        updateText(getResources().getString(R.string.oneText));
    }

    public void twoBTNPush(View view) {
        updateText(getResources().getString(R.string.twoText));
    }

    public void threeBTNPush(View view) {
        updateText(getResources().getString(R.string.threeText));
    }

    public void fourBTNPush(View view) {
        updateText(getResources().getString(R.string.fourText));
    }

    public void fiveBTNPush(View view) {
        updateText(getResources().getString(R.string.fiveText));
    }

    public void openbrackPush(View view) {
        updateText("(");
    }

    public void closebrackPush(View view) {
        updateText(")");
    }

    public void xSquarePush(View view) {
        updateText("^(2)");
    }

    public void korenPush(View view) {
        updateText("sqrt(");
    }

    public void sixBTNPush(View view) {
        updateText(getResources().getString(R.string.sixText));
    }

    public void sevenBTNPush(View view) {
        updateText(getResources().getString(R.string.sevenText));
    }

    public void eightBTNPush(View view) {
        updateText(getResources().getString(R.string.eightText));
    }

    public void nineBTNPush(View view) {
        updateText(getResources().getString(R.string.nineText));
    }

    public void plusPush(View view) {
        updateText(getResources().getString(R.string.addText));
    }

    public void minusPush(View view) {
        updateText(getResources().getString(R.string.subtractText));
    }

    public void umnoPush(View view) {
        updateText(getResources().getString(R.string.multiplyText));
    }

    public void dividePush(View view) {
        updateText(getResources().getString(R.string.divideText));
    }



    public void deletePush(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void equalPush(View view) {
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }
}