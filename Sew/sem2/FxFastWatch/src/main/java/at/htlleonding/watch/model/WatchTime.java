package at.htlleonding.watch.model;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class WatchTime {
    //TODO: Singleton (lazy initialization) goes here.

    private static WatchTime instance;

    private Timer timer;

    private SimpleIntegerProperty hours;
    private SimpleIntegerProperty minutes;
    private SimpleStringProperty dayOfWeekShort;
    private SimpleIntegerProperty tickDelay;
    private DayOfWeek dayOfWeek;

    //TODO: Getters go here.

    private WatchTime() {
        //TODO: Initialize properties etc.

        LocalDateTime now = LocalDateTime.now();
        hours = new SimpleIntegerProperty(now.getHour());
        minutes = new SimpleIntegerProperty(now.getMinute());
        dayOfWeekShort = new SimpleStringProperty(now.getDayOfWeek().toString().substring(0, 3));
        tickDelay = new SimpleIntegerProperty(1000);
        dayOfWeek = DayOfWeek.valueOf(now.getDayOfWeek().toString());

        this.timer = new Timer(true);
        this.tickTock();
    }

    public static WatchTime getInstance(){
        if(instance == null) instance = new WatchTime();
        return instance;
    }

    private void tickTock() {
        getTimer().schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    //TODO: Logic for each tick goes here... update hours, minutes, day of week accordingly.
                    if (minutes.get() == 59) {
                        minutes.set(0);
                        if (hours.get() == 23) {
                            hours.set(0);
                            dayOfWeek = DayOfWeek.values()[(dayOfWeek.ordinal() + 1) % 7];
                            dayOfWeekShort.set(dayOfWeek.toString().substring(0, 3));
                        } else hours.set(hours.get() + 1);
                    } else minutes.set(minutes.get() + 1);

                    //DO NOT remove/change the following lines!
                    tickTock();
                });
            }
        }, tickDelay.get());
    }

    public void setTime(int hours, int minutes, DayOfWeek dayOfWeek) {
        //TODO: Allow setting the time and day from outside

        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59 || dayOfWeek == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Invalid data entered!");
            alert.showAndWait();
            return;
        }

        this.hours.set(hours);
        this.minutes.set(minutes);
        this.dayOfWeekShort.set(dayOfWeek.toString().substring(0, 3));
        this.dayOfWeek = dayOfWeek;

    }
    public Timer getTimer() {
        return timer;
    }
    public int getHours() {
        return hours.get();
    }
    public SimpleIntegerProperty hoursProperty() {
        return hours;
    }
    public int getMinutes() {
        return minutes.get();
    }
    public SimpleIntegerProperty minutesProperty() {
        return minutes;
    }
    public String getDayOfWeekShort() {
        return dayOfWeekShort.get();
    }
    public SimpleStringProperty dayOfWeekShortProperty() {
        return dayOfWeekShort;
    }
    public int getTickDelay() {
        return tickDelay.get();
    }
    public SimpleIntegerProperty tickDelayProperty() {
        return tickDelay;
    }
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
