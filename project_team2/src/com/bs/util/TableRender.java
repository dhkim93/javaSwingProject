/* 
 * =============================
 * 프로그램 설명 : 테이블 색상 변경을 위한 클래스    
 * プログラムの説明　: テーブルの色を変更のためのクラス
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

package com.bs.util;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableRender extends DefaultTableCellRenderer  {
	public Color color;
	public int rowAtMouse;
		
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) 
	{ 
	        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
	        if (! table.isRowSelected(row)) //현재 선택된 행의 색상은 변경하지 않고 선택 해제된 경우에만 배경색상을 변경한다
	        {
	        	if(row==rowAtMouse) c.setBackground(color);		
	        	else c.setBackground(Color.WHITE);			//마우스가 떼어졌을 때 흰색으로 바뀜
	        }
	        return c;
	} 
}
