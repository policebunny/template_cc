import processing.core.PApplet;
import processing.core.PImage;
import processing.opengl.PShader;
import controlP5.*;

import java.security.Key;


public class MySketch extends PApplet {
	float circler = 10;
	int seed = 0;
	float maxTrans = 0.7f; // without f makes it double
	float maxRot = 0.05f;
	int filler = 50;
	int labelcolor = 255;
	ControlP5 cp5;
	public void setup() {
		this.getSurface().setResizable(true);
		cp5 = new ControlP5(this);
		cp5.addSlider("maxTrans")
				.setPosition(10, 10)
				.setRange(0.07f, 0.7f)
				.setValue(5)
				.setColorLabel(labelcolor)
				.setSize(100, 20);
		cp5.addSlider("maxRot")
				.setPosition(10, 40)
				.setRange(0.0001f, 0.05f)
				.setValue(5)
				.setSize(100, 20);
		cp5.addSlider("filler")
				.setPosition(10,80)
				.setRange(0,255)
				.setValue(5)
				.setSize(100,20);


		ellipseMode(CORNER);
		rectMode(CORNER); //use the upper left corner as the origin of your rects
		stroke(0);
		strokeWeight(2);


		// saveFrame("pixeltest.jpg");

	}

	public void settings() {
		size(512, 970);
	}

	public void frameResized(int w, int h) {

	}

	public void draw(){
		if(mousePressed) {
			saveFrame("output-####.png");
			seed = (int)random(12345);
		}

		background(255); // white
		fill(filler);

		float border = 10; // should be 30
		float rectSize = (width - 2 * border) / 12;
		randomSeed(seed);

		translate(border, border);
		for (int row = 0; row < 24; row++) {
			for (int column = 0; column < 12; column++) {
				pushMatrix();
				translate(column * rectSize, row * rectSize);
				float weight = sin((0.003f * millis()));
				float translationFactor = weight * maxTrans;
				float rotationFactor = weight * maxRot;

				translate(translationFactor * random(-1, 1) * row, translationFactor * random(-1, 1) * row);
				rotate(rotationFactor * random(-1, 1) * row);
				rect(0, 0, rectSize, rectSize);
				popMatrix();
			}
		}

		fill(255);
		ellipse(mouseX -20, mouseY -20, 20, 20);


	}

	public void frameUpdate() {
		if(labelcolor > 1) {
			labelcolor--;
		}
	}
}
