package org.wahlzeit.model;

public interface ICoordinate {
	
	public CartesianCoordinate asCartesianCoordinate();
	public double getCartesianDistance(ICoordinate coordinates);
	public SphericalCoordinate asSphericalCoordinate();
	public double getCentralAngle(ICoordinate coordinates);
	public boolean isEqual(ICoordinate coordinates);

}
