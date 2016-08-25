package orderpicker.cache;

import orderpicker.models.domain.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 20:38
 */

/**
 * This class is a Cache<Integer, Location> implementation that makes use of a HashMap containing keys towards
 * ArrayLists so it can cache many locations using their productIds.
 * Its messages are kept temporarily using Timertasks.
 */
public class LocationCache implements Cache<Integer, Location> {
    private long duration;
    private Map<Integer, Location> locations;
    private Map<Integer, Timer> timers;

    public LocationCache(long duration) {
        this.duration = duration;
        this.locations = new HashMap<>();
        this.timers = new HashMap<>();
    }

    @Override
    public void cache(Integer key, Location value) {
        if (!this.isCached(key)) {
            this.locations.put(key, value);
        }

        if (!this.isScheduled(key)) {
            Timer timer = new Timer();

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    LocationCache.this.clear(key);
                }
            };

            timer.schedule(task, duration);
            this.timers.put(key, timer);
        }
    }

    @Override
    public void clear(Integer key) {
        this.locations.remove(key);
        this.timers.remove(key);
    }

    @Override
    public Location get(Integer key) {
        return this.locations.get(key);
    }

    @Override
    public boolean isCached(Integer key) {
        return this.locations.containsKey(key);
    }

    @Override
    public boolean isScheduled(Integer key) {
        return this.timers.containsKey(key);
    }
}
