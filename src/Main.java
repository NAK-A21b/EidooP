public class Main {

    public static void main(String[] args) {
        final IEventQueueImpl eventQueue = new IEventQueueImpl();

        int n = 100000;
        for (int i = 0; i < n; i++) {
            eventQueue.enqueue(Math.random(), new Object());
        }

        eventQueue.printQueue();

        test(eventQueue);
    }

    public static void test(IEventQueueImpl eventQueue) {
        final int m = 100000;

        long totalEnqueueTime = 0;
        for (int i = 0 ; i < m ; i++) {
            final Double time = Math.random();
            final Object object = new Object();

            long startTime = System.nanoTime();

            eventQueue.enqueue(time, object);

            long endTime = System.nanoTime();
            totalEnqueueTime += endTime - startTime;
        }
        System.out.println(totalEnqueueTime / m);

        long totalDequeueTime = 0;
        for (int i = 0 ; i < m ; i++) {
            long startTime = System.nanoTime();

            eventQueue.dequeue();

            long endTime = System.nanoTime();
            totalDequeueTime += endTime - startTime;
        }
        System.out.println(totalDequeueTime / m);
    }
}