package bean;

public class MabDataReplyBean {
	int reContentId;
	int reId;
	String reContent;
	/*
	create table mab_reply(
		    reply_content_id number(6) not null,
		    reply_id number(12) unique not null,
		    reply_content varchar2(2000) not null
		    );
		 alter table mab_reply drop constraint SYS_C007105;
		insert into mab_reply values (1, mab_reply_seq.nextval, '혈막정후');
		insert into mab_reply values (1, mab_reply_seq.nextval, '우리 제발 2군 10일만 갔다오자');
	*/
	
	public int getReContentId() {
		return reContentId;
	}
	public void setReContentId(int reContentId) {
		this.reContentId = reContentId;
	}
	public int getReId() {
		return reId;
	}
	public void setReId(int reId) {
		this.reId = reId;
	}
	public String getReContent() {
		return reContent;
	}
	public void setReContent(String reContent) {
		this.reContent = reContent;
	}
	
}
