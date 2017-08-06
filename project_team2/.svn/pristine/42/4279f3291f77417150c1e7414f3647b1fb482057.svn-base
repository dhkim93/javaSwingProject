/* 
 * =============================
 * 프로그램 설명 : AdminPage VO
 * プログラムの説明: AdminPage VO
 * 작성자 : 오내훈
 * 作成者 :  オ・ネフン
 * 최초 작성일자 :　2017-07-12
 * 最初の作成日付　:　2017-07-12
 * 최종 수정일 : 
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */


package com.bs.vo;

public class AdminPageVO {
	private String id; //아이디ハンドルネーム
	private String balance; //잔고残高
	private String requestCash; //충전요청금액充電要請の金額
	private String productCode; //상품코드商品コード
	private String productName; //상품명商品名
	private String size; // 사이즈サイズ
	private String brand; //브랜드 ブランド
	private int price; //가격 価格
	private String material; //소재素材
	private String buydate; //구매일자購買付
	private int status;	 //쿼리 수행 결과값結果値
	private int xAxis=0; //엑스축エクスチュク
	private int yAxis=0; //와이축ワイ軸

	
	public AdminPageVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdminPageVO(String id, String balance, String requestCash) {
		super();
		this.id = id;
		this.balance = balance;
		this.requestCash = requestCash;
	}

	public AdminPageVO(String productCode, String productName, String size,
			String brand, int price, String material, String buydate) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.size = size;
		this.brand = brand;
		this.price = price;
		this.material = material;
		this.buydate = buydate;
	}
	
	public AdminPageVO(String productCode, int xAxis,
			int yAxis) {
		this.productCode = productCode;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
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
	public String getBuydate() {
		return buydate;
	}
	public void setBuydate(String buydate) {
		this.buydate = buydate;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getxAxis() {
		return xAxis;
	}
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	public int getyAxis() {
		return yAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getRequestCash() {
		return requestCash;
	}
	public void setRequestCash(String requestCash) {
		this.requestCash = requestCash;
	}
	@Override
	public String toString() {
		return getProductCode()+","+getProductName();
	}
	
	
	

}
