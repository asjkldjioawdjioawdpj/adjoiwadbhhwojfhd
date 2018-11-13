package org.usfirst.frc.team219.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightLeftScale extends CommandGroup {

    public RightLeftScale() {
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
    	addSequential(new DriveForward(-.25,.1,false,false)); 
    	addSequential(new DriveForward(-.5,.1,false,false)); 
    	addSequential(new DriveForward(-.75,1.92,false,false)); 
    	
    	//turn towards middle
    	addSequential(new DriveTurn(-115,1,false));

    	//Prep shooter (consider changing to values set later on)
    	addParallel(new Shoot(1,1,0,true));
    	 addParallel(new DartDownvar());
    	//middle passage
    	addSequential(new DriveForward(-.75,2.17,false,false)); //2.85
    	
    	//turn towards scale
    	addSequential(new DriveTurn(205,1,true));//170
    	


    	
    	
    	//delay to steady arm
    	addSequential(new DriveForward(-.3,.4,false,false)); 
    	addSequential(new DriveForward(0,1.5,true,true));
    	
    	//start the actual shot
    	addSequential(new Shoot(.7,.68,.75));
    	
    	
    	
//    	
//    	addSequential(new DriveForward(-.5,3,false,false));
//    	addSequential(new DriveTurn(-134,1,false)); //132
//    	addParallel(new Shoot(1,1,0,true));
//    	addSequential(new DriveForward(-.5,3.05,false,false)); //2.85
//    	addSequential(new DriveTurn(199,1,false));
//    	addSequential(new DriveForward(-.5,.15,true,true));
//    	addSequential(new DartUpx2(23));
//    	addSequential(new DriveForward(0,1.1,true,true));
//    	addSequential(new Shoot(.75,.75,.75));
//    	addSequential(new DriveForward(.4,.4,true,true));
//    	addSequential(new DimeTurn(260));
//    	addSequential(new DriveForward(-.4,1.6,true,true));
    //	addSequential(new SideShot(0,0,0,0,0,0));
    	//addSequential(new ShootSwitch());
    }
    
}
