package ggx.com.iocdemo;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.AuthorityFail;
import com.example.AuthorityOK;

import ggx.com.ioc_api.MPermission;

public class MainActivity extends AppCompatActivity {

    MPermission permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permission=MPermission.with(this);
        //请求相机和读写的权限
        permission.apply(100, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permission.onRequestPermissionsResult(this,requestCode,permissions,grantResults);
    }

    @AuthorityOK(100)
    public void requestOK(){

    }

    @AuthorityFail(100)
    public void requestFail(){

    }

    @AuthorityOK(101)
    public void requestOtherOK(){

    }

    @AuthorityFail(101)
    public void requestOtherFail(){

    }


    @Override
    protected void onDestroy() {
        permission.recycle();
        super.onDestroy();
    }
}
