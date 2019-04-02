public class Rover {

    private int x;
    private int y;
    private Plateau plateau;
    private String orientation;
    private Orientation orientation_;
    String command;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Rover(int x, int y, String orientation, Plateau plateau, String command){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.plateau = plateau;
        this.command = command;

        checksIfPositionIsLegalAndMoves(x,y);
        setOrientation();
    }

    private void setOrientation() {
        orientation_ = Orientation.rotateToThe(this.orientation);
    }

    public String executeCommand(){

        for (char c : command.toCharArray()) {
            if(c == 'L') orientation_ = orientation_.left();
            else if(c == 'R') orientation_ = orientation_.right();
            else if(c == 'M') { move(); }

            else throw new AssertionError("ERROR. Unexpected command. Commands should be 'L', 'R' or 'M'");
        }

        return setCoordinates();
    }


    private String setCoordinates() {
        return (this.x + " " + this.y + " " + orientation_.value()).trim();
    }


    private void move() {

        int x = getX();
        int y = getY();


        switch (orientation_){
            case NORTH:
                checksIfPositionIsLegalAndMoves(x, y+1);
                break;
            case SOUTH:
                checksIfPositionIsLegalAndMoves(x, y-1);
                break;
            case EAST:
                checksIfPositionIsLegalAndMoves(x+1, y);
                break;
            case WEST:
                checksIfPositionIsLegalAndMoves(x-1, y);
                break;
            default:
                throw new AssertionError("ERROR. Rover's orientation should be 'N', 'S', 'E' or 'W'");
        }


    }


    private void checksIfPositionIsLegalAndMoves(int newPositionX, int newPositionY){
        if(newPositionX > plateau.getUpperRightX() || newPositionX < 0
                ||  newPositionY > plateau.getUpperRightY() || newPositionY < 0 ) {
            throw new AssertionError("ERROR. Rover can't get out of the plateau");
        }else{
            setX(newPositionX);
            setY(newPositionY);
        }
    }


}
