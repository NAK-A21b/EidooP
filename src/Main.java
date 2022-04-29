public class Main {
    public static void main(String[] args) {
        int[] initialSizes = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000, 13000, 14000, 15000};
        int repetitions = 2000;
        long[] times = new long[initialSizes.length];
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < initialSizes.length; i++) {
                Experiment experiment = new Experiment();
                times[i] = experiment.main(repetitions, initialSizes[i]);
            }
        }
        for (int i = 0; i < initialSizes.length; i++) {
            System.out.println(initialSizes[i] + "; " + times[i] + ";");
        }
    }
}