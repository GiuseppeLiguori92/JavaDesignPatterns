package com.giuseppeliguori.tolearn.labda;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class Trigger {

    private State state = State.ON;
    private OnStateChange onStateChange;

    enum State {
        ON,
        OFF
    }

    public interface OnStateChange {
        void onStateChange(State newState);
    }

    public Trigger() {

        new Thread( () -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                state = state == State.ON ? State.OFF : State.ON;
                if (onStateChange != null) {
                    onStateChange.onStateChange(state);
                }
            }
        }).start();
    }

    public void setOnStateChangeListener(OnStateChange onStateChange) {
        this.onStateChange = onStateChange;
    }
}
