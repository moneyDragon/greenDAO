package de.greenrobot.daoexample;

import java.util.List;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Bundle;

public class ToolActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tool);
        initView();
        initData();
        initListener();
    }

    private void initView() {

    }

    private void initData() {

        testShortcutList();
    }

    private void initListener() {

    }

    private void testShortcutList() {
        List<PackageInfo> packs = getBaseContext().getPackageManager().getInstalledPackages(
                PackageManager.GET_PROVIDERS);
        if (packs != null) {
            for (PackageInfo pack : packs) {
                ProviderInfo[] providers = pack.providers;
                if (providers != null) {
                    for (ProviderInfo provider : providers) {
                        System.out.println(provider.readPermission + "   " + provider.writePermission + "  "
                                + provider.authority);
                    }
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
