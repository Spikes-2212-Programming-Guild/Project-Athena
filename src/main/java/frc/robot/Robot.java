// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.spikes2212.dashboard.RootNamespace;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.utils.ProgramBase;
import groups.Group1;
import groups.Group2;
import groups.Group3;
import groups.Group4;

import java.util.function.Supplier;

public class Robot extends TimedRobot {

    private SendableChooser<Supplier<Command>> autoChooser;
    private final RootNamespace namespace = new RootNamespace("athena");

    @Override
    public void robotInit() {

        autoChooser = new SendableChooser<>();
        autoChooser.addOption("Group 1", () -> compile(new Group1()));
        autoChooser.addOption("Group 2", () -> compile(new Group2()));
        autoChooser.addOption("Group 3", () -> compile(new Group3()));
        autoChooser.addOption("Group 4", () -> compile(new Group4()));

        namespace.putData("chooser", autoChooser);
    }

    private ProgramBase compile(ProgramBase programBase) {
        programBase.writeProgram();
        return programBase;
    }

    @Override
    public void robotPeriodic() {
        namespace.update();
        CommandScheduler.getInstance().run();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void autonomousInit() {
        Command auto = autoChooser.getSelected().get();
        if (auto != null) {
            CommandScheduler.getInstance().schedule(auto);
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.

    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
    }

    @Override
    public void testInit() {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}
