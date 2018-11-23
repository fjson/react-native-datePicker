import { requireNativeComponent } from 'react-native';
import React, {PureComponent} from 'react';
import PropTypes  from 'prop-types';


class JFDatePicker extends PureComponent {
    render(){
        return(
            <RNTIOSDatePicker />
        );
    }
}
JFDatePicker.propTypes = {
    minimumDate:PropTypes.date,           //最早可选时间
    maximumDate:PropTypes.date,          //最晚可选时间
    onDateChange:PropTypes.func,        //时间变更调用
    datePickerMode:PropTypes.number,    //picker 模式  1:年月日 2:年月日时分
};

const JZDatePicker = requireNativeComponent('RNTDatePicker', JFDatePicker);
export default JZDatePicker;

