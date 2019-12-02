package org.wahlzeit.model;

public class JapanPhoto extends Photo {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prefecture;
    private String poi;	//place of interest

    /**
     * @methodtype constructor
     */
    public JapanPhoto() {
        super();
    }

    /**
     * @methodtype constructor
     */
    public JapanPhoto(PhotoId myId) {    	
        super(myId);
        
    	if(myId == null) {
    		throw new NullPointerException();
    	}
    }

    /**
     * @methodtype get
     */
    public String getPrefecture() {
    	if(this.prefecture == null) {
    		throw new NullPointerException();
    	}
    	
    	String prefecture = new String(this.prefecture);
        return prefecture;
    }

    /**
     * @methodtype set
     */
    public void setprefecture(String prefecture) {
    	if(prefecture == null) {
    		throw new NullPointerException();
    	}
        this.prefecture = new String(prefecture);
    }

    /**
     * @methodtype get
     */
    public String getPOI() {
    	if(this.poi == null) {
    		throw new NullPointerException();
    	}
    	
    	String poi = new String(this.poi);
        return poi;
    }

    /**
     * @methodtype set
     */
    public void setPOI(String poi) {
    	if(poi == null) {
    		throw new NullPointerException();
    	}
    	
        this.poi = new String(poi);
    }

}
