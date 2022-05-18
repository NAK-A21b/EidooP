import eventqueue.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) {
        int repetitions = 25;
        int depth = 500;

        Experiment[] queues = new Experiment[]{
                //new Experiment(new ArrayListEventQueue<>()),
                //new Experiment(new SortedArrayQueue<>()),
                new Experiment(new UnsortedArrayQueue<>()), new Experiment(new StackArrayQueue<>()), new Experiment(new StackArrayListQueue()),};
        processExperimentList(queues, repetitions, depth);

        /*==========================================================*/
        String[] queueNames = new String[]{"UnsortedArrayQueue", "StackArrayQueue", "StackArrayListQueue", "Test1234"};
        Experiment[] reflectedExperimentQueues = new Experiment[queueNames.length];
        for (int i = 0; i < queueNames.length; i++) {
            try {
                Class<?> test = Class.forName("eventqueue." + queueNames[i]);
                reflectedExperimentQueues[i] = new Experiment((IEventQueue) test.getDeclaredConstructor().newInstance());
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException |
                     InvocationTargetException e) {
                System.out.println("Class not found: " + queueNames[i]);
            }
        }
        processExperimentList(reflectedExperimentQueues, repetitions, depth);
    }

    public static void processExperimentList(Experiment[] experimentQueues, int repetitions, int depth) {
        Long[][] resultTable = new Long[repetitions][experimentQueues.length];
        int counter = 0;
        for (Experiment experiment : experimentQueues) {
            if (experiment != null) {
                for (int j = 0; j < repetitions; j++) {
                    experiment.initialize(j * 1000);
                    resultTable[j][counter] = experiment.evaluate(depth);
                    System.out.print("[" + (counter + 1) + "|" + experimentQueues.length + "]\t");
                    System.out.print((j / (double) repetitions) * 100 + "%\r");
                }
                System.out.print("[" + (counter + 1) + "|" + experimentQueues.length + "]\t 100%\n");
                counter++;
            }
        }

        /* format resultTable as CSV */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultTable.length; i++) {
            for (int j = 0; j < resultTable[i].length; j++) {
                sb.append(resultTable[i][j]);
                sb.append(";");
            }
            sb.append("\n");
        }
        for (Experiment experiment : experimentQueues) {
            if (experiment != null) {
                System.out.print(experiment.getQueueName() + ";");
            }
        }
        System.out.println();
        System.out.println(sb);
    }

}
