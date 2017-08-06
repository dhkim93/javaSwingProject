/* 
 * =============================
 * 프로그램 설명 :  MemberVO.java
 * プログラムの説明:   MemberVO.java
 * 작성자 :  오내훈　　
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

public class MemberVO {
   
   private String id ; //아이디ハンドルネーム

   private String password; //비밀번호パスワード
   private String name; //이름名前
   private int gender; //성별性別
   private int admin_flag; //관리자 여부管理者
   private String phone; //전화번호電話番号
   private String email; //이메일メール
   private int balance; //잔고残高
   
   public MemberVO(String id){
      this.id = id;
   }
   
   public MemberVO(String id, String password, String name
         , String phone, int admin_flag, String email, int gender, int balance) 
   {
      super();
      this.id = id;
      this.password = password;
      this.name = name;
      this.gender = gender;
      this.admin_flag = admin_flag;
      this.phone = phone;
      this.email = email;
      this.balance = balance;      
   }


   public MemberVO(      String id
                     , String password
                     , String name
                     , String phone
                     , String email 
                     , int gender) {
      this.id = id;
      this.password = password;
      this.name = name;
      this.gender = gender;
      this.phone = phone;
      this.email = email;
   }

   
   public MemberVO(String id, String password, String name, String phone,
         String email) {
      super();
      this.id = id;
      this.password = password;
      this.name = name;
      this.phone = phone;
      this.email = email;
   }

   public MemberVO() {
      super();
      // TODO Auto-generated constructor stub
   }


   public String getId() {
      return id;
   }


   public void setId(String id) {
      this.id = id;
   }


   public String getPassword() {
      return password;
   }


   public void setPassword(String password) {
      this.password = password;
   }


   public String getName() {
      return name;
   }


   public void setName(String name) {
      this.name = name;
   }


   public int getGender() {
      return gender;
   }


   public void setGender(int gender) {
      this.gender = gender;
   }


   public int getAdmin_flag() {
      return admin_flag;
   }


   public void setAdmin_flag(int admin_flag) {
      this.admin_flag = admin_flag;
   }


   public String getPhone() {
      return phone;
   }


   public void setPhone(String phone) {
      this.phone = phone;
   }


   public String getEmail() {
      return email;
   }


   public void setEmail(String email) {
      this.email = email;
   }

   public int getBalance() {
	   return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

@Override
   public String toString() {
      return "MemberVO [id=" + id + ", password=" + password + ", name="
            + name + ", phone=" + phone + ", email=" + email + "]";
   }




   
   
   
   
   

}