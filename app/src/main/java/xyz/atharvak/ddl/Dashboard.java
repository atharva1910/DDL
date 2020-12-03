package xyz.atharvak.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dashboard extends AppCompatActivity {

    private Long date;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        /* Get date from the main activity and convert to string */
        date  = getIntent().getLongExtra("ARG_LONG_DATE", 0);
        String dateString = new SimpleDateFormat("yyyy/MM/dd").format(new Date(date));

        /* Set the date to the text field on the dashboard */
        TextView dashTextView = (TextView)findViewById(R.id.DashTextDate);
        dashTextView.setText(dateString);
    }

    public void DBBtnClicked(View view)
    {
        switch (view.getId()){
            case R.id.DashBtnMP:{
                /* Switch to Morning page intent */
                Intent mpIntent = new Intent(Dashboard.this, MorningPages.class);
                mpIntent.putExtra("ARG_LONG_DATE", this.date);
                Dashboard.this.startActivity(mpIntent);
            }
            default:{
                // What!
            }
        }
    }
}