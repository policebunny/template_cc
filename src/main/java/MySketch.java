import processing.core.PApplet;
import processing.core.PImage;
import processing.opengl.PShader;
import controlP5.*;


public class MySketch extends PApplet {
	int circler = 16;
	int seed = 0;
	int circleSize = width / circler;
	PImage img;
	ControlP5 cp5;
	public void setup() {
		this.getSurface().setResizable(true);
		cp5 = new ControlP5(this);
		cp5.addSlider("circler")
				.setPosition(10, 10)
				.setRange(16, 64)
				.setValue(5)
				.setSize(100, 20);
		cp5.addSlider("decay")
				.setPosition(10, 40)
				.setRange(0.001f, 0.005f)
				.setValue(5)
				.setSize(100, 20);

		// saveFrame("pixeltest.jpg");

	}

	public void settings() {
		size(500, 500);

	}

	public void frameResized(int w, int h) {

	}

	public void draw(){
		// settings
		if(mousePressed) {
			seed++;
		}
		noStroke();
		background(255); // white background
		randomSeed(seed);
		fill(0);
		ellipseMode(CORNER);

		// grid for black circles
		for (int x = 0; x < width; x += circleSize) {
			for (int y = 0; y < height; y += circleSize) {
				// random shift in the range [-2 * bigCircleSize, 2 * bigCircleSize]
				float shiftX = random(-2, 2) * mouseX / circleSize;
				float shiftY = random(-2, 2) * mouseY / circleSize;
				shiftX = shiftX + x;
				shiftY = shiftY + y;
				ellipse(shiftX, shiftY, circleSize, circleSize);
			}
		}

		// grid for white circles
		int smallCircleSize = circleSize / 2;
		ellipseMode(CENTER);
		fill(255);
		for (int x = smallCircleSize; x < width; x += circleSize) {
			for (int y = smallCircleSize; y < height; y += circleSize) {
				ellipse(x, y, smallCircleSize, smallCircleSize);
			}
		}


	}

}
