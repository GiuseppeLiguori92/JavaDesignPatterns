package com.giuseppeliguori.designpattern.creational.singleton;

import java.util.HashMap;

/**
 * Created by giuseppeliguori on 05/05/2017.
 */
public class StorageSingleton {

    private static StorageSingleton instance;

    private HashMap<Integer, Item> storage;

    public static StorageSingleton getInstance() {
        if (instance == null) {
            instance = new StorageSingleton();
        }
        return instance;
    }

    private StorageSingleton() {
        storage = new HashMap<>();
    }

    public void storeItem(Item item) {
        storage.put(item.id, item);
    }

    public Item getItem(int id) {
        Item item = storage.get(id);
        System.out.println(item.getId() + " " + item.getValue());
        return item;
    }
}
