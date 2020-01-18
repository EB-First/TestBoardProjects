/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class CVprocessor extends SubsystemBase {
  private String networktablename;
  /**
    Constructs a new CVprocessor Object with network table name (to connect to the correct Raspberry Pi). should be "raspberrypi"
   */
  public CVprocessor(String inputname) {
    networktablename = inputname;
  }
  //determines whether raspberry pi detects a target (ball)
  public boolean hasTarget() {
      double value =  NetworkTableInstance.getDefault().getTable(networktablename).getEntry("hasTarget").getDouble(0);
      if (value == 1) {
          return true;
      }else {
          return false;
      }
  }
  //Average X Value from raspberry pi Coprocessor
  public double getAvgX () {
    return NetworkTableInstance.getDefault().getTable(networktablename).getEntry("avgX").getDouble(0);
  }
  //Average Y Value from raspberry pi Coprocessor
  public double getAvgY () {
    return NetworkTableInstance.getDefault().getTable(networktablename).getEntry("avgY").getDouble(0);
  }
  //Average R Value from raspberry pi Coprocessor
  public double getAvgR () {
    return NetworkTableInstance.getDefault().getTable(networktablename).getEntry("avgR").getDouble(0);
  }


}
