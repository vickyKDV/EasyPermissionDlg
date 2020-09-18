package lesehankoding.com.examplepermissiondialog;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import lesehankoding.com.easydlgpermission.EasyPermissionDlg;
import lesehankoding.com.easydlgpermission.PermissionCallback;
import lesehankoding.com.easydlgpermission.PermissionItem;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDlg();
            }
        });

        showDlg();
    }



    private void showDlg(){
        ArrayList<PermissionItem> permissionItems = new ArrayList<>();
        permissionItems.add(new PermissionItem(Manifest.permission.CAMERA,"Camera",R.drawable.permission_ic_camera));
        permissionItems.add(new PermissionItem(Manifest.permission.READ_CONTACTS,"Contact",R.drawable.permission_ic_contacts));
        permissionItems.add(new PermissionItem(Manifest.permission.ACCESS_COARSE_LOCATION,"Contact",R.drawable.permission_ic_location));
        EasyPermissionDlg.create(MainActivity.this)
                .permissions(permissionItems)
                .animStyle(R.style.Animation_Design_BottomSheetDialog)
                .checkMutiPermission(new PermissionCallback() {
                    @Override
                    public void onClose() {
                        Log.i(TAG, "onClose");
                    }

                    @Override
                    public void onFinish() {
                        Log.d("MainActivity", "onFinish: ");
                    }

                    @Override
                    public void onDeny(String permission, int position) {
                        Log.i(TAG, "onDeny");
                    }

                    @Override
                    public void onGuarantee(String permission, int position) {
                        Log.i(TAG, "onGuarantee");
                    }
                });
    }


}