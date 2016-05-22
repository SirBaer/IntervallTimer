package com.timer.bko.intervalltimer;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.timer.bko.intervalltimer.item.TrackItem;

public class MainActivity extends AppCompatActivity implements TrackFragment.OnListFragmentInteractionListener{
    private TextView statusTextView;

    private TrackItem currentPauseTrack;

    private BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String string = bundle.getString(IntervallTimerService.CURRENT_STATUS);
                statusTextView.setText(string);
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        statusTextView = (TextView) findViewById(R.id.statusTextView);
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    10);
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(IntervallTimerService.STATUS_MESSAGE));
    }


    @Override
    public void onPause(){
        unregisterReceiver(receiver);
        super.onPause();
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

    public void onStartButtonClicked(View view) {
        Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_SHORT)
                .show();
//        if(this.currentPauseTrack != null) {
            Intent intent = new Intent(this, IntervallTimerService.class);
            intent.putExtra(IntervallTimerService.REPITITIONS, 5);
//            intent.putExtra(IntervallTimerService.PAUSE_TRACK, this.currentPauseTrack.getURI());
            startService(intent);
//        }
    }

    public void onStopButtonClicked(View view) {
        Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT)
                .show();

    }


    @Override
    public void onListFragmentInteraction(TrackItem item) {
        this.statusTextView.setText(item.title);
    }
}
