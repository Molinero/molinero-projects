package objects;

/**
 * Created by SMelnik on 5/15/2014.
 */
public class Snake implements SnakeGameObject {
    private int x;
    private int y;
    private static int size = 2;

    public int getSize() {
        return size;
    }

    public void increaseSize(){
        size++;
    }

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
