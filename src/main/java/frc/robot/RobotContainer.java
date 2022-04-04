// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Sequences.AutonomousSequenceOne;
import frc.robot.commands.MecanumDriver;
import frc.robot.commands.ArmMechanism.ArmLoweringMechanism;
import frc.robot.commands.ArmMechanism.ArmRaisingMechanism;

import frc.robot.commands.ClimbingSystem.LeftLoweringMechanism;
import frc.robot.commands.ClimbingSystem.LeftRaisingMechanism;
import frc.robot.commands.IntakeShooterSystem.Shooter;
import frc.robot.commands.IntakeShooterSystem.Intake;



public class RobotContainer {
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  XboxController controller = new XboxController(Constants.Controller.m_controller);

  public Button xButton = new JoystickButton(controller, Constants.Controller.Buttons.m_xButton);
  public Button yButton = new JoystickButton(controller, Constants.Controller.Buttons.m_yButton);
  public Button bButton = new JoystickButton(controller, Constants.Controller.Buttons.m_bButton);
  public Button aButton = new JoystickButton(controller, Constants.Controller.Buttons.m_aButton);

  public Button rBumper = new JoystickButton(controller, Constants.Controller.Buttons.Bumpers.m_rBumper);
  public Button lBumper = new JoystickButton(controller, Constants.Controller.Buttons.Bumpers.m_lBumper);


  public double GetDriverRawAxis(int axis){
    return controller.getRawAxis(axis);
  }

  private void configureButtonBindings() {
    Robot.m_driveTrain.setDefaultCommand(new MecanumDriver());
    Robot.m_intakeShooter.setDefaultCommand(new Shooter());
    Robot.m_climber.setDefaultCommand(new LeftRaisingMechanism());
   //Robot.m_arm.setDefaultCommand(new ArmLoweringMechanism(Constants.Timings.ArmTimings.m_ArmRaisingTime));



    m_chooser.setDefaultOption("Run Forward", new AutonomousSequenceOne());
    //m_chooser.addOption("Auto Routine Time", new AutonomousTime());
    SmartDashboard.putData(m_chooser);
  }

  public RobotContainer() {
    xButton.whenPressed(new ArmLoweringMechanism(Constants.Timings.ArmTimings.m_ArmLoweringTime));
    bButton.whenPressed(new ArmRaisingMechanism(Constants.Timings.ArmTimings.m_ArmRaisingTime));

    
    rBumper.whileHeld(new Intake());
    lBumper.whileHeld(new LeftLoweringMechanism());
   
  
   
 
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
 
  public Command getAutonomousCommand() {
    //An ExampleCommand will run in autonomous
    return m_chooser.getSelected();
  }
  
}
