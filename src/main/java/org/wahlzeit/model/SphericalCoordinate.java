package org.wahlzeit.model;

public class SphericalCoordinate extends AbstractCoordinate {

	protected double phi;
	protected double theta;
	protected double radius;

	/*
	 * Constructor of coordinate object
	 * - No values given means all coordinates are set to 0
	 */
	public SphericalCoordinate () {
		phi = 0;
		theta = 0;
		radius = 0;
	}

	/*
	 * Constructor of coordinate object with given coordinates
	 */
	public SphericalCoordinate (double phi, double theta, double radius) {
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}

	/**
	 * @methodtype get
	 */
	public double getPhi() {
		//Preconditions
		assertClassInvariants();
		
		return this.phi;
	}	

	/**
	 * @methodtype get
	 */
	public double getTheta() {
		//Preconditions
		assertClassInvariants();
		
		return this.theta;
	}

	/**
	 * @methodtype get
	 */
	public double getRadius() {
		//Preconditions
		assertClassInvariants();
		
		return this.radius;
	}	

	/**
	 * @methodtype set
	 */
	public void setPhi(double phi) {
		//Preconditions
		assertClassInvariants();
		
		this.phi = phi;
	}		

	/**
	 * @methodtype set
	 */
	public void setTheta(double theta) {
		//Preconditions
		assertClassInvariants();
		
		this.theta = theta;
	}

	public double calculateRadius() {
		
		double radius;
		
		//Preconditions
		assertClassInvariants();
		assertNotNull(this);
		
		radius = doCalculateRadius();
		
		//Postconditions
		assertClassInvariants();
		
		return radius;
	}

	/*
	 * Uses the CartesianCoordinate's method to calculate the radius
	 */
	public double doCalculateRadius() {
		CartesianCoordinate coordinates = this.asCartesianCoordinate();
		return coordinates.calculatePythagorianTheorem();
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {

		//Preconditions
		assertClassInvariants();
		assertNotNull(this);

		double x = this.getRadius() * Math.cos(this.getTheta()) * Math.sin(this.getPhi());
		double y = this.getRadius() * Math.sin(this.getTheta()) * Math.sin(this.getPhi());
		double z = this.getRadius() * Math.cos(this.getPhi());
		CartesianCoordinate cartCoor = new CartesianCoordinate(x,y,z);

		//Preconditions
		assertClassInvariants();

		return cartCoor;
	}

	@Override
	public double doGetCartesianDistance(CartesianCoordinate coordinates) {
		return coordinates.doGetCartesianDistance(this.asCartesianCoordinate());
	}

	@Override
	public SphericalCoordinate asSphericalCoordinate() {

		//Preconditions
		assertClassInvariants();
		
		return this;
	}

	@Override
	public double doGetCentralAngle(ICoordinate coordinates) {

		CartesianCoordinate thisCoordinate = this.asCartesianCoordinate();
		double cartesianSubtraction = thisCoordinate.doGetCartesianDistance(coordinates.asCartesianCoordinate());
		double centralAngle = 2 * Math.asin(cartesianSubtraction / 2);

		return centralAngle;
	}

	@Override
	public boolean isEqual(ICoordinate coordinates) {
		return equals(coordinates.asSphericalCoordinate());
	}

	@Override
	public int hashCode() {

		//Preconditions
		assertClassInvariants();
		
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(phi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(theta);
		result = prime * result + (int) (temp ^ (temp >>> 32));

		//Postconditions
		assertClassInvariants();
		
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
		SphericalCoordinate other = (SphericalCoordinate) obj;
		if (Double.doubleToLongBits(phi) != Double.doubleToLongBits(other.phi))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		if (Double.doubleToLongBits(theta) != Double.doubleToLongBits(other.theta))
			return false;
		return true;
	}
	
	@Override
	protected void assertClassInvariants() {

		assertNotNull(this.phi);
		assertNotNull(this.theta);
		assertNotNull(this.radius);
		
		
		if(Double.isNaN(this.phi)) {
			throw new IllegalStateException("y is NaN!");
		}
		if(Double.isNaN(this.theta)) {
			throw new IllegalStateException("y is NaN!");
		}
		if(Double.isNaN(this.radius)) {
			throw new IllegalStateException("z is NaN!");
		}
		
	}
}