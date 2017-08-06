/* 
 * =============================
 * 프로그램 설명 :   ClosetVO.java
 * プログラムの説明:   
 * 작성자 :  오내훈　　
 * 作成者 : 　オ・ネフン
 * 최초 작성일자 :　　2017-07-12
 * 最初の作成日付　:　 2017-07-12　　
 * 최종 수정일 : 
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */

package com.bs.vo;

public class ClosetVO {
	
	private String id; //아이디ハンドルネーム
	private String productCode; //상품코드商品コード
	private String productName; //상품명商品名
	private String buyDate; //구매일자購買付
	
	public ClosetVO(String productCode, String productName) {
		super();
		this.productCode = productCode;
		this.productName = productName;
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

	@Override
	public String toString() {
		return productName;
	}
	

}
