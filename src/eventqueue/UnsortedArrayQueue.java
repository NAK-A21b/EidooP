package eventqueue;

import java.util.Arrays;

public class UnsortedArrayQueue<E> implements IEventQueue<E> {

    private MyEntry<E>[] entries;
    private int freeIndex;
    private int upperBuffer;
    private int lowerBuffer;


    public UnsortedArrayQueue() {
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
    }

    @Override
    public Entry<E> dequeue() {
        if (freeIndex <= entries.length - this.lowerBuffer) {
            entries = Arrays.copyOf(entries, entries.length - this.lowerBuffer);
        }
        double minTime = Double.POSITIVE_INFINITY;
        int minIndex = 0;
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null && entries[i].getTime() < minTime) {
                minTime = entries[i].getTime();
                minIndex = i;
            }
        }
        MyEntry<E> minEntry = entries[minIndex];
        removeElement(minIndex);
        return minEntry;
    }

    @Override
    public IEventQueue<E> cleanCopy() {
        return new UnsortedArrayQueue<>();
    }

    private void removeElement(int index) {
        int remainingElements = this.entries.length - (index + 1);
        System.arraycopy(this.entries, index + 1, this.entries, index, remainingElements);
    }

}
