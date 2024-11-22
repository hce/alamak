package li.hce.alamak;

import java.util.HashMap;

public final class PerDeviceSettings {
    private PerDeviceSettings() {
        put("00082XXXXXXX", "Seitenzimmer", 3600000L, 60000L, "http://192.168.7.8/walldisplay/");
        put("00082XXXXXXX", "Wohnzimmer", 3600000L, 60000L, "http://192.168.7.8/walldisplay/");

        put("00082XXXXXXX", "Development", 60000L, 60000L, "http://192.168.7.8/walldisplay-devel/");
    }

    public DeviceSettings get_(final String deviceId) {
        return settings.getOrDefault(deviceId, defaultSettings);
    }

    public static DeviceSettings get(final String deviceId) {
        return getInstance().get_(deviceId);
    }

    private static PerDeviceSettings getInstance() {
        return instance;
    }

    private void put(final String deviceId, final String deviceName, final long updateInterval, final long waitUntilTouch, final String urlToDisplay) {
        final DeviceSettings entry = new DeviceSettings(deviceId, deviceName, updateInterval, waitUntilTouch, urlToDisplay);
        settings.put(deviceId, entry);
    }

    private static final PerDeviceSettings instance = new PerDeviceSettings();

    private final HashMap<String, DeviceSettings> settings = new HashMap<>();

    private final DeviceSettings defaultSettings = new DeviceSettings("default", "default", 3600000L, 60000L, "http://192.168.7.8/walldisplay/");

    public static final class DeviceSettings {
        private final String deviceId;
        private final String deviceName;
        private final long updateInterval;// = 3600000L;

        private final long waitUntilTouch;// = 60000L;

        private final String urlToDisplay;// = "http://192.168.7.8/walldisplay/";

        private DeviceSettings(final String deviceId, final String deviceName, final long updateInterval, final long waitUntilTouch, final String urlToDisplay) {
            this.deviceId = deviceId;
            this.deviceName = deviceName;
            this.updateInterval = updateInterval;
            this.waitUntilTouch = waitUntilTouch;
            this.urlToDisplay = urlToDisplay;
        }

        public long getUpdateInterval() {
            return updateInterval;
        }

        public long getWaitUntilTouch() {
            return waitUntilTouch;
        }

        public String getUrlToDisplay() {
            return urlToDisplay;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public String getDeviceName() {
            return deviceName;
        }
    }
}
