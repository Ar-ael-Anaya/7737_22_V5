// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class IntakeShooter extends SubsystemBase {
 PWMVictorSPX intakeShooterMotor = new PWMVictorSPX(Constants.Motors.IntakeShooterMotors.m_intakeShooterMotor);
 
  public IntakeShooter() {}

  @Override
  public void periodic() {
  }
  public void setIntakeShooterMotorSpeed(double axis){
    intakeShooterMotor.set(axis);
    }
  

}

