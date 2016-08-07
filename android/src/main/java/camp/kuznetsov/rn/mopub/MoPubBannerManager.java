package camp.kuznetsov.rn.mopub;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;

import java.util.Map;

public class MoPubBannerManager extends SimpleViewManager<RNMoPubView>{
    public static final String REACT_CLASS = "RNMoPubBannerView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected RNMoPubView createViewInstance(final ThemedReactContext reactContext) {
        return new RNMoPubView(reactContext);
    }

    @ReactProp(name = "adUnitId")
    public void setAdUnitId(RNMoPubView view, String adUnitId){
        view.setAdUnitId(adUnitId);
        view.loadAd();
    }

    @ReactProp(name = "testing", defaultBoolean = false)
    public void setTesting(RNMoPubView view, Boolean testing){
        view.setTesting(testing);
    }

    @ReactProp(name = "autoRefresh", defaultBoolean = true)
    public void setAutoRefresh(RNMoPubView view, Boolean autoRefresh){
        view.setAutorefreshEnabled(autoRefresh);
    }

    @ReactProp(name = "localExtras")
    public void setLocalExtras(RNMoPubView view, @Nullable  ReadableMap localExtras){
        view.setLocalExtras(((ReadableNativeMap) localExtras).toHashMap());
    }

    @ReactProp(name = "keywords")
    public void setKeywords(RNMoPubView view, @Nullable String keywords){
        view.setKeywords(keywords);
    }

    @javax.annotation.Nullable
    @Override
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder<String, Object> builder = MapBuilder.builder();
        builder.put(RNMoPubView.EVENT_LOADED, MapBuilder.of("registrationName", RNMoPubView.EVENT_LOADED));
        builder.put(RNMoPubView.EVENT_FAILED, MapBuilder.of("registrationName", RNMoPubView.EVENT_FAILED));
        builder.put(RNMoPubView.EVENT_CLICKED, MapBuilder.of("registrationName", RNMoPubView.EVENT_CLICKED));
        builder.put(RNMoPubView.EVENT_EXPANDED, MapBuilder.of("registrationName", RNMoPubView.EVENT_EXPANDED));
        builder.put(RNMoPubView.EVENT_COLLAPSED, MapBuilder.of("registrationName", RNMoPubView.EVENT_COLLAPSED));
        return builder.build();
    }
}