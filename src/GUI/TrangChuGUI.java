package GUI;

import BUS.DangNhapBUS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TrangChuGUI extends JPanel{
	TrangChuGUI(){
		init();
	}
	public void init() {
	setLayout(null);
	setBounds(0,0,1150,800); 
	ImageIcon avatar=new ImageIcon("image/man.png");
	JLabel icon7=new JLabel(avatar);
	icon7.setBounds(70, 25, 256, 256);
	JLabel tenNV=new JLabel(DangNhapBUS.login.hoNV+" "+DangNhapBUS.login.tenNV);
	tenNV.setBounds(65, 230, 300, 200);
	tenNV.setFont(new Font("Tahoma", 1, 30));
	tenNV.setForeground(Color.red);
	JLabel hello=new JLabel("Xin Chào Admin!");
	hello.setBounds(970, 0, 200, 100);
	hello.setFont(new Font("Tahoma", 2, 20));
	JLabel deli=new JLabel(new ImageIcon("image/deli.png"));
	deli.setBounds(970, 40, 128, 128);
	JLabel sale=new JLabel(new ImageIcon("image/sale.png"));
	sale.setBounds(970, 200, 128, 128);
	JLabel medal=new JLabel(new ImageIcon("image/medal.png"));
	medal.setBounds(970, 365, 128, 128);
	ImageIcon dabIcon=new ImageIcon("image/safe.png");
	java.awt.Image dabImage=dabIcon.getImage();
	java.awt.Image mode=dabImage.getScaledInstance(128,128,java.awt.Image.SCALE_SMOOTH);
	dabIcon=new ImageIcon(mode);
	JLabel safe=new JLabel(dabIcon);
	safe.setBounds(970, 520, 128, 128);
	JButton lg=new JButton();
	ImageIcon iconlogout=new ImageIcon("image/logout.png");
	JLabel icon8=new JLabel(iconlogout);
	icon8.setBounds(15, 15, 30, 30);
	JLabel logout=new JLabel("Đăng Xuất");
	logout.setFont(new Font("Tahoma", 1, 18));
	logout.setBounds(50,14,180,30);
	logout.setForeground(Color.white);
	lg.setLayout(null);
	lg.setFocusable(false);
	lg.setBackground(new java.awt.Color(198, 0, 0));
	lg.setBounds(930,700, 170, 60);
	lg.add(logout);
	lg.add(icon8);
        lg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 ((Window) getRootPane().getParent()).dispose();
                new DangNhapGUI();
            }
            
           
        });
	add(icon7);
	add(deli);
	add(sale);
	add(medal);
	add(safe);
	add(lg);
	add(tenNV);
	//add(hello);
	}
}

