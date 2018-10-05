import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Commands_ {

    private CommandExecution commandExecution;
    private String oneRoverCommands;
    private String twoRoversCommands;
    private String threeRoversCommands;

    @Before
    public void setUp(){

        oneRoverCommands = "5 5\n1 2 N\nLMLMLMLMM";
        twoRoversCommands = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";
        threeRoversCommands = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM\n1 2 N\nLMLMLMLMM";
    }

    @Test
    public void with_one_rover_should_be_correct(){
        commandExecution = new CommandExecution(oneRoverCommands);
        assertThat(commandExecution.process(), is("1 3 N"));
    }

    @Test
    public void with_two_rover_should_be_correct(){
        commandExecution = new CommandExecution(twoRoversCommands);
        assertThat(commandExecution.process(), is("1 3 N\n5 1 E"));
    }

    @Test
    public void with_three_rover_should_be_correct(){
        commandExecution = new CommandExecution(threeRoversCommands);
        assertThat(commandExecution.process(), is("1 3 N\n5 1 E\n1 3 N"));
    }


    @Test (expected = AssertionError.class)
    public void should_throw_exception(){
        commandExecution = new CommandExecution("5 5\n1 2 N");
        commandExecution.process();
    }

}
