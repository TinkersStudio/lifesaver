package app.dqtrinh.lifesaver;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainWindow extends AppCompatActivity {
    //update something in here

    protected ImageButton help;
    protected Button setting;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    public void editSetting() {

        setting = (Button) findViewById(R.id.settingButton);
        help = (ImageButton) findViewById(R.id.helpButton);

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

}
