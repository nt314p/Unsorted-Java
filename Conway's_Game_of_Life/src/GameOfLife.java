import processing.core.PApplet;

public class GameOfLife extends PApplet {

	public static void main(String[] args) {
		PApplet.main("GameOfLife");
	}
	
	//ADD MORE DEATH

	/*
	 * CONWAY'S GAME OF LIFE Rules:
	 * 
	 * 1. Any live cell with fewer than two live neighbors dies (under population).
	 * 2. Any live cell with more than three live neighbors dies (over population).
	 * 3. Any live cell with two or three live neighbors lives, unchanged, to the
	 * next generation. 4. Any dead cell with exactly three live neighbors will come
	 * to life.
	 * 
	 */

	int sWidth = 1000;
	int sHeight = 1000;
	int scale = 5; // the side length of each cell

	boolean cells[][] = new boolean[sWidth / scale][sHeight / scale];
	boolean newcells[][] = cells;

	public void settings() {
		size(sWidth, sHeight);
	}

	public void setup() {
		frameRate(60);
		cells[4][3] = true;
		cells[4][4] = true;
		cells[4][5] = true;
	}

	public void draw() {
		// background
		fill(255, 255, 0);
		background(100, 100, 100);

		newcells = cells;
		// drawing cells
		for (int i = 0; i < (width / scale); i++) {
			for (int j = 0; j < (height / scale); j++) {
				if (cells[i][j]) {
					rect(i * scale, j * scale, scale, scale);
				}
			}
		}

		if (frameCount % 10 == 0) {

			// across
			for (int i = 0; i < (width / scale); i++) {
				// down
				for (int j = 0; j < (height / scale); j++) {
					// computing next iteration
					int currNeighbors = getNeighbors(i, j);
					
					if (currNeighbors == 3) {
						// Dead cell comes to life
						newcells[i][j] = true;
					} else if (currNeighbors == 2 && cells[i][j]) {
						// Living cell stays alive
						newcells[i][j] = true;
					} else {
						// Cell dies
						newcells[i][j] = false;
					}
					
				}
			}
		}

	}

	public int getNeighbors(int i, int j) {
		int neighbors = 0;

		// k modifier is left (-1), middle (0), or right (1)
		// l modifier is top (-1), center (0), or bottom (1)
		for (int k = -1; k < 2; k++) {
			for (int l = -1; l < 2; l++) {
				// try catch for exceptions
				try {
					if (cells[i + k][j + l] && !(k == 0 && l == 0)) { // if k=0 and l=0 then middle
						// if true, it has a neighbor
						neighbors++;
					}
				} catch (IndexOutOfBoundsException e) {
					// System.out.println("exception");
				}
			}
		}
		return neighbors;
	}

	public void mouseClicked() {
		changeState();
	}

	public void mouseDragged() {
		changeState();
	}

	public void changeState() {
		// adding or taking away cells
		boolean state = cells[Math.round(mouseX / scale)][Math.round(mouseY / scale)];
		if (state) {
			cells[Math.round(mouseX / scale)][Math.round(mouseY / scale)] = false;
		} else {
			cells[Math.round(mouseX / scale)][Math.round(mouseY / scale)] = true;
		}

	}
}
