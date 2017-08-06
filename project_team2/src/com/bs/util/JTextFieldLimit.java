/* 
 * =============================
 * 프로그램 설명 : JtextFiled 의 글자수 제한을 위한 클래스 
 * プログラムの説明　:  JtextFiledの字数の制限のためのクラス
 * 작성자 : 오내훈
 * 作成者 :  オ・ネフン
 * 최초 작성일자 :　　2017-07-31
 * 最初の作成日付　:　2017-07-31　
 * 최종 수정일 : 
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */


package com.bs.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {
	   private int limit;
	   private boolean toUppercase = false;

	   public JTextFieldLimit(int limit) {
	      super();
	      this.limit = limit;
	   }

	 

	   JTextFieldLimit(int limit, boolean upper) {
	      super();
	      this.limit = limit;
	      this.toUppercase = upper;
	   }

	 

	   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	      if (str == null) {
	         return;
	      }

	      if ( (getLength() + str.length()) <= limit) {
	         if (toUppercase) {
	            str = str.toUpperCase();
	         }
	         super.insertString(offset, str, attr);
	      }
	   }
	}