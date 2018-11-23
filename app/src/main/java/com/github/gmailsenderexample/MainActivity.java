package com.github.gmailsenderexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.github.tntkhang.gmailsenderlibrary.GMailSender;
import com.github.tntkhang.gmailsenderlibrary.IListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edt_email_address)
    EditText edtEmailAddress;

    @BindView(R.id.edt_body)
    EditText edtBody;

    @BindView(R.id.edt_title)
    EditText edtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn_send)
    void sendEmail() {
        String emailAddress = edtEmailAddress.getText().toString();
        String title = edtTitle.getText().toString();
        String body = edtBody.getText().toString();

        GMailSender senderHelper = new GMailSender("your-email@gmail.com", "email-password");
        senderHelper.sendMail(title, body, emailAddress, getString(R.string.app_name), new IListener() {
            @Override
            public void sendSuccess() {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void sendFail(String err) {
                Toast.makeText(MainActivity.this, "Fail: " + err, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
