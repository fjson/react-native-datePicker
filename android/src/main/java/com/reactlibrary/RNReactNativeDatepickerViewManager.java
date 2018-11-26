package com.reactlibrary;

import android.content.Context;
import android.util.Log;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Locale;


public class RNReactNativeDatepickerViewManager extends SimpleViewManager<MyPickerView> implements ResultHandler {
    public static final String REACT_CLASS = "RNTDatePicker";
    private Context context;
    private MyPickerView myPickerView;
    private SimpleDateFormat sdf;
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected MyPickerView createViewInstance(ThemedReactContext reactContext) {
        this.context=reactContext;
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        myPickerView=new MyPickerView(reactContext);
        myPickerView.setResultHandlerListener(this);
        myPickerView.showSpecificTime(false);
        return myPickerView;
    }

    @ReactProp(name = "minDate")
    public void setMinDate(MyPickerView view,String minDate) {
        view.setStartTime(minDate);
    }
    @ReactProp(name = "maxDate")
    public void setMaxDate(MyPickerView view, String maxDate) {
        view.setEndTime(maxDate);
    }

    @ReactProp(name = "datePickerMode")
    public void setDatePickerMode(MyPickerView view, int canBe) {
        view.showSpecificTime(canBe==2);
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
