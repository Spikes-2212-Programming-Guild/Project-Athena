package frc.robot.subsystems;


import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.spikes2212.command.DashboardedSubsystem;
import com.spikes2212.dashboard.Namespace;
import com.spikes2212.dashboard.RootNamespace;
import com.spikes2212.util.smartmotorcontrollers.SparkWrapper;
import frc.robot.RobotMap;

import java.util.function.Supplier;

public class Drivetrain extends DashboardedSubsystem {

    public static final Namespace namespace = new RootNamespace("tank");

    public static final double DRIVE_SPEED = 0.1;
    public static final double TURN_SPEED = 0.1;

    private static final double BATTERY_VOLTAGE = 12;
    private static final int CURRENT_LIMIT = 40;

    private final SparkWrapper leftMaster;
    private final SparkWrapper leftSlave;
    private final SparkWrapper rightMaster;
    private final SparkWrapper rightSlave;

    private static Drivetrain instance;

    public static Drivetrain getInstance() {
        if (instance == null) {
            SparkWrapper leftMaster = SparkWrapper.createSparkMax(
                    RobotMap.CAN.DRIVETRAIN_LEFT_MASTER, SparkLowLevel.MotorType.kBrushless);
            SparkWrapper leftSlave = SparkWrapper.createSparkMax(
                    RobotMap.CAN.DRIVETRAIN_LEFT_SLAVE, SparkLowLevel.MotorType.kBrushless);

            SparkWrapper rightMaster = SparkWrapper.createSparkMax(
                    RobotMap.CAN.DRIVETRAIN_RIGHT_MASTER, SparkLowLevel.MotorType.kBrushless);
            SparkWrapper rightSlave = SparkWrapper.createSparkMax(
                    RobotMap.CAN.DRIVETRAIN_RIGHT_SLAVE, SparkLowLevel.MotorType.kBrushless);

            instance = new Drivetrain(namespace, leftMaster, leftSlave, rightMaster, rightSlave);
        }
        return instance;
    }

    private Drivetrain(Namespace namespace, SparkWrapper leftMaster, SparkWrapper leftSlave,
                       SparkWrapper rightMaster, SparkWrapper rightSlave) {
        super(namespace);
        this.leftMaster = leftMaster;
        this.leftSlave = leftSlave;
        this.rightMaster = rightMaster;
        this.rightSlave = rightSlave;
        configureMotors();
        configureDashboard();
    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftMaster.set(leftSpeed);
        rightMaster.set(-rightSpeed);
    }

    public void stop() {
        leftMaster.stopMotor();
        leftSlave.stopMotor();
        rightMaster.stopMotor();
        rightSlave.stopMotor();
    }

    private void configureMotors() {
        configureDriveMotor(leftMaster);
        configureDriveMotor(leftSlave);
        configureDriveMotor(rightMaster);
        configureDriveMotor(rightSlave);
        leftSlave.follow(leftMaster);
        rightSlave.follow(rightMaster);
    }

    private void configureDriveMotor(SparkWrapper spark) {
        spark.restoreFactoryDefaults();
        spark.setIdleMode(SparkBaseConfig.IdleMode.kCoast);
        spark.applyConfiguration(spark.getSparkConfiguration().smartCurrentLimit(CURRENT_LIMIT));
        spark.applyConfiguration(spark.getSparkConfiguration().voltageCompensation(BATTERY_VOLTAGE));
        spark.setInverted(false);
        spark.resetPosition();
    }

    @Override
    public void configureDashboard() {
    }
}
