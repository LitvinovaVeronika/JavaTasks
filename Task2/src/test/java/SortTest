import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;

@RunWith(Parameterized.class)
public class SortTest<T> {
    private static final Comparator<Product> PRODUCT_COMPARATOR_PRICE = new Comparator<Product>() {
        public int compare(final Product p1, final Product p2) {
            return Integer.compare(p1.getPrice(), p2.getPrice());
        }
    };
    private static final Comparator<Product> PRODUCT_COMPARATOR_NAME = new Comparator<Product>() {
        public int compare(final Product obj1,final Product obj2) {
            String str1 = obj1.getName();
            String str2 = obj2.getName();

            return str1.compareTo(str2);
        }
    };

    private static final Comparator<Double> DOUBLE_COMPARATOR1 = new Comparator<Double>() {
        public int compare(final Double d1, final Double d2) {
            return d1.compareTo(d2);
        }
    };

    private static final Comparator<Double> DOUBLE_COMPARATOR2 = new Comparator<Double>() {
        public int compare(final Double o1, final Double o2) {
            return o2.compareTo(o1);
        }
    };
    private static final Object[][] TEST_DATA = {
            {new InsertionSort<Product>(), PRODUCT_COMPARATOR_NAME, new Product[]{new Product(1, "Chocolate"), new Product(0, "Milk"), new Product()}},
            {new InsertionSort<Product>(), PRODUCT_COMPARATOR_NAME, randomProductsArray()},
            {new InsertionSort<Product>(), PRODUCT_COMPARATOR_PRICE, new Product[]{}},
            {new InsertionSort<Product>(), PRODUCT_COMPARATOR_PRICE, new Product[]{new Product(1, "Pizza"), new Product(3, "Orange"), new Product(5, "Sweet")}},

            {new InsertionSort<Double>(), DOUBLE_COMPARATOR1, new Double[]{1.234, 3.234, 1.353, 4.2421, 2.123, 5.12}},
            {new InsertionSort<Double>(), DOUBLE_COMPARATOR1, randomDoubleArray()},
            {new InsertionSort<Double>(), DOUBLE_COMPARATOR2, randomDoubleArray()},
            {new InsertionSort<Double>(), DOUBLE_COMPARATOR2, new Double[]{}},
            {new InsertionSort<Double>(), DOUBLE_COMPARATOR2, new Double[]{3.21, 2.12, 2.01, 1.434, 0.12424}}
    };
    private InsertionSort<T> sort;
    private T[] input;
    private Comparator<T> comparator;

    public SortTest(InsertionSort<T> sort, Comparator<T> comparator, T[] input) {
        this.sort = sort;
        this.input = input;
        this.comparator = comparator;
    }

    private static Product[] randomProductsArray() {
        String[] names = {"Cocoa", "Bread", "Butter", "Egg", "Apple", "Groats", "Cookies", "Yogurt", "Meat", "Fish"};
        Random rand = new Random();
        Product[] products = new Product[Math.abs(rand.nextInt()) % 20];
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product(Math.abs(rand.nextInt()), names[Math.abs(rand.nextInt()) % 9]);
        }
        return products;
    }

    private static Double[] randomDoubleArray() {
        Random rand = new Random();
        Double[] num = new Double[Math.abs(rand.nextInt()) % 20];
        for (int i = 0; i < num.length; i++) {
            num[i] = rand.nextDouble();
        }
        return num;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(TEST_DATA);
    }

    private static <T> boolean testOrder(T[] array, Comparator<T> c) {
        for (int i = 0; i < array.length - 1; i++) {
            if (c.compare(array[i], array[i + 1]) > 0)
                return false;
        }
        return true;
    }

    private static <T> boolean hasEachElementOf(T[] input, T[] result) {
        for (T element : input) {
            int c = 0;
            for (int j = 0; j < result.length; j++) {
                if (element.equals(result[j]))
                    c++;
                if (element.equals(input[j]))
                    c--;
            }
            if (c != 0)
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        T[] result = sort.sort(input, comparator);

        Assert.assertTrue("Массив не отсортирован", testOrder(result, comparator));
        Assert.assertEquals("Длина массивов не совпадает", input.length, result.length);
        Assert.assertTrue("Элементы массивов не совпадают", hasEachElementOf(input, result));
    }
}
