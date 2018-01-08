package com.example.mesmusiques.db;

import com.example.mesmusiques.ui.add.AddActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
	// database name
	public static final String DB_NAME						= "mesmusiques";
	
	// table name 
	public static final String TBL_MUSIQUE					= "music";
	
	// table column name  
	public static final String MUSIQUE_ID					= "_id";
	public static final String MUSIQUE_CATEGORIE			= "category";
	public static final String MUSIQUE_NOM					= "name";
	public static final String MUSIQUE_DESCRIPTION			= "description";
	public static final String MUSIQUE_CHANTEUR				= "singer";

	private static SQLiteDatabase db;

	//Database.getInstance(AddActivity.this).addOrUpdateMusic(musiques.getContentValues());
	private static Database mInstance = null;

	public static Database getInstance(Context context) {
		if (context == null) {
			throw new IllegalArgumentException(
					"Context is null ! Databases can't be initialized with null context");
		}

		if (mInstance == null) {
			//Log.e("database", "mInstance == null");
			mInstance = new Database(context.getApplicationContext());
			open();
		}

		return mInstance;
	}

	private Database(Context c) {
		super(c, DB_NAME, null, 1); // +1 version to upgrade database
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.e("onCreate", "Database update");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS "+TBL_MUSIQUE+" (" +
				MUSIQUE_ID+" INTEGER PRIMARY KEY," +
				MUSIQUE_CATEGORIE+" VARCHAR," +
				MUSIQUE_NOM+" VARCHAR," +
				MUSIQUE_DESCRIPTION+" VARCHAR, "+ 
				MUSIQUE_CHANTEUR+" VARCHAR"+ 
				");" );

	}
	
	private static void open() {

		if (db == null) {
			db = mInstance.getWritableDatabase();
		}
	}

	public synchronized void closeConnecion() {
		if (mInstance != null) {
			mInstance.close();
			db.close();
			mInstance = null;
			db = null;
		}
	}
	
	@Override
	public synchronized void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onCreate(db);
	}

	// Ajouter méthode select
    public static select (String table, ) {
        
        return ;
    }

	// Ajouter méthode insert
	
	
	
	
	
}