package eventqueue;

public class MyEntry<E> implements IEventQueue.Entry<E> {

    private E event;
    private double time;

    public MyEntry(E event, double time) {
        this.event = event;
        this.time = time;
    }

    @Override
    public double getTime() {
        return this.time;
    }

    @Override
    public E getEvent() {
        return this.event;
    }
}
