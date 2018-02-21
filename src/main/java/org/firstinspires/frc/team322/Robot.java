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

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.firstinspires.frc.team322.commands.*;
import org.firstinspires.frc.team322.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand, steadyLED, blinkingLED, dashboardUpdater;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Chassis chassis;
    public static ChassisSensors chassisSensors;
    public static LowerArm lowerArm;
    public static EndArm endArm;
    public static ClimbArm climbArm;
    public static LEDControl ledControl;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private static DriverStation DS;
    private static String gameData;
    public static UsbCamera frontCameraServer, rearCameraServer;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassis = new Chassis();
        chassisSensors = new ChassisSensors();
        climbArm = new ClimbArm();
        endArm = new EndArm();
        lowerArm = new LowerArm();

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        ledControl = new LEDControl();
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();
        
        DS = DriverStation.getInstance();
        gameData = DS.getGameSpecificMessage();
        
    	//Setup Camera
    	frontCameraServer = CameraServer.getInstance().startAutomaticCapture();
    	frontCameraServer.setResolution(640, 360);
    	
    	rearCameraServer = CameraServer.getInstance().startAutomaticCapture();
    	rearCameraServer.setResolution(640, 360);
    	
    	//steadyLED = new SteadyLED();
    	//blinkingLED = new BlinkingLED();
    	dashboardUpdater = new DashboardUpdater();
        
        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        chooser.addDefault("Autonomous Command", new AutonomousCommand());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        SmartDashboard.putData("Auto mode", chooser);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){
    	//steadyLEDSetter();
    }

    @Override
    public void disabledPeriodic() {
    	//updateDashboard();
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        //blinkingLEDSetter(200);
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
    	//updateDashboard();
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        //blinkingLEDSetter(100);
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
    	//updateDashboard();
        Scheduler.getInstance().run();
    }
    
    public void updateDashboard() {
    	dashboardUpdater.start();
    }
    
    public void steadyLEDSetter() {
    	if(blinkingLED.isRunning()) blinkingLED.cancel();
    	if(DS.getAlliance() == DriverStation.Alliance.Red) {
    		RobotMap.redInt = 100.0;
    		RobotMap.greenInt = 0.0;
    		RobotMap.blueInt = 0.0;
    		steadyLED.start();
    	}
    	else if(DS.getAlliance() == DriverStation.Alliance.Blue) {
    		RobotMap.redInt = 0.0;
    		RobotMap.greenInt = 0.0;
    		RobotMap.blueInt = 100.0;
    		steadyLED.start();
    	}
    	else {
    		RobotMap.redInt = 0.0;
    		RobotMap.greenInt = 100.0;
    		RobotMap.blueInt = 0.0;
    		steadyLED.start();
    	}
    }
    public void blinkingLEDSetter(long blinkRate) {
    	if(steadyLED.isRunning()) steadyLED.cancel();
    	if(DS.getAlliance() == DriverStation.Alliance.Red) {
    		RobotMap.redInt = 100.0;
    		RobotMap.greenInt = 0.0;
    		RobotMap.blueInt = 0.0;
    		RobotMap.ledBlinkRate = blinkRate;
    		blinkingLED.start();
    	}
    	else if(DS.getAlliance() == DriverStation.Alliance.Blue) {
    		RobotMap.redInt = 0.0;
    		RobotMap.greenInt = 0.0;
    		RobotMap.blueInt = 100.0;
    		RobotMap.ledBlinkRate = blinkRate;
    		blinkingLED.start();
    	}
    	else {
    		RobotMap.redInt = 0.0;
    		RobotMap.greenInt = 100.0;
    		RobotMap.blueInt = 0.0;
    		RobotMap.ledBlinkRate = blinkRate;
    		blinkingLED.start();    	}
    }
}
