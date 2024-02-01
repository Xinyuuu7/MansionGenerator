package Xinyuiii.MansionGenerator.piece;

public class SimpleGrid {
    public final int[][] grid;
    public final int width;
    public final int height;
    public final int valueIfOutside;

    public SimpleGrid(int width, int height, int valueIfOutside) {
        this.width = width;
        this.height = height;
        this.valueIfOutside = valueIfOutside;
        this.grid = new int[width][height];
    }

    public void set(int a, int b, int c) {
        if (a >= 0 && a < this.width && b >= 0 && b < this.height) {
            this.grid[a][b] = c;
        }
    }

    public void set(int a, int b, int c, int d, int e) {
        for(int i = b; i <= d; ++i) {
            for(int j = a; j <= c; ++j) {
                this.set(j, i, e);
            }
        }
    }

    public int get(int a, int b) {
        return a >= 0 && a < this.width && b >= 0 && b < this.height ? this.grid[a][b] : this.valueIfOutside;
    }

    public void setIf(int a, int b, int c, int d) {
        if (this.get(a, b) == c) {
            this.set(a, b, d);
        }
    }

    public boolean edgesTo(int a, int b, int c) {
        return this.get(a - 1, b) != c && this.get(a + 1, b) != c && this.get(a, b + 1) != c && this.get(a, b - 1) != c;
    }
}