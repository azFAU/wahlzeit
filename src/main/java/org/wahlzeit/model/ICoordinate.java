package org.wahlzeit.model;

import org.joda.time.IllegalFieldValueException;

public interface ICoordinate {
	
	public CartesianCoordinate asCartesianCoordinate() throws IllegalCoordinateException;
	public double getCartesianDistance(ICoordinate coordinates) throws Exception;
	public SphericalCoordinate asSphericalCoordinate() throws IllegalCoordinateException;
	public double getCentralAngle(ICoordinate coordinates) throws Exception;
	public boolean isEqual(ICoordinate coordinates);

}
