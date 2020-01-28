/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.variables.RobotMap;

/*
  Ping-response ultrasonic sensor
*/
public class DistanceSensor extends Subsystem {
  /**
   * Creates a new DistanceSensor.
   */
  private AnalogPotentiometer dist_pot;
  private final double fullRange=180; //change to full range of motion in appropriate units
  private final double offset=0; //the "starting point" of the motion (location when pot is 0v)
  
  public DistanceSensor() {
   // dist_pot = new AnalogPotentiometer(RobotMap.DIST_SENSOR_ANALOG, fullRange, offset);
  }

  public double getDistance(){
 //   return dist_pot.get();
 return 1;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub

    }
}
