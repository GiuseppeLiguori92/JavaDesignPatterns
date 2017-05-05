package com.giuseppeliguori.designpattern.creational.prototype;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by giuseppeliguori on 05/05/2017.
 */
public class ComputerCache {
    private static HashMap<Integer, Computer> cache = new HashMap<>();

    public ComputerCache() {}

    public Computer getComputer(int id) {
        Computer computerCache = cache.get(id);
        return (Computer) computerCache.clone();
    }

    public void storeComputerInCache(Computer computer) {
        if (computer == null) { throw new NullPointerException("Computer is null"); }
        cache.put(computer.getId(), computer);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ComputerCache{");
        Iterator iterator = cache.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            stringBuilder.append("\n, " + entry.getKey() + " " + entry.getValue().toString());
        }
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }
}
