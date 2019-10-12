package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String Database = "user.db";

    public DBHelper(@Nullable Context context) {
        super(context, Database, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + Usermaster.Users.Table + " (" +
                Usermaster.Users._ID + " integer primary key," +
                Usermaster.Users.Col1 + " text);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean add(String name){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Usermaster.Users.Col1,name);

        long data = db.insert(Usermaster.Users.Table,null,values);

        if(data > 0){
            return  true;
        }
        else{
            return false;
        }
    }

    public Cursor query() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(
                Usermaster.Users.Table,
                null,
                null,
                null,
                null,
                null,
                Usermaster.Users.Col1 + " DESC"
        );
    }
}
