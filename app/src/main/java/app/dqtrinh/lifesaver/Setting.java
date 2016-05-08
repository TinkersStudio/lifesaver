package app.dqtrinh.lifesaver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class Setting extends AppCompatActivity
{
    protected Button contact;

    public void editContacts() {

        contact = (Button) findViewById(R.id.contactButton);
        contact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent settingContacts = new Intent(getApplicationContext(), Contacts.class);
                startActivity(settingContacts);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        editContacts();

    }
}
