package com.example.hiot_cloud.test.mvptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiot_cloud.R;
import com.example.hiot_cloud.test.mvptest.model.TestView;
import com.example.hiot_cloud.test.mvptest.model.User;

public class TestMVPActivity extends AppCompatActivity implements TestView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mvp);
        final EditText etusername = findViewById(R.id.et_user_name);
        final EditText etpassword = findViewById(R.id.et_password);
        Button btnlogin = findViewById(R.id.bt_login);
        final User user = new User();
        final TestPresenter presenter = new TestPresenter(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mvc做法，在这里做身份校验
                user.setUsername(etusername.getText().toString());
                user.setPassword(etpassword.getText().toString());
                presenter.login(user);

               // login(user);

            }
        });
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

//  private void login(User user) {
//        if ("lisi".equals(user.getUsername()) && "123".equals(user.getPassword())){
//            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
//        }
//    }
}
