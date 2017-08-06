/* 
 * =============================
 * 프로그램 설명 : 게시판 상세보기 화면  
 * プログラムの説明:  掲示板詳細表示の画面
 * 작성자 : 오내훈, 박신영　　
 * 作成者:オ・ネフン、パク・シンヨン
 * 최초 작성일자 : 　2017-07-11　
 * 最初の作成日付 :2017-07-11
 * 최종 수정일 : 　　　
 * 最終の修正日 :
 * 수정 내용 : 　　　
 * 修正の内容 :
 * =============================
 * */

package com.bs.board.control;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.bs.view.MainFrame;
import com.bs.vo.NoticeBoardVO;

public class BoardDetail extends JPanel implements ActionListener,ItemListener, MouseListener {
	
	private JTextField[] jt = new JTextField[3];
	private JLabel[] jl = new JLabel[4];
	private JButton jb2 = new JButton("以前に戻る"); //"이전으로"
	private JButton jb3 = new JButton("メインに移動");//"메인으로"
	private JTextArea jta;
	private int i;
	private int qa = 3;
	private ButtonGroup butg;
	private NoticeBoardVO nbvo = null;

	public BoardDetail(MainFrame win) {
		setBackground(Color.WHITE);
		
		//취소 하기 버튼 　　
                //キャンセルするボタン
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (e.getSource() == jb2) {
						win.panelChange("Board", MainFrame.id);
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		//메인으로 가기 버튼 　　
		//メインに移動ボタン
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (e.getSource() == jb3) {
						win.panelChange("LoginPage", MainFrame.id);
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

	}
	
	public void getRefresh(String id){
		
		setBounds(new Rectangle(0, 0, 900, 600));
		setLayout(null);
		
		
		jl[0] = new JLabel("subject");
		jl[0].setBounds(37, 60, 417, 21);
		jl[1] = new JLabel("writer");
		jl[1].setBounds(476, 60, 417, 21);
		jl[2] = new JLabel("date");
		jl[2].setBounds(650, 60, 417, 21);
		jl[3] = new JLabel("content");
		jl[3].setBounds(37, 110, 208, 21);
		
		jt[0] = new JTextField("", 100); //제목　　
						 //タイトル
		jt[0].setBounds(37, 80, 417, 21);
		jt[0].addMouseListener((MouseListener) this);
		
		
		jt[1] = new JTextField(10); //이름　　
                			    //名前
		jt[1].setBounds(476, 80, 156, 21);
		jt[1].setText(MainFrame.id); // 0
		
		jt[2] = new JTextField(10); //날짜　　
                            		    //日付
		jt[2].setBounds(650, 80, 208, 21);
		
		jta = new JTextArea(); // 게시판내용창　　
                		       //掲示板内容の画面
		jta.setBounds(37, 133, 821, 309);
		
		Color b=new Color(127,255,212);
		jta.setBackground(b);
		add(jta);
		jb2.setBounds(592, 475, 124, 23);
		jb3.setBounds(728, 475, 124, 23); // 버튼을 눌렀을 때 메인화면으로 돌아감　　
										//　ボタンを押した時にメイン画面に戻る
		butg = new ButtonGroup();

		jt[0].setEditable(false);
		jt[1].setEditable(false);
		jt[2].setEditable(false);
		jta.setEditable(false);
		
		add(jl[0]);
		add(jl[1]);
		add(jl[2]);
		add(jl[3]);
		add(jt[0]);
		add(jt[1]);
		add(jt[2]);
		add(jb2);
		add(jb3);
		setVisible(true);
		try {
			
			ArrayList<NoticeBoardVO> list = new ArrayList<NoticeBoardVO>();
			BoardDetailDAO bddao = new BoardDetailDAO();
			list = bddao.getBoardDetail(Board.selectedNum);
			
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@" + Board.selectedNum);
			
			if(list!=null){
				
				for (int i = 0; i < list.size(); i++) {
					
					System.out.println("$$$$$$$$$$$$$$$$$$$$" + list.get(i).getContent());
					jta.setText(list.get(i).getContent());
					jt[0].setText(list.get(i).getSubject());
					jt[1].setText(list.get(i).getWriter());
					jt[2].setText(list.get(i).getDate());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 액션리스너　　
							// アクションリスナー
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
