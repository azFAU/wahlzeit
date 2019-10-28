package org.wahlzeit.model;


/*
 * The location specifies the exact place a photo was taken
 */
public class Location {

	/*
	 * Constructor for empty location
	 * - Sets coordinates to 0
	 */
	private Coordinate coordinates;
	
	public Location () {
		coordinates = new Coordinate();
	}
	
	/*
	 * Constructor for Location with given coordinates
	 */
	public Location (Coordinate coordinates) {
		this.coordinates = coordinates;
	}
	
	public Coordinate getCoordinate() {
		return this.coordinates;
	}
	
	public void setCoordinate(Coordinate coordinates) {
		if (coordinates == null) {
			throw new IllegalArgumentException("Argument for coordinates shouldn't be null");
		}
		this.coordinates = coordinates;
	}

}
