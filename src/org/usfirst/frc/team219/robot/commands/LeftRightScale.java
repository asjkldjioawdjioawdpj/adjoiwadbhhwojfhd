package org.usfirst.frc.team219.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftRightScale extends CommandGroup {

    public LeftRightScale() {
  
    	
//    	//initial drive up
//    	addSequential(new DriveForward(-.5,2.95,false,false)); 
//    	
//    	//turn towards middle
//    	addSequential(new DriveTurn(133,1,false));
//    	
//    	//Prep shooter (consider changing to values set later on)
//    	addParallel(new Shoot(1,1,0));
//    	
//    	//middle passage
//    	addSequential(new DriveForward(-.5,3.25,false,false)); //2.85
//    	
//    	//turn towards scale
//    	addSequential(new DriveTurn(-198,1,false));//170
//    	
//    	//this is kinda stupid, but if we get rid of it remember to make true right b4 this
//    	addSequential(new DriveForward(-.5,.01,true,true));
//
//    	//raising arm up further
//    	addSequential(new DartUpx2(23));
//    	
//    	//delay to steady arm
//    	addSequential(new DriveForward(0,1.3,true,true));
//    	
//    	//start the actual shot
//    	addSequential(new Shoot(.8,.78,.75));
//    	
//    	//delay to allow time to shoot
//    	addSequential(new DriveForward(0,1,true,true));
//    	
//    	//stopping shooter
//    	addSequential(new Shoot(0,0,0));
//    	
//    	//back up drive
//    	addSequential(new DriveForward(.4,.4,true,true));
//    	
//    	//turn towards cube
//    	addSequential(new DimeTurn(-260));
//    	
//    	//
//    	addSequential(new DriveForward(-.4,1.6,true,true));
//
//    	//addSequential(new SideShot(0,0,0,0,0,0));
//    
//	
	//initial drive up
	
	//raising arm up further
   // addParallel(new DartDownvar());
    //Gearaffes only
    addSequential(new DartUp(13));	
	addSequential(new DriveForward(-.25,.1,false,false)); 
	addSequential(new DriveForward(-.5,.1,false,false)); 
	addSequential(new DriveForward(-.75,1.95,false,false)); //1.92
	
	//turn towards middle
	addSequential(new DriveTurn(111,1,false)); //115

	//Prep shooter (consider changing to values set later on)
	addParallel(new Shoot(1,1,0,true));
	 addParallel(new DartDownvar());//blue angle must change
	//middle passage
	addSequential(new DriveForward(-.75,0.2,true,true)); 
	
	//turn towards scale
	/*addSequential(new DriveTurn(-189,1,true));//170 -205-blue, -210 for red, altered 15 to right
	addSequential(new DriveForward(-0.5,.11,false,false));//new thing
	

	
	
	//last inch up
	//addSequential(new DriveForward(-.3,.4,false,false)); //-blue
	
	//delay to steady arm
	addSequential(new DriveForward(0,1.5,true,true));
	
	//start the actual shot
	addSequential(new Shoot(.7,.68,.75));
	
	//delay to allow time to shoot
	addParallel(new DartDown());

	
	addSequential(new DimeTurn(-185));//-185 for red //-195 blue
	addSequential(new DriveForward(-.3,1.5,true,true));
	addParallel(new HarvestAuto(20));
  	addSequential(new DriveForward(-.3,1.2,true,true));//.6
  	addSequential(new DriveForward(.3,.6,true,true));
  	addSequential(new DimeTurn(185));
	
	//back up drive
//	addSequential(new DriveForward(.4,.4,true,true));
	
	//turn towards cube
//	addSequential(new DimeTurn(-260));
	
	//
// 	addSequential(new DriveForward(-.4,1.6,true,true));

	//addSequential(new SideShot(0,0,0,0,0,0));
	 * 
	 */
}
}