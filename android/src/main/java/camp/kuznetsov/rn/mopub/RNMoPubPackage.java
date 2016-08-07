package camp.kuznetsov.rn.mopub;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RNMoPubPackage implements ReactPackage {

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        ArrayList<NativeModule> nativeModules = new ArrayList<>();
        nativeModules.add(new RNMoPubInterstitialModule(reactContext));
        return nativeModules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        ArrayList<ViewManager> viewManagers = new ArrayList<>();
        viewManagers.add(new MoPubBannerManager());
        return viewManagers;
    }
}
