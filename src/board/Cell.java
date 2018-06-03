package board;


import java.awt.*;

public class Cell {

    public static final Color EMPTY = Color.BLACK ;
    public static final Color ELECTRON_HEAD = Color.BLUE ;
    public static final Color ELECTRON_TAIL = Color.RED ;
    public static final Color CONDUCTOR = Color.YELLOW ;

    private Color state ;
    private int neighbour ;

    public Cell() {
        this.state = EMPTY;
        this.neighbour = 0;
    }


    public int getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(int neighbour) {
        this.neighbour = neighbour;
    }

    Color getState() {
        return state;
    }

    public void setState(Color state) {
        this.state = state;
    }


}
