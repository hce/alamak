if (typeof alamakNative === "undefined") {
    alamakNative = { };
    var rememberMyLast = false;
    var storage = new Map();
    alamakNative.getDeviceId = function() {
        return "virtual";
    };
    alamakNative.getRelaisState = function() {
        return rememberMyLast;
    };
    alamakNative.setRelaisState = function(newState) {
        rememberMyLast = newState;
    };
    alamakNative.storeState = function(k, v) {
        storage.set(k, v)
    }
    alamakNative.getState = function(k, d) {
        if (storage.has(k)) {
            return storage.get(k);
        } else {
            return d;
        }
    }
}
