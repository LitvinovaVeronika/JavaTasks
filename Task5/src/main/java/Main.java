import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            int countThread = 1;
            if (args.length != 4) {
                if (args.length != 3)
                    countThread = 1;
                else
                    throw new Exception("Неверные входные данные!");
            } else
                countThread = Integer.valueOf(args[3]);
            File file1 = new File(args[0]);
            File file2 = new File(args[1]);
            File outFile = new File(args[2]);
            Matrix m1 = OperationWithFile.readMatrix(file1);
            Matrix m2 = OperationWithFile.readMatrix(file2);

            OperationWithFile.printInFile(outFile, new MatrixMultiplication(m1, m2, countThread).multiply());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
