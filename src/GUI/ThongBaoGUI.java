package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ThongBaoGUI extends JDialog{
	public String tb;
	public ThongBaoGUI(String tb) {
		this.tb=tb;
		init();
	}
	public void init() {
		setSize(500, 200);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setLayout(new BorderLayout());
		setUndecorated(true);
		
		JPanel title=new JPanel();
		title.setBackground(Color.black);
		title.setPreferredSize(new Dimension(0,40));
		title.setLayout(null);
		JLabel close=new JLabel(new ImageIcon("image/close.png"));
		close.setBounds(450,0,40,40);
		close.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		JLabel icon=new JLabel(new ImageIcon("image/mess.png"));
		icon.setBounds(15,0,40,40);		
                JPanel content=new JPanel();
		content.setLayout(null);
		content.setBackground(new java.awt.Color(198, 226, 255));
		JTextArea mess=new JTextArea(tb);
		mess.setFont(new Font("Tahoma",1,20));		mess.setForeground(Color.red);
		mess.setBounds(70, 50, 400, 80);
		mess.setLineWrap(true);
		mess.setWrapStyleWord(true);
		mess.setBackground(new java.awt.Color(198, 226, 255));
		mess.setFocusable(false);
		content.add(mess);
		title.add(close);
		title.add(icon);
		add(title,BorderLayout.NORTH);
		add(content,BorderLayout.CENTER);
		setVisible(true);
	}
}
