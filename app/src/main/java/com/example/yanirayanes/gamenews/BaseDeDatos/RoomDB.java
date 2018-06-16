package com.example.yanirayanes.gamenews.BaseDeDatos;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

public abstract class RoomDB extends RoomDatabase{
    public abstract NoticiasDAO noticiaDAO();
    private static RoomDB INSTANCE;

    public static RoomDB getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (RoomDB.class){
                if(INSTANCE == null){
                    INSTANCE= android.arch.persistence.room.Room.databaseBuilder(context.getApplicationContext(),
                            RoomDB.class,"NoticiasDeJuegos_DataBase")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback rdbRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

}
