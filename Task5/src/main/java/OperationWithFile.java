import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class OperationWithFile {
    public static void printInFile(File outFile, Matrix res) throws Exception {
        try (PrintWriter printWriter = new PrintWriter(outFile)) {
            for (int i = 0; i < res.getColumns(); i++) {
                for (int j = 0; j < res.getLine(); j++)
                    printWriter.print(res.getElement(i, j) + " ");
                printWriter.println();
            }
            printWriter.close();
        }
    }

    public static Matrix readMatrix(File file) throws Exception {
        int countColumns = 0;
        int countLines = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                if (countColumns == 0)
                    countColumns = line.length;
                if (countColumns != line.length) {
                    scanner.close();
                    throw new Exception("Неверные входные данные!");
                }
                countLines++;
            }
            scanner.close();
        }

        Matrix m = new Matrix(countLines, countColumns);
        try (Scanner scanner1 = new Scanner(file)) {
            for (int i = 0; i < countLines; i++) {
                for (int j = 0; j < countColumns; j++) {
                    m.setElement(i, j, scanner1.nextDouble());
                }
            }
            scanner1.close();
            return m;
        }
    }
}
