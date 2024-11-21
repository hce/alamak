This little piece of software's purpose is to display a webview in
Kiosk mode on an Android device to serve as a "smart home" control
panel.

It's just for my own use; I doubt that it'll be too useful for others,
but since I like free software I thought I'd publish it here.

It currently has the target URL hardcoded.

It loads that URL and everything else you can do in JavaScript. The
URL is reloaded once per hour unless the display is used, in which
case the reload will be postponed to 60 seconds after the last touch.

You may query the target device's unique id from Javascript by writing a
function as such:

<pre>
return alamakNative.getDeviceId();
</pre>

There is a small .js file called alamakNativeStub.js provided for in browser testing.

The other API functions are still in develeopment, there is an API function to
store/get state across JS reloads. But it only works with long values right
now, need to investigate how to store/load arbitrary JS objects. Also, there is
an API to set/query the relay state, but that's device specific for now.

Example usage:

![Example 1](doc/img/ex1.jpeg)

![Example 2](doc/img/ex2.jpeg)
