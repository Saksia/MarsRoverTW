import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Rover_Position_Of_ {

    private Rover rover;
    private Plateau plateau;


    @Before
    public void setUp(){

        plateau = new Plateau(5,5);
        rover = new Rover(1,2,"N", plateau);
    }

    @Test
    public void y_should_be_higher() throws Exception{
        assertThat(rover.executeCommand("M"), is("1 3 N"));
    }
    @Test
    public void x_should_be_higher() throws Exception{
        assertThat(rover.executeCommand("RM"), is("2 2 E"));
    }

    @Test
    public void y_should_be_lower() throws Exception{
        assertThat(rover.executeCommand("LLM"), is("1 1 S"));
    }
    @Test
    public void x_should_be_lower() throws Exception{
        assertThat(rover.executeCommand("LM"), is("0 2 W"));
    }

    //A few more tests for acceptance.
    @Test
    public void acceptance(){

    }

}
