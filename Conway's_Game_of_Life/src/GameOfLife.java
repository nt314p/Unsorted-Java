import processing.core.PApplet;

public class GameOfLife extends PApplet {

	public static void main(String[] args) {
		GameOfLife gol = new GameOfLife();
		PApplet.runSketch(new String[] { "GameOfLife" }, gol);
	}

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

	int sWidth = 400;
	int sHeight = 800;
	final int scale = 50; // the side length of each cell
	final float probability = 0.5f; // how likely a cell will spawn at the beginning
	boolean cells[][] = new boolean[sWidth / scale][sHeight / scale];
	final boolean wrap = true; // should screenwrap occur
	final int fps = 20;
	int fpsCounter = 0;
	// set tmp to cells to get glitched effects due to a shared pointer
	boolean tmp[][] = new boolean[sWidth / scale][sHeight / scale]; // cells;

	public void settings() {
//		fullScreen();
//		sWidth = displayWidth;
//		sHeight = displayHeight;
		size(sWidth, sHeight);
	}

	public void setup() {
		// surface.setResizable(true);
		frameRate(200);
		fill(255, 255, 0);
		noStroke();
		for (int i = 0; i < sWidth / scale; i++) {
			for (int j = 0; j < sHeight / scale; j++) {
				cells[i][j] = Math.random() < probability;
			}
		}
	}

	public void draw() {
		display();
		// step();
//		if (120/((float)fps) <= fpsCounter) {
//			step();
//			fpsCounter = 0;
//		}
//		fpsCounter++;
	}

	public void keyTyped() {
		step();
	}

	public void display() {
		background(100, 100, 100);

		// drawing cells
		for (int i = 0; i < (sWidth / scale); i++) {
			for (int j = 0; j < (sHeight / scale); j++) {
				if (cells[i][j]) {
					rect(i * scale, j * scale, scale, scale);
				}
			}
		}
	}

	public void step() {
		for (int i = 0; i < (sWidth / scale); i++) { // across
			for (int j = 0; j < (sHeight / scale); j++) { // down
				// computing next iteration
				int currNeighbors = getNeighbors(i, j);
				if (currNeighbors == 3) {
					tmp[i][j] = true; // Dead cell comes to life
				} else if (currNeighbors == 2 && cells[i][j]) {
					tmp[i][j] = true; // Living cell stays alive
				} else {
					tmp[i][j] = false; // Cell dies
				}
			}
		}

		// setting tmp array to the cells one
		for (int i = 0; i < (sWidth / scale); i++) {
			for (int j = 0; j < (sHeight / scale); j++) {
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
				if (wrap) {
					if (cells[(i + k + cells.length) % cells.length][(j + l + cells[0].length) % cells[0].length]
							&& !(k == 0 && l == 0)) { // if k=0 and l=0 then middle
						
						neighbors++; // if true, it has a neighbor
					}
					continue;
				}
				try {
					if (cells[i + k][j + l] && !(k == 0 && l == 0)) { // if k=0 and l=0 then middle
						neighbors++; // if true, it has a neighbor
					}
				} catch (IndexOutOfBoundsException e) {
					// no neighbor
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
