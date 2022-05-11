package eventqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class StackArrayListQueue<E> implements IEventQueue<E> {
    private final Stack<MyEntry<E>> nearFutureEvents;
    private List<MyEntry<E>> farFutureEvents;
    private double maxStackValue;

    public StackArrayListQueue() {
        nearFutureEvents = new Stack<>();
        // initialize farFutureEvents
        farFutureEvents = new ArrayList();
    }

    @Override
    public void enqueue(double time, E event) {
        if (time > maxStackValue) {
            farFutureEvents.add(new MyEntry<>(event, time));
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
        return new StackArrayListQueue<>();
    }

    private void refillNearFutureEvents() {
        int refillSize = (int) Math.ceil(farFutureEvents.size() / 5.0);
        // sort farFutureEvents by time
        this.farFutureEvents = new ArrayList<>(this.farFutureEvents.stream().sorted(Comparator.comparing(MyEntry::getTime)).toList());
        // refill nearFutureEvents
        for (int i = refillSize - 1; i >= 0; i--) {
            nearFutureEvents.push(farFutureEvents.remove(i));
        }
        // update maxStackValue as the value of the event on the buttom of the stack
        maxStackValue = nearFutureEvents.peek().getTime();
        //reverse Stack
    }

}
