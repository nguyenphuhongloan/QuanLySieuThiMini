package GUI;
import java.awt.Color;import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import BUS.DangNhapBUS;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DangNhapGUI extends JFrame {
	JTextField txtusername;
	JPasswordField txtpass;
	DangNhapBUS dnBUS=new DangNhapBUS();
	public DangNhapGUI() {
		// TODO Auto-generated constructor stub
		init();
	}
	public void init() {
		setSize(530, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setLayout(null);
		getContentPane().setBackground(new java.awt.Color(47,79,79));
		setUndecorated(true);
		
		JLabel close=new JLabel(new ImageIcon("image/close.png"));
		close.setBounds(480,5,40,40);
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
				System.exit(0);
			}
		});
		JLabel logo=new JLabel(new ImageIcon("image/logo.png"));
		logo.setBounds(150, 100, 50, 50);
		JLabel txtlogo=new JLabel("QUẢN LÝ SIÊU THỊ");
		txtlogo.setBounds(200, 90, 200, 70);
		txtlogo.setForeground(Color.WHITE);
		txtlogo.setFont(new Font("Tahoma",1,18));
		
		JLabel iconusername=new JLabel(new ImageIcon("image/username.png"));
		iconusername.setBounds(80, 230, 50, 50);
		txtusername=new JTextField("Username");
		txtusername.setBounds(135, 242, 300, 30);
		txtusername.setBorder(BorderFactory.createEmptyBorder());
		txtusername.setOpaque(false);
		txtusername.setCaretColor(Color.white);
		txtusername.setForeground(Color.white);
		txtusername.setFont(new Font("Tahoma", 0, 21));
		txtusername.addMouseListener(new MouseListener() {
			
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
				txtusername.setText("");
			}
		});
		JPanel line1=new JPanel();
		line1.setBounds(85,278,360,2);
		line1.setBackground(Color.white);
		
		JLabel iconpass=new JLabel(new ImageIcon("image/pass.png"));
		iconpass.setBounds(80, 350, 50, 50);
		txtpass=new JPasswordField("Password");
		txtpass.setBounds(135, 362, 300, 30);
		txtpass.setBorder(BorderFactory.createEmptyBorder());
		txtpass.setOpaque(false);
		txtpass.setCaretColor(Color.white);
		txtpass.setForeground(Color.white);
		txtpass.setFont(new Font("Tahoma", 0, 21));
		txtpass.addMouseListener(new MouseListener() {
			
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
				txtpass.setText("");
			}
		});
		JPanel line2=new JPanel();
		line2.setBounds(85,398,360,2);
		line2.setBackground(Color.white);
		
		JButton dangnhap=new JButton("Đăng Nhập");
		dangnhap.setFocusable(false);
		dangnhap.setBounds(180, 500, 170, 50);
		dangnhap.setFont(new Font("Tahoma", 1, 20));
		dangnhap.setBackground(new java.awt.Color(0,206,209));
		dangnhap.setForeground(Color.white);
		dangnhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String tk=txtusername.getText();
				String mk;
				mk = txtpass.getText();
				try {
					if(dnBUS.DangNhap(tk, mk)==true) {
						txtusername.setText("");
						txtpass.setText("");
						QLSieuThiGUI qlst=new QLSieuThiGUI();
						setVisible(false);
					}
					else {
						ThongBaoGUI tb=new ThongBaoGUI("Sai Tên Đăng Nhập Hoặc Mật Khẩu!");
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception ex) {
                                Logger.getLogger(DangNhapGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		
		add(close);
		add(logo);
		add(txtlogo);
		add(iconusername);
		add(txtusername);
		add(line1);
		add(iconpass);
		add(txtpass);
		add(line2);
		add(dangnhap);
		setVisible(true);
	}
	public static void main(String[] args)  {
		DangNhapGUI t=new DangNhapGUI();

	}
}
