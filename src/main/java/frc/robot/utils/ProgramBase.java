package frc.robot.utils;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.CurvatureDrive;
import frc.robot.subsystems.Drivetrain;

/**
 * The backend of student written programs.<br>
 * This class adds commands to a {@link SequentialCommandGroup} according to the user's demand.
 */
public abstract class ProgramBase extends SequentialCommandGroup {

    private final Drivetrain drivetrain = Drivetrain.getInstance();

    protected void driveForwardInSeconds(double seconds) {
        addCommands(new CurvatureDrive(
                drivetrain, () -> Drivetrain.DRIVE_SPEED, () -> 0.0, () -> true, () -> false
        ).withTimeout(seconds));
    }

    protected void driveBackwardsInSeconds(double seconds) {
        addCommands(new CurvatureDrive(
                drivetrain, () -> -Drivetrain.DRIVE_SPEED, () -> 0.0, () -> true, () -> false
        ).withTimeout(seconds));
    }

    protected void turnLeftInSeconds(double seconds) {
        addCommands(new CurvatureDrive(
                drivetrain, () -> 0.0, () -> Drivetrain.TURN_SPEED, () -> true, () -> false
        ).withTimeout(seconds));
    }

    protected void turnRightInSeconds(double seconds) {
        addCommands(new CurvatureDrive(
                drivetrain, () -> 0.0, () -> -Drivetrain.TURN_SPEED, () -> true, () -> false
        ).withTimeout(seconds));
    }

    public abstract void writeProgram();
}
