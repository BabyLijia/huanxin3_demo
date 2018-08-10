package com.example.asus.huanxin3_demo;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_LOGS,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS,
                    Manifest.permission.ACCESS_WIFI_STATE,
                    Manifest.permission.CHANGE_WIFI_STATE,
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.MODIFY_AUDIO_SETTINGS,
                    Manifest.permission.WAKE_LOCK,
                    Manifest.permission.RECEIVE_BOOT_COMPLETED,
                    Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
       connect("lLybQNLPJybePISuibQESlLeWYwPC/RuDRjxWJCh1LwDDYXALcXJWAV29xrfwp2HB6jOwgj7qDXO6GMiWwUbrw==");
      //  connect("q+4CF0HdeL+zvLrSBo1FHlLeWYwPC/RuDRjxWJCh1LwDDYXALcXJWDou/TSE20s369sjj1yMBcnO6GMiWwUbrw==");
      /*  if(RongIM.getInstance().getRongIMClient().getCurrentConnectionStatus()
                ==RongIMClient.ConnectionStatusListener.ConnectionStatus.DISCONNECTED){
            connect("lLybQNLPJybePISuibQESlLeWYwPC/RuDRjxWJCh1LwDDYXALcXJWAV29xrfwp2HB6jOwgj7qDXO6GMiWwUbrw==");

        }*/

}
    private void connect(String token) {
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                Log.e("LoginActivity", "--onTokenIncorrect");
            }
            @Override
            public void onSuccess(String userid) {
                Log.e("LoginActivity", "--onSuccess--" + userid);
                Toast.makeText(MainActivity.this, "登录成功,用户：" + userid, Toast.LENGTH_SHORT).show();
                //服务器连接成功，跳转消息列表
                startActivity(new Intent(MainActivity.this, ConversationListActivity.class));
            }
            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.e("LoginActivity", "--onError");
            }
        });
    }
}
