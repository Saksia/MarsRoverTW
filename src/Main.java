import java.util.Scanner;

public class Main {

    public static void main(String args[]){

        String command = getCommandString();
        executeCommand(command);

    }

    private static String getCommandString() {
        String command=" ";
        Scanner scanner = new Scanner(System.in);

        while(!command.contains("done")){
            command = command+"\n"+scanner.nextLine();
        }
        return command;
    }

    private static void executeCommand(String command) {
        CommandExecution commandExecution = new CommandExecution(command.replace("done","").toUpperCase().trim());
        System.out.println(commandExecution.process());
    }


}
