/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RotatePanel extends Command {
  /**
   * Creates a new RotatePanel.
   */
  //is initial color an already known value?
  private Color initialColor;
  private double numOfRev=0;

  public RotatePanel() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initialColor=Robot.m_colorSensor.findColor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //loop, until motor stops
    if (!(initialColor.equals(Robot.m_colorSensor.findColor()))){
        if (Robot.m_colorSensor.findColor().equals(initialColor))
          numOfRev+=0.5;
    }
    if (numOfRev==3.0) {
      //stop motor
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
