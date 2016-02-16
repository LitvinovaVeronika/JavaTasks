import java.util.Comparator;

public interface Sort<T> {
    T[] sort(T[] array, Comparator<T> comparator);
}
