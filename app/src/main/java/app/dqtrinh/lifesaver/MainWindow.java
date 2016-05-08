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
    private GPSTracker gps;
    protected double longtitude, lattitude;
    public String locationText;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    public void editSetting() {

        setting = (Button) findViewById(R.id.settingButton);
        setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent settingWindow = new Intent(MainWindow.this, Setting.class);
                startActivity(settingWindow);
            }
        });
    }

    public void sendMessage()
    {
        help = (ImageButton) findViewById(R.id.helpButton);
        gps = new GPSTracker(MainWindow.this);
        help.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO: make the call to twilio
                locationText = this.sendLocationText();
                lattitude = this.latitude();
                longtitude = this.longitude();

                //TODO: make the call to facebook
                //TODO: Contact authority
            }


            /**
             *
             * @return location of the user
             */
            private String sendLocationText() {
                String location = null;
                if(gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    // \n is for new line
                    location =  "Your Location is - \nLat: " + latitude + "\nLong: "
                            + longitude;
                }
                else
                {
                    location = "Location is unknown";
                }
                return location;
            }

            private double longitude()
            {
                if(gps.canGetLocation()){
                    return gps.getLongitude();
                }
                return 0;
            }

            private double latitude()
            {
                if(gps.canGetLocation()){
                    return gps.getLatitude();
                }
                return 0;
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        editSetting();
        sendMessage();
    }
}
