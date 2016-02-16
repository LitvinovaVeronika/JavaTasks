public class Matrix {
    private double[][] data;

    public Matrix(int countLine, int countColumn) {
        this.data = new double[countLine][countColumn];
    }

    public Matrix(double[][] data) {
        this.data = data;
    }

    public int getLine() {
        if (data != null)
            return data.length;
        return 0;
    }

    public int getColumns() {
        if (data != null)
            return data[0].length;
        return 0;
    }

    public Double getElement(int i, int j) {
        return data[i][j];
    }

    public void setElement(int i, int j, double value) {
        data[i][j] = value;
    }
}
