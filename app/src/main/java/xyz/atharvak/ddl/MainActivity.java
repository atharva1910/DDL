package xyz.atharvak.ddl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView mainCal = (CalendarView)findViewById(R.id.MainCalendar);
        mainCal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
            {
                Calendar cal = Calendar.getInstance();
                cal.set(year, month, dayOfMonth);
                mainCal.setDate(cal.getTimeInMillis(), true, true);
            }
        });
    }

    public void MainOkButtonClicked(View view)
    {
        CalendarView mainCal = (CalendarView)findViewById(R.id.MainCalendar);
        Intent dashBoardIntent = new Intent(MainActivity.this, Dashboard.class);
        dashBoardIntent.putExtra("ARG_LONG_DATE", mainCal.getDate());
        MainActivity.this.startActivity(dashBoardIntent);
    }
}