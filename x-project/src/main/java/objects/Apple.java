package objects;

/**
 * Created by SMelnik on 5/15/2014.
 */
public class Apple implements SnakeGameObject {
    private int x;
    private int y;
    private static int width = 1;
    private static int height = 1;

    @Override
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getCoordinateX() {
        return x;
    }

    @Override
    public int getCoordinateY() {
        return y;
    }

    @Override
    public void setCoordinateX(int x) {
        this.x = x;
    }

    @Override
    public void setCoordinateY(int y) {
        this.y = y;
    }
}
