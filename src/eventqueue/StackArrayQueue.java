package eventqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class StackArrayQueue<E> implements IEventQueue<E> {
    private final Stack<MyEntry<E>> nearFutureEvents;
    private final int upperBuffer;
    private final int lowerBuffer;
    private MyEntry<E>[] farFutureEvents;
    private int freeIndex;
    private double maxStackValue;


    public StackArrayQueue() {
        this.nearFutureEvents = new Stack<MyEntry<E>>();
        this.farFutureEvents = new MyEntry[100];
        this.freeIndex = 0;
        this.upperBuffer = 100;
        this.lowerBuffer = 110;
    }

    @Override
    public void enqueue(double time, E event) {
        if (freeIndex >= farFutureEvents.length) {
            farFutureEvents = Arrays.copyOf(farFutureEvents, farFutureEvents.length + this.upperBuffer);
        }
        if (time > maxStackValue) {
            farFutureEvents[freeIndex] = new MyEntry<>(event, time);
            freeIndex++;
        } else {
            Stack<MyEntry<E>> tempStack = new Stack<>();
            while (!nearFutureEvents.empty() && nearFutureEvents.peek().getTime() < time) {
                tempStack.push(nearFutureEvents.pop());
            }
            nearFutureEvents.push(new MyEntry<>(event, time));
            while (!tempStack.empty()) {
                nearFutureEvents.push(tempStack.pop());
            }
        }
    }

    @Override
    public Entry<E> dequeue() {
        if (nearFutureEvents.empty()) {
            refillNearFutureEvents();
        }
        return nearFutureEvents.pop();
    }

    @Override
    public IEventQueue<E> cleanCopy() {
        return new StackArrayQueue<>();
    }

    private void refillNearFutureEvents() {
        int refillAmount = (int) Math.ceil(freeIndex / 5.0);
        Arrays.sort(farFutureEvents, Comparator.nullsLast(Comparator.comparingDouble(MyEntry::getTime)));
        for (int i = 0; i < refillAmount; i++) {
            nearFutureEvents.push(farFutureEvents[i]);
        }
        this.maxStackValue = farFutureEvents[refillAmount - 1].getTime();
        int elementsRemainingInFFE = freeIndex - nearFutureEvents.size();
        System.arraycopy(this.farFutureEvents, refillAmount, this.farFutureEvents, 0, elementsRemainingInFFE);
        this.freeIndex = elementsRemainingInFFE;
    }
}
