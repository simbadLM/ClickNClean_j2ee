package model;

public class Review {
	int reviewId;
	String content;
	int grade;
	int userReceivingId;
	int missionId;
	
	public Review(int reviewId, String content, int grade, int userReceivingId, int missionId) {
		//super();
		this.reviewId = reviewId;
		this.content = content;
		this.grade = grade;
		this.userReceivingId = userReceivingId;
		this.missionId = missionId;
	}

	public int getId_review() {
		return this.reviewId;
	}

	public void setId_review(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getContent() {
		return this.content;
	}

	public int getGrade() {
		return this.grade;
	}

	public int getId_user() {
		return this.userReceivingId;
	}

	public int getId_mission() {
		return this.missionId;
	}
}
