package bean;

import java.sql.Timestamp;

public class MabDataPostBean {
	private int postNum;
	private int postSubject;
	private Timestamp postWriteDate;
	private int postReadCount;
	private int postRef;
	private int postRefStep;
	private int postRefLevel;
	private String postContent;
	private String ip;
	
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public int getPostSubject() {
		return postSubject;
	}
	public void setPostSubject(int postSubject) {
		this.postSubject = postSubject;
	}
	public Timestamp getPostWriteDate() {
		return postWriteDate;
	}
	public void setPostWriteDate(Timestamp postWriteDate) {
		this.postWriteDate = postWriteDate;
	}
	public int getPostReadCount() {
		return postReadCount;
	}
	public void setPostReadCount(int postReadCount) {
		this.postReadCount = postReadCount;
	}
	public int getPostRef() {
		return postRef;
	}
	public void setPostRef(int postRef) {
		this.postRef = postRef;
	}
	public int getPostRefStep() {
		return postRefStep;
	}
	public void setPostRefStep(int postRefStep) {
		this.postRefStep = postRefStep;
	}
	public int getPostRefLevel() {
		return postRefLevel;
	}
	public void setPostRefLevel(int postRefLevel) {
		this.postRefLevel = postRefLevel;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
