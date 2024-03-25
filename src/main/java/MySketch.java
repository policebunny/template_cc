import processing.core.PApplet;
import processing.core.PImage;
import processing.opengl.PShader;
import controlP5.*;


public class MySketch extends PApplet {
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
		surface.setResizable(true);

		background(100, 180, 180);
		noStroke();
		frameRate(5);



	}

	public void settings() {
		size(500, 500);

	}

	public void frameResized(int w, int h) {

	}

	public void draw(){
		background(64);
		ellipseMode(CORNER);
		if (mousePressed == true) {
			ellipse(mouseX, mouseY, 20, 20); //kreis um mauszeiger

		}
		// color c = color(100, random(180, 255), random(180, 255), random(15,150));
		// color ist kein objekt?
		// fill(c);
		ellipse(random(width), random(height), random(width / 40, width / 20) , random(width / 40, width / 20) );
		saveFrame("output/randomcirlce.png");




	}

	public void frameUpdate() {

	}
}
