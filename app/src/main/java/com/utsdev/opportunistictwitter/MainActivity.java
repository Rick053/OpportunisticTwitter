package com.utsdev.opportunistictwitter;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.utsdev.opportunistictwitter.fields.CreationTime;
import com.utsdev.opportunistictwitter.fields.Mood;
import com.utsdev.opportunistictwitter.fields.Tweet;
import com.utsdev.opportunistictwitter.fields.Username;

import tech.cocoon.Constants.Types;
import tech.cocoon.Message.Beacon;
import tech.cocoon.Message.Format.BeaconFormat;
import tech.cocoon.Monitor.Status;
import tech.cocoon.Service.Configuration;
import tech.cocoon.Utilities.DateUtils;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.setActivity(this);
        App.startService(MainActivity.this);

        Configuration.setScanInterval(5);
        Configuration.setHotspotServiceDuration(10);

        TextView status = (TextView) App.getActivity().findViewById(R.id.status);
        Status.assignView(status);

        Username name = new Username(7);
        Tweet tweet = new Tweet(14);
        Mood mood = new Mood(1);
        CreationTime time = new CreationTime(2);

        BeaconFormat bf = new BeaconFormat
                .Builder(Types.BeaconType.SSID)
                .addField(name)
                .addField(tweet)
                .addField(mood)
                .addField(time)
                .build();

        bf.setFieldValue(name, "Rick");
        bf.setFieldValue(tweet, "hello world!");
        bf.setFieldValue(mood, "1");
        bf.setFieldValue(time, DateUtils.getTimeInBase64());

        Beacon myBeacon = new Beacon(bf, Types.ServiceType.GENERIC_MESSAGE);

        App.getBeaconInbox().pushElement(myBeacon);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
