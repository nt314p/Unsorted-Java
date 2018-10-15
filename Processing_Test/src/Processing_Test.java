
import processing.core.PApplet;

public class Processing_Test extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Processing_Test pt = new Processing_Test();
		PApplet.runSketch(new String[] { "Processing_Test" }, pt);
	}

	int screenSizeWidth = 800;
	int screenSizeHeight = 1200;

	// Speed of the ball
	double speedX = 20;
	double speedY = 30;

	// The ball's x and y
	int ballX = 10;
	int ballY = 10;

	// The ball's width and height
	int bwidth = 40;
	int bheight = 40;

	// Bounciness
	double bounce = 0.90;

	// Paddle
	double paddleX = 0.0;
	int paddleW = screenSizeWidth / 8;
	int paddleH = screenSizeWidth / 40;
	
	// ai paddle
	double aiX;
	double aiY;

	double paddleBoost = 1.3;

	// Gravity
	double gravity = 0.0;

	public void setup() {
		frameRate(60);
	}

	public void settings() {
		size(screenSizeWidth, screenSizeHeight);
	}

	public void draw() {
		background(255);
		fill(0, 255, 204); // Lovely blue
		stroke(0);
		strokeWeight(2);
		ellipse(ballX, ballY, bwidth, bheight);
		rectMode(2);

		fill(0, 255, 255);
		rect((int) paddleX, 7 * screenSizeHeight / 8, paddleW, paddleH);
		
		
		// Moving paddle
		if (mouseX < paddleW) {
			paddleX = paddleW;
		} else if (mouseX > screenSizeWidth - (paddleW)) {
			paddleX = screenSizeWidth - (paddleW);
		} else {
			paddleX = mouseX;
		}
		
		if (mouseX < paddleW) {
			paddleX = paddleW;
		} else if (mouseX > screenSizeWidth - (paddleW)) {
			paddleX = screenSizeWidth - (paddleW);
		} else {
			paddleX = mouseX;
		}
		// Horizontal X movement
		// speedX = 0.03*(mouseX-ballX);

		// Moving the ball
		ballY += speedY;
		ballX += speedX;

		// Left wall bounce
		if (ballX < (bwidth / 2) && speedX < 0) {
			ballX = (bwidth / 2);
			speedX = -bounce * speedX;
		}

		// Right wall bounce
		if (ballX > screenSizeWidth - (bwidth / 2) && speedX > 0) {
			ballX = screenSizeWidth - (bwidth / 2);
			speedX = -bounce * speedX;
		}

		// Top edge bounce (disabled for pong)
//		if (ballY < (bheight / 2) && speedY < 0) {
//			ballY = (bheight / 2);
//			speedY = speedY * -bounce;
//		}

		// Bottom edge bounce/kill
		if (ballY > screenSizeHeight) {
			ballY = screenSizeHeight / 2;// screenSizeWidth - (bheight / 2);
			ballX = screenSizeWidth / 2;
			speedY = 10;// -bounce * speedY;
			speedX = random(-10, 10);
		}

		// Top edge bounce/kill
		if (ballY < 0) {
			ballY = screenSizeHeight / 2;// screenSizeWidth - (bheight / 2);
			ballX = screenSizeWidth / 2;
			speedY = random(-2, 2)+5;// -bounce * speedY;
			speedX = random(-2, 2)+5;
		}

		// Gravity
		if (screenSizeHeight - (bheight / 2) > ballY) {
			speedY = -1 * (speedY * -1.00002 - gravity);
		}

		if (paddleX - paddleW < ballX && ballX < paddleX + paddleW) {
			if (ballY > (7 * screenSizeHeight / 8) - (bheight / 2) - (paddleH)
					&& ballY < (7 * screenSizeHeight / 8) - (bheight / 2) + (paddleH)) {
				speedY = -speedY * paddleBoost;
			}
		}
	}
}
