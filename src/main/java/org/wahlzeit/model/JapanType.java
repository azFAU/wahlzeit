package org.wahlzeit.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.wahlzeit.services.DataObject;

public class JapanType extends DataObject {
	private String name;
	private String prefecture;
	private boolean isIsland;

    private JapanType superType;
    private Set<JapanType> subTypes;
    private Set<Japan> instances;
	
	public JapanType(String name) {
		this.name = name;
		this.prefecture = "";
		this.isIsland = false;
		
        superType = null;
        subTypes = new HashSet<>();
        instances = new HashSet<>();
	}
	
	public JapanType(String name, String prefecture, boolean isIsland) {
		this.name = name;
		this.isIsland = isIsland;
		this.prefecture = prefecture;
		
        superType = null;
        subTypes = new HashSet<>();
        instances = new HashSet<>();
	}
	
	public Japan createInstance() {
		Japan japan = new Japan(this);
		return japan;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPrefecture() {
		return this.prefecture;
	}
	
	public boolean isIsland() {
		return this.isIsland;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	
	public void setIsland(boolean isIsland) {
		this.isIsland = isIsland;
	}
	
    public boolean hasSuperType() {
        if (superType != null) {
        	return true;
        }
        return false;
    }
    
    public JapanType getSuperType() {
        return superType;
    }
    
    public void setSuperType(JapanType superType) {
    	assertValidSuperType(superType);
    	doSetSuperType(superType);
    	assertValidSuperType(this.superType);
    }
    
    private void doSetSuperType(JapanType superType) {
        if (superType != null) {
            superType.removeSubType(this);
        }

        superType.addSubType(this);
        this.superType = superType;
    }
    
    protected void addInstance(Japan japan) {
        assertValidJapan(japan);
        doAddInstance(japan);
        assertValidJapan(japan);
    }
    
    private void doAddInstance(Japan japan) {
        if (japan.getType() != this) {
            throw new IllegalArgumentException("Object given is not of the type Japan");
        }

        instances.add(japan);
    }
    
    protected void removeInstance(Japan japan) {
        assertValidJapan(japan);
        doRemoveJapan(japan);
        assertValidJapan(japan);
    }
    
    private void doRemoveJapan(Japan japan) {
        if (japan.getType() != this || !instances.contains(japan)) {
            throw new IllegalArgumentException("Object given is not of the Type Japan");
        }

        instances.remove(japan);
    }

    public Set<Japan> getInstances() {
        return new HashSet<>(instances);
    }

    public boolean hasInstance(Japan japan) {
        assertValidJapan(japan);

        if (japan.getType() == this) {
            return true;
        }

        for (JapanType japanType : subTypes) {
            if (japanType.hasInstance(japan)) {
                return true;
            }
        }

        return false;
    }

    public void addSubType(JapanType japanType) {
        assertValidSubType(japanType);
        doAddSubType(japanType);
        assertValidSubType(japanType);
    }
    
    private void doAddSubType(JapanType japanType) {
    	subTypes.add(japanType);
    }

    public void removeSubType(JapanType japanType) {
        assertValidSubType(japanType);
        doRemoveSubType(japanType);
        assertValidSubType(japanType);
    }
    
    private void doRemoveSubType(JapanType japanType) {
        subTypes.remove(japanType);
    }
    
    public Set<JapanType> getSubTypes() {
        return new HashSet<>(subTypes);
    }

    private void assertValidSubType(JapanType japanType) {
        if (japanType == null) {
            throw new IllegalArgumentException("Object not defined and therefore not eligible as subtype");
        }

        if (japanType == this) {
            throw new IllegalArgumentException("This is not a subtype");
        }
    }

    private void assertValidJapan(Japan japan) {
        if (japan == null) {
            throw new IllegalArgumentException("Object not defined");
        }
    }

    private void assertValidSuperType(JapanType japanType) {
        if (japanType == this) {
            throw new IllegalArgumentException("This is not a supertype");
        }
    }
	
	public boolean isSubtype(JapanType subType) {
        for (JapanType japanType : subTypes) {
            if (japanType.getClass() == subType.getClass()) {
                return true;
            }
        }
        return false;
	}
}
