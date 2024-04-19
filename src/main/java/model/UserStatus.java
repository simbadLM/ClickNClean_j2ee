package model;

public enum UserStatus {
	ADMIN(1),
	CLEANER(2),
	OWNER(3),
	UNKNOWN(4);
	private final int status;

	private UserStatus(int status) {
		this.status = status;
	}

	public static UserStatus fromInt(int status) throws Exception{
		switch (status) {
		case 1:
			return UserStatus.ADMIN;
		case 2:
			return UserStatus.CLEANER;
		case 3:
			return UserStatus.OWNER;
		case 4:
			return UserStatus.UNKNOWN;
		default:
			throw new Exception("Given int status could not be converted into UserStatus: " + status);
		}
	}

	public int asInt() {
		return this.status;
	}
}


