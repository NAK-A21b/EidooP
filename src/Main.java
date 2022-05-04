import eventqueue.ArrayListEventQueue;
import eventqueue.SortedArrayQueue;
import eventqueue.UnsortedArrayQueue;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args){
        int repetitions = 10;
        int depth = 1000;
        Long[][] resultTable = new Long[repetitions][3];

        Experiment[] queues = new Experiment[]{
                new Experiment(new ArrayListEventQueue<>()),
                new Experiment(new UnsortedArrayQueue<>()),
                new Experiment(new SortedArrayQueue<>())
        };
        int counter = 0;
        for (Experiment experiment: queues) {
            for (int j = 0; j < repetitions; j++) {
                experiment.initialize(j * 1000);
                resultTable[j][counter] = experiment.evaluate(depth);
                System.out.print("[" + (counter + 1) + "|" + queues.length + "]\t");
                System.out.print((j / (double) repetitions) * 100 + "%\r");
            }
            System.out.print("[" + (counter + 1) + "|" + queues.length + "]\t 100%\n");
            counter++;
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
        System.out.println("ArrayListEventQueue;UnsortedArrayQueue;SortedArrayQueue;");
        System.out.println(sb.toString());


    }

}
