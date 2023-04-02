package edu.qc.seclass.tipcalculator;

import static java.lang.Math.ceil;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }

    //You can ignore all the comments.

    public void computeTip(View view){
        EditText checkAmount = (EditText) findViewById(R.id.checkAmountValue);
        EditText partySize = (EditText) findViewById(R.id.partySizeValue);
        String checkAmountString = checkAmount.getText().toString();
        String partySizeString = partySize.getText().toString();
        EditText fifteenPercentTipMessage = findViewById(R.id.fifteenPercentTipValue);
        EditText fifteenPercentTotalMessage = findViewById(R.id.fifteenPercentTotalValue);
        EditText twentyPercentTipMessage = findViewById(R.id.twentyPercentTipValue);
        EditText twentyPercentTotalMessage = findViewById(R.id.twentyPercentTotalValue);
        EditText twentyFivePercentTipMessage = findViewById(R.id.twentyfivePercentTipValue);
        EditText twentyFivePercentTotalMessage = findViewById(R.id.twentyfivePercentTotalValue);


        /* What I am trying to do:
        I am trying to if statement, where checkAmount and partySize cannot be less than zero
        and empty
         */


        if(checkAmountString.isEmpty() || partySizeString.isEmpty() || Integer.parseInt(partySizeString)< 1 || Integer.parseInt(checkAmountString)<0) {
            CharSequence text = "Empty or Incorrect Value(s)";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            fifteenPercentTipMessage.setText("");
            fifteenPercentTotalMessage.setText("");
            twentyPercentTipMessage.setText("");
            twentyPercentTotalMessage.setText("");
            twentyFivePercentTipMessage.setText("");
            twentyFivePercentTotalMessage.setText("");

        }

        /*
        Now I need to use those two method and insert checkAmount and partySize and display it in correct order.
         */
        else {
            int checkAmountInteger = Integer.parseInt(checkAmountString);
            int partySizeInteger = Integer.parseInt(partySizeString);
            int tipCalculation15 = tipCalculation(0.15, checkAmountInteger, partySizeInteger);
            int tipCalculation20 = tipCalculation(0.20, checkAmountInteger, partySizeInteger);
            int tipCalculation25 = tipCalculation(0.25, checkAmountInteger, partySizeInteger);


            fifteenPercentTipMessage.setText(String.valueOf(tipCalculation15));

            fifteenPercentTotalMessage.setText(String.valueOf(totalCalculation(tipCalculation15, checkAmountInteger, partySizeInteger)));

            twentyPercentTipMessage.setText(String.valueOf(tipCalculation20));

            twentyPercentTotalMessage.setText(String.valueOf(totalCalculation(tipCalculation20, checkAmountInteger, partySizeInteger)));

            twentyFivePercentTipMessage.setText(String.valueOf(tipCalculation25));

            twentyFivePercentTotalMessage.setText(String.valueOf(totalCalculation(tipCalculation25, checkAmountInteger, partySizeInteger)));

        }



    }

    /*
    Create 2 method:
    Method 1 (tipCalculation)
     * parameters: double tipPercentage, int checkAmount, int partySize)
     * return: int tip
     Method 2 (totalCalculation)
     * parameters (int tipCalculation, int checkAmount, int partySize)
     * return int total
    Calculation for tip and total:
     * tip: (checkAmount/partySize)*tipPercentage
     * total: (checkAmount/partySize)+tip
     */

    public int tipCalculation(double tipPercentage, int checkAmount, int partySize) {

        int tip = 0;
        tip = (int) (ceil((checkAmount / partySize) * tipPercentage));
        return  tip;

    }
    public int totalCalculation (int tipCalculation, int checkAmount, int partySize){
        int total = 0;
        total = (checkAmount/partySize)+tipCalculation;
        return total;
    }


}