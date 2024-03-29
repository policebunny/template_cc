import processing.core.PApplet;
import processing.core.PImage;
import processing.opengl.PShader;
import controlP5.*;


public class MySketch extends PApplet {

	int pixelsize = 7;
	ControlP5 cp5;
	PImage invader;
	int bordersize = 7;
	int center = pixelsize / 2;
	int newsize = 5;
	int invadersize = pixelsize * newsize;
	int cellsize = invadersize + 2 * bordersize;
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
		// noLoop();
		frameRate(5);
		redraw();

		// FillColorArray(colors); // for schleifen in methode gepackt
		// makeInvader(colors); // for schleifen in methode gepackt
		// invader = get();
		// background(0);
		// image(invader, 0, 0);

		// rect(c1,c1, width / pixelsize, width / pixelsize);

	}

	public void settings() {
		size(500, 500);
		noSmooth();
	}

	public void frameResized(int w, int h) {
	}

	public void draw(){
		// image(invader, 0, 0);

		if(mousePressed) {


			background(0);
			for (int x = bordersize; x < width; x = x + cellsize) {
				for (int y = bordersize; y < height; y = y + cellsize) {
					PImage spaceInvader = makeInvader();
					image(spaceInvader, x, y, invadersize, invadersize);
				}
			}
		}

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

	public int[] FillColorArray(int[] colors_) {
		for (int x = 0; x <= 2; x++) {
			colors_[x] = getrandomcolor(); // ersten 3 sollen random farbe sein
		}
		for (int x = 3; x <= 5; x++) {
			colors_[x] = color(0, 0, 0, 0); // statt schwarz nun transparent
		}
		return colors_;
	}

	public PImage makeInvader() {

		PImage imgPixelVader = createImage(pixelsize, pixelsize, ARGB);
		int[] colors = new int[6];
		FillColorArray(colors);

		// brauche array hier zum ausfüllen
		for (int row = 0; row < pixelsize; row++) {
			for (int columm = 0; columm < center; columm++) {
				// fill(chooserandomcolor(colors));
				final int cc = chooserandomcolor(colors);
				// rect(invadersize * columm, invadersize * row, invadersize, invadersize);
				// invaderPixels - 1 - column, row
				imgPixelVader.set(columm, row, cc);

				// rect(invadersize * (pixelsize - 1 - columm), invadersize * row, invadersize, invadersize);
				imgPixelVader.set(pixelsize - 1 - columm, row, cc);

				/*
				imgInvader.set(column, row, c);
      imgInvader.set(invaderPixels - 1 - column, row, c);

				 */
			}
			// row..... symmetricColumnCount, row
			fill(chooserandomcolor(colors));
			if (0 != pixelsize % 2) {
				// rect(invadersize * center, invadersize * row, invadersize, invadersize);
				imgPixelVader.set(center, row, chooserandomcolor(colors));
			}

		}
	return imgPixelVader;
	}

}
