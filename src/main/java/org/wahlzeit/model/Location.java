package org.wahlzeit.model;


/*
 * The location specifies the exact place a photo was taken
 */
public class Location {

	/*
	 * Constructor for empty location
	 * - Sets coordinates to 0
	 */
	private ICoordinate coordinates;
	
	public Location () {
		coordinates = new CartesianCoordinate();
	}
	
	/*
	 * Constructor for Location with given coordinates
	 */
	public Location (ICoordinate coordinates) {
		this.coordinates = coordinates;
	}
	
	public ICoordinate getCoordinate() {
		return this.coordinates;
	}
	
	public void setCoordinate(ICoordinate coordinates) {
		
		if (coordinates == null) {
			throw new IllegalArgumentException("Argument for coordinates shouldn't be null");
		}
		
		this.coordinates = coordinates;
	}

}
