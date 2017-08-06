/* 
 * =============================
 * 프로그램 설명 :  NoticeBoardVO.java
 * プログラムの説明:   NoticeBoardVO.java
 * 작성자 :  오내훈　　
 * 作成者 :  オ・ネフン
 * 최초 작성일자 :　　2017-07-12　
 * 最初の作成日付　:　2017-07-12　
 * 최종 수정일 : 
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */

package com.bs.vo;

import com.bs.board.control.BoardDetailDAO;

public class NoticeBoardVO {
	private Integer no; //글번호番号
	private String writer; //작성자作成者
	private String subject; //제목タイトル
	private String content; //내용内容
	private String date; //날짜 日付
	private int flag; //글종류文章の種類

	public NoticeBoardVO() {
	}
	

	public NoticeBoardVO(String subject, String content, Integer no) {
			super();
			this.no = no;
			this.subject = subject;
			this.content = content;
	}
	
	public NoticeBoardVO(
					  String writer
					, String subject
					, String content
					, String date
					, int flag) {
		super();
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.date = date;
		this.flag = flag;
		}

	public NoticeBoardVO(Integer no
						, String writer
						, String subject
						, String content
						, String date
						, int flag) {
		
		super();
		this.no = no;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.date = date;
		this.flag = flag;
	}
	
	public NoticeBoardVO(  //생성자 오버로딩
			  String writer
			, String subject
			, String content
			, int flag) {

		super();
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.flag = flag;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return getNo() + ","+ getSubject();
	}

}
