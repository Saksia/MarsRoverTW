import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Rover_Position_Of_ {

    private Rover rover;
    private Plateau plateau;
    private Rover deadRover;

    @Before
    public void setUp(){

        plateau = new Plateau(5,5);
        rover = new Rover(1,2,"N", plateau);
        deadRover = new Rover(3,3,"E",plateau);
    }

    @Test
    public void y_should_be_higher(){
        assertThat(rover.executeCommand("M"), is("1 3 N"));
    }

    @Test
    public void x_should_be_higher(){
        assertThat(rover.executeCommand("RM"), is("2 2 E"));
    }

    @Test
    public void y_should_be_lower(){
        assertThat(rover.executeCommand("LLM"), is("1 1 S"));
    }

    @Test
    public void x_should_be_lower() {
        assertThat(rover.executeCommand("LM"), is("0 2 W"));
    }


    @Test
    public void should_print_rover_last_position_alive_and_rip_when_it_dies(){
        assertThat(deadRover.executeCommand("MMRMMLMRRM"), is("5 1 E RIP"));
    }

    @Test
    public void should_avoid_obstacle_and_print_last_position(){
        deadRover.executeCommand("MMRMMLMRRM");
        Rover newRoverAfterDeadRover = new Rover(3,3,"E",plateau);
        assertThat(newRoverAfterDeadRover.executeCommand("MMRMMLMRRM"), is("4 1 W"));
    }



}
