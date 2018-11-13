package org.usfirst.frc.team219.robot.subsystems;


import org.usfirst.frc.team219.robot.RobotMap;
import org.usfirst.frc.team219.robot.commands.TeleOpDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj.PIDSourceType;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//inches
	TalonSRX driveFR,driveFL,driveBR,driveBL;

	private double batteryVol;
	private boolean turnFinish = false;
	public String alliance = "Blue";
	
	public DriveTrain(double bat, String al)
	{
		alliance=al;
		batteryVol = bat;
		driveFR= new TalonSRX(RobotMap.driveFrontRightPort);
		driveFL= new TalonSRX(RobotMap.driveFrontLeftPort);
		driveBR= new TalonSRX(RobotMap.driveBackRightPort);
		driveBL= new TalonSRX(RobotMap.driveBackLeftPort);
	
	}
	
	
	public void driveNTurn( double angle, double time, double speedDif)
	{
		//SmartDashboard.putNumber("EncVelL", driveFL.getSensorCollection().getQuadratureVelocity());
		SmartDashboard.putNumber("Bat", batteryVol);
		
		double circumference = 194; //Take the width of the robot as the radius 
		double percentOfCircumference= Math.abs(angle/360);
		double maxSpeedIn = 150; //Empirically determined and 'somewhat' fudged
		double speedDifIn = maxSpeedIn*speedDif;
	
		//^This is also 'somewhat' fudged
		if(time < (circumference*percentOfCircumference)/speedDifIn )
		{
			double baseSpeed = -.5;
			if(angle>0)	
			{
				tankDrive(baseSpeed + speedDif/2, baseSpeed - speedDif/2 );
			}
			else
			{
				tankDrive(baseSpeed - speedDif/2, baseSpeed + speedDif/2 );	
			}
			//This is so we can communicate with the command that uses this method
			turnFinish=false;
		}
		//This boolean will be called by the command to check if it's done yet
		else
		{
			turnFinish=true;
		}

	}
	public void driveNTurn( double angle, double time, double speedDif, boolean fast)
	{
		//SmartDashboard.putNumber("EncVelL", driveFL.getSensorCollection().getQuadratureVelocity());
		SmartDashboard.putNumber("Bat", batteryVol);
		
		double circumference = 194; //Take the width of the robot as the radius 
		double percentOfCircumference= Math.abs(angle/360);
		double maxSpeedIn = 150; //Empirically determined and 'somewhat' fudged
		double speedDifIn = maxSpeedIn*speedDif;
	
		//^This is also 'somewhat' fudged
		if(time < (circumference*percentOfCircumference)/speedDifIn )
		{
			double baseSpeed = -.75;
			if(angle>0)	
			{
				if(baseSpeed - speedDif/2 < -1)
				{
					double extra = baseSpeed - speedDif/2 + 1;
					tankDrive(baseSpeed + speedDif/2 - extra, -1 );
				}
				else
				{
					tankDrive(baseSpeed + speedDif/2, baseSpeed - speedDif/2 );
				}
			}
			else
			{
				if(baseSpeed - speedDif/2 < -1)
				{
					double extra = baseSpeed - speedDif/2 + 1;
					tankDrive( -1, baseSpeed + speedDif/2 - extra );
				}
				else
				{
					tankDrive(baseSpeed + speedDif/2, baseSpeed - speedDif/2 );
				}
				tankDrive(baseSpeed - speedDif/2, baseSpeed + speedDif/2 );	
			}
			//This is so we can communicate with the command that uses this method
			turnFinish=false;
		}
		//This boolean will be called by the command to check if it's done yet
		else
		{
			turnFinish=true;
		}

	}
	public void reverseDriveNTurn( double angle, double time, double speedDif)
	{
		//SmartDashboard.putNumber("EncVelL", driveFL.getSensorCollection().getQuadratureVelocity());
		SmartDashboard.putNumber("Bat", batteryVol);
		
		double circumference = 194; //Take the width of the robot as the radius 
		double percentOfCircumference= Math.abs(angle/360);
		double maxSpeedIn = 150; //Empirically determined and 'somewhat' fudged
		double speedDifIn = maxSpeedIn*speedDif;
	
		//^This is also 'somewhat'(very) fudged
		if(time < (circumference*percentOfCircumference)/speedDifIn )
		{
			double baseSpeed = -.5;
			if(angle>0)	
			{
				tankDrive(-(baseSpeed + speedDif/2),-( baseSpeed - speedDif/2 ));
			}
			else
			{
				tankDrive(-(baseSpeed - speedDif/2), -(baseSpeed + speedDif/2) );	
			}
			//This is so we can communicate with the command that uses this method
			turnFinish=false;
		}
		//This boolean will be called by the command to check if it's done yet
		else
		{
			turnFinish=true;
		}

	}
	
	
	public void dimeTurn(double angle, double currenTime)
	{
		double percent = Math.abs(angle/360);
		double speedDifIn = 135;
		if(currenTime < ((213.0*percent)/speedDifIn))
		{
			if (angle>0)
			{
				tankDrive(.5,-.5);
			}
			else
			{
				tankDrive(-.5,.5);
			}
			
			turnFinish=false;
		}
		else
		{
			turnFinish=true;
		}
	}
	
	public boolean turnFinished()
	{
		return turnFinish;
	}
	

	//used for straight driving
	public void goForward(double var)
	{
		driveFR.set(ControlMode.PercentOutput,var* (12.1/batteryVol));
    	driveFL.set(ControlMode.PercentOutput, -(var+(var*.05))* (12.1/batteryVol));
    	driveBR.set(ControlMode.Follower, RobotMap.driveFrontRightPort);
    	driveBL.set(ControlMode.Follower, RobotMap.driveFrontLeftPort);
	}
	public void goForward2(double left,double right)
	{
		driveFR.set(ControlMode.PercentOutput,right* (12.1/batteryVol));
    	driveFL.set(ControlMode.PercentOutput, -(left+(left*.05))* (12.1/batteryVol));
    	driveBR.set(ControlMode.Follower, RobotMap.driveFrontRightPort);
    	driveBL.set(ControlMode.Follower, RobotMap.driveFrontLeftPort);
	}

    public void initDefaultCommand() {
       
    	setDefaultCommand(new TeleOpDrive());
    }
    
    public void tankDrive(double right, double left)
    {
    	right = right * (12.1/batteryVol);
    	left = left * (12.1/batteryVol);
    	
    	driveFR.set(ControlMode.PercentOutput, right);
    	driveFL.set(ControlMode.PercentOutput, -left);
    	driveBR.set(ControlMode.Follower, RobotMap.driveFrontRightPort);
    	driveBL.set(ControlMode.Follower, RobotMap.driveFrontLeftPort);
    	
    } 
     //The robot knows where it is at all times. It knows this because it knows where it isn't.
     //By subtracting where it is from where it isn't, or where it isn't from where it is
     //(whichever is greater), it obtains a diffference, or deviation. The PID Loop uses
     //deviations to generate corective commands to drive the robot from a position where it is
     //to a position where it isn't, and arriving at a position where it wasn't, it now is.
     //Consequently, the position where it is, is now the position that it wasn't, and it
     //follows that the position that it was, is now the position that it isn't.
     //In the event that the position that is in is not the position that it wasn't, the
     //encoder has acquired a variation, the variation being the difference between where the 
     //robot is, and where it wasn't. If variatoin is considered to be a significant factor,
     //it too may be corrected by the PID loop. However, the robot must also know where it was.
     //The roboRio scenario works as follows. Because a variation has modified some of the 
     //information the robot has obtained, it is not sure just where it is. However, it is
     //sure where it isn't, within reason, and it knows where it was. It now subtracts
     //where it should be from where it wasn't, or vice-versa, and by differentiating this
     //from the algebraic sum of where it shouldn't be, and where it was, it is able
     //to obtain the deviation and its variation, which is called error.

    
    
    
}

