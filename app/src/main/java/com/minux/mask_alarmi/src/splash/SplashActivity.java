package com.minux.mask_alarmi.src.splash;

import com.minux.mask_alarmi.src.BaseActivity;


public class SplashActivity extends BaseActivity {
   /* private static final String TAG = "SPLASH ACT://";

    PermissionListener permissionlistener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            Thread splashThread;

            splashThread = new Thread() {
                @Override
                public void run() {
                    synchronized (this) {
                        try {
                            wait(1000);

                            Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(mainIntent);
                            finish();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            splashThread.start();
        }

        @Override
        public void onPermissionDenied(List<String> deniedPermissions) {
            showCustomToast("앱 설정을 통해 권한을 허용해주세요!");
            finish();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TedPermission.with(SplashActivity.this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("위치 및 GPS 권한 설정을 해주세요.")
                .setPermissions(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                )
                .check();
    }



    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void validateSuccess(String message) {

    }*/
}