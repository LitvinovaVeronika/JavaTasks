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
            measureTime(20, 20, new File("src/20x20_Matrix.txt"));
            measureTime(200, 200, new File("src/200x200_Matrix.txt"));
            measureTime(600, 600, new File("src/600x600_Matrix.txt"));
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
            for (threads = 1; threads <= 50; threads +=2 ) {
                MatrixMultiplication matrixMultiplication = new MatrixMultiplication(m1, m2, threads);
                long allTime = 0;
                for (int j = 0; j < 10; j++) {
                    long beginTime = System.nanoTime();
                    matrixMultiplication.multiply();
                    long endTime = System.nanoTime() - beginTime;
                    allTime += endTime;
                }
                printWriter.println(threads + "     " + allTime / 10);
            }
            printWriter.close();
        }
    }
}

