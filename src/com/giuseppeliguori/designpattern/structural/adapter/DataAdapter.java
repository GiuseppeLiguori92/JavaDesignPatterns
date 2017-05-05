package com.giuseppeliguori.designpattern.structural.adapter;

import java.util.HashMap;

/**
 * Created by giuseppeliguori on 05/05/2017.
 */
public class DataAdapter implements AdapterInteface {

    private HashMap<Integer, Object> data;

    public DataAdapter(HashMap<Integer, Object> data) {
        this.data = data;
    }

    public HashMap<Integer, Object> getData() {
        return data;
    }

    @Override
    public String getDataValue(Object data) {
        if (data instanceof Item) {
            return ((Item)data).getItemValue();
        } else if (data instanceof Person) {
            return ((Person)data).getPersonValue();
        } else {
            return null;
        }
    }
}
