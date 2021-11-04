package com.example.sqlite_lab_06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView productID;
    EditText productName;
    EditText productQuantity;


    Button addButtn, findButtn, delButtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        productName = (EditText) findViewById(R.id.productName);
        productID = (TextView) findViewById(R.id.productID);
        productQuantity = (EditText) findViewById(R.id.productQuantity);
        addButtn = (Button) findViewById(R.id.addButtn);
        findButtn = (Button) findViewById(R.id.findButtn);
        delButtn = (Button) findViewById(R.id.deleteButtn);
    }



    public void newProduct (View view) {

        int Quantity = Integer.parseInt(productQuantity.getText().toString());

        com.example.sqlite_lab_06.Product product = new com.example.sqlite_lab_06.Product(productName.getText().toString(), Quantity);

        // TODO: add to database

        productName.setText("");

        productQuantity.setText("");
    }


    public void lookupProduct (View view) {

        // TODO: get from Database
        com.example.sqlite_lab_06.Product product = null;

        if (product != null) {
            productID.setText(String.valueOf(product.getID()));
            productQuantity.setText(String.valueOf(product.getQuantity()));
        } else {
            productID.setText("No Match Found");
        }
    }


    public void removeProduct (View view) {

        // TODO: remove from database
        boolean result = false;

        if (result) {
            productID.setText("Record Deleted");
            productName.setText("");
            productQuantity.setText("");
        }
        else
            productID.setText("No Match Found");
    }


    public void about(View view) {
        Intent aboutIntent = new Intent(this, com.example.sqlite_lab_06.About.class);
        startActivity(aboutIntent);
    }
}
