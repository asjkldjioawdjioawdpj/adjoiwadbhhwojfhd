package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HarvestSecond extends Command {

    public HarvestSecond() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.squish);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.squish.harvestRetract();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return(Robot.squish.shootBR.getOutputCurrent()>=4); ///4.5
        //return false;	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.squish.varSpeed(1,1,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
