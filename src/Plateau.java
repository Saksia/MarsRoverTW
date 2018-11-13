import java.util.ArrayList;

public class Plateau {

    private int x;
    private int y;
    ArrayList<String> notPassOrientation;


    public Plateau(int x, int y){
        this.x = x;
        this.y = y;
        this.notPassOrientation = new ArrayList();
    }

    public int getUpperRightX() { return this.x; }

    public int getUpperRightY(){
        return this.y;
    }



}
