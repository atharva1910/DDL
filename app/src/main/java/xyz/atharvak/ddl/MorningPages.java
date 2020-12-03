package xyz.atharvak.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MorningPages extends AppCompatActivity {
    private Long date;
    DBManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning_pages);

        /* Get date and open a db connection */
        date = getIntent().getLongExtra("ARG_LONG_DATE", 0);
        db   = new DBManager(getApplicationContext());

        /* Get the morning page if already in db */
        EditText mpEditText = findViewById(R.id.MorningPageEditor);
        mpEditText.setText(db.GetMorningPage(date), TextView.BufferType.EDITABLE);
    }

    @Override
    public void onBackPressed()
    {
        EditText mpEditText = findViewById(R.id.MorningPageEditor);
        db.SetMorningPage(date, mpEditText.getText().toString());
        super.onBackPressed();
    }
}