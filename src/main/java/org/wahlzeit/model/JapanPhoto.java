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
    }

    /**
     * @methodtype get
     */
    public String getPrefecture() {
    	String prefecture = new String(this.prefecture);
        return prefecture;
    }

    /**
     * @methodtype set
     */
    public void setprefecture(String prefecture) {
        this.prefecture = new String(prefecture);
    }

    /**
     * @methodtype get
     */
    public String getPOI() {
    	String poi = new String(this.poi);
        return poi;
    }

    /**
     * @methodtype set
     */
    public void setPOI(String poi) {
        this.poi = new String(poi);
    }

}
