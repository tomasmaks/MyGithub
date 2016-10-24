package my.github.tomas.mygithub.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import my.github.tomas.mygithub.R;

/**
 * Created by Tomas on 24/10/2016.
 */

public class SignInActivity extends AppCompatActivity {


    public static final String STRING_PATH = "my.github.tomas.mygithub";
    private TextView mUsername, mPassword;
    private Button mButtonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUsername = (TextView) findViewById(R.id.editTextLoginUsername);
        mPassword = (TextView) findViewById(R.id.editTextLoginPassword);
        mButtonLogin = (Button) findViewById(R.id.buttonLogin);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mCurrentUserName = mUsername.getText().toString();
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                intent.putExtra(STRING_PATH, mCurrentUserName);
                startActivity(intent);
            }
        });


    }



}
