package co.hytlabs.rubus.entity;

/**
 * Rubus
 * Created by tma02 on 6/23/15.
 * Description:
 */

public class DeltaCounter {

    private int deltaCounter;
    private Runnable runnable;
    private int delta;

    public DeltaCounter(Runnable runnable, int delta) {
        this.runnable = runnable;
        this.delta = delta;
        this.deltaCounter = 0;
    }

    public void tick(int delta) {
        this.deltaCounter += delta;
        if (this.deltaCounter > this.delta) {
            this.runnable.run();
            this.deltaCounter = 0;
        }
    }

    public void reset() {
        this.deltaCounter = 0;
    }

}
