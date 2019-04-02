
————————————————————How to execute and test the project————————————————————

*TERMINAL (tested on macOS):
1. Go to the project’s src folder.
2. Compile .java files using javac:
	javac Main.java Plateau.java Rover.java Orientation.java CommandExecution.java
3. The project can be executed using ‘java’ command:
	java Main filepath

*IDE (IntelliJ):

1. Open the project on IntelliJ.
3. Program argument (filename), and working directory should be specified. 
To do that, go to Run > Edit Configurations... Write the file name in 'Program arguments' and select the path where the files are in 'Working directory'.
2. Run > Run... > Select the Main class, or just ctrl+alt+R and select class Main.

Test the project:
1. Open the project on IntelliJ.
2. Run > Run all in MarsRoverJavaSSC or just ctrl+R



——————————————————————————————Project brief————————————————————————————————

5 classes, 1 enum and 3 test classes were used to solve the Mars Rover Problem:

-ReadFile:
Class. Reads and processes the input file with the information.
Method:
	-getFileContent(String): returns a string which contains the text of the input file. 

- Main:
Class. Contains the main method. 
Argument needed: File name where the rover and plateau information are.
Method: 
	-executeCommand(String): calls class CommandExecution to obtain the output solution and prints it on console.
- CommandExecution:
Class. Creates the plateau and the rovers with the information given in the input file.
Methods:
	-process(): returns the final position of the rovers.
	-executeCommand(Rover): processes all the lines of the string that contains the file content
	-createRover(String): creates the rover
	-createPlateau(String): creates a plateau

	There are some checking methods that check if the given information's correct.

- Plateau:
Class. Defines the plateau dimensions and its getters.

- Rover:
Class. Defines the rover first coordinates and the related plateau. This class also defines the moving (move() method) and rotating (setOrientation() method) actions.
It also check if the movement perfomance is inside the plateau dimensiones.

-Orientation:
Enum. Contains cardinal points and, for each one, the cardinal point that is to its right and to its left. Helps 'Rover' class to performance the movements and rotativos.

TESTS:
Tests perform:
	*Normal behaviour
	*Exceptions expected

-Commands: Tests normal behaviour and exceptions of CommandExecution class.

-Rover_Orientation and Rover_Position test normal behaviour and exeptions of Rover class.