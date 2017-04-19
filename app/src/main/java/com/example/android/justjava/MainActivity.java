package com.example.android.justjava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        boolean hasWhippedCream = checkWhippedCream();
        boolean hasChocolate = checkChocolate();
        String userName = getUserName();

        // Calculate price
        int price = calculatePrice(hasWhippedCream, hasChocolate);

        String priceMessage = createOrderSummary(userName, price, hasWhippedCream, hasChocolate);

        //String priceMessage = "Total: $" + price;
        //priceMessage = priceMessage + "\nThank you!";
        displayMessage(priceMessage);

    }

    /**
     * Calculates the price of the order.
     *
     * @param hasWhippedCream if the user added whipped cream topping
     * @param hasChocolate    if the user added chocolate topping
     * @return total price of the order
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {

        int basePrice = 5;

        // Add $1 if the user adds whipped cream
        if (hasWhippedCream) {
            basePrice = basePrice + 1;
        }

        // Add $2 if the user adds chocolate
        if (hasChocolate) {
            basePrice = basePrice + 2;
        }

        return (basePrice * quantity);
    }

    private String getUserName() {
        EditText userNameEditText = (EditText) findViewById(R.id.name_edit_text);
        String userName = userNameEditText.getText().toString();
        return userName;
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
     * @param name            is the name of the user
     * @param price           of the order
     * @param hasWhippedCream is whether the user wants whipped cream or not
     * @param hasChocolate    is whether the user wants chocolate or not
     * @return a string containing the order summary
     */
    private String createOrderSummary(String name, int price, boolean hasWhippedCream, boolean hasChocolate) {

        String orderSummary = "Name: " + name;
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

        if (quantity == 100) {
            // Show an error message in a toast
            Toast.makeText(this, "The maximum order is 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    /**
     * This method increments the amount of coffee
     */
    public void decrement(View view) {

        if (quantity == 1) {
            // Show an error message in a toast
            Toast.makeText(this, "The minimum order is 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity - 1;
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
