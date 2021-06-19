package com.example.dbimport;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

//DB에 저장된 로또 번호들 출력 페이지
public class ListViewT extends AppCompatActivity {



    com.example.dbimport.DataBaseHelper dbhelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_view_t);
        ListView lv = (ListView) findViewById(R.id.listview);
        dbhelper = new com.example.dbimport.DataBaseHelper(ListViewT.this);
        dbhelper.onUpgrade(db,1,2);
        db = dbhelper.getWritableDatabase();
        dbhelper.onCreate(db);
        String sql = "select * from lottonum";
        Cursor c = db.rawQuery(sql,null);
        int [] ints = new int[] {R.id.textViewRound,R.id.textViewNum1,R.id.textViewNum2,R.id.textViewNum3,R.id.textViewNum4,R.id.textViewNum5,R.id.textViewNum6,R.id.textViewBonus};
        SimpleCursorAdapter adapter = null;
        String[] strs = new String[]{"_id","Num1","Num2","Num3","Num4","Num5","Num6","Bonus"};
        adapter = new SimpleCursorAdapter(lv.getContext(),R.layout.lvlayout,c,strs,ints,0);
        lv.setAdapter(adapter);
    }
    public void onclick_finish(View view){
        finish();
    }
    public static final String ROOT_DIR = "/data/data/com.example.dbimport/";
    private static final String DATABASE_NAME = "test.db";
    public static void initialize(Context ctx) {		// check
        File folder = new File(ROOT_DIR + "databases");
        folder.mkdirs();
        File outfile = new File(ROOT_DIR + "databases/" + DATABASE_NAME);
        if (outfile.length() <= 0) {
            AssetManager assetManager = ctx.getResources().getAssets();
            try {
                InputStream is = assetManager.open(DATABASE_NAME, AssetManager.ACCESS_BUFFER);
                long filesize = is.available();
                byte [] tempdata = new byte[(int)filesize];
                is.read(tempdata);
                is.close();
                outfile.createNewFile();
                FileOutputStream fo = new FileOutputStream(outfile);
                fo.write(tempdata);
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}