import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {

        if (args == null)
            throw new IllegalArgumentException("There is no argument given");
        else if (args.length != 1)
            throw new IllegalArgumentException("Argument should be a file name");


        ReadFile readFile = new ReadFile (args[0]);
        String command = readFile.getFileContent();
        System.out.println("INPUT: \n" + command.trim());
        executeCommand(command);

    }


    private static void executeCommand(String command) {
        CommandExecution commandExecution = new CommandExecution(command.replace("done","").toUpperCase().trim());
        System.out.println("\nOUTPUT: \n" + commandExecution.process());
    }


}
