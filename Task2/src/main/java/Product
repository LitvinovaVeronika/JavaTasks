public class Product {

    private int price;
    private String name;

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Product() {
        this.price = 0;
        this.name = "";
    }

    @Override
    public boolean equals(Object o) {
        return ((o instanceof Product) && (((Product) o).getPrice() == price) && (((Product) o).getName() == name));
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
