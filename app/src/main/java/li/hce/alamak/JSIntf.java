package li.hce.alamak;

import android.util.Log;
import android.webkit.JavascriptInterface;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class JSIntf {
    private final String deviceId;

    private final HashMap<String, Long> storage = new HashMap<>();

    public JSIntf(final String deviceId) {
        this.deviceId = deviceId;
    }

    @JavascriptInterface
    public String getDeviceId() {
        return deviceId;
    }

    @JavascriptInterface
    public boolean getRelaisState() {
        final Maybe<String> cnt = readContents("/sys/devices/platform/leds/red_enable");
        if (cnt.isJust()) {
            return cnt.asJust().contains("1");
        } else {
            return false;
        }
    }

    @JavascriptInterface
    public boolean setRelaisState(final boolean enabled) {
        writeContents("/sys/devices/platform/leds/red_enable", enabled ? "1" : "0");
        writeContents("/sys/devices/platform/leds/green_enable", enabled ? "1" : "0");
        return getRelaisState();
    }

    @JavascriptInterface
    public void storeState(final String key, final long value) {
        storage.put(key, value);
    }

    @JavascriptInterface
    public long getState(final String key, final long def) {
        return storage.getOrDefault(key, def);
    }

    private static boolean writeContents(final String fileName, final String contents) {
        try {
            final OutputStream os = new FileOutputStream(fileName);
            os.write(contents.getBytes(StandardCharsets.UTF_8));
            os.close();
            return true;
        } catch (final IOException e) {
            return false;
        }
    }

    private static Maybe<String> readContents(final String fileName) {
        try {
            final File f = new File(fileName);
            final byte[] buf = new byte[(int) f.length()];
            final InputStream is = new FileInputStream(f);
            is.read(buf);
            return Maybe.just(new String(buf));
        } catch (final IOException e) {
            return Maybe.nothing();
        }
    }
}
