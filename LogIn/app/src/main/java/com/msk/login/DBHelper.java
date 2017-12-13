package com.msk.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by msk on 07-11-2017.
 */


//Contractor Class
 class TableData {
    public TableData() {

    }

    public static abstract class TableInfo implements BaseColumns{
        public static final String DATABASE_NAME = "Users.db";
        public static final String TABLE_NAME = "Info";
        public static final String COLUMN_USERID = "username";
        public static final String COLUMN_PASS = "password";
    }
}



public class DBHelper extends SQLiteOpenHelper {



    public DBHelper(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TableData.TableInfo.TABLE_NAME + " (" + TableData.TableInfo.COLUMN_USERID + " TEXT PRIMARY KEY, "+ TableData.TableInfo.COLUMN_PASS +" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertInfo (String username, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableData.TableInfo.COLUMN_USERID, username);
        contentValues.put(TableData.TableInfo.COLUMN_PASS, pass);

        db.insert(TableData.TableInfo.TABLE_NAME, null, contentValues);
        return true;
    }

    public boolean updateInfo (String username, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableData.TableInfo.COLUMN_PASS, pass);

        db.update(TableData.TableInfo.TABLE_NAME, contentValues, TableData.TableInfo.COLUMN_USERID + " = ? ", new String[] {username} );

        return true;
    }

    public Cursor fetchInfo(String username, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TableData.TableInfo.TABLE_NAME, new String[] {TableData.TableInfo.COLUMN_USERID, TableData.TableInfo.COLUMN_PASS}, TableData.TableInfo.COLUMN_USERID + "=? " +"AND "+TableData.TableInfo.COLUMN_PASS + "=?", new String[] {username, pass}, null, null, null);

        return cursor;
    }


}
