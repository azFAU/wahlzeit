package org.wahlzeit.model;
import java.util.HashMap;

public class JapanManager {

	//Instance Ids for Japan
	private static int nextId = 0;
	
	//The single JapanManager to exist
	private static final JapanManager managerInstance = new JapanManager();
	
	//The HashMaps containing all Japan objects and all JapanTypes
	private HashMap<Integer, Japan> japanObjects;
	private HashMap<String, JapanType> japanTypes;
	
	//private constructor to ensure the Singleton
	private JapanManager() {
		japanObjects = new HashMap<Integer, Japan>();
		japanTypes = new HashMap<String, JapanType>();
	}
	
	//return the single instance of JapanManager
	public synchronized static JapanManager getInstance() {
		return managerInstance;
	}
	
	public Japan createJapanInstance(String type) {
		assertIsValidJapanType(type);
		JapanType japanType = getJapanType(type);
		Japan result = japanType.createInstance();
		updateId();
		japanObjects.put(result.getId(), result);
		return result;
	}
	
	public void addJapanType(JapanType type) {
		japanTypes.put(type.getName(), type);
		
	}
	
	//return the next free Id for new japan instances
	public int getIdOfNextElement() {
		return nextId + 1;
	}
	
	//Update after newly added instances
	public void updateId() {
		nextId++;
	}
	
	public JapanType getJapanType(String type) {
		return japanTypes.get(type);
	}
	
	public Japan getJapanInstance(int Id) {
		return japanObjects.get(Id);
	}
	
	public void assertIsValidJapanType(String type) {
		if(japanTypes.get(type) == null) {
			throw new IllegalArgumentException("Type not existent");
		}
	}
}
