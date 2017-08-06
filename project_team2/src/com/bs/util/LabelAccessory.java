/* 
 * =============================
 * 프로그램 설명 : 라벨 설정을 위한 클래스  
 * プログラムの説明: ラベルの設定のためのクラス
 * 작성자 : 김덕현
 * 作成者 :  キム・ドクヒョン
 * 최초 작성일자 :　2017-07-25　
 * 最初の作成日付　:　2017-07-25　
 * 최종 수정일 : 
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */


package com.bs.util;

import java.awt.Dimension;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
//파일 선택시 프리뷰 기능//ファイルを選択の時にプレビュー機能
public class LabelAccessory extends JLabel implements PropertyChangeListener {
	private static final int PREFERRED_WIDTH = 125;
	private static final int PREFERRED_HEIGHT = 100;

	public LabelAccessory(JFileChooser chooser) {
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
		chooser.addPropertyChangeListener(this);
		setPreferredSize(new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT));
	}

	public void propertyChange(PropertyChangeEvent changeEvent) {
		String changeName = changeEvent.getPropertyName();
		if (changeName.equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
			File file = (File) changeEvent.getNewValue();
			if (file != null) {
				ImageIcon icon = new ImageIcon(file.getPath());
				if (icon.getIconWidth() > PREFERRED_WIDTH) {
					icon = new ImageIcon(icon.getImage().getScaledInstance(
							PREFERRED_WIDTH, -1, Image.SCALE_DEFAULT));
					if (icon.getIconHeight() > PREFERRED_HEIGHT) {
						icon = new ImageIcon(icon.getImage().getScaledInstance(
								-1, PREFERRED_HEIGHT, Image.SCALE_DEFAULT));
					}
				}
				setIcon(icon);
			}
		}
	}
}
