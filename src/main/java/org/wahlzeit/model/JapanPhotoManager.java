package org.wahlzeit.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.wahlzeit.model.persistence.ImageStorage;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.services.Persistent;

import com.google.appengine.api.images.Image;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;

public class JapanPhotoManager extends PhotoManager {

	protected static final JapanPhotoManager instance = new JapanPhotoManager();
	
	private static final Logger log = Logger.getLogger(JapanPhotoManager.class.getName());

	/**
	 *
	 */
	public JapanPhotoManager() {
		photoTagCollector = JapanPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	
	public static JapanPhotoManager getInstance() {
		return instance;
	}

}
