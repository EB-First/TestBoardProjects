/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import java.net.Socket;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
public class MoveToColor extends Command {
  /**
   * Creates a new MoveToColor.
   */
  public MoveToColor() {
    // Use addRequirements() here to declare subsystem dependencies.
    requires(Robot.m_colorSensor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Code Initialized MovetoColor");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Code Executed MovetoColor");
    //Note: turn off backlight/LED to get a better reading of color because reading under control panel
    if (Robot.m_colorSensor.isTargetColor(Robot.colorTarget)){
      System.out.println("is target color");
    }
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
