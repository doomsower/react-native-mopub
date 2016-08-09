# React Native MoPub SDK

This module allows you to display [MoPub](http://www.mopub.com/) ads in your react-native apps. 
Currently it supports 320x50 banners and interstitials.
Under the hood, it wraps [MoPub Android SDK](https://github.com/mopub/mopub-android-sdk) and [MoPub iOS SDK](https://github.com/mopub/mopub-ios-sdk).

## Requirements

This module works with **react-native 0.29.2+**

For iOS version you'll need [CocoaPods](https://cocoapods.org/)

## Installation 

```
npm install --save react-native-mopub
```

### Android

1. Run `react-native link`
2. Add permissions, activities and meta-data as to your `AndroidManifest.xml` as described [here](https://github.com/mopub/mopub-android-sdk/wiki/Getting-Started#updating-your-android-manifest) in the official docs.

### iOS

1. This module requires CocoaPods to be used in iOS project. To add CocoaPods to your React Native project, follow steps 2 throught 7 of [this](https://blog.callstack.io/login-users-with-facebook-in-react-native-4b230b847899#.lai35aq3a) tutorial.
Add this line  

    ```ruby
    pod 'react-native-mopub', :path => '../node_modules/react-native-mopub'
    ```
    to your Podfile (you may need to adjust path if you have non-standard project structure).

    And then run `pod install` (if you’re setting up Cocoapods for the first time)
    or `pod update` (if you’re adding MoPub to an existing CocoaPods project).
2. Disable App Transport Security (this is [required](https://github.com/mopub/mopub-ios-sdk/wiki/Getting-Started#building-against-ios9) by MoPub iOS SDK, it is not react-native specific requirement or this module's flaw).
To do so, add the following to your app plist:

    ```xml
    <key>NSAppTransportSecurity</key>
    <dict>
        <key>NSAllowsArbitraryLoads</key>
        <true/>
    </dict>
    ```

## Usage

Check out the [example app](https://github.com/doomsower/react-native-mopub/blob/master/example/App.js). 

This app uses adUnitIds from MoPub sample apps. 

## Contributing

Feel free to create issues and submit pull requests. 
