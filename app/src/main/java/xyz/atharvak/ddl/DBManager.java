package xyz.atharvak.ddl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {
    private static final String COLUMN_DATE = "DATE";
    private static final String TABLE_NAME = "DDL";
    private static final String COLUMN_MORNING_PAGE = "MORNINGPAGE";

    public DBManager(@Nullable Context context) {
        super(context, "DDL.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createDB = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_DATE + " INTEGER PRIMARY KEY, " + COLUMN_MORNING_PAGE + " TEXT)";
        db.execSQL(createDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void SetMorningPage(Long date, String page)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv  = new ContentValues();

        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_MORNING_PAGE, page);

        /* Check if entry exists */
        String sqlString  = "SELECT " + COLUMN_MORNING_PAGE + " FROM " + TABLE_NAME + " WHERE " + COLUMN_DATE + "=" + date.toString();
        Cursor cursor     = db.rawQuery(sqlString, null);

        /* If entry exists, update entry */
        if (cursor.moveToFirst()){
            db.update(TABLE_NAME, cv, COLUMN_DATE + "=?", new String[]{date.toString()});
        }else {

            db.insert(TABLE_NAME, null, cv);
        }
    }

    public String GetMorningPage(Long date)
    {
        String sqlString  = "SELECT " + COLUMN_MORNING_PAGE + " FROM " + TABLE_NAME + " WHERE " + COLUMN_DATE + "=" + date.toString();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor     = db.rawQuery(sqlString, null);

        String page = "";
        if(cursor.moveToFirst()){
            do{
                page = cursor.getString(0);
                Log.d("DBG", page);
            }while(cursor.moveToNext());
        }else{
            Log.d("DB", "Failed to open connection");
        }

        cursor.close();
        return page;
    }
}
