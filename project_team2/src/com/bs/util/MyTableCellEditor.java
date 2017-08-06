/* 
 * =============================
 * 프로그램 설명 : 테이블 셀 데이터 수정을 위한 클래스  
 * プログラムの説明　: テーブルのセルデータを修正のためのクラス
 * 작성자 : 오내훈
 * 作成者 :  オ・ネフン
 * 최초 작성일자 :　2017-07-25　
 * 最初の作成日付　:　2017-07-25　
 * 최종 수정일 : 
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */

package com.bs.util;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class MyTableCellEditor  extends AbstractCellEditor implements TableCellEditor {

	  JComponent component = new JTextField();

	  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
	      int rowIndex, int vColIndex) {

	    ((JTextField) component).setText((String) value);

	    return component;
	  }

	  public Object getCellEditorValue() {
	    return ((JTextField) component).getText();
	  }
	}
