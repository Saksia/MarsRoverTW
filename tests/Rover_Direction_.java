
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Rover_Direction_ {

    private Rover rover;

    @Before
    public void setUp(){
        rover = new Rover(1,3, Orientation.NORTH);
    }


    //RIGHT
    @Test
    public void should_be_East_when_rotate_right(){
        assertThat(rover.changeDirection("R"), is("1 3 E"));
    }
    @Test
    public void should_be_South_when_rotate_right(){
        assertThat(rover.changeDirection("RR"), is("1 3 S"));
    }
    @Test
    public void should_be_West_when_rotate_right(){
        assertThat(rover.changeDirection("RRR"), is("1 3 W"));
    }
    @Test
    public void should_be_North_when_rotate_right(){
        assertThat(rover.changeDirection("RRRR"), is("1 3 N"));
    }


    //LEFT
    @Test
    public void should_be_West_when_rotate_left(){
        assertThat(rover.changeDirection("L"), is("1 3 W"));
    }
    @Test
    public void should_be_South_when_rotate_left(){
        assertThat(rover.changeDirection("LL"), is("1 3 S"));
    }
    @Test
    public void should_be_East_when_rotate_left(){
        assertThat(rover.changeDirection("LLL"), is("1 3 E"));
    }
    @Test
    public void should_be_North_when_rotate_left(){
        assertThat(rover.changeDirection("LLLL"), is("1 3 N"));
    }
}
