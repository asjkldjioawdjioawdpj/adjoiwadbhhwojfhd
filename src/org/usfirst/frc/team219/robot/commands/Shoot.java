package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shoot extends Command {

	double frontSpeed,midSpeed,backSpeed;
	Timer timer;
	boolean auton = false;
	public Shoot(double front,double mid,double back) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.squish);
    	frontSpeed = front+.05;
    	midSpeed = mid;
    	backSpeed = back;
    	timer = new Timer();
    	auton = false;
    }
	public Shoot(double front,double mid,double back, boolean auto) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.squish);
    	frontSpeed = front;
    	midSpeed = mid;
    	backSpeed = back;
    	timer = new Timer();
    	auton = auto;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(frontSpeed == .85)
    	{
    		System.out.println("Ultra-High Shot at ~"+ DriverStation.getInstance().getMatchTime() +" time left");
    	}
    	else if(frontSpeed ==.70)
    	{
    		System.out.println("High Shot at ~"+ DriverStation.getInstance().getMatchTime() +" time left");
    	}
    	else if(frontSpeed == .63)
    	{
    		System.out.println("Medium Shot at ~"+ DriverStation.getInstance().getMatchTime() +" time left");
    	}
    	else if(frontSpeed == .62)
    	{
    		System.out.println("Low+ Shot at ~"+ DriverStation.getInstance().getMatchTime() +" time left");
    	}
    	else if(frontSpeed == .55)
    	{
    		System.out.println("Low Shot at ~"+ DriverStation.getInstance().getMatchTime() +" time left");
    	}
    	else if(frontSpeed == .25)
    	{
    		System.out.println("Switch Shot at ~"+ DriverStation.getInstance().getMatchTime() +" time left");
    	}
    	Robot.squish.varSpeed(frontSpeed, midSpeed, backSpeed);
    	if(!auton)
    	{
    		timer.start();
    	}
    	
    	
    	

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(!auton)
    	{
    		return timer.get()> 1.2;
    	}
    	else
    	{
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(!auton)
    	{
    		timer.stop();
    		timer.reset();
    		Robot.squish.varSpeed(0, 0, 0);
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
