package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

import java.util.function.Supplier;

public class CurvatureDrive extends Command {

    private final Drivetrain drivetrain;
    private final Supplier<Double> driveSpeed;
    private final Supplier<Double> rotationSpeed;
    private final Supplier<Boolean> allowTurnInPlace;
    private final Supplier<Boolean> squareInputs;

    public CurvatureDrive(Drivetrain drivetrain, Supplier<Double> driveSpeed, Supplier<Double> rotationSpeed,
                          Supplier<Boolean> allowTurnInPlace, Supplier<Boolean> squareInputs) {
        addRequirements(drivetrain);
        this.drivetrain = drivetrain;
        this.driveSpeed = driveSpeed;
        this.rotationSpeed = rotationSpeed;
        this.allowTurnInPlace = allowTurnInPlace;
        this.squareInputs = squareInputs;
    }

    @Override
    public void execute() {
        double drive = driveSpeed.get();
        double rotation = rotationSpeed.get();

        if (squareInputs.get()) {
            drive = MathUtil.copyDirectionPow(drive, 2);
            rotation = MathUtil.copyDirectionPow(rotation, 2);
        }

        var speeds = DifferentialDrive.curvatureDriveIK(drive, rotation, allowTurnInPlace.get());
        drivetrain.drive(speeds.left, speeds.right);
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        drivetrain.stop();
    }
}
