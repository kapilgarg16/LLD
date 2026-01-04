package SeatLock;

import java.util.HashMap;
import java.util.Map;

public class SeatLockManager {
    private Map<String, SeatLock> seatLocks;
    private static final long DEFAULT_LOCK_TIMEOUT = 10; // 10 seconds
    
    public SeatLockManager() {
        this.seatLocks = new HashMap<>();
    }
    
    public synchronized boolean lockSeat(int showId, int seatId, String userId) {
        String lockKey = showId + "_" + seatId;
        
        // Check if seat is already locked
        if (seatLocks.containsKey(lockKey)) {
            SeatLock existingLock = seatLocks.get(lockKey);
            
            // If lock is expired, remove it
            if (existingLock.isLockExpired()) {
                System.out.println("⚠️  Previous lock expired. Removing expired lock for seat " + seatId);
                seatLocks.remove(lockKey);
            } else {
                // Seat is locked by another user
                if (!existingLock.getUserId().equals(userId)) {
                    System.out.println("❌ Seat " + seatId + " is currently locked by user: " + existingLock.getUserId());
                    System.out.println("   Locked at: " + existingLock.getLockTime());
                    return false;
                } else {
                    // Same user trying to lock again - refresh the lock
                    System.out.println("ℹ️  Seat " + seatId + " already locked by you. Refreshing lock...");
                    seatLocks.put(lockKey, new SeatLock(showId, seatId, userId, DEFAULT_LOCK_TIMEOUT));
                    return true;
                }
            }
        }
        
        // Acquire new lock
        SeatLock newLock = new SeatLock(showId, seatId, userId, DEFAULT_LOCK_TIMEOUT);
        seatLocks.put(lockKey, newLock);
        System.out.println("🔒 Seat " + seatId + " locked successfully for user: " + userId);
        System.out.println("   Lock will expire in " + DEFAULT_LOCK_TIMEOUT + " seconds");
        return true;
    }
    
    public synchronized boolean unlockSeat(int showId, int seatId, String userId) {
        String lockKey = showId + "_" + seatId;
        
        if (!seatLocks.containsKey(lockKey)) {
            return false; // No lock exists
        }
        
        SeatLock lock = seatLocks.get(lockKey);
        
        // Only the user who locked can unlock
        if (!lock.getUserId().equals(userId)) {
            System.out.println("❌ Cannot unlock seat " + seatId + ". Locked by different user: " + lock.getUserId());
            return false;
        }
        
        seatLocks.remove(lockKey);
        System.out.println("🔓 Seat " + seatId + " unlocked successfully by user: " + userId);
        return true;
    }
    
    public synchronized boolean isSeatLocked(int showId, int seatId) {
        String lockKey = showId + "_" + seatId;
        
        if (!seatLocks.containsKey(lockKey)) {
            return false;
        }
        
        SeatLock lock = seatLocks.get(lockKey);
        
        // Check if lock is expired
        if (lock.isLockExpired()) {
            seatLocks.remove(lockKey);
            return false;
        }
        
        return true;
    }
    
    public synchronized SeatLock getSeatLock(int showId, int seatId) {
        String lockKey = showId + "_" + seatId;
        SeatLock lock = seatLocks.get(lockKey);
        
        if (lock != null && lock.isLockExpired()) {
            seatLocks.remove(lockKey);
            return null;
        }
        
        return lock;
    }
    
    // Clean up expired locks (can be called periodically)
    public synchronized void cleanupExpiredLocks() {
        seatLocks.entrySet().removeIf(entry -> entry.getValue().isLockExpired());
    }
}

