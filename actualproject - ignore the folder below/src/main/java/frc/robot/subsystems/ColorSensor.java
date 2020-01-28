/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import edu.wpi.first.wpilibj.command.Subsystem;
public class ColorSensor extends Subsystem {
  //To be replaced after testing
  private final double BLUE_R=0.143;
  private final double BLUE_G=0.427;
  private final double BLUE_B=0.429;
  private final double GREEN_R=0.197;
  private final double GREEN_G=0.561;
  private final double GREEN_B=0.240;
  private final double RED_R=0.561;
  private final double RED_G=0.232;
  private final double RED_B=0.114;
  private final double YELLOW_R=0.361;
  private final double YELLOW_G=0.524;
  private final double YELLOW_B=0.113;

  private I2C.Port i2cPort = I2C.Port.kOnboard;
  private ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private ColorMatch colorMatcher = new ColorMatch();

  public final Color kBlueTarget = ColorMatch.makeColor(BLUE_R, BLUE_G, BLUE_B);
  public final Color kGreenTarget = ColorMatch.makeColor(GREEN_R, GREEN_G, GREEN_B);
  public final Color kRedTarget = ColorMatch.makeColor(RED_R, RED_G, RED_B);
  public final Color kYellowTarget = ColorMatch.makeColor(YELLOW_R, YELLOW_G, YELLOW_B);
  
  /**
   * Creates a new ColorSensor.
   */
  public ColorSensor() {
    colorMatcher.addColorMatch(kBlueTarget);
    colorMatcher.addColorMatch(kGreenTarget);
    colorMatcher.addColorMatch(kRedTarget);
    colorMatcher.addColorMatch(kYellowTarget); 

    colorMatcher.setConfidenceThreshold(0.80);
  }

  public void detectColor (){
    Color detectedColor = colorSensor.getColor();
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
  }

  public boolean isTargetColor(Color colorTarget) {
    Color detectedColor = colorSensor.getColor();
    ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);
    Color panelSensor;

    if (match.color.equals(kBlueTarget)) {
      panelSensor=kRedTarget;
    } else if (match.color.equals(kRedTarget)) {
      panelSensor=kBlueTarget;
    } else if (match.color.equals(kGreenTarget)) {
      panelSensor=kYellowTarget;
    } else if (match.color.equals(kYellowTarget)) {
      panelSensor=kGreenTarget;
    } else {
      panelSensor=Color.kBlack; 
    }
    return (panelSensor==colorTarget);
  }

  public Color findColor(){
    Color detectedColor=colorSensor.getColor();
    ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);
    return match.color;
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
