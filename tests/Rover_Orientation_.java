
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Rover_Orientation_ {

    private Plateau plateau;
    private Rover rover;

    @Before
    public void setUp(){

        plateau = new Plateau(5,5);
        rover = new Rover(1,3, "N", plateau);

    }


    //RIGHT
    @Test
    public void should_be_East_when_rotate_right(){
        assertThat(rover.executeCommand("R"), is("1 3 E"));
    }
    @Test
    public void should_be_South_when_rotate_right(){
        assertThat(rover.executeCommand("RR"), is("1 3 S"));
    }
    @Test
    public void should_be_West_when_rotate_right(){
        assertThat(rover.executeCommand("RRR"), is("1 3 W"));
    }
    @Test
    public void should_be_North_when_rotate_right(){
        assertThat(rover.executeCommand("RRRR"), is("1 3 N"));
    }


    //LEFT
    @Test
    public void should_be_West_when_rotate_left(){
        assertThat(rover.executeCommand("L"), is("1 3 W"));
    }
    @Test
    public void should_be_South_when_rotate_left(){
        assertThat(rover.executeCommand("LL"), is("1 3 S"));
    }
    @Test
    public void should_be_East_when_rotate_left(){
        assertThat(rover.executeCommand("LLL"), is("1 3 E"));
    }
    @Test
    public void should_be_North_when_rotate_left(){
        assertThat(rover.executeCommand("LLLL"), is("1 3 N"));
    }


    @Test (expected = AssertionError.class)
    public void should_return_exception_message(){
        rover.executeCommand("LLRRLH");
    }


}
