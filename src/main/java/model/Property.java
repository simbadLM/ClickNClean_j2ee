package model;

public class Property {
	private int propertyId;
	private Address propertyAddress;
	private int propertySurface;
	private int ownerId;
	private String accesCode;
	private String keyBoxCode;
	private String specialInstruction;

	public Property(
	    int propertyId,
	    Address propertyAddress,
	    int propertySurface,
	    int ownerId,
	    String accesCode,
	    String keyBoxCode,
	    String specialInstruction
	) {
		this.propertyAddress = propertyAddress;
		this.propertySurface = propertySurface;
		this.accesCode = accesCode;
		this.keyBoxCode = keyBoxCode;
		this.specialInstruction = specialInstruction;
		this.ownerId = ownerId;
		this.propertyId = propertyId;
	}

	public Address getPropertyAddress() {
		return this.propertyAddress;
	}

	public int getPropertySurface() {
		return this.propertySurface;
	}

	public String getAccesCode() {
		return this.accesCode;
	}

	public String getKeyBoxCode() {
		return this.keyBoxCode;
	}

	public String getSpecialInstruction() {
		return this.specialInstruction;
	}

	public int getOwnerId() {
		return this.ownerId;
	}

	public int getPropertyId() {
		return this.propertyId;
	}

	public void setAccesCode(String accesCode) {
		this.accesCode = accesCode;
	}

	public void setKeyBoxCode(String keyBoxCode) {
		this.keyBoxCode = keyBoxCode;
	}

	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", propertyAddress=" + propertyAddress + ", propertySurface="
				+ propertySurface + ", ownerId=" + ownerId + ", accesCode=" + accesCode + ", keyBoxCode=" + keyBoxCode
				+ ", specialInstruction=" + specialInstruction + "]";
	}
	
}
