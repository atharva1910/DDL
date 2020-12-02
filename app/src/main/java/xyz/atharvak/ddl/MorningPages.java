package xyz.atharvak.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MorningPages extends AppCompatActivity {
    private long date;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning_pages);

        date = getIntent().getLongExtra("ARG_LONG_DATE", 0);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}