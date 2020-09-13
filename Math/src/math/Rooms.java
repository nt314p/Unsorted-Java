package math;

public class Rooms {

	static int lived;
	static int n = 10000000;
	static int doorsPerRoom = 3;
	static int deadDoors = 11;
	static int numRooms = 20;
	static Room[] rooms = new Room[numRooms];
	static int deadlyRooms = 0;

	public static void main(String[] args) {
		run();
	}

	public static void run() {
		lived = 0;

		for (int i = 0; i < rooms.length; i++) {
			rooms[i] = new Room(doorsPerRoom);
		}
		for (int i = 0; i < n; i++) {
			sim();
		}
		System.out.println("Performed " + n + " iterations");
		double pDeath = ((double) n - lived) / (double) n;
		double pDeadly = ((double) deadlyRooms) / (double) n;
		System.out.println("P(death)= " + pDeath);
		System.out.println("P(survive)= " + (1 - pDeath));
		System.out.println("P(deadly rooms)= " + pDeadly);
	}

	public static void sim() {
		for (Room r : rooms) {
			r.reset();
		}

		for (int i = 0; i < deadDoors; i++)
			doorPass();

		countDeadlyRooms();

		for (Room r : rooms) {
			if (!r.survived()) // death
				return;
		}
		lived++;
	}
	
	public static void countDeadlyRooms() {
		for (Room r : rooms) {
			int deadDoorCount = 0;
			for (boolean isDead : r.deaths) {
				if (isDead)
					deadDoorCount++;
			}
			if (deadDoorCount == doorsPerRoom) {
				deadlyRooms++;
				break;
			}
		}
	}

	public static void doorPass() {
		boolean success = false;

		while (!success) {
			int roomNum = (int) (Math.random() * rooms.length);

			for (int i = 0; i < rooms.length; i++) {
				if (i == roomNum) {
					int j;
					boolean[] deaths = rooms[i].deaths;
					for (j = 0; j < deaths.length; j++) {
						if (!deaths[j])
							break;
					}
					try {
						deaths[j] = true;
						success = true;
					} catch (ArrayIndexOutOfBoundsException e) {

					}
				}
			}
		}
	}
}
