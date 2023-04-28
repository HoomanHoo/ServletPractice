package bean;

import java.sql.Timestamp;

public class MabDataPostBean {
	private String postId;
	private int postNum;
	private String postSubject;
	private Timestamp postWriteDate;
	private int postReadCount;
	private int postRef;
	private int postRefStep;
	private int postRefLevel;
	private String postContent;
	private String ip;
	/*
	 * post_id varchar2(15) constraint mab_post_fk references mab_member(id),
    post_num number(6) unique not null,
    post_subject varchar2(200) not null,
    post_write_date date default sysdate,
    post_readcount number(6) default 0,
    post_ref number(6) not null,
    post_ref_step number(6) not null,
    post_ref_level number(6) not null,
    post_content varchar2(4000) not null,
    ip varchar2(20) not null
	
	 */
	
	public int getPostNum() {
		return postNum;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public String getPostSubject() {
		return postSubject;
	}
	public void setPostSubject(String postSubject) {
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
