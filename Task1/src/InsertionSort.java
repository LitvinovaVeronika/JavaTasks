/**
 * Created by Boss on 23.11.2015.
 */
public class InsertionSort {

    public static void main(String[] args) {
        double[] mas = new double[args.length];

        for (int i = 0; i < args.length; i++) {
            mas[i] = Double.parseDouble(args[i]);
        }

        for (int i = 1; i < mas.length; i++) {
            double tec = mas[i];

            for (int j = i - 1; j >= 0; j--) {
                if (mas[j] <= tec) {
                    mas[j + 1] = tec;
                    break;
                }
                mas[j + 1] = mas[j];
                if (j == 0) {
                    mas[j] = tec;
                }
            }
        }

        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
    }
}
