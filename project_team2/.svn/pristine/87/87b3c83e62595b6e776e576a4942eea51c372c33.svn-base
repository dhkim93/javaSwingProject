/* 
 * =============================
 * 프로그램 설명 : 게시판화면(테이블)에 DB에 저장되어있는 데이터를 가져오는 DAO   
 * プログラムの説明 : 掲示板の画面(テーブル)にDBに保存されているデータをもってくるDAO
 * 작성자 : 오내훈   
 * 作成者 : オ・ネフン
 * 최초 작성일자 :    2017-07-17
 * 最初の作成日付 : 2017-07-17
 * 최종 수정일 :   
 * 最終の修正日 :
 * 수정 내용 :   
 * 修正の内容 :
 * =============================
 * */

package com.bs.board.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.bs.vo.NoticeBoardVO;

public class BoardModel extends AbstractTableModel implements MouseListener{
	
	Object[][] data;
	Object[] columnName;
	BoardDAO bdao = new BoardDAO();
	NoticeBoardVO nbvo;
	ArrayList<String>title;
	ArrayList<NoticeBoardVO> list;
//	AbstractTableModel table;
	
	public  BoardModel() {
        
		// 열의 개수와 행의 개수를 알아야 2차원 배열선언　　
		// 列の数と行の数を知ってこそ、2次元の配列を宣言
		// 테이블에서 컬럼이름을 얻어와서 1차원 배열 선언　　
		// テーブルでコラムの名を得てきて1次元の配列を宣言
			title = bdao.getColumnName();
//			System.out.println("title.get(0) " + title.get(0));
			
			columnName = title.toArray();
//			System.out.println("columnName :" + title.toArray().toString());

			int columnCount = title.size();
			list = bdao.getBoardTotal();
			int rowCount = list.size();
			data = new Object[rowCount][columnCount]; //2개 컬럼은 숨기기　　
								  //2つのコラムは隠す
			
			//배열에 데이터 입력 　　
			//配列にデータを入力
			for (int index = 0; index < rowCount; index++) {

				nbvo = list.get(index);
				data[index][0] = nbvo.getNo();
				data[index][1] = nbvo.getSubject();
				data[index][2] = nbvo.getWriter();
				data[index][3] = nbvo.getDate();
			}
	}
	
	//컬럼 카운트 반환 메서드 구현 　　
	//ColumnCountの返還メソッドを実装
	public int getColumnCount() { 
		// TODO Auto-generated method stub
		if (columnName == null)
			return 0;
		else
			return columnName.length;
	}

	//로우 카운트 반환 메서드 구현 　　
	//RowCountの返還メソッドを具現
	public int getRowCount() {
		// TODO Auto-generated method stub
		if (data == null)
			return 0;
		else
			return data.length;
	}

	//getValue 메서드 구현 　　
	//getValueメソッドを具現
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
	
	//컬럼네임 반환 메서드 구현 　　
	//ColumnNameの返還メソッドを具現
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) columnName[column];
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("$mouseEntered@@");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
