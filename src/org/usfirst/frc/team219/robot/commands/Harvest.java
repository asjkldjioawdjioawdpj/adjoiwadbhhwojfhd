package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Harvest extends Command {

    public Harvest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.squish);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.squish.harvestPerp();
		SmartDashboard.putString("Harvest Caught via Current?", "Waiting");
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.squish.shootMR.getOutputCurrent()>=3.4)
    	{
    		SmartDashboard.putString("Harvest Caught via Current?", "Yes");
    		new HarvestRetract(21);
    	}
        return(Robot.squish.shootMR.getOutputCurrent()>=3.4); ///DONT KNOW NUMBER YET
       // return 	(!Robot.squish.limit.get());	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.squish.varSpeed(0,0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
