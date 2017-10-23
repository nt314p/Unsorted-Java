package robots;

import robocode.Robot;

public class CustomTarget extends Robot {

	public void run() {

		while (true) {
			if (!((getHeading() < 91) && (getHeading() > 89))) {
				turnRight((getHeading()-90)/2 );
			} else {
				ahead(100);
				ahead(-100);
			}
		}
	}
}
