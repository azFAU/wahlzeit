package org.wahlzeit.model;


/*
 * The location specifies the exact place a photo was taken
 */
public class Location {

	/*
	 * Constructor for empty location
	 * - Sets coordinates to 0
	 */
	protected Coordinate coordinates;
	
	public Location () {
		coordinates = new Coordinate();
	}
	
	/*
	 * Constructor for Location with given coordinates
	 */
	public Location (Coordinate coordinates) {
		this.coordinates = coordinates;
	}

}
