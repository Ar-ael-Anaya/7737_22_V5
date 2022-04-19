// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADIS16448_IMU;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
  public static final ADIS16448_IMU gyro = new ADIS16448_IMU();
  
  public GyroSubsystem() {}

  @Override
  public void periodic() {
   
  }
public double getGyroAngle(){
  return gyro.getAngle();
}

public void gyroCalibrate(){
  gyro.calibrate();
}
  public void resetGyro(){
    gyro.reset();
    
  }
}
