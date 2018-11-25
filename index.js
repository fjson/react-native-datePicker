import React, {PureComponent} from 'react';
import {NativeModules, requireNativeComponent} from 'react-native';
const { RNReactNativeFtPicker } = NativeModules;
import PropTypes  from 'prop-types';
const  RNTDatePicker=requireNativeComponent('RNTDatePicker');
export default class JFDatePicker extends PureComponent {
    render(){
        return(
            <RNTDatePicker {...this.props} />
    );
    }
}
JFDatePicker.propTypes = {
    minDate:PropTypes.string,           //最早可选时间
    maxDate:PropTypes.string,          //最晚可选时间
    onDateChange:PropTypes.func,        //时间变更调用
    datePickerMode:PropTypes.number,    //picker 模式  1:年月日 2:年月日时分
};
