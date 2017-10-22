package robots;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html


// CODE COPIED NOT MINE
/**
 * Robot3 - a robot by (your name here)
 */
public class Plaguerizer extends AdvancedRobot
{
	int movementDirection = 1;
	boolean weHaveARobot =  false;
	double previousEnergy = 100;
	
	public void run() {
	
		setBodyColor(new Color(244, 122, 66));
		setGunColor(new Color(255, 68, 35));
		setRadarColor(new Color(255, 218, 34));
		setScanColor(Color.black);
		setBulletColor(new Color(33, 255, 243));
		
		
		setAdjustGunForRobotTurn(true); // keeps gun still while turning.
		setAdjustRadarForGunTurn(true); //keeps radar still while turning.
		turnRadarRightRadians(Double.POSITIVE_INFINITY);
		
	}
	public void onScannedRobot(ScannedRobotEvent e) {
		
		setAhead(Double.POSITIVE_INFINITY * movementDirection);

		
		weHaveARobot = true;
		//double enemyDistance=e.getDistance;
		double absBearing=e.getBearingRadians()+getHeadingRadians();
		double latVel=e.getVelocity() * Math.sin(e.getHeadingRadians() -absBearing);
		double gunTurnAmt;
		setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
		gunTurnAmt = robocode.util.Utils.normalRelativeAngle(absBearing- getGunHeadingRadians()+latVel/11);
		setTurnGunRightRadians(gunTurnAmt);
		setTurnLeft(-90-e.getBearing());
		setFire(3);
		
		double changeInEnergy = previousEnergy-e.getEnergy();
		if (changeInEnergy>0 && changeInEnergy<=3){
			movementDirection=-movementDirection;
		}
	}

	public void onHitByBullet(HitByBulletEvent e) {
		movementDirection=-movementDirection;
	}
	
	public void onHitWall(HitWallEvent e) {
		movementDirection=-movementDirection;
	}	
}
