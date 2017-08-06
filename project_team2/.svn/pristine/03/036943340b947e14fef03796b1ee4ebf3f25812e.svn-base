/* 
 * =============================
 * 프로그램 설명 :  ClothBasicVO.java
 * プログラムの説明:   ClothBasicVO.java
 * 작성자 :  오내훈　　
 * 作成者 :  オ・ネフン
 * 최초 작성일자 :　　2017-07-12
 * 最初の作成日付　:　　2017-07-12
 * 최종 수정일 : 
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */

package com.bs.vo;

import java.util.ArrayList;

public class ClothBasicVO {
	
	private String id; //ID 
	private String productCode ;  //상품코드商品コード

	private String productName;  //상품명商品名
	private String size;			//사이즈サイズ
	private String brand;		//브랜드ブランド
	private int price;			//가격価格
	private String material;		//소재素材
	private String buyDate;	//구입일자購入日

	private String imageName;	//이미지 명イメージの名前
	private String imagePath;		//이미지 경로 イメージ経路
	private ArrayList productCodeList = null; //상품코드 리스트
	private int status; //쿼리 수행결과実行結果の値
	
	
	public ClothBasicVO() {
		super();
	}
	
	
	public ClothBasicVO(String id, String productCode, String productName, String buyDate) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.productName = productName;
		this.buyDate = buyDate;
	}

	public ClothBasicVO(ArrayList productCodeList) {
		super();
		this.productCodeList = productCodeList;
	}
	

	public ClothBasicVO(String productCode
								, String productName
								, String size
								, String brand
								, String material
								, String buyDate
								, int price) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.size = size;
		this.brand = brand;
		this.price = price;
		this.material = material;
		this.buyDate = buyDate;
	}




	public ClothBasicVO(String productCode
								, String productName
								, String size
								, int price
								, String brand
								, String material
								, String imagePath) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.size = size;
		this.brand = brand;
		this.price = price;
		this.material = material;
		this.imagePath = imagePath;
	}
	
	public ArrayList getProductCodeList() {
		return productCodeList;
	}

	public void setProductCodeList(ArrayList productCodeList) {
		this.productCodeList = productCodeList;
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}




	@Override
	public String toString() {
		return productName;
	}	

}
