import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Rover_Position {

    private Plateau plateau;

    @Before
    public void setUp(){

        plateau = new Plateau(5,5);
    }

    @Test
    public void only_moves_forward(){
        Rover firstRover = new Rover(1,2,"N", plateau, "M");
        assertThat(firstRover.executeCommand(), is("1 3 N"));
    }

    @Test
    public void turn_to_the_right_and_moves(){
        Rover secondRover = new Rover(1,2,"N", plateau, "RM");
        assertThat(secondRover.executeCommand(), is("2 2 E"));
    }

    @Test
    public void turn_to_the_left_and_moves(){
        Rover thirdRover = new Rover(1,2,"N", plateau, "LLM");
        assertThat(thirdRover.executeCommand(), is("1 1 S"));
    }




}
