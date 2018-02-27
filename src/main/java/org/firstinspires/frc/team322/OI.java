// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.firstinspires.frc.team322;

import org.firstinspires.frc.team322.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;
import org.firstinspires.frc.team322.subsystems.*;
import org.firstinspires.frc.team322.utilities.F310Controller;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton brakeButton;
    public XboxController driveStick;
    public JoystickButton pullCrateButton;
    public JoystickButton pushCrateButton;
    public JoystickButton climbArmExtensionButton;
    public JoystickButton climbArmRetractionButton;
    public JoystickButton climbArmWinchExtendButton;
    public JoystickButton climbArmWinchRetractButton;
    public F310Controller manipulatorStick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        driveStick = new XboxController(0);
        brakeButton = new JoystickButton(driveStick, 2);
        brakeButton.whileHeld(new Brakes());
        
        manipulatorStick = new F310Controller(1);
        climbArmRetractionButton = new JoystickButton(manipulatorStick, 6);
        climbArmRetractionButton.whenPressed(new RetractClimbArm());
        climbArmExtensionButton = new JoystickButton(manipulatorStick, 5);
        climbArmExtensionButton.whenPressed(new ExtendClimbArm());
        climbArmWinchExtendButton = new JoystickButton(manipulatorStick, 4);
        climbArmWinchExtendButton.whileHeld(new ClimbArmWinchExtend());
        climbArmWinchRetractButton = new JoystickButton(manipulatorStick, 3);
        climbArmWinchRetractButton.whileHeld(new ClimbArmWinchRetract());
        pushCrateButton = new JoystickButton(manipulatorStick, 2);
        pushCrateButton.whileHeld(new PushCrate());
        pullCrateButton = new JoystickButton(manipulatorStick, 1);
        pullCrateButton.whileHeld(new PullCrate());

        // SmartDashboard Buttons
        SmartDashboard.putData("DriveWithJoystick", new DriveWithJoystick());
        SmartDashboard.putData("Brakes", new Brakes());
        
        SmartDashboard.putData("DoNothing", new DoNothing());
        SmartDashboard.putData("DriveForward", new DriveForward());
        SmartDashboard.putData("DriveBackward", new DriveBackward());
        
        SmartDashboard.putData("LowerArmControl", new LowerArmControl());
        SmartDashboard.putData("EndArmControl", new EndArmControl());
        SmartDashboard.putData("PullCrate", new PullCrate());
        SmartDashboard.putData("PushCrate", new PushCrate());
        
        SmartDashboard.putData("ExtendClimbArm", new ExtendClimbArm());
        SmartDashboard.putData("RetractClimbArm", new RetractClimbArm());
        SmartDashboard.putData("ClimbArmWinchExtend", new ClimbArmWinchExtend());
        SmartDashboard.putData("ClimbArmWinchRetract", new ClimbArmWinchRetract());
        SmartDashboard.putData("ClimbArmWinchStop", new ClimbArmWinchStop());
        
        SmartDashboard.putData("SetLED", new SetLED());
        SmartDashboard.putData("DashboardUpdater", new DashboardUpdater());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public XboxController getDriveStick() {
        return driveStick;
    }

    public F310Controller getManipulatorStick() {
        return manipulatorStick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

