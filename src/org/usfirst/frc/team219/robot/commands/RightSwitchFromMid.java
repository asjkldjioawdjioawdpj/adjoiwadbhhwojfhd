package org.usfirst.frc.team219.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitchFromMid extends CommandGroup {

    public RightSwitchFromMid() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
    	
    	
    	
    	
    	
    	
    	//      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	//addSequential(new AutonDrive(.3,80,1));
    	//addSequential(new DartUp(13));
    	addSequential(new DriveTurn(100,.5,false));
    	addSequential(new DriveForward(-.5,.25,false,false));
    	addSequential(new DriveTurn(-96,.5,true));
    	addSequential(new DriveForward(-.25,1.5,true,false));
    	addSequential(new DartDownSwitch());
    	addParallel(new ShootSwitch());
    	addSequential(new DriveForward(0,.75,true,true));
    	
    	
    	//back up protocal --reverse of normal run
    	addSequential(new DriveForward(.25,1,false,false));//1
    	addParallel(new Shoot(0,0,0));
    	addSequential(new DriveTurnReverse(-96,.5,true));
    	addSequential(new DriveForward(.5,.25,false,false));
    	addSequential(new DriveTurnReverse(100,.5,true));
    	addSequential(new DartDown());
  
    	
    	//start going for second cube
    	addParallel(new HarvestAuto(24));
    	addSequential(new DriveForward(-.5,1.5,true,true));
    	//back up
    	addSequential(new DriveForward(.5,1.5,true,true));
    	
    	//repeat of original run
    	addSequential(new DriveTurn(100,.5,false));
    	addSequential(new DriveForward(-.5,.25,false,false));
    	addSequential(new DriveTurn(-96,.5,true));
    	addSequential(new DriveForward(-.25,1.5,true,false));
    	addSequential(new DartDownSwitch());
//    	addParallel(new ShootSwitch());
//    	addSequential(new DriveForward(0,.5,true,true));
    
    	
    	
    	
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
