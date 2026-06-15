// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.spikes2212.dashboard.RootNamespace;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import groups.*;

public class Robot extends TimedRobot {

    private AutoChooser chooser;
    private final RootNamespace namespace = new RootNamespace("athena");

    @Override
    public void robotInit() {
        Group1 g1 = new Group1();
        Group2 g2 = new Group2();
        Group3 g3 = new Group3();
        Group4 g4 = new Group4();
        Group5 g5 = new Group5();
        Group6 g6 = new Group6();

        chooser = new AutoChooser(
                g1, "Group 1",
                g2, "Group 2",
                g3, "Group 3",
                g4, "Group 4",
                g5, "Group 5",
                g6, "Group 6"
        );
        namespace.putData("athena chooser", chooser);
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
        chooser.schedule();
//        ProgramBase program = new Group1();
//        program.writeProgram();
//        CommandScheduler.getInstance().schedule(program);
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
