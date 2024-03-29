import processing.core.PApplet;
import processing.core.PImage;
import processing.opengl.PShader;
import controlP5.*;


public class MySketch extends PApplet {
	public PImage img = loadImage("https://i.redd.it/tbw9xtpzbcf61.jpg");
	float circler = 10;
	ControlP5 cp5;
	public void setup() {
		this.getSurface().setResizable(true);
		cp5 = new ControlP5(this);
		cp5.addSlider("circler")
				.setPosition(10, 10)
				.setRange(1, 100)
				.setValue(5)
				.setSize(100, 20);
		cp5.addSlider("decay")
				.setPosition(10, 40)
				.setRange(0.001f, 0.005f)
				.setValue(5)
				.setSize(100, 20);


		img.resize(width, height);   //public ez
		ellipseMode(CORNER);
		noStroke();   //kreis soll keinen rand haben
		background(0);

		int[] colors = new int [7];
		fillRed(colors);


		// saveFrame("pixeltest.jpg");

	}

	public void settings() {
		size(500, 500);
	}

	public void frameResized(int w, int h) {

	}

	public void draw(){
		ellipse(mouseX, mouseY, 20, 20);

	}

	public void frameUpdate() {

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
