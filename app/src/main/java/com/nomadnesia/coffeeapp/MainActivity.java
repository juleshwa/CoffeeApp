package com.nomadnesia.coffeeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickOrder(View view) {
        showQuantity(quantity);
        int price = quantity * 10000;
        showPrice("Total ", price);
    }

    public void clickPlus(View view) {

        if(quantity == 100) {
            return;
        }
        quantity = quantity + 1;
        showQuantity(quantity);
    }

    public void clickMin(View view) {
        if(quantity == 0) {
            return;
        }
        quantity = quantity - 1;
        showQuantity(quantity);
    }

    private void showQuantity(int numOfCoffee) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_number);
        quantityTextView.setText("" + numOfCoffee);
    }

    private void showPrice(String message, int priceOfCoffee) {
        DecimalFormat idrCurrency = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols idrFormat = new DecimalFormatSymbols();

        idrFormat.setCurrencySymbol("Rp. ");
        idrFormat.setMonetaryDecimalSeparator(',');
        idrFormat.setGroupingSeparator('.');

        idrCurrency.setDecimalFormatSymbols(idrFormat);


        TextView priceTextView = (TextView) findViewById(R.id.price_number);
        priceTextView.setText(message + idrCurrency.format(priceOfCoffee));

        // priceTextView.setText(NumberFormat.getCurrencyInstance(new Locale("en","ID")).format(" " + priceOfCoffee));
    }

}
