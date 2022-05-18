package eventqueue;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayQueue<E> implements IEventQueue<E> {

    private final int upperBuffer;
    private final int lowerBuffer;
    private MyEntry<E>[] entries;
    private int freeIndex;


    public SortedArrayQueue() {
        this.entries = new MyEntry[100];
        this.freeIndex = 0;
        this.upperBuffer = 100;
        this.lowerBuffer = 110;
    }

    @Override
    public void enqueue(double time, E event) {
        if (freeIndex >= entries.length) {
            entries = Arrays.copyOf(entries, entries.length + this.upperBuffer);
        }
        entries[freeIndex] = new MyEntry<>(event, time);
        freeIndex++;
        Arrays.sort(entries, Comparator.nullsLast(Comparator.comparingDouble(MyEntry::getTime)));
    }

    @Override
    public IEventQueue.Entry<E> dequeue() {
        if (freeIndex <= entries.length - this.lowerBuffer) {
            entries = Arrays.copyOf(entries, entries.length - this.lowerBuffer);
        }
        MyEntry<E> minEntry = entries[0];
        removeElement(0);
        return minEntry;
    }

    @Override
    public IEventQueue<E> cleanCopy() {
        return new SortedArrayQueue<>();
    }

    private void removeElement(int index) {
        int remainingElements = this.entries.length - (index + 1);
        System.arraycopy(this.entries, index + 1, this.entries, index, remainingElements);
    }
}
