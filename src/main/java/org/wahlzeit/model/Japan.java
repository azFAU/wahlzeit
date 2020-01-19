package org.wahlzeit.model;

public class Japan {
	private int id;
	private JapanManager japanManager;
	protected JapanType japanType = null;
	
	public Japan(JapanType type) {
		this.japanManager = JapanManager.getInstance();
		this.id = japanManager.getIdOfNextElement();
		this.japanType = type;
	}
	
	public int getId() {
		return this.id;
	}
	
	public JapanType getType() {
		return this.japanType;
	}
}
