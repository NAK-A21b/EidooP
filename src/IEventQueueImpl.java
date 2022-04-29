import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IEventQueueImpl implements IEventQueue<Object> {

    private final List<EntryImpl> queue = new ArrayList<>();

    @Override
    public void enqueue(Double time, Object event) {
        int j = queue.size();

        for (int i = 0; i < queue.size(); i++) {
            if (time < queue.get(i).getTime()) {
                j = i;
                break;
            }
        }

        queue.add(j, new EntryImpl(time, event));
    }

    @Override
    public EntryImpl dequeue() {
        return queue.remove(0);
    }

    public void printQueue() {
        System.out.println(
                queue.stream()
                        .map(EntryImpl::getTime)
                        .collect(Collectors.toList())
        );
    }

    public static class EntryImpl implements Entry<Object> {

        final Double time;
        final Object event;

        public EntryImpl(Double time, Object event) {
            this.time = time;
            this.event = event;
        }

        @Override
        public Double getTime() {
            return time;
        }

        @Override
        public Object getEvent() {
            return event;
        }
    }
}
