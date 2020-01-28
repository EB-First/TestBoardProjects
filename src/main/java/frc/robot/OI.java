/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.MoveToColor;
import frc.robot.commands.RotatePanel;


/**
 * Add your docs here.
 */

public class OI {
    public Joystick ps4_controller = new Joystick(RobotMap.PS4_CONTROLLER_PORT);
    public JoystickButton rotatePanelButton = new JoystickButton(ps4_controller, 11);
    public JoystickButton findColorButton = new JoystickButton(ps4_controller, 12);
    
    public OI(){
        rotatePanelButton.whenPressed(new RotatePanel());
        findColorButton.whenPressed(new MoveToColor());
    }

}
