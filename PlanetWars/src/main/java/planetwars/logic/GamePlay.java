/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetwars.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import planetwars.database.PlayerDao;
import planetwars.logic.graphicobjects.MapLocator;
import planetwars.logic.graphicobjects.Ship;
import planetwars.logic.graphicobjects.Torpedo;
import static planetwars.ui.PlanetWarsApplication.screenHeight;
import static planetwars.ui.PlanetWarsApplication.screenWidth;

/**
 * The class handles all information regarding the current game: the player's ship,
 * the torpedos, the map locator, the points, the time at the beginning and the time
 * left, and planets left.
 * @author jaakkpaa
 */
public class GamePlay {
	private GameArenaInterface gameArena;	
	
	private int points;
	private int timePerLevel = 60;
	private final double accelerationFactor = 0.005;
	private final double brakingFactor = 0.001;
	private double timeLeft;
	private long startTime = 0;
	private int planetsLeft;
	private long previousTorpedoFired;
	
	/**
	 * Sets the settings for the current game.
	 *
	 * @param screenWidth The width of the screen in pixels.
	 * @param screenHeight The height of the screen in pixels.
	 * @param gameArena The game arena created for the game.
	 * @param points The points in the current game.
	 */
	public GamePlay(int screenWidth, int screenHeight, GameArenaInterface gameArena, int points) {
		this.gameArena = gameArena;
		this.planetsLeft = gameArena.getPlanets().size();
		this.points = points;
		this.timeLeft = timePerLevel;
	}
	
	public int getTimePerLevel() {
		return timePerLevel;
	}

	public double getAccelerationFactor() {
		return accelerationFactor;
	}

	public double getBrakingFactor() {
		return brakingFactor;
	}

	public void setPreviousTorpedoFired(long previousTorpedoFired) {
		this.previousTorpedoFired = previousTorpedoFired;
	}

	public long getPreviousTorpedoFired() {
		return previousTorpedoFired;
	}

	public void setTimeLeft(double timeLeft) {
		this.timeLeft = timeLeft;
	}

	public double getTimeLeft() {
		return timeLeft;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}

	public void setPlanetsLeft(int planetsLeft) {
		this.planetsLeft = planetsLeft;
	}

	public int getPlanetsLeft() {
		return planetsLeft;
	}
}

