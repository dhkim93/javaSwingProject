/* 
 * =============================
 * 프로그램 설명 : CartVO.java
 * プログラムの説明:
 * 작성자 : 김덕현　　
 * 作成者 :  キム・ドクヒョン
 * 최초 작성일자 :　　2017-07-12
 * 最初の作成日付　:　　2017-07-12
 * 최종 수정일 : 　
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */

package com.bs.vo;

public class CartVO {
	private String id = null; //아이디ハンドルネーム
	private String productName = null; //상품명 商品名
	private String productCode = null; //상품코드商品コード
	private String size = null; //사이즈サイズ
	private String brand = null; //브랜드ブランド
	private String material = null; //소재素材
	private String price = null; //가격価格
	private String imageName = null; //이미지 이름イメージの名前
	private String imagePath = null; //이미지 경로イメージ経路
	private int status; //쿼리 실행결과값実行結果の値


	private int sum = 0;

	public CartVO() {
	}
	//조인을 위한 생성자
	public CartVO(String id, String productCode, String productName,
			String size, String price, String brand, String material,String imagePath) {
		
		this.id = id;
		this.productName = productName;
		this.productCode = productCode;
		this.size = size;
		this.brand = brand;
		this.material = material;
		this.price = price;
		this.imagePath = imagePath;
	}
	//삭제를 위한 생성자
	public CartVO(String id, String productCode, String productName,
			String size, String price, String brand, String material) {
		
		this.id = id;
		this.productName = productName;
		this.productCode = productCode;
		this.size = size;
		this.brand = brand;
		this.material = material;
		this.price = price;
	}

	public CartVO(String imageName, String imagePath) {
		
		this.imageName = imageName;
		this.imagePath = imagePath;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return getId() + "  ,  " + getProductCode()+"  ,  "+getProductName()+"  ,  "+getSize()+"  ,  "+getPrice()+"  ,  "+getBrand()+"  ,  "+getMaterial()+"  ,  "+getImagePath();
	}

}
