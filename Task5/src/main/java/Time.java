import java.io.File;
import java.io.PrintWriter;
import java.util.Random;

public class Time {

    private static void createRandom(Matrix m) {
        Random random = new Random();
        for (int i = 0; i < m.getLine(); i++) {
            for (int j = 0; j < m.getColumns(); j++) {
                m.setElement(i, j, random.nextDouble());
            }
        }
    }

    public static void main(String[] args) {
        try {
            measureTime(10, 15, new File("src/res1.txt"));
            measureTime(100, 150, new File("src/res2.txt"));
            measureTime(400, 500, new File("src/res3.txt"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void measureTime(int rows, int columns, File file) throws Exception {
        int threads;

        Matrix m1 = new Matrix(rows, columns);
        createRandom(m1);
        Matrix m2 = new Matrix(columns, rows);
        createRandom(m2);

        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (threads = 1; threads <= 500; threads += 50) {
                MatrixMultiplication MatrixMultiplication = new MatrixMultiplication(m1, m2, threads);
                long allTime = 0;
                for (int j = 0; j < 5; j++) {
                    long beginTime = System.currentTimeMillis();
                    MatrixMultiplication.multiply();
                    long endTime = System.currentTimeMillis() - beginTime;
                    allTime += endTime;
                }
                printWriter.println(threads + "\t" + allTime / 5);
            }
            printWriter.close();
        }
    }
}
