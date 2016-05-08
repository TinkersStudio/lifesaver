package app.dqtrinh.lifesaver;

import java.util.*;
import android.content.Intent;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.twilio.client.*;
import com.twilio.client.impl.session.Account;
import com.twilio.client.impl.session.Message;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.*;
import com.twilio.sdk.*;
import com.twilio.sdk.resource.factory.*;
import com.twilio.sdk.resource.instance.*;
import com.twilio.sdk.resource.list.*;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;


public class MainWindow extends AppCompatActivity {
    //update something in here
    public static final String ACCOUNT_SID = "AC848a9e2ee6791d8e7f64f86622e81321";
    public static final String AUTH_TOKEN = "c39fa3a423819cfffa2ceac436bde083";
    protected ImageButton help;
    protected Button setting;
    private GPSTracker gps;
    protected double longtitude, lattitude;
    public String locationText;
    private boolean contactFlag = false;
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
                //sendSMS();
                //TODO: make the call to facebook

                //TODO: Contact authority
                if(contactFlag){
                    contactAuthority();
                }
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
        //build setting button
        editSetting();
        //build messae
        sendMessage();
    }


    public void sendSMS(String infomation, String message, String location,
                        ArrayList<String>primaryContact,ArrayList<String>secondaryContact){
        String content = createContent(message, primaryContact,secondaryContact);
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
        com.twilio.sdk.resource.instance.Account account = client.getAccount();
        MessageFactory messageFactory = account.getMessageFactory();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", "7608085735"));
        params.add(new BasicNameValuePair("From", "7608085735"));
        params.add(new BasicNameValuePair("Body", content));
        try
        {
            com.twilio.sdk.resource.instance.Message sms = messageFactory.create(params);
            //resp.getWriter().print(sms.getBody());
        }
        catch (TwilioRestException e)
        {
            //throw new Exception("Twilio error");

        }
    }

    public String createContent(String message, ArrayList<String>primaryContact,ArrayList<String>secondaryContact){
        return null;
    }

    /**
     * Contact authority if the flag is on
     */
    public void contactAuthority() {
        //TODO: Will notice 911 perhap. Need database

    }
}

