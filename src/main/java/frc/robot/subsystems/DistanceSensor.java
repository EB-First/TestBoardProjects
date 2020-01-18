/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

/*
  Ping-response ultrasonic sensor
*/
public class DistanceSensor extends SubsystemBase {
  /**
   * Creates a new DistanceSensor.
   */
  private Ultrasonic dist_sensor;
  
  public DistanceSensor() {
    dist_sensor=new Ultrasonic(RobotMap.PING_CHANNEL, RobotMap.ECHO_CHANNEL);
    dist_sensor.setAutomaticMode(true);
  }

  public double getDistance(){
    return dist_sensor.getRangeInches();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
