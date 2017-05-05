package com.giuseppeliguori.tolearn.lambda;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class Lambda {
    public Lambda() {

        Trigger trigger = new Trigger();;
        trigger.setOnStateChangeListener( (newState -> System.out.println(newState.toString())) );
    }
}
