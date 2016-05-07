package app.dqtrinh.lifesaver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

public class MainWindow extends AppCompatActivity {
    //update something in here

    protected Button help;
    protected Button setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);

        //help = (Button)findViewById(R.id.helpButton);
        setting = (Button)findViewById(R.id.settingButton);

        setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent settingWindow = new Intent(getApplicationContext(), Setting.class);
                startActivity(settingWindow);
            }
        });

    }


}
