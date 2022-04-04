// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
//import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class DriveTrain extends SubsystemBase {
  private PWMSparkMax frontLeft = new PWMSparkMax(Constants.Motors.DriveMotors.m_frontleft);
  private PWMSparkMax reafLeft = new PWMSparkMax(Constants.Motors.DriveMotors.m_rearleft);
  private PWMSparkMax frontRight = new PWMSparkMax(Constants.Motors.DriveMotors.m_frontRight);
  private PWMSparkMax rearRight = new PWMSparkMax(Constants.Motors.DriveMotors.m_rearRight);
  


  /** Creates a new DriveTrain. */
  public DriveTrain() {
    rearRight.setInverted(true);
    frontRight.setInverted(true);

    Robot.m_robotDrive = new MecanumDrive(frontLeft, reafLeft, frontRight, rearRight);

  }

  @Override
  public void periodic() {}

  public void setMotorSpeed(double xAxis, double yAxis, double  zAxis){
    Robot.m_robotDrive.driveCartesian(xAxis, yAxis, zAxis, 0.0);
  } 
}
