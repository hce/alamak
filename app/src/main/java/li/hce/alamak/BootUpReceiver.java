package li.hce.alamak;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootUpReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
            final Intent startBV = new Intent(context, BrowserView.class);
            startBV.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(startBV);
    }
}