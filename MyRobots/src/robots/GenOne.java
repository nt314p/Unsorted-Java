package robots;

import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class GenOne extends Robot {

	public void run() {
		while (true) {
			// spin radar
			turnRadarRight(360);
			ahead(100);
			turnRadarRight(360);
			ahead(-100);
		}
	}
	
	public void onHitRobot (HitRobotEvent e) {
		//get out of the way!
		turnRight(45);
		ahead(-200);
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
		turnRight(e.getBearing());
		
		// we're too close! back up!
		if (e.getDistance() < 200) {
			ahead(-100);
		}

		fire(3);
	}
}
