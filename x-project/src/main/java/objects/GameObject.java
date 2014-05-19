package objects;

/**
 * Created by SMelnik on 5/15/2014.
 */
public interface GameObject {
    public void setCoordinates(int x, int y);

    public int getCoordinateX();

    public int getCoordinateY();

    public void setCoordinateX(int x);

    public void setCoordinateY(int y);
}