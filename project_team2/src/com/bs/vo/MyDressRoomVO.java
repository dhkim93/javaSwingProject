/* 
 * =============================
 * 프로그램 설명 :  MyDressRoomVO.java
 * プログラムの説明:   MyDressRoomVO.java
 * 작성자 :  오내훈　　
 * 作成者 : オ・ネフン
 * 최초 작성일자 :　　 2017-07-12
 * 最初の作成日付　:　　 2017-07-12
 * 최종 수정일 : 
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */

package com.bs.vo;

import java.util.HashMap;
import java.util.Map;

public class MyDressRoomVO {
	
	private String id = null; //아이디ハンドルネーム
	private String productCode = null; //제품코드 製品コード
	private String productName = null; //제품명製品名
	private String buyDate = null; //구매일자購買付
	private String imageName = null; //이미지 이름イメージの名前
	private String imagePath= null; //이미지 경로イメージ経路
	private int gender; //성별性別
	private int xAixs;  //이미지 x 축x軸
	private int yAixs;  //이미지 y 축y軸
	private int balance;  //残高
	
	public MyDressRoomVO() {
	}
	
	public MyDressRoomVO(int gender, int balance) {
		super();
		this.gender = gender;
		this.balance = balance;
		
		
	}



	public MyDressRoomVO(String productCode) {
		this.productCode = productCode;
	}
	
	public MyDressRoomVO(String imageName, String imagePath, int xAixs, int yAixs, String buyDate) {
		this.imageName = imageName;
		this.imagePath = imagePath;
		this.buyDate = buyDate;
		this.xAixs = xAixs;
		this.yAixs = yAixs;
	}
	//AdminPageDAO에서 사용
	public MyDressRoomVO(String imageName, String imagePath, int xAixs,
			int yAixs) {
		super();
		this.imageName = imageName;
		this.imagePath = imagePath;
		this.xAixs = xAixs;
		this.yAixs = yAixs;
	}

	public MyDressRoomVO(String id, String productCode, String productName, String buyDate, int balance) {
		this.id = id;
		this.productCode = productCode;
		this.productName = productName;
		this.buyDate = buyDate;
		this.balance = balance;
	}

	public String getImageName() {
		return imageName;
	}
	

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public int getxAixs() {
		return xAixs;
	}

	public void setxAixs(int xAixs) {
		this.xAixs = xAixs;
	}

	public int getyAixs() {
		return yAixs;
	}

	public void setyAixs(int yAixs) {
		this.yAixs = yAixs;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return productCode; 
	}
	
}
