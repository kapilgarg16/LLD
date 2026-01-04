package SeatLock;

import java.util.Date;

public class SeatLock {
    private int showId;
    private int seatId;
    private String userId;
    private Date lockTime;
    private long lockTimeoutInSeconds;
    
    public SeatLock(int showId, int seatId, String userId, long lockTimeoutInSeconds) {
        this.showId = showId;
        this.seatId = seatId;
        this.userId = userId;
        this.lockTime = new Date();
        this.lockTimeoutInSeconds = lockTimeoutInSeconds;
    }
    
    public boolean isLockExpired() {
        long currentTime = System.currentTimeMillis();
        long lockExpiryTime = lockTime.getTime() + (lockTimeoutInSeconds * 1000);
        return currentTime > lockExpiryTime;
    }
    
    public String getLockKey() {
        return showId + "_" + seatId;
    }
    
    // Getters
    public int getShowId() {
        return showId;
    }
    
    public int getSeatId() {
        return seatId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public Date getLockTime() {
        return lockTime;
    }
    
    public long getLockTimeoutInSeconds() {
        return lockTimeoutInSeconds;
    }
}

