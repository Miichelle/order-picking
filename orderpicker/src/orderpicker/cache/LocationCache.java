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
public class LocationCache implements Cache<Integer, Location> {
    private long duration;
    private Map<Integer, Location> locations;
    private Map<Integer, Timer> timers;

    public LocationCache() {
    }

    public LocationCache(long duration) {
        this.locations = new HashMap<>();
        this.timers = new HashMap<>();
        this.duration = duration;
    }

    @Override
    public void cache(Integer key, Location value) {
        //TODO:  nog niet in cache
        if (!this.isCached(key)) {
            //toDO: voeg dan toe aan cash
            this.locations.put(key, value);
        }

        //TODO: als nog geen timer op staat
        if (!this.isScheduled(key)) {
            Timer timer = new Timer();

            TimerTask task = new TimerTask() {
                @Override
                //TODO: indien afgelopen maak cacheveld leeg
                public void run() {
                    LocationCache.this.clear(key);
                }
            };

            //TODO: voeg schema toe en voeg dan toe aan timers
            timer.schedule(task, duration);
            this.timers.put(key, timer);
        }
    }

    @Override
    public void clear(Integer key) {
        //TODO: verwijder locatievalue uit de cache en verwijder de timer erop
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
