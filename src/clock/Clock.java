/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

/**
 *
 * @author minenice
 */
public class Clock {
    private int hour;
    private int minute;
    private int second;

    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public Clock() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }
    
    public Clock(Clock other) {
        this.hour = other.hour;
        this.minute = other.minute;
        this.second = other.second;
    }

    public boolean equals(Clock other) {
        return this.hour == other.hour && 
                this.minute == other.minute && 
                this.second == other.second;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
    
    public void increaseHour() {
        int nextHour = (hour + 1) % 24;
        setHour(nextHour);
    }
    
    public void increaseMinute() {
        minute = (minute + 1) % 60;
    }
}
