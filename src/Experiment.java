public class Experiment {
    private final IEventQueueImpl my_eventq = new IEventQueueImpl();

    public void initialize(Integer initialSize) {
        for (int i = 0; i < initialSize; i++) {
            my_eventq.enqueue((double) i, "Eventname-" + i);
        }
    }

    public long evaluate(Integer repetitions) {
        long startTime = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            my_eventq.enqueue((double) i, "Eventname-" + i);
            IEventQueue.Entry<Object> dequeue_event = my_eventq.dequeue();
        }
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        //long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(elapsedTime);
        //long elapsedSeconds = TimeUnit.NANOSECONDS.toSeconds(elapsedTime);
        //System.out.println("Experiment evaluated");
        //System.out.println("\t repetitions: " + repetitions);
        //System.out.println("\telapsed time: " + elapsedMillis + " Milliseconds");
        //System.out.println("\telapsed time: ~" + elapsedSeconds + " Seconds");
        return elapsedTime / repetitions;
    }

    public long main(int repetitions, int initialSize) {
        initialize(initialSize);
        return evaluate(repetitions);
    }
}