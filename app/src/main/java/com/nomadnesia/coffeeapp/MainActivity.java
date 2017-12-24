package com.nomadnesia.coffeeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickOrder(View view) {
        displayPrice(quantity * 10000);
    }

    public void clickPlus(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void clickMin(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_number);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {

        DecimalFormat idrCurrency = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols idrFormat = new DecimalFormatSymbols();

        idrFormat.setCurrencySymbol("Rp. ");
        idrFormat.setMonetaryDecimalSeparator(',');
        idrFormat.setGroupingSeparator('.');

        idrCurrency.setDecimalFormatSymbols(idrFormat);

        TextView priceTextView = (TextView) findViewById(R.id.price_number);
        /** priceTextView.setText("Rp. " + number); */
        /** priceTextView.setText(NumberFormat.getCurrencyInstance(new Locale("en", "ID")).format(number)); */
        priceTextView.setText(idrCurrency.format(number));
    }
}
