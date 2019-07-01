package de.hshl.isd.database;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        @SuppressLint("StaticFieldLeak") AsyncTask<UserEntity, Integer, Void>
                task = new AsyncTask<UserEntity, Integer, Void>() {
            @Override
            protected Void doInBackground(UserEntity... userEntities) {
                db.userDao().insertAll(userEntities);
                return null;
            }

        };

        UserEntity entity = new UserEntity();
        entity.uid = 1;
        entity.firstName = "Maria";
        entity.lastName = "Bernasconi";

        task.execute(entity);
    }

}
