public class Rover {

    private int x;
    private int y;
    private Plateau plateau;
    private String orientation;
    private Orientation orientation_;


    public Rover(int x, int y, String orientation, Plateau plateau){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.plateau = plateau;

        setOrientation();
    }

    private void setOrientation() {
        switch (this.orientation){
            case "N":
                orientation_ = Orientation.NORTH;
                break;
            case "S":
                orientation_ = Orientation.SOUTH;
                break;
            case "E":
                orientation_ = Orientation.EAST;
                break;
            case "W":
                orientation_ = Orientation.WEST;
                break;
            default:
                throw new AssertionError("");
        }
    }

    public String executeCommand(String command){

        for (char c : command.toCharArray()) {
            if(c == 'L') orientation_ = orientation_.left();
            else if(c == 'R') orientation_ = orientation_.right();
            else if(c == 'M') move();
            else throw new AssertionError("ERROR. Unexpected command. Commands should be 'L', 'R' or 'M'");
        }

        return setCoordinates();
    }

    private String setCoordinates() {
        return this.x + " " + this.y + " " + orientation_.value();
    }


    private void move() {

        switch (orientation_.value()){
            case "N":
                checkIfNewPositionIsLegal(this.x, this.y++);
                this.y++;
                break;
            case "S":
                checkIfNewPositionIsLegal(this.x, this.y--);
                this.y--;
                break;
            case "E":
                checkIfNewPositionIsLegal(this.x++, this.y);
                this.x++;
                break;
            case "W":
                checkIfNewPositionIsLegal(this.x--, this.y);
                this.x--;
                break;
            default:
                throw new AssertionError("ERROR. Rover's orientation should be 'N', 'S', 'E' or 'W'");
        }
    }

    private void checkIfNewPositionIsLegal(int newPositionX, int newPositionY){
        if((newPositionX > plateau.getUpperRightX()
                || newPositionY > plateau.getUpperRightY())
                || (newPositionX < 0 || newPositionY < 0 )){
            throw new AssertionError("ERROR. The rover cannot be outside the plateau");
        }
    }


}
