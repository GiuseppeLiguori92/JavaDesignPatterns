package com.giuseppeliguori.designpattern.structural.adapter;

import java.util.HashMap;

/**
 * Created by giuseppeliguori on 05/05/2017.
 */
public class DataPresenter {

    public DataPresenter(DataAdapter dataAdapter) {
        HashMap<Integer, Object> dataFromAdapter = dataAdapter.getData();
        for (int i = 0; i < dataFromAdapter.size(); i++) {
            System.out.println("[" + i + "]" + dataAdapter.getDataValue(dataFromAdapter.get(i)));
        }
    }
}
