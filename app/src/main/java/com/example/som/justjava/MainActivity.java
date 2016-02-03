package com.example.som.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity{
    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
          int price= calculatePrice();
        displayMessage(createOrderSummary(price));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffess) {
        TextView quantityTextView = (TextView) findViewById(R.id.number);
        quantityTextView.setText("" + numberOfCoffess);
    }

    public void increment(View view){

       quantity=quantity+1;
        displayQuantity(quantity);
    }
    public void decrement(View view) {
        quantity=quantity-1;
        displayQuantity(quantity);
    }
    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }
private String createOrderSummary(int price){
    String priceMessage="Qunatity: " + quantity;
    priceMessage=priceMessage+"\nTotal: Rs " + price;
    priceMessage= priceMessage + "\nThankYou! \nCome Again :)";
    return priceMessage;
}
}