import processing.core.PApplet;
import processing.core.PImage;
import processing.opengl.PShader;
import controlP5.*;


public class MySketch extends PApplet {
	int circler = 8;
	int[] colors = new int [7];
	int quadrantSize = width / circler;
	PImage img;
	ControlP5 cp5;
	public void setup() {
		this.getSurface().setResizable(true);
		cp5 = new ControlP5(this);
		cp5.addSlider("circler")
				.setPosition(10, 10)
				.setRange(8, 32)
				.setValue(5)
				.setSize(100, 20);
		cp5.addSlider("decay")
				.setPosition(10, 40)
				.setRange(0.001f, 0.005f)
				.setValue(5)
				.setSize(100, 20);


		// set up
		ellipseMode(CORNER);
		hint(ENABLE_STROKE_PURE);

		background(255); // white background
		int white = color(255);
		stroke(white);
		colorMode(HSB, 360, 100, 100);



		fillRed(colors); // filling the array so we can use it

		for (int x = 0; x < width; x += quadrantSize) {
			for (int y = 0; y < height; y += quadrantSize) {
				fill(chooseRandomColor(colors)); // provide a random color out of the array
				randomQuarterCircle(x, y, quadrantSize);
			}
		}
		img = get();
		// saveFrame("pixeltest.jpg");

	}

	public void settings() {
		size(500, 500);
		smooth(4);
	}

	public void frameResized(int w, int h) {

	}

	public void draw(){
		// ellipse(mouseX, mouseY, 20, 20);
		if (circler == 8) {
			image(img, 0, 0);
		} else {
			int NewQuadrantSize = width / circler;
			for (int x = 0; x < width; x += NewQuadrantSize) {
				for (int y = 0; y < height; y += NewQuadrantSize) {
					fill(chooseRandomColor(colors)); // provide a random color out of the array
					randomQuarterCircle(x, y, NewQuadrantSize);
				}
			}
		}


	}

	public int chooseRandomColor(int[] colors_) {
		return colors_[floor(random(colors_.length))];
	}

	public void randomQuarterCircle(int x, int y, int quadrantSize) {
		int quadrant = (int)random(4);
		float start = quadrant * HALF_PI;
		float stop = start + HALF_PI;
		switch(quadrant) {
			case 0:
				x = x - quadrantSize; y = y - quadrantSize;
				break;
			case 1:
				y = y - quadrantSize;
				break;
			case 3:
				x = x - quadrantSize;
				break;
		}
		arc(x, y, quadrantSize * 2, quadrantSize * 2, start, stop, PIE);

	}

	public int redcolor(int howmuch) {
		return color(340, 80, howmuch);
	}

	public int[] fillRed(int[] colors_) {
		int white = color(255);
		stroke(white);
		colorMode(HSB, 360, 100, 100);
		colors_[0] = redcolor(95); colors_[1] = redcolor(80);
		colors_[2] = redcolor(50); colors_[3] = redcolor(95);
		colors_[4] = redcolor(80); colors_[5] = redcolor(50);
		colors_[6] = white;
		return colors_;
	}

}
