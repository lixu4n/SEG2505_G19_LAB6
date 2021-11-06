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

    // this is called first time when database is accessed

    @Override
    public void onCreate(SQLiteDatabase db) {
        //  Kenneth
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                                        + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_PRODUCTNAME
                                        + " TEXT," + COLUMN_SKU + "INTEGER" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    //this is called if the db version changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        // Kenneth
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);

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

    public void removeProduct(Product product){

    }


    //(Daouda) lecture à partir d'une base de données

    public <retun> Product findProduct (String productname){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * FROM"+TABLE_PRODUCTS + "WHERE"+ COLUMN_PRODUCTNAME+"=\""+productname+"\"";
        Cursor cursor = db.rawQuery(query, null);
        Product product = new Product ();
        if (cursor.moveToFirst()){
            product.setID(Integer.parseInt(cursor.getString(0)));
            product.setProductName(cursor.getString(1));
            product.setSku(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        } else {
            product= null;
        }
        db.close();
        return product;
    }





}
