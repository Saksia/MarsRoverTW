
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Rover_Orientation {

    private Plateau plateau;
    private Rover rover;

    @Before
    public void setUp(){
        plateau = new Plateau(5,5);
       // rover = new Rover(1,3, "N", plateau, );

    }


    //RIGHT
    @Test
    public void should_be_East_when_rotate_right(){
        Rover rover = new Rover(1,3,"N",plateau,"R");
        assertThat(rover.executeCommand(), is("1 3 E"));
    }
    @Test
    public void should_be_South_when_rotate_right(){
        Rover rover = new Rover(1,3,"N",plateau,"RR");
        assertThat(rover.executeCommand(), is("1 3 S"));
    }
    @Test
    public void should_be_West_when_rotate_right(){
        Rover rover = new Rover(1,3,"N",plateau,"RRR");
        assertThat(rover.executeCommand(), is("1 3 W"));
    }
    @Test
    public void should_be_North_when_rotate_right(){
        Rover rover = new Rover(1,3,"N",plateau,"RRRR");
        assertThat(rover.executeCommand(), is("1 3 N"));
    }


    //LEFT
    @Test
    public void should_be_West_when_rotate_left(){
        Rover rover = new Rover(1,3,"N",plateau,"L");
        assertThat(rover.executeCommand(), is("1 3 W"));
    }
    @Test
    public void should_be_South_when_rotate_left(){
        Rover rover = new Rover(1,3,"N",plateau,"LL");
        assertThat(rover.executeCommand(), is("1 3 S"));
    }
    @Test
    public void should_be_East_when_rotate_left(){
        Rover rover = new Rover(1,3,"N",plateau,"LLL");
        assertThat(rover.executeCommand(), is("1 3 E"));
    }
    @Test
    public void should_be_North_when_rotate_left(){
        Rover rover = new Rover(1,3,"N",plateau,"LLLL");
        assertThat(rover.executeCommand(), is("1 3 N"));
    }


    @Test (expected = AssertionError.class)
    public void should_return_exception_message(){
        Rover rover = new Rover(1,3,"N",plateau,"h");
        rover.executeCommand();
    }


}
