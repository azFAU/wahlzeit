package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

public class JapanPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(JapanPhotoFactory.class.getName());
    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static JapanPhotoFactory instance = null;

    /**
     *@methodtype constructor
     */
    public JapanPhotoFactory() {
        // do nothing
    }

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize() {
        getInstance(); // drops result due to getInstance() side-effects
    }

    /**
     * Public singleton access method.
     * @methodtype get
     */
    public static synchronized JapanPhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
            setInstance(new JapanPhotoFactory());
        }

        return instance;
    }

    /**
     * Method to set the singleton instance of PhotoFactory.
     * @methodtype set
     */
    protected static synchronized void setInstance(JapanPhotoFactory JapanPhotoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize PhotoFactory twice");
        }

        instance = JapanPhotoFactory;
    }

    /**
     * @methodtype factory
     */
    @Override
    public Photo createPhoto() {
        return new JapanPhoto();
    }

    /**
     * @methodtype factory
     */
    @Override
    public Photo createPhoto(PhotoId id) {
        return new JapanPhoto(id);
    }
	
}
