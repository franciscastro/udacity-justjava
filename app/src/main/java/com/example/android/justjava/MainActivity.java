package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        int price = calculatePrice();
        boolean hasWhippedCream = checkWhippedCream();
        boolean hasChocolate = checkChocolate();

        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);

        //String priceMessage = "Total: $" + price;
        //priceMessage = priceMessage + "\nThank you!";
        displayMessage(priceMessage);

    }

    /**
     * Calculates the price of the order.
     *
     * @return total price of the order
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    private boolean checkWhippedCream() {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        return whippedCreamCheckBox.isChecked();
    }

    private boolean checkChocolate() {
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        return chocolateCheckBox.isChecked();
    }

    /**
     * Generates the order summary
     *
     * @param price           of the order
     * @param hasWhippedCream is whether the user wants whipped cream or not
     * @param hasChocolate    is whether the user wants chocolate or not
     * @return a string containing the order summary
     */
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate) {

        String orderSummary = "Name: Francis";
        orderSummary += "\nAdd whipped cream? " + hasWhippedCream;
        orderSummary += "\nAdd chocolate? " + hasChocolate;
        orderSummary += "\nQuantity: " + quantity;
        orderSummary += "\nTotal: $" + price;
        orderSummary += "\nThank you!";

        return orderSummary;

    }

    /**
     * This method increments the amount of coffee
     */
    public void increment(View view) {

        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    /**
     * This method increments the amount of coffee
     */
    public void decrement(View view) {

        if (quantity > 0) {
            quantity = quantity - 1;
        }
        displayQuantity(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {

        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }

}
