package app.dqtrinh.lifesaver;

import android.content.Intent;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainWindow extends AppCompatActivity {
    //update something in here

    protected ImageButton help;
    protected Button setting;
    public LocationManager locationManager;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    public void editSetting() {

        setting = (Button) findViewById(R.id.settingButton);
        help = (ImageButton) findViewById(R.id.helpButton);
        //locationManager = new LocationManager();
        //TODO: set the location
        //if()


        setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent settingWindow = new Intent(MainWindow.this, Setting.class);
                startActivity(settingWindow);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO: make the call to twilio

                //TODO: make the call to facebook
                //TODO: Contact autority
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        editSetting();

    }

    /**
     *
     * @return location of the user
     */
    private String sendLocation()
    {
        return null;
        //use GPS_PROVIDER
    }

    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

}
