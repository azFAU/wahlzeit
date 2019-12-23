package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.List;

import PatternInstance.*;

@PatternInstance(
		patternName = "Template Method",
		participants = {
				"AbstractCoordinate",
				"CartesianCoordinate",
				"SphericalCoordinate"
		}
)

public abstract class AbstractCoordinate implements ICoordinate {
	
	static List<AbstractCoordinate> listOfCoordinates = new ArrayList<AbstractCoordinate>();
	
	public AbstractCoordinate() { }
	
	public abstract CartesianCoordinate asCartesianCoordinate() throws IllegalCoordinateException;
	
	public double getCartesianDistance(ICoordinate coordinates) throws IllegalCoordinateException {
		try {
			double cartesianDistance;
			
			//Preconditions
			assertClassInvariants();
			assertNotNull(coordinates);
	
			CartesianCoordinate cartesianCoordinates = coordinates.asCartesianCoordinate();
			cartesianDistance = this.doGetCartesianDistance(cartesianCoordinates);
			
			//Postcondition
			assertClassInvariants();
			
			return cartesianDistance;	
		}catch (IllegalCoordinateException e) {
			throw new IllegalCoordinateException("Error in getCartesianDistance", e.getInvalidClass(), e.getInvalidValue());
		}
	}
	
	protected abstract double doGetCartesianDistance(CartesianCoordinate coordinates);
	
	public abstract SphericalCoordinate asSphericalCoordinate() throws IllegalCoordinateException;
	
	public double getCentralAngle(ICoordinate coordinates) throws IllegalCoordinateException {
		try {
			double centralAngle;
			
			//Preconditions
			assertClassInvariants();
			assertNotNull(coordinates);
			
			centralAngle = doGetCentralAngle(coordinates);
			
			assertClassInvariants();
			
			return centralAngle;	
		} catch (IllegalCoordinateException e) {
			throw new IllegalCoordinateException("Error in getCentralAngle", e.getInvalidClass(), e.getInvalidValue());
		}
	}
	
	protected abstract double doGetCentralAngle(ICoordinate coordinates);
	
	public abstract boolean isEqual(ICoordinate coordinates);
	
	protected abstract void assertClassInvariants();
	
	protected void assertNotNull(Object obj) {
		if(obj == null) {
			throw new IllegalArgumentException("Argument cannot be null!");
		}
	}
}