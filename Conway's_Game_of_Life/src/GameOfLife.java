import processing.core.PApplet;

public class GameOfLife extends PApplet {

	public static void main(String[] args) {
		GameOfLife gol = new GameOfLife();
        PApplet.runSketch(new String[]{"GameOfLife"}, gol);
	}

	// ADD MORE DEATH

	/*
	 * CONWAY'S GAME OF LIFE Rules:
	 * 
	 * 1. Any live cell with fewer than two live neighbors dies (under population).
	 * 2. Any live cell with more than three live neighbors dies (over population).
	 * 3. Any live cell with two or three live neighbors lives, unchanged, to the
	 * next generation. 
	 * 4. Any dead cell with exactly three live neighbors will come
	 * to life.
	 * 
	 */

	int sWidth = 2160;
	int sHeight = 1440;
	int scale = 10; // the side length of each cell

	boolean cells[][] = new boolean[sWidth / scale][sHeight / scale];
	
	// set tmp to cells to get glitchy
	boolean tmp[][] = new boolean[sWidth / scale][sHeight / scale]; // cells;

	public void settings() {
		fullScreen();
		//size(sWidth, sHeight);
	}

	public void setup() {
		frameRate(40);
		fill(255, 255, 0);
		
		for (int i = 0; i < sWidth/scale; i++) {
			for (int j = 0; j < sHeight/scale; j++) {
				cells[i][j] = Math.random() < 0.5;
			}
		}
	}

	public void draw() {
		
		display();
		//step();
	}

	public void keyTyped() {
		step();
	}

	public void display() {
		// background
		background(100, 100, 100);

		// drawing cells
		for (int i = 0; i < (width / scale); i++) {
			for (int j = 0; j < (height / scale); j++) {
				if (cells[i][j]) {
					rect(i * scale, j * scale, scale, scale);
				}
			}
		}
	}

	public void step() {
		// across
		for (int i = 0; i < (width / scale); i++) {
			// down
			for (int j = 0; j < (height / scale); j++) {
				// computing next iteration
				int currNeighbors = getNeighbors(i, j);
				if (currNeighbors == 3) {
					// Dead cell comes to life
					tmp[i][j] = true;
					//
				} else if (currNeighbors == 2 && cells[i][j]) {
					// Living cell stays alive
					tmp[i][j] = true;
				} else {
					// Cell dies
					tmp[i][j] = false;
				}
			}
		}

		// setting tmp array to the cells one
		for (int i = 0; i < (width / scale); i++) {
			for (int j = 0; j < (height / scale); j++) {
				cells[i][j] = tmp[i][j];
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
		// try catch for out of bounds mouse inputs
		try {
			// adding or taking away cells
			boolean state = cells[Math.round(mouseX / scale)][Math.round(mouseY / scale)];
			if (state) {
				cells[Math.round(mouseX / scale)][Math.round(mouseY / scale)] = false;
			} else {
				cells[Math.round(mouseX / scale)][Math.round(mouseY / scale)] = true;
			}
		} catch (IndexOutOfBoundsException e) {

		}
	}
}
