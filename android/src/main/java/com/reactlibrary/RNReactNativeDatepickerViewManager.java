package com.reactlibrary;

import android.content.Context;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

import java.util.Date;
import java.util.Map;

public class RNReactNativeDatepickerViewManager extends SimpleViewManager<MyPickerView> implements ResultHandler {
    public static final String REACT_CLASS = "RNTDatePicker";
    private Context context;
    private MyPickerView myPickerView;
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected MyPickerView createViewInstance(ThemedReactContext reactContext) {
        this.context=reactContext;
        myPickerView=new MyPickerView(reactContext);
        myPickerView.setResultHandlerListener(this);
        myPickerView.showSpecificTime(false);
        return myPickerView;
    }

    @ReactProp(name = "minDate")
    public void setMinDate(MyPickerView view, String minDate) {
        view.setStartTime(minDate);
    }
    @ReactProp(name = "maxDate")
    public void setMaxDate(MyPickerView view, String maxDate) {
        view.setEndTime(maxDate);
    }

    @ReactProp(name = "datePickerMode")
    public void setDatePickerMode(MyPickerView view, Boolean canBe) {
        view.showSpecificTime(canBe);
    }

    @Override
    public void handle(Date time) {
        myPickerView.onReceiveNativeEvent(time.getTime());
    }

    @Override
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put(
                        "onDateChange",
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onDateChange")))
                .build();
    }

}
