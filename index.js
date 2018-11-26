import React, {Fragment, PureComponent} from 'react';
import {NativeModules, requireNativeComponent} from 'react-native';
const { RNReactNativeFtPicker } = NativeModules;
import PropTypes  from 'prop-types';

const  formatToString = (timestamp, formater) => {
    let date = new Date();
    date.setTime(parseInt(timestamp));
    formater = (formater != null) ? formater : 'yyyy-MM-dd hh:mm';
    Date.prototype.Format = function (fmt) {
        var o = {
            "M+": this.getMonth() + 1, //月
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };

        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o) {
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ?
                (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
        return fmt;
    }
    return date.Format(formater);
};


const  RNTDatePicker=requireNativeComponent('RNTDatePicker');
export default class JFDatePicker extends PureComponent {

    render(){
        let {minDate,maxDate,...props} =this.props;
        return(
            <Fragment>
                <RNTDatePicker minDate={formatToString(new Date(minDate).getTime(),null)} maxDate={formatToString(new Date(maxDate).getTime(),null)} { ...props }/>
            </Fragment>
        );
    }
}
//
JFDatePicker.propTypes = {
    // minDate:PropTypes.date,           //最早可选时间
    // maxDate:PropTypes.date,          //最晚可选时间
    onDateChange:PropTypes.func,        //时间变更调用
    datePickerMode:PropTypes.number,    //picker 模式  1:年月日 2:年月日时分
};