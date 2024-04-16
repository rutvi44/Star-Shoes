package com.example.group6_prog3210_finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper {

    // Constants for db name and version
    private static final String DATABASE_NAME = "starShoesDB";
    private static final int DATABASE_VERSION = 2;

    // Constants for the table and columns
    public static final String TABLE_USERS = "users";
    // commo
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";

    public static final String TABLE_ITEMS = "items";
    public static final String COLUMN_ITEM_ID = "_id";
    public static final String COLUMN_ITEM_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_SUBCATEGORY_ID = "subcategory_id";


    public static final String TABLE_CART = "cart";
    public static final String COLUMN_CART_ID = "_id";
    public static final String COLUMN_USER_ID_FK = "user_id";
    public static final String COLUMN_ITEM_ID_FK = "item_id";
    public static final String COLUMN_QUANTITY = "quantity";


    // SQL statement to create a new table

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + // Defines a primary key that auto increments
                    COLUMN_NAME + " TEXT, " +                            // Defines a column for user names
                    COLUMN_EMAIL + " TEXT UNIQUE, " +                    // Defines a column for emails, must be unique
                    COLUMN_PASSWORD + " TEXT" +                          // Defines a column for passwords
                    ");";


    private static final String CREATE_ITEMS_TABLE =
            "CREATE TABLE " + TABLE_ITEMS + " (" +
                    COLUMN_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ITEM_NAME + " TEXT, " +
                    COLUMN_DESCRIPTION + " TEXT, " +
                    COLUMN_PRICE + " REAL, " +
                    COLUMN_SUBCATEGORY_ID + " INTEGER, " +
                    // Column for storing image data
                    "FOREIGN KEY (" + COLUMN_SUBCATEGORY_ID + ") REFERENCES subcategories(_id)" +
                    ");";

    private static final String CREATE_CART_TABLE =
            "CREATE TABLE " + TABLE_CART + " (" +
                    COLUMN_CART_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USER_ID_FK + " INTEGER, " +
                    COLUMN_ITEM_ID_FK + " INTEGER, " +
                    COLUMN_QUANTITY + " INTEGER, " +
                    "FOREIGN KEY (" + COLUMN_USER_ID_FK + ") REFERENCES " + TABLE_USERS + "(" + COLUMN_ID + "), " +
                    "FOREIGN KEY (" + COLUMN_ITEM_ID_FK + ") REFERENCES " + TABLE_ITEMS + "(" + COLUMN_ITEM_ID + ")" +
                    ");";


    /**
     * Constructor that takes the context to allow the database creation.
     * @param context The context through which to access the database.
     */
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(CREATE_ITEMS_TABLE);
        db.execSQL(CREATE_CART_TABLE);
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);

        onCreate(db);
    }


    // CRUD Operations for USERS Table
// CRUD Operations for ITEMS Table
// CRUD Operations for ITEMS Table

    // CRUD Operations for ITEMS Table

    // Adding new item
// Adding new item
    // Adding new item
    public long addItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEM_NAME, item.getName());
        values.put(COLUMN_DESCRIPTION, item.getDescription());
        values.put(COLUMN_PRICE, item.getPrice());
        values.put(COLUMN_SUBCATEGORY_ID, item.getSubcategoryId()); // Assuming the method is getSubcategoryId()


        long id = db.insert(TABLE_ITEMS, null, values);
        db.close(); // Closing database connection
        return id;
    }

    // Getting single item
    public Item getItem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ITEMS, new String[]{COLUMN_ITEM_ID,
                        COLUMN_ITEM_NAME, COLUMN_DESCRIPTION, COLUMN_PRICE, COLUMN_SUBCATEGORY_ID}, COLUMN_ITEM_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Item item = new Item();
        item.setId(Integer.parseInt(cursor.getString(0)));
        item.setName(cursor.getString(1));
        item.setDescription(cursor.getString(2));
        item.setPrice(cursor.getDouble(3));
        item.setSubcategoryId(cursor.getInt(4)); // Assuming the method is setSubcategoryId()


        // Close cursor and database connection
        cursor.close();
        db.close();

        // return item
        return item;
    }



    // Getting All Items
    // Getting All Items
    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<Item>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEMS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setId(cursor.getInt(0));
                item.setName(cursor.getString(1));
                item.setDescription(cursor.getString(2));
                item.setPrice(cursor.getDouble(3));
                item.setSubcategoryId(cursor.getInt(4)); // Assuming the method is setSubcategoryId()

                itemList.add(item);
            } while (cursor.moveToNext());
        }

        // Close cursor and database connection
        cursor.close();
        db.close();

        // return item list
        return itemList;
    }


    // Updating single item
    // Updating single item
    public int updateItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEM_NAME, item.getName());
        values.put(COLUMN_DESCRIPTION, item.getDescription());
        values.put(COLUMN_PRICE, item.getPrice());
        values.put(COLUMN_SUBCATEGORY_ID, item.getSubcategoryId()); // Assuming the method is getSubcategoryId()

        return db.update(TABLE_ITEMS, values, COLUMN_ITEM_ID + " = ?",
                new String[]{String.valueOf(item.getId())});
    }


    // Deleting single item
    public void deleteItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEMS, COLUMN_ITEM_ID + " = ?",
                new String[]{String.valueOf(item.getId())});
        db.close();
    }

    // Getting items Count
    public int getItemsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ITEMS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

}
