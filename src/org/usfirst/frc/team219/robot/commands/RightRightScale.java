package org.usfirst.frc.team219.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightRightScale extends CommandGroup {

    public RightRightScale() {
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
    	//addSequential( new AutonDrive(.5,13) );
    	///addSequential() DRIVENTURN
    	//addSequential(new ) SHOOTER
    	//addSequential(new DriveTurn(-90,.5,false));
    	addSequential(new DartUp(13));
    	addParallel(new Shoot(.5,.5,0,true));
    	
    	//accelerate steadily
    	addSequential(new DriveForward(-.25,.1,false,false)); 
    	addSequential(new DriveForward(-.5,.1,false,false)); 
    	addSequential(new DriveForward(-.75,1.3,false,false));
    	
    	//start accelerating steadily in the opposite direction
    	addSequential(new DriveForward(-.7,.3,false,false));
    	addSequential(new DriveForward(-.6,.3,false,false));
    	addSequential(new DriveForward(-.5,.3,false,false));
    	
    	//turn towards the scale
    	addSequential(new DriveTurn(-56,.5,false));
    	addSequential(new DriveForward(-.45,.1,false,false));
    	//drive forward for the last lil bit
    	addParallel(new Shoot(.68,.59,.75));
    	
    	
    	addSequential(new DriveForward(-.45,.1,false,false));
    	
    	
    	//start the shot while slowing down in preperation of turning around
    	addParallel(new DartDown());
    	addSequential(new DriveForward(-.4,.1,false,false));
    	addSequential(new DriveForward(-.35,.2,false,true));
    	
    	addSequential(new DriveForward(-.25,.15,true,true));
    	
    	//get out while bringing arm down
    	//addParallel(new DartDown());
    	addSequential(new DriveForward(.6,1,true,true));
    	
    	//turn towards second perp
    	
    	addSequential(new DimeTurn(-147));//147
//    	
//    	addSequential(new DriveTurn(15,.5,false));
//    	addParallel(new Shoot(1,1,0,true));
//    	addSequential(new DriveForward(-.5,3.7,false,false));
//    	addSequential(new DriveTurn(-95,.5,false));
//    	addSequential(new DriveForward(-.5,.05,true,true));
//    	addSequential(new DartUpx2(23));
//    	addSequential(new DriveForward(0,1,true,true));//testing
//    	addSequential(new Shoot(.78,.78,.75));
//    	addSequential(new DriveForward(0,1,true,true));
//    	addSequential(new Shoot(0,0,0));
//    	addSequential(new DimeTurn(-240));
//    	
//    	
//    	addSequential(new DriveForward(-.4,1.3,true,true));

    	//addSequential(new SideShot(0,0,0,0,0,0));
    	//addSequential(new ShootSwitch());
    }
}
