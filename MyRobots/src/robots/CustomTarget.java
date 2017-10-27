package robots;

import robocode.Robot;

public class CustomTarget extends Robot {

	public void run() {

		turnLeft(getHeading());

		while (true) {

			ahead(500);
			ahead(-500);
		}
	}
}
