package com.szatc.cdm.common.pojo.cdm;

import com.szatc.cdm.common.adapter.CalendarAdapterXML;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;
import java.util.List;

/**
 * 流控信息t_fc_flowcontrol
 */
@XmlRootElement(name = "CDMMessage")
public class Cdm039 {
    private List<FlowControl> message;

    @XmlElementWrapper(name="message")
    @XmlElement(name="flowControl")
    public List<FlowControl> getMessage() {
        return message;
    }

    public void setMessage(List<FlowControl> message) {
        this.message = message;
    }

    // {
//                "header": {
//                "stype": "flowcontr",
//                        "ddtm": "2017-07-24 12:00:00",
//                        "type": "otherdata",
//                        "sndr": "fps"
//            },
//            "body": [
//            {
//                "enabledFlag": "1",
//                    "message": "2",
//                    "controlPoint": "3",
//                    "interval": "4",
//                    "flowId": "ZGSZ",
//                    "startTime": "2017-07-26 10:10:00",
//                    "endTime": "2017-07-26 10:10:01",
//                    "flightKeyList": [
//                {
//                    "adep": "ZGSZ",
//                        "flightNo": "CSZ9606",
//                        "fuid": 6,
//                        "sobt": "2017-07-26 10:10:00",
//                        "ades": 1,
//                        "sibt": "2017-07-03 14:20:00"
//                },
//                {
//                    "adep": "ZGSZ",
//                        "flightNo": "CSZ9606",
//                        "fuid": 6,
//                        "sobt": "2017-07-26 10:10:00",
//                        "ades": 1,
//                        "sibt": "2017-07-03 14:20:00"
//                }
//            ]
//            }
//    ]
//        }

//    <message>
//    <flowControls>
//      <flowControl controlPoint="SULAS" remark="" flowId="38017" endTime="2018-04-20T16:35:00" reason="" enabledFlag="N" airportBeyond="0" interval="4分钟/架次" startTime="2018-04-20T03:35:00" />
//    </flowControls>
//  </message>

    @XmlRootElement(name = "flowControl")
    public  static class FlowControl {
        private String flowId;
        private String controlPoint;
        private String interval;
        private Calendar startTime;
        private Calendar endTime;
        private String reason;
        private String enabledFlag;
        private String airportBeyond;
        private String remark;


        @XmlAttribute(name = "flowId")
        public String getFlowId() {
            return flowId;
        }

        public void setFlowId(String flowId) {
            this.flowId = flowId;
        }

        @XmlAttribute(name = "controlPoint")
        public String getControlPoint() {
            return controlPoint;
        }

        public void setControlPoint(String controlPoint) {
            this.controlPoint = controlPoint;
        }

        @XmlAttribute(name = "interval")
        public String getInterval() {
            return interval;
        }

        public void setInterval(String interval) {
            this.interval = interval;
        }

        @XmlAttribute(name = "startTime")
        public Calendar getStartTime() {
            return startTime;
        }

        @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
        public void setStartTime(Calendar startTime) {
            this.startTime = startTime;
        }

        @XmlAttribute(name = "endTime")
        public Calendar getEndTime() {
            return endTime;
        }

        @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
        public void setEndTime(Calendar endTime) {
            this.endTime = endTime;
        }

        @XmlAttribute(name = "reason")
        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        @XmlAttribute(name = "enabledFlag")
        public String getEnabledFlag() {
            return enabledFlag;
        }

        public void setEnabledFlag(String enabledFlag) {
            this.enabledFlag = enabledFlag;
        }

        @XmlAttribute(name = "airportBeyond")
        public String getAirportBeyond() {
            return airportBeyond;
        }

        public void setAirportBeyond(String airportBeyond) {
            this.airportBeyond = airportBeyond;
        }

        @XmlAttribute(name = "remark")
        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }


    }
}
