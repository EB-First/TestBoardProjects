/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class Aimbot extends Command {

    /**
     * Creates a new Aimbot.
     * 
     * @return
     */
    public void MoveToColor() {
    // Use addRequirements() here to declare subsystem dependencies.
    requires(Robot.m_limelight);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.m_limelight.setLED("on");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.m_limelight.hasTarget()) {
        //1.4 is a random number based on observations, we need to do some actual testing *cough cough we need a working radio*
        if (Robot.m_limelight.getTargetArea() > 1.4) {
            //use horizontal and vertical offsets to turn the robot and position the shooter to aim
        }else {
            //drive forward
        }
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      Robot.m_limelight.setLED("off");
    return false;
  }
}
