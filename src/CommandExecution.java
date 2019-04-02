import java.util.ArrayList;
import java.util.Arrays;

public class CommandExecution {

    private String commands;

    private static final int MIN_INPUT_LINES = 3;
    private static final int PLATEAU_PARAMS = 2;
    private static final int ROVER_COMMAND_LINES = 3;

    private ArrayList<String> commandLines;

    private Plateau plateau;
    private Rover rover;

    private String output="";


    public CommandExecution(String commands){
        this.commands = commands;
    }


    public String process() {

        commandLines = new ArrayList<>(Arrays.asList( commands.split(System.getProperty("line.separator"))));

        //Check if there're at least 3 commands lines.
        checkInputLines(commandLines.size());

        //Creating plateau
        createPlateau(commandLines.get(0));

        //Creating rovers
        while(!commandLines.isEmpty()) {
            createRover(commandLines.get(0));
        }

        return output.trim();
    }



    private void executeCommand(Rover rover) {

        checkCommandLine();
        output = output+rover.executeCommand()+"\n";
        removeLine();
    }

    private void createRover(String roverLine) {

        String [] roverStartPositionParams = roverLine.split(" ");
        checkRoverPositionLine(roverStartPositionParams.length);


        int x = Integer.parseInt(roverStartPositionParams[0]);
        int y = Integer.parseInt(roverStartPositionParams[1]);
        String orientation = roverStartPositionParams[2];


        removeLine();
        String command ="";
        if(!commandLines.isEmpty()){
            command = commandLines.get(0);
        }

        rover = new Rover(x,y,orientation,plateau, command);


        executeCommand(rover);


    }


    private void createPlateau(String line) {

        String[] plateauParams = line.split(" ");
        checkPlateauLine(plateauParams);

        int x = Integer.parseInt(plateauParams[0]);
        int y = Integer.parseInt(plateauParams[1]);

        plateau = new Plateau(x,y);

        removeLine();

    }


    // ------------- CHECKING METHODS ----------------

    private void checkPlateauLine(String[] plateauParams) {
        if(plateauParams.length != PLATEAU_PARAMS){
            throw new IllegalArgumentException("Plateau parameters should be 2");
        }

    }


    private void checkInputLines(int inputLinesSize){
        if(inputLinesSize < MIN_INPUT_LINES){
            throw new IllegalArgumentException("Input lines should be, at least, 3 lines");
        }
    }


    private void checkCommandLine() {
        if(commandLines.isEmpty()){
            throw new IllegalArgumentException("It should contains a command line to execute the program.");
        }
    }


    private void checkRoverPositionLine(int numberOfParams) {
        if(numberOfParams != ROVER_COMMAND_LINES){
            throw new IllegalArgumentException("Rover initial position parameters should be 3: 2 INTEGERS and 1 CHARACTER");
        }
    }


    //Removing the processed and executed line.
    private void removeLine(){
        commandLines.remove(0);
    }


}
