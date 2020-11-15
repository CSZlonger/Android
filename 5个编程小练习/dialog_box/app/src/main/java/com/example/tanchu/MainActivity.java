package com.example.tanchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View viewDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog, null, false);//从布局文件生成
        builder.setTitle("登录对话框")
                .setView(viewDialog)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //取得用户输入内容，注意findViewById前面的viewDialog，表示在该view里面进行查找
                        EditText editTextUserId = viewDialog.findViewById(R.id.userId);
                        EditText editTextUserPassword = viewDialog.findViewById(R.id.userPassword);
                        if(editTextUserId.getText().toString().equals("abc") &&
                           editTextUserPassword.getText().toString().equals("123")){
                            /*Toast.makeText(MainActivity.this, "UserId：" + editTextUserId.getText().toString()
                            + "UserPassword：" + editTextUserPassword.getText().toString(), Toast.LENGTH_LONG).show();
                       */
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText( MainActivity.this,"登录失败",Toast.LENGTH_LONG).show();
                        }

                    }
                });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {           }        });
        //显示对话框
        builder.create().show();
    }


    }