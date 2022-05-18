import eventqueue.IEventQueue;

import java.util.Random;

public class Experiment<E, Q extends IEventQueue<E>> {
    private Q queue;

    public Experiment(Q queue) {
        this.queue = queue;
    }

    public void initialize(int initialSize) {
        this.queue = (Q) this.queue.cleanCopy();
        Random random = new Random();
        for (int i = 0; i < initialSize; i++) {
            this.queue.enqueue(random.nextDouble(), null);
        }
    }

    public long evaluate(int repetitions) {
        Random random = new Random();
        long timeStart = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            this.queue.enqueue(random.nextDouble(), null);
            this.queue.dequeue();
        }
        long elapsedTime = System.nanoTime() - timeStart;
        return elapsedTime / repetitions;
    }

    public String getQueueName() {
        return this.queue.getClass().getSimpleName();
    }

    public Experiment getCopy() {
        return new Experiment<E, Q>((Q) this.queue.cleanCopy());
    }


}
