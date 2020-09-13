package math;

public class Room {
	public boolean[] deaths;

	public Room(int doors) {
		deaths = new boolean[doors];
	}

	public boolean survived() {
		int deadDoorCount = 0;
		for (int i = 0; i < deaths.length; i++) {
			if (deaths[i])
				deadDoorCount++;
		}
		return Math.random() > ((double) deadDoorCount) / ((double)deaths.length);
	}
	
	public void reset() {
		deaths = new boolean[deaths.length];
	}
}
