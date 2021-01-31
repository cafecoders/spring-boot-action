package com.pan.Springbootaction.gof;

import java.util.ArrayList;
import java.util.List;

public class Alert {

    List<AlertHandler> handlerList = new ArrayList<>();

    public void addHandler(AlertHandler handler) {
        handlerList.add(handler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler handler : handlerList) {
            handler.check(apiStatInfo);
        }
    }

    static abstract class AlertHandler {
        protected AlertRule alertRule;
        protected Notification notification;

        public AlertHandler(AlertRule alertRule, Notification notification) {
            this.alertRule = alertRule;
            this.notification = notification;
        }

        public abstract void check(ApiStatInfo apiStatInfo);
    }

    static class TpsAlertHandler extends AlertHandler {

        public TpsAlertHandler(AlertRule alertRule, Notification notification) {
            super(alertRule, notification);
        }

        @Override
        public void check(ApiStatInfo apiStatInfo) {
            long tps = apiStatInfo.requestCount / apiStatInfo.durationOfSeconds;
            if(tps > AlertRule.MAX_TPS) {
                notification.toNotify(NotificationEmergencyLevel.URGENCY);
            }
        }
    }

    static class ErrorAlertHandler extends AlertHandler {

        public ErrorAlertHandler(AlertRule alertRule, Notification notification) {
            super(alertRule, notification);
        }

        @Override
        public void check(ApiStatInfo apiStatInfo) {
            if(apiStatInfo.errorCount > AlertRule.MAX_ERROR) {
                notification.toNotify(NotificationEmergencyLevel.SEVERE);
            }
        }
    }

    static class ApiStatInfo {
        private long requestCount;
        private long errorCount;
        private long durationOfSeconds;

        public long getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(long requestCount) {
            this.requestCount = requestCount;
        }

        public long getErrorCount() {
            return errorCount;
        }

        public void setErrorCount(long errorCount) {
            this.errorCount = errorCount;
        }

        public long getDurationOfSeconds() {
            return durationOfSeconds;
        }

        public void setDurationOfSeconds(long durationOfSeconds) {
            this.durationOfSeconds = durationOfSeconds;
        }
    }

    static class AlertRule {
        public static final Long MAX_TPS = 1000L;
        public static final Long MAX_ERROR = 100L;
    }

    static class Notification {
        public void toNotify(NotificationEmergencyLevel level) {
            System.out.println("level of " + level.getMsg() + " is triggered!");
        }
    }

    enum NotificationEmergencyLevel {
        URGENCY(100, "urgency"),
        SEVERE(200, "severe");

        private int code;
        private String msg;
        NotificationEmergencyLevel(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }

    static class ApplicationContext {
        private Alert alert;
        private AlertRule alertRule;
        private Notification notification;

        public void initBeans() {
            alert = new Alert();
            alertRule = new AlertRule();
            notification = new Notification();

            alert.addHandler(new TpsAlertHandler(alertRule, notification));
            alert.addHandler(new ErrorAlertHandler(alertRule, notification));
        }

        public Alert getAlert() {
            return alert;
        }

        public ApplicationContext() {
            // 构造方法内完成初始化
            initBeans();
        }

        private static final ApplicationContext instance = new ApplicationContext();
        public static ApplicationContext getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {
        Alert.ApiStatInfo apiStatInfo = new Alert.ApiStatInfo();
        apiStatInfo.setErrorCount(10000);
        apiStatInfo.setRequestCount(10010000);
        apiStatInfo.setDurationOfSeconds(100);

        Alert.ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}


