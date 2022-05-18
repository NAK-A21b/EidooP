package eventqueue;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayListEventQueue<E> implements IEventQueue<E> {

    private ArrayList<MyEntry<E>> objectList;

    public ArrayListEventQueue() {
        this.objectList = new ArrayList<>();
    }

    @Override
    public void enqueue(double time, E event) {
        this.objectList.add(new MyEntry(event, time));
        objectList = new ArrayList<>(this.objectList.stream().sorted(Comparator.comparing(MyEntry::getTime)).toList());
        // Collections.reverse(objectList);
    }

    @Override
    public Entry<E> dequeue() {
        MyEntry firstEvent = this.objectList.get(0);
        this.objectList.remove(0);
        return firstEvent;
    }

    @Override
    public IEventQueue<E> cleanCopy() {
        return new ArrayListEventQueue<>();
    }


}
