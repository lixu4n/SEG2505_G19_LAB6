package com.example.sqlite_lab_06;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import androidx.annotation.Nullable;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME = "productname";
    public static final String COLUMN_SKU = "SKU";


    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    // this is called first time when database is accesed
    @Override
    public void onCreate(SQLiteDatabase db) {
        //add code here @ kenneth

    }

    //this is called if the db version changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        // add code here @kenneth

    }

    public void addProduct(Product product){

        //Celeste

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, product.getProductName());
        values.put(COLUMN_SKU, product.getID());

        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }




}
