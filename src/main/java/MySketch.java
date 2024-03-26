import processing.core.PApplet;
import processing.core.PImage;
import processing.opengl.PShader;
import controlP5.*;


public class MySketch extends PApplet {

	int pixelsize = 7;
	ControlP5 cp5;
	public void setup() {
		this.getSurface().setResizable(true);
		cp5 = new ControlP5(this);
		cp5.addSlider("pixelsize")
				.setPosition(10, 10)
				.setRange(7, 10)
				.setValue(5)
				.setSize(100, 20);
		cp5.addSlider("decay")
				.setPosition(10, 40)
				.setRange(0.001f, 0.005f)
				.setValue(5)
				.setSize(100, 20);



		ellipseMode(CORNER);
		noStroke();   //kreis soll keinen rand haben
		background(64);
		// brauche farbe
		int c1 = color(100, random(180, 255), random(180, 255), random(15,150));
		int c2 = color(100, random(180,255), random(180,255), random(15,150));



	}

	public void settings() {
		size(500, 500);
	}

	public void frameResized(int w, int h) {

	}

	public void draw(){

		ellipse(mouseX, mouseY, 20, 20);
		// eigentliches draw in setup für nur einmal

	}

	public void frameUpdate() {

	}
}
