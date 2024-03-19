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


		// saveFrame("pixeltest.jpg");

	}

	public void settings() {
		size(500, 500);
	}

	public void frameResized(int w, int h) {

	}

	public void draw(){
		background(64);
		ellipse(mouseX, mouseY, 20, 20);


		float circleSize = circler;
		for (int x = 0; x < width; x += circleSize) {
			for (int y = -47; y < height; y += circleSize) {
				fill(img.get(x, max(y,0)));
				ellipse(x, y, circleSize, circleSize); //circle(x,y,circleSize) ist vom import
				//benutze ellipse stattdessen, aber input 4 variablen ez circlesizecirclesize
			}
			circleSize *= 0.964;
			circleSize = max(circleSize, 1);
		}
	}

	public void frameUpdate() {

	}
}
