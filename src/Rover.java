public class Rover {

    private int x;
    private int y;
    private Plateau plateau;
    Orientation orientation;

    
    
    public Rover(int x, int y, Orientation orientation, Plateau plateau){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.plateau = plateau;
    }

     public String executeCommand(String command){

        for (char c : command.toCharArray()) {
            if(c == 'L') orientation = orientation.left();
            else if(c == 'R') orientation = orientation.right();
            else if(c == 'M') move();
            else throw new AssertionError("ERROR. Commands should be 'L', 'R' or 'M'");
        }

        return setCoordinates();
    }

    private String setCoordinates() {
        return this.x + " " + this.y + " " + orientation.value();
    }

    private void move() {

        switch (orientation.value()){
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
                throw new AssertionError("ERROR. Orientation of the rover should be 'N', 'S', 'E' or 'W'");
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
