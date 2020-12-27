package com.pan.Springbootaction.gof;

public class Alert {
    private AlertRule alertRule;
    private Notification notification;

    public Alert(AlertRule alertRule, Notification notification) {
        this.alertRule = alertRule;
        this.notification = notification;
    }

    public void checkout(String api, long requestCount, long errorCount, long durationOfSeconds) {
        long tps = requestCount / durationOfSeconds;
        if(tps > AlertRule.MAX_TPS) {
            notification.toNotify(NotificationEmergencyLevel.URGENCY);
        }
        if(errorCount > AlertRule.MAX_ERROR) {
            notification.toNotify(NotificationEmergencyLevel.SEVERE);
        }
    }

    static class AlertRule {
        public static final Long MAX_TPS = 1000L;
        public static final Long MAX_ERROR = 100L;
    }

    static class Notification {
        public void toNotify(NotificationEmergencyLevel level) {
            System.out.println("level of " + level.getMsg() + "is triggered!");
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
}


