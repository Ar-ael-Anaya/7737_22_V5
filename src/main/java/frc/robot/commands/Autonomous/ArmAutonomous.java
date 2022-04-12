// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;
//Implement Dio switch backup

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ArmAutonomous extends CommandBase {
  Timer m_timer = new Timer();
  double m_time; 
  double m_speed;
  public ArmAutonomous(double time, double speed) {
    m_time = time;
    m_speed = speed;
    addRequirements(Robot.m_arm);
  }


  @Override
  public void initialize() {

      m_timer.start();
   
  }

  @Override
  public void execute() {
 
    Robot.m_arm.setArmMotorSpeed(m_speed );
    if (Robot.m_arm.checkBottomArmLimitSwitch() || Robot.m_arm.checkTopArmLimitSwitch()){
      Robot.m_arm.setArmMotorSpeed(0);
    }  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_arm.setArmMotorSpeed(0);
    m_timer.reset();
 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
 
    return m_timer.get() > m_time;
 }
}
