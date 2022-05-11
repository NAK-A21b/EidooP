import eventqueue.*;

public class Main {

    public static void main(String[] args){
        int repetitions = 25;
        int depth = 500;

        Experiment[] queues = new Experiment[]{
                new Experiment(new ArrayListEventQueue<>()),
                new Experiment(new SortedArrayQueue<>()),
                new Experiment(new UnsortedArrayQueue<>()),
                new Experiment(new StackArrayQueue<>()),
                new Experiment(new StackArrayListQueue()),
        };
        Long[][] resultTable = new Long[repetitions][queues.length];
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
        System.out.println("ArrayListEventQueue;SortedArrayQueue;UnsortedArrayQueue;StackArrayQueue;StackArrayListQueue;");
        System.out.println(sb.toString());


    }

}
