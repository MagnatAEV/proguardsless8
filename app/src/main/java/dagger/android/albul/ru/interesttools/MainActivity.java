package dagger.android.albul.ru.interesttools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LEAK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        killMemory();
    }

    private void killMemory() {
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                int begin = 0;
                int end = 200;
                while (begin < end) {
                    begin++;
                    end--;
                    Log.d(TAG, "doInBackground: " + (begin*end)/10);
                    SystemClock.sleep(500);
                }
                return null;
            }


        }.execute();
    }
}
