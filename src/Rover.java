public class Rover {

    private int x;
    private int y;
    Orientation orientation;
    String coordinates;
    
    private int plateauX = 5;
    private int plateauY = 5;
    
    
    public Rover(int x, int y, Orientation orientation){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        coordinates = x + " " + y;
    }

     String changeDirection(String command){
        for (char c: command.toCharArray()) {
            if(c == 'L') orientation = orientation.left();
            if(c == 'R') orientation = orientation.right();
        }
        return coordinates + " " + orientation.value();
    }


}
