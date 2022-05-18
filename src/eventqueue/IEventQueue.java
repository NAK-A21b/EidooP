package eventqueue;

public interface IEventQueue<E> {
    void enqueue(double time, E event);

    IEventQueue.Entry<E> dequeue();

    IEventQueue<E> cleanCopy();

    public interface Entry<E> {

        double getTime();

        E getEvent();

    }
}