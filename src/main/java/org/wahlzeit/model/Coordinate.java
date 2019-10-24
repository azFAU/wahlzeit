package org.wahlzeit.model;

import java.lang.Math;

/*
 * This class specifies specific cartesian coordinates x, y, z
 */
public class Coordinate {
	protected double x;
	protected double y;
	protected double z;
	
	/*
	 * Constructor of coordinate object
	 * - No values given means all coordinates are set to 0
	 */
	public Coordinate () {
		x = 0;
		y = 0;
		z = 0;
	}
	
	/*
	 * Constructor of coordinate object with given coordinates
	 */
	public Coordinate (double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * @methodtype get
	 */
	public double getXValue() {
		return this.x;
	}	
	
	/**
	 * @methodtype get
	 */
	public double getYValue() {
		return this.y;
	}	
	
	/**
	 * @methodtype get
	 */
	public double getZValue() {
		return this.z;
	}
	
	/*
	 * Compares all 3 values of the two coordinate objects
	 * returns true if all values are the same
	 */
	public boolean isEqual(Coordinate coordinates) {
		boolean isEqual = false;
		
		if(this.x == coordinates.getXValue()) {
			if(this.y == coordinates.getYValue()) {
				if(this.z == coordinates.getZValue()) {
					isEqual = true;
				}
			}
		}
		
		return isEqual;
	}
	
	/*
	 * Gets distance between two coordinate objects
	 */
	public double getDistance(Coordinate coordinates) {

		double distance = 0;
		
		//Get distance between every single coordinate
		double distance_x = this.x - coordinates.getXValue();
		double distance_y = this.y - coordinates.getYValue();
		double distance_z = this.z - coordinates.getZValue();
		
		//Get distance through Pythagorean Theorem
		distance = distance_x * distance_x + distance_y * distance_y + distance_z * distance_z;
		distance = Math.sqrt(distance);
		
		return distance;
	}
}
