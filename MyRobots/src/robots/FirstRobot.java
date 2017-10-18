package robots;

import robocode.Bullet;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class FirstRobot extends Robot {

	public void run() {

		while (true) {
			ahead(50);
			turnRadarRight(360);
			ahead(-50);
			turnRadarRight(360);
		}
	}

	public void onHitRobot(HitRobotEvent e) {
		fire(3);
		ahead(-200);
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		turnRight(e.getBearing());
		ahead(e.getDistance() + 10);
	}

	public void onHitWall(HitWallEvent event) {
		turnRight(180);
		ahead(10);
	}
}
