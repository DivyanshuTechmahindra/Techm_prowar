package uk.prudentialwarnew.CalendarExmp;

/**
 * Created by user on 8/12/2016.
 */
import com.github.tibolte.agendacalendarview.AgendaCalendarView;
import com.github.tibolte.agendacalendarview.CalendarPickerController;
import com.github.tibolte.agendacalendarview.models.BaseCalendarEvent;
import com.github.tibolte.agendacalendarview.models.CalendarEvent;
import com.github.tibolte.agendacalendarview.models.DayItem;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.prudentialwarnew.R;
import uk.prudentialwarnew.utils.floatingActionButtons.FloatingActionButton;
import uk.prudentialwarnew.utils.floatingActionButtons.FloatingActionsMenu;


/**
 * Created by user on 8/11/2016.
 */
public class CalandarSample extends AppCompatActivity implements CalendarPickerController {

    public static FloatingActionsMenu menuMultipleActions;
    private static final String LOG_TAG = CalandarSample.class.getSimpleName();

    //    @Bind(R.id.activity_toolbar)
//    Toolbar mToolbar;
    @Bind(R.id.agenda_calendar_view)
    AgendaCalendarView mAgendaCalendarView;

    // region Lifecycle methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander);
        ButterKnife.bind(this);

        // setSupportActionBar(mToolbar);

        // minimum and maximum date of our calendar
        // 2 month behind, one year ahead, example: March 2015 <-> May 2015 <-> May 2016
        Calendar minDate = Calendar.getInstance();
        Calendar maxDate = Calendar.getInstance();

        minDate.add(Calendar.MONTH, -2);
        minDate.set(Calendar.DAY_OF_MONTH, 1);
        maxDate.add(Calendar.YEAR, 1);

        List<CalendarEvent> eventList = new ArrayList<>();
        mockList(eventList);

        mAgendaCalendarView.init(eventList, minDate, maxDate, Locale.getDefault(), this);
        mAgendaCalendarView.addEventRenderer(new DrawableEventRenderer());

        //##############################################################

        menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        final View action_screen_share = findViewById(R.id.action_screen_share);
        action_screen_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent postLoadDashBoardIntent = new Intent(CalandarSample.this, CustomerActivity.class);
//                CalandarSample.this.startActivity(postLoadDashBoardIntent);


                menuMultipleActions.collapse();
            }
        });
        final View action_virtual_meeting = findViewById(R.id.action_virtual_meeting);
        action_virtual_meeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent postTruckIntent = new Intent(CalandarSample.this, AnotherBarActivity.class);
//                CalandarSample.this.startActivity(postTruckIntent);
                menuMultipleActions.collapse();
            }
        });


        final FloatingActionButton action_chat = (FloatingActionButton) findViewById(R.id.action_chat);
        action_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent postTruckIntent = new Intent(CalandarSample.this, CustomerListActivityMain.class);
//                CalandarSampleSample.this.startActivity(postTruckIntent);
                menuMultipleActions.collapse();
            }
        });


        final FloatingActionButton action_mail = (FloatingActionButton) findViewById(R.id.action_mail);
        action_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent postTruckIntent = new Intent(CalandarSample.this, CustomerListActivityMain.class);
//                CalandarSample.this.startActivity(postTruckIntent);
                menuMultipleActions.collapse();
            }
        });


        final FloatingActionButton action_call = (FloatingActionButton) findViewById(R.id.action_call);
        action_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent postTruckIntent = new Intent(CalandarSample.this, CustomerListActivityMain.class);
//                CalandarSample.this.startActivity(postTruckIntent);
                menuMultipleActions.collapse();
            }
        });
        //##############################################################
    }

    // endregion

    // region Interface - CalendarPickerController

    @Override
    public void onDaySelected(DayItem dayItem) {
        Log.d(LOG_TAG, String.format("Selected day: %s", dayItem));
    }

    @Override
    public void onEventSelected(CalendarEvent event) {
        Log.d(LOG_TAG, String.format("Selected event: %s", event));
    }

    @Override
    public void onScrollToDate(Calendar calendar) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
        }
    }

    // endregion

    // region Private Methods

    private void mockList(List<CalendarEvent> eventList) {
        Calendar startTime1 = Calendar.getInstance();
        Calendar endTime1 = Calendar.getInstance();
        endTime1.add(Calendar.MONTH, 1);
//        BaseCalendarEvent event1 = new BaseCalendarEvent("Thibault travels in Iceland", "A wonderful journey!", "Iceland",
//                ContextCompat.getColor(CalandarSample.this, getResources().getColor(R.color.orange)), startTime1, endTime1, true);
        BaseCalendarEvent event1 = new BaseCalendarEvent("Thibault travels in Iceland", "A wonderful journey!", "Iceland",
                getResources().getColor(R.color.orange), startTime1, endTime1, true);
        eventList.add(event1);

        Calendar startTime2 = Calendar.getInstance();
        startTime2.add(Calendar.DAY_OF_YEAR, 1);
        Calendar endTime2 = Calendar.getInstance();
        endTime2.add(Calendar.DAY_OF_YEAR, 3);
//        BaseCalendarEvent event2 = new BaseCalendarEvent("Visit to Dalvík", "A beautiful small town", "Dalvík",
//                ContextCompat.getColor(CalandarSample.this, getResources().getColor(R.color.orange)), startTime2, endTime2, true);
        BaseCalendarEvent event2 = new BaseCalendarEvent("Visit to Dalvík", "A beautiful small town", "Dalvík",
                getResources().getColor(R.color.orange), startTime2, endTime2, true);
        eventList.add(event2);

        Calendar startTime3 = Calendar.getInstance();
        Calendar endTime3 = Calendar.getInstance();
        startTime3.set(Calendar.HOUR_OF_DAY, 14);
        startTime3.set(Calendar.MINUTE, 0);
        endTime3.set(Calendar.HOUR_OF_DAY, 15);
        endTime3.set(Calendar.MINUTE, 0);
//        DrawableCalendarEvent event3 = new DrawableCalendarEvent("Visit of Harpa", "", "Dalvík",
//                ContextCompat.getColor(CalandarSample.this,  getResources().getColor(R.color.blue)), startTime3, endTime3, false, android.R.drawable.ic_dialog_info);
        DrawableCalendarEvent event3 = new DrawableCalendarEvent("Visit of Harpa", "", "Dalvík",
                getResources().getColor(R.color.blue), startTime3, endTime3, false, android.R.drawable.ic_dialog_info);
        eventList.add(event3);
    }

    // endregion
}
