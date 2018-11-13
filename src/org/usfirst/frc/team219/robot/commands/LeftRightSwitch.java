package org.usfirst.frc.team219.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftRightSwitch extends CommandGroup {

    public LeftRightSwitch() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
//    	addSequential (new DriveForward(-.5,.8,false,false));
//    	addSequential (new DriveTurn(90, .5, false));
//    	addSequential(new DriveForward(-.5,1.8,false,false));
//    	addSequential (new DriveTurn(90, .5, false));
//    	addSequential (new DriveForward(-.5, .2, false, false));
//    	addSequential (new DriveTurn(90, .5, false));
//    	addSequential (new DriveForward(-.5, .2, true, true));
//    	addSequential(new DriveForward(-.5,2.85,false,false));
//    	addSequential(new DriveTurn(129,1,false));
//    	addParallel(new Shoot(1,1,0));
//    	addSequential(new DriveForward(-.5,2.65,true,true)); //2.85
//    	
    	addSequential(new DartUp(13));
    	addSequential(new DriveForward(-.5,2.95,false,false)); 
    	addSequential(new DriveTurn(133,1,false));
    	//addParallel(new Shoot(1,1,0));
    	addSequential(new DriveForward(-.5,1.475,false,false)); //2.85
    }
}
