import processing.core.PApplet;
import processing.core.PImage;
import processing.opengl.PShader;
import controlP5.*;


public class MySketch extends PApplet {
	int[] colors = new int[6];
	int pixelsize = 7;
	ControlP5 cp5;
	public void setup() {
		this.getSurface().setResizable(true);
		cp5 = new ControlP5(this);
		cp5.addSlider("circler")
				.setPosition(10, 10)
				.setRange(7, 10)
				.setValue(5)
				.setSize(100, 20);
		cp5.addSlider("decay")
				.setPosition(10, 40)
				.setRange(0.001f, 0.005f)
				.setValue(5)
				.setSize(100, 20);


		background(0);
		noStroke();   //kreis soll keinen rand haben
		frameRate(1);

		// rect(c1,c1, width / pixelsize, width / pixelsize);

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

	public int getrandomcolor() {
		int c = color(random(50,260), random(50,260), random(50,260));
		return c;
	}

	public int chooserandomcolor(int[] colors_) {
		return colors_[floor(random(colors_.length))];
	}
}
