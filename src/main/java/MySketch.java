import processing.core.PApplet;
import processing.core.PImage;
import processing.opengl.PShader;
import controlP5.*;


public class MySketch extends PApplet {
	int[] colors = new int[6];
	int pixelsize = 7;
	ControlP5 cp5;
	PImage invader;
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
		for (int x = 0; x <= 2; x++) {
			colors[x] = getrandomcolor(); // ersten 3 sollen random farbe sein
		}
		for (int x = 3; x <= 5; x++) {
			colors[x] = color(0); // schwarze farbe
		}
		// now columm and rows
		int center = pixelsize / 2; //
		int invadersize = width / pixelsize;
		for (int row = 0; row < pixelsize; row++) {
			for (int columm = 0; columm < pixelsize; columm++) {
				fill(chooserandomcolor(colors));
				// columm

				rect(invadersize * columm, invadersize * row, invadersize, invadersize);
				// invaderPixels - 1 - column, row
				rect(invadersize * (pixelsize - 1 - columm), invadersize * row, invadersize, invadersize);

			}
			// row..... symmetricColumnCount, row
			fill(chooserandomcolor(colors));
			if (0 != pixelsize % 2) {
				rect(invadersize * center, invadersize * row, invadersize, invadersize);
			}


		}
		invader = get();
		background(0);
		image(invader, 0, 0);

		// rect(c1,c1, width / pixelsize, width / pixelsize);

	}

	public void settings() {
		size(500, 500);
	}

	public void frameResized(int w, int h) {
	}

	public void draw(){
		image(invader, 0, 0);
		// eigentliches draw in setup für nur einmal
		// hier der fertige invader weiterhin anzeigen
	}

	public void frameUpdate() {
	}

	public int getrandomcolor() {
		int c = color(random(50,260), random(50,260), random(50,260));
		// color immer noch kein objekt, ez int
		return c;
	}

	public int chooserandomcolor(int[] colors_) {
		return colors_[floor(random(colors_.length))];
		// floor() macht ein float zu final int
	}
}
