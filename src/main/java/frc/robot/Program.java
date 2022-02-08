package frc.robot;

import frc.robot.utils.ProgramBase;

/**
 * <H2>Here you should write your program</H2>you can use the methods: <br>
 * <p>
 * {@link  #moveForwardInSeconds(double)} <br>
 * {@link  #moveBackwardInSeconds(double)} <br>
 * {@link  #turnLeftInAngle(double)} <br>
 * {@link  #turnRightInAngle(double)} <br>
 * {@link  #turnLeftInSeconds(double)} <br>
 * {@link  #turnRightInSeconds(double)} <br>
 * </p>
 * <p>
 * In the basic program below, the robot will <b>drive forward</b> for 2 seconds, and then <b>turn left</b> by 90 degrees<br>
 * <p>
 * To create your own program, just delete those 2 lines, and start coding.
 * Have fun!
 */
public class Program extends ProgramBase {

    public void writeProgram() {
        moveForwardInSeconds(2); //todo remove this line and start coding
        turnLeftInAngle(45); //todo remove this line and start coding
    }
}
