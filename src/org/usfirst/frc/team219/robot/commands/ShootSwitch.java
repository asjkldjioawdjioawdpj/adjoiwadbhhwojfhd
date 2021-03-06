package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class ShootSwitch extends Command {

    public ShootSwitch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.squish);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lights.RainGlitter();
    	Robot.squish.varSpeed(.4, .6, .6);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lights.RainGlitter();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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


