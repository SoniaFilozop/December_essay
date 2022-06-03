package ru.myitschool.vsu2021.filozop_s_a.decemberessay;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SecondActivity extends Activity {

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        mDBHelper = new DatabaseHelper(this);

        mDBHelper.updateDataBase();

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        ArrayList<HashMap<String, Object>> clients = new ArrayList<HashMap<String, Object>>();

        HashMap<String, Object> client;

        Bundle arguments = getIntent().getExtras();
        Integer id_th = arguments.getInt("id_theme");

        String sqlQuery = "SELECT * FROM Works WHERE id_theme = ?";
        Cursor cursor = mDb.rawQuery(sqlQuery, new String[] {String.valueOf(id_th)});
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            client = new HashMap<String, Object>();
            client.put("name",  cursor.getString(3));
            client.put("author",  cursor.getString(2));
            clients.add(client);
            cursor.moveToNext();
        }
        cursor.close();

        String[] from = { "name", "author"};
        int[] to = { R.id.textView, R.id.textView2};

        SimpleAdapter adapter = new SimpleAdapter(this, clients, R.layout.adapter_item, from, to);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }

}