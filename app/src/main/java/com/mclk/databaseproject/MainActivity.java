package com.mclk.databaseproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            SQLiteDatabase myDb = this.openOrCreateDatabase("ArtBookDb", MODE_PRIVATE, null);
            myDb.execSQL("CREATE TABLE IF NOT EXISTS musicians(name VARCHAR, age INT(2))");
            myDb.execSQL("INSERT INTO musicians (name, age) values('Jordan',19)");

            Cursor cursor = myDb.rawQuery("Select name, age from musicians",null);
            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");

            cursor.moveToFirst();//En baştaki kayda geç
            while (cursor!=null)
            {

                System.out.println(cursor.getString(nameIndex));
                System.out.println(cursor.getInt(ageIndex));

                cursor.moveToNext();
            }
        }
        catch (Exception exGeneral)
        {
            exGeneral.printStackTrace();
        }
    }
}
