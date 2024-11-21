package li.hce.alamak;

import android.webkit.JavascriptInterface;

public class JSIntf {
    private final String deviceId;

    public JSIntf(final String deviceId) {
        this.deviceId = deviceId;
    }

    @JavascriptInterface
    public String getDeviceId() {
        return deviceId;
    }
}
