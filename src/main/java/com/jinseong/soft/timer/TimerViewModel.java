package com.jinseong.soft.timer;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TimerViewModel {
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
    private final StringProperty time = new SimpleStringProperty();
    private ScheduledFuture<?> scheduledFuture;

    public TimerViewModel() {
        startRealTimeMode();
    }

    public void startRealTimeMode() {
        stopTimer();
        scheduledFuture = Executors.newSingleThreadScheduledExecutor()
                .scheduleWithFixedDelay(() -> {
                            Platform.runLater(() -> setTime(ZonedDateTime.now(ZoneId.of("Asia/Seoul"))));
                        },
                        0,
                        500,
                        TimeUnit.MILLISECONDS);
    }

    private void setTime(ZonedDateTime targetTime) {
        time.set(targetTime.format(TIME_FORMAT));
    }

    private void stopTimer() {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(true);
            scheduledFuture = null;
        }
    }

    public StringProperty timeProperty() {
        return time;
    }
}
