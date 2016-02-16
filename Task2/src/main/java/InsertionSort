import java.util.Arrays;
import java.util.Comparator;

public class InsertionSort<T> implements Sort<T> {
    public T[] sort(T[] mas, Comparator<T> comparator) {
        T[] result = Arrays.copyOf(mas, mas.length);
        for (int j = 1; j < result.length; j++) {
            T tec = result[j];
            int i = j - 1;
            while (i >= 0 && (comparator.compare(result[i], tec) >= 0))
                result[i + 1] = result[i--];
            result[i + 1] = tec;
        }
        return result;
    }
}
