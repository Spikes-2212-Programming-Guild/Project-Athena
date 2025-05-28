package groups;

import frc.robot.utils.ProgramBase;

/**
 * <H2>Here you should write your program</H2>you can use the methods: <br>
 * <p>{@link  #moveForwardInSeconds(double)} <br>
 * {@link  #moveBackwardInSeconds(double)} <br>
 * {@link  #turnLeftInDegrees(double)} <br>
 * {@link  #turnRightInDegrees(double)} <br></p>
 * <p>
 * In the basic program below, the robot will <b>drive forward</b> for 2 seconds, and then <b>turn left</b> by 90 degrees<br>
 * <p>
 * To create your own program, just delete those 2 lines, and start coding.
 * Have fun!
 */
public class Group1 extends ProgramBase {

    @Override
    public void writeProgram() {


            moveForwardInSeconds(3);
            turnRightInSeconds(0.8); //todo remove this line and start coding
            moveForwardInSeconds(4); //todo remove this line and start coding
            turnLeftInSeconds(1.5);
        }
    for(int i =1;i<=200;){
        moveForwardInSeconds(3);
        turnRightInSeconds(0.8); //todo remove this line and start coding
        moveForwardInSeconds(4); //todo remove this line and start coding
        turnLeftInSeconds(1.5);

    }
}
