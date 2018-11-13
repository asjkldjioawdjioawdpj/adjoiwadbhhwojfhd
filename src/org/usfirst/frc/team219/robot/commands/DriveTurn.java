package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTurn extends Command {
	Timer time;
	double angle,speedDif;
	boolean last,fast = false;
    public DriveTurn(double ang,double speedDif, boolean la, boolean fast) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	time = new Timer();
    	last = la;
    	requires(Robot.drivetrain);
    	angle = ang;
    	this.speedDif = speedDif;
    	this.fast=fast;
    	
    }
    public DriveTurn(double ang,double speedDif, boolean la) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	time = new Timer();
    	last = la;
    	requires(Robot.drivetrain);
    	angle = ang;
    	this.speedDif = speedDif;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(fast)
    	{
    		Robot.drivetrain.driveNTurn(angle, time.get(), speedDif,fast);
    	}
    	else
    	{
    		Robot.drivetrain.driveNTurn(angle, time.get(), speedDif);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.drivetrain.turnFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    	time.reset();
    	if(last)
    	{
    		Robot.drivetrain.tankDrive(0,0);
    	}
    	fast = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
