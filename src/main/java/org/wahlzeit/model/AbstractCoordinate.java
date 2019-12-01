package org.wahlzeit.model;

public abstract class AbstractCoordinate implements ICoordinate {
	
	public AbstractCoordinate() { }
	
	public abstract CartesianCoordinate asCartesianCoordinate();
	
	public double getCartesianDistance(ICoordinate coordinates) {
		double cartesianDistance;
		
		//Preconditions
		assertClassInvariants();
		assertNotNull(coordinates);

		CartesianCoordinate cartesianCoordinates = coordinates.asCartesianCoordinate();
		cartesianDistance = this.doGetCartesianDistance(cartesianCoordinates);
		
		//Postcondition
		assertClassInvariants();
		
		return cartesianDistance;	
	}
	
	public abstract double doGetCartesianDistance(CartesianCoordinate coordinates);
	
	public abstract SphericalCoordinate asSphericalCoordinate();
	
	public double getCentralAngle(ICoordinate coordinates) {
		double centralAngle;
		
		//Preconditions
		assertClassInvariants();
		assertNotNull(coordinates);
		
		centralAngle = doGetCentralAngle(coordinates);
		
		assertClassInvariants();
		
		return centralAngle;
	}
	
	public abstract double doGetCentralAngle(ICoordinate coordinates);
	
	public abstract boolean isEqual(ICoordinate coordinates);
	
	protected abstract void assertClassInvariants();
	
	protected void assertNotNull(Object obj) {
		if(obj == null) {
			throw new IllegalArgumentException("Argument cannot be null!");
		}
	}
}