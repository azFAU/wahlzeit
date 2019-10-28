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
	
	/**
	 * @methodtype set
	 */
	public void setXValue(double x) {
		this.x = x;
	}	
	
	/**
	 * @methodtype set
	 */
	public void setYValue(double y) {
		this.y = y;
	}	
	
	/**
	 * @methodtype set
	 */
	public void setZValue(double z) {
		this.z = z;
	}
	
	/*
	 * Compares all 3 values of the two coordinate objects
	 * returns true if all values are the same
	 */
	public boolean isEqual(Coordinate coordinates) {
		return this.equals(coordinates);
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}
}
