package org.wahlzeit.model;

public abstract class Coordinate implements ICoordinate {
	
	public Coordinate() { }
	
	public abstract CartesianCoordinate asCartesianCoordinate();
	
	public double getCartesianDistance(ICoordinate coordinates) {
		CartesianCoordinate cartesianCoordinates = coordinates.asCartesianCoordinate();
		return doGetCartesianDistance(cartesianCoordinates);	
	}
	
	public abstract double doGetCartesianDistance(CartesianCoordinate coordinates);
	
	public abstract SphericalCoordinate asSphericalCoordinate();
	
	public double getCentralAngle(ICoordinate coordinates) {
		return doGetCentralAngle(coordinates);
	}
	
	public abstract double doGetCentralAngle(ICoordinate coordinates);
	
	public abstract boolean isEqual(ICoordinate coordinates);
}
