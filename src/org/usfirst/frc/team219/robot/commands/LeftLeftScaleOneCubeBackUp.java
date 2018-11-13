package org.usfirst.frc.team219.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftLeftScaleOneCubeBackUp extends CommandGroup {

    public LeftLeftScaleOneCubeBackUp() {
    	
    	//prep the wheels
    	addSequential(new DartUp(13));
    	addParallel(new Shoot(.5,.5,0,true));
    	
    	//accelerate steadily
    	addSequential(new DriveForward(-.25,.1,false,false,true)); 
    	addSequential(new DriveForward(-.5,.1,false,false,true)); 
    	addSequential(new DriveForward(-.75,1.3,false,false,true));
    	
    	//start accelerating steadily in the opposite direction
    	addSequential(new DriveForward(-.7,.3,false,false,true));
    	addSequential(new DriveForward(-.6,.3,false,false,true));
    	addSequential(new DriveForward(-.5,.3,false,false,true));
    	
    	//turn towards the scale
    	addSequential(new DriveTurn(67,.5,false));
    	addSequential(new DriveForward(-.5,.1,false,false));
    	//drive forward for the last lil bit
    	addParallel(new Shoot(.73,.65,.75));
    	
    	
    	addSequential(new DriveForward(-.5,.15,false,false));
    	
    	
    	//start the shot while slowing down in preperation of turning around
    	addParallel(new DartDown());
    	addSequential(new DriveForward(-.4,.1,false,false));
    	addSequential(new DriveForward(-.35,.2,false,true));
    	
    	addSequential(new DriveForward(-.25,.15,true,true));
    	
    	//get out while bringing arm down
    	//addParallel(new DartDown());
    	addSequential(new DriveForward(.6,1.3,true,true));
    	addSequential(new DimeTurn(-20));
    	addSequential(new DriveForward(.6,1,true,true));
    	addSequential(new DriveForward(.3,.6,true,true));
    	
    	
    	
    	
    }
}
