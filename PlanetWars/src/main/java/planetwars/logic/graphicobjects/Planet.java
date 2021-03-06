/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetwars.logic.graphicobjects;

import planetwars.logic.GameArena;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import planetwars.ui.PlanetWarsApplication;

/**
 *
 * @author jaakkpaa
 */

public class Planet extends Shape {
	private Planet mapViewPlanet;
	private boolean conquered;

	public Planet getMapViewPlanet() {
		return mapViewPlanet;
	}
	
    public Planet(int x, int y, int size, Color color, int spaceWidth, int spaceHeight) {
		super(new Circle(x, y, size), color);
		createMapViewPlanet(x, y, size, color, spaceWidth, spaceHeight);
	}
	
    public Planet(int x, int y, int size, Color color, boolean mapViewPlanet) {
		super(new Circle(x, y, size), color);
	}

	/**
	 * Creates a planet symbol in the map view.
	 * @param x
	 * @param y
	 * @param size
	 * @param color
	 * @param spaceWidth
	 * @param spaceHeight 
	 */
	private void createMapViewPlanet(double x, double y, int size, Color color, int spaceWidth, int spaceHeight) {
		mapViewPlanet = new Planet((int) Math.round(x * (1.0 * PlanetWarsApplication.mapWidth / 
				spaceWidth)), 
				(int) Math.round(y * (1.0 * PlanetWarsApplication.mapHeight /
					spaceHeight)), size / 10, color, true);
	}

	public void setConquered(boolean conquered) {
		this.conquered = true;
	}

	public boolean isConquered() {
		return conquered;
	}
}
