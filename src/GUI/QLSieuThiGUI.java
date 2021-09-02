package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.KeyStore.PrivateKeyEntry;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import BUS.DangNhapBUS;
import BUS.Role_CategoryBUS;
import DTO.Role_CategoryDTO;

public class QLSieuThiGUI extends JFrame {
	private JPanel main;
	QLSieuThiGUI() throws ClassNotFoundException, SQLException, Exception{
		init();
	}
	int check1=0,check2=0,check3=0,check4=0,check5=0,check6=0,check7=0,check8=0,check9=0, check10=0;
	JButton banhang,qlsp,qlnv,qlkh,qlhd,ncc,nhapxuat,phieunhaphang,thongke, qlquyen;
	JLabel txtbanhang,txtqlsp,txtqlnv,txtqlkh,txtqlhd,txtncc,txtNX,txtpnh,txtthongke, txtqlquyen;
	public void init() throws ClassNotFoundException, SQLException, Exception {
		setSize(1400, 840);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//setAlwaysOnTop(true);
		setUndecorated(true);
		setLayout(new BorderLayout(1, 1));
		main = new JPanel();
		main.setLayout(null);
		changeMainInfo(0);
		
		JPanel title=new JPanel();
		title.setBackground(Color.black);
		title.setPreferredSize(new Dimension(0,40));
		title.setLayout(null);
		//JLabel close=new JLabel(new ImageIcon("image/off.png"));
		//close.setBounds(1350,5,32,32);
		ImageIcon off=new ImageIcon("image/off.png");
		java.awt.Image daboff=off.getImage();
		java.awt.Image mode=daboff.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		off=new ImageIcon(mode);
		JLabel close=new JLabel(off);
		close.setBounds(1340,0,40,40);
		JLabel logo=new JLabel(new ImageIcon("image/logo.png"));
		logo.setBounds(18, 3, 35, 35);
		JLabel txtlogo=new JLabel("Quản Lý Siêu Thị");
		txtlogo.setBounds(60, 5, 150, 30);
		txtlogo.setFont(new Font("Tahoma", 1, 15));
		txtlogo.setForeground(Color.white);
		close.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
                                
				System.exit(0);
			}
		});
		//JLabel hori=new JLabel(new ImageIcon("image/horizontal.png"));
		//hori.setBounds(1300,10,24,24);
		ImageIcon mnm=new ImageIcon("image/minimize.png");
		java.awt.Image dabmnm=mnm.getImage();
		java.awt.Image mode1=dabmnm.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		mnm=new ImageIcon(mode1);
		JLabel hori=new JLabel(mnm);
		hori.setBounds(1300,8,26,26);
		hori.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
                
		title.add(close);
		title.add(hori);
		title.add(logo);
		title.add(txtlogo);
		
		JPanel contentLeft= new JPanel();
		contentLeft.setPreferredSize(new Dimension(250,0));
		contentLeft.setBackground(new java.awt.Color(54, 54, 54));
		contentLeft.setLayout(null);
		
		JPanel contentMenu = new JPanel();
		contentMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		contentMenu.setBackground(null);
		contentMenu.setBackground(new Color(54,54,54));
		//contentMenu.setBounds(0,132,250,720);
		contentMenu.setPreferredSize(new Dimension(250,0));
		
		JScrollPane scrollPane = new JScrollPane(contentMenu);
		scrollPane.setBackground(new Color(54,54,54));
		scrollPane.setBounds(0,132,250,670);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(1,100));
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton trangchu=new JButton("Trang Chủ");
		trangchu.setFocusable(false);
		trangchu.setBackground(new java.awt.Color(178, 223, 238));
		trangchu.setFont(new Font("Tahoma", 1, 27));
		trangchu.setForeground(new java.awt.Color(139, 0, 0));
		trangchu.setBounds(25,0,200,100);
		trangchu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					changeMainInfo(0);
					clickItem();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception ex) {
                                Logger.getLogger(QLSieuThiGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		Dimension d = new Dimension(250,70);
		ImageIcon iconsell=new ImageIcon("image/sell.png");
		JLabel icon1=new JLabel(iconsell);
		banhang=new JButton();
		txtbanhang=new JLabel("Bán Hàng");
		txtbanhang.setFont(new Font("Tahoma", 1, 15));
		txtbanhang.setBounds(70,18,180,30);
		txtbanhang.setForeground(Color.white);
		banhang.setLayout(null);
		banhang.add(txtbanhang);
		banhang.setFocusable(false);
		banhang.setBorder(BorderFactory.createEmptyBorder());
		banhang.setBackground(new java.awt.Color(79,79,79));
		banhang.setPreferredSize(d);
		icon1.setBounds(30, 23, 20, 20);
		banhang.add(icon1);
		banhang.addMouseListener(new MouseListener() {
			
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
				if(check1==0) {
				banhang.setBackground(new java.awt.Color(79,79,79));
				txtbanhang.setForeground(Color.white);}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				banhang.setBackground(new java.awt.Color(220, 220, 220));
				txtbanhang.setForeground(Color.black);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					changeMainInfo(1);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception ex) {
                                Logger.getLogger(QLSieuThiGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		qlsp=new JButton();
		ImageIcon iconpro=new ImageIcon("image/product.png");
		JLabel icon2=new JLabel(iconpro);
		icon2.setBounds(30, 23, 20, 20);
		txtqlsp=new JLabel("Quản Lý Sản Phẩm");
		txtqlsp.setFont(new Font("Tahoma", 1, 15));
		txtqlsp.setBounds(70,18,180,30);
		txtqlsp.setForeground(Color.white);
		qlsp.setLayout(null);
		qlsp.add(txtqlsp);
		qlsp.add(icon2);
		qlsp.setFocusable(false);
		qlsp.setBorder(BorderFactory.createEmptyBorder());
		qlsp.setBackground(new java.awt.Color(79,79,79));
		qlsp.setPreferredSize(d);
		qlsp.addMouseListener(new MouseListener() {
			
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
				if(check2==0) {
				qlsp.setBackground(new java.awt.Color(79,79,79));
				txtqlsp.setForeground(Color.white);}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				qlsp.setBackground(new java.awt.Color(220, 220, 220));
				txtqlsp.setForeground(Color.black);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					changeMainInfo(2);
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception ex) {
                                Logger.getLogger(QLSieuThiGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		qlnv=new JButton();
		ImageIcon iconnv=new ImageIcon("image/staff.png");
		JLabel icon3=new JLabel(iconnv);
		icon3.setBounds(30, 23, 20, 20);
		txtqlnv=new JLabel("Quản Lý Nhân Viên");
		txtqlnv.setFont(new Font("Tahoma", 1, 15));
		txtqlnv.setBounds(70,18,180,30);
		txtqlnv.setForeground(Color.white);
		qlnv.setLayout(null);
		qlnv.add(txtqlnv);
		qlnv.add(icon3);
		qlnv.setFocusable(false);
		qlnv.setBorder(BorderFactory.createEmptyBorder());
		qlnv.setBackground(new java.awt.Color(79,79,79));
		qlnv.setPreferredSize(d);
		qlnv.addMouseListener(new MouseListener() {
			
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
				if(check3==0) {
				qlnv.setBackground(new java.awt.Color(79,79,79));
				txtqlnv.setForeground(Color.white);}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				qlnv.setBackground(new java.awt.Color(220, 220, 220));
				txtqlnv.setForeground(Color.black);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					changeMainInfo(3);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception ex) {
                                Logger.getLogger(QLSieuThiGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		qlkh=new JButton();
		ImageIcon iconuser=new ImageIcon("image/user.png");
		JLabel icon4=new JLabel(iconuser);
		icon4.setBounds(30, 23, 20, 20);
		txtqlkh=new JLabel("Quản Lý Khách Hàng");
		txtqlkh.setFont(new Font("Tahoma", 1, 15));
		txtqlkh.setBounds(70,18,180,30);
		txtqlkh.setForeground(Color.white);
		qlkh.setLayout(null);
		qlkh.add(txtqlkh);
		qlkh.add(icon4);
		qlkh.setFocusable(false);
		qlkh.setBorder(BorderFactory.createEmptyBorder());
		qlkh.setBackground(new java.awt.Color(79,79,79));
		qlkh.setPreferredSize(d);
		qlkh.addMouseListener(new MouseListener() {
			
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
				if(check4==0) {
				qlkh.setBackground(new java.awt.Color(79,79,79));
				txtqlkh.setForeground(Color.white);}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				qlkh.setBackground(new java.awt.Color(220, 220, 220));
				txtqlkh.setForeground(Color.black);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					changeMainInfo(4);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception ex) {
                                Logger.getLogger(QLSieuThiGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		qlhd=new JButton();
		JLabel icon7=new JLabel(new ImageIcon("image/bill.png"));
		icon7.setBounds(28, 23, 20, 20);
		txtqlhd=new JLabel("Quản Lý Hóa Đơn");
		txtqlhd.setFont(new Font("Tahoma", 1, 15));
		txtqlhd.setBounds(70,18,180,30);
		txtqlhd.setForeground(Color.white);
		qlhd.setLayout(null);
		qlhd.add(txtqlhd);
		qlhd.add(icon7);
		qlhd.setFocusable(false);
		qlhd.setBorder(BorderFactory.createEmptyBorder());
		qlhd.setBackground(new java.awt.Color(79,79,79));
		qlhd.setPreferredSize(d);
		qlhd.addMouseListener(new MouseListener() {
			
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
				if(check5==0) {
				qlhd.setBackground(new java.awt.Color(79,79,79));
				txtqlhd.setForeground(Color.white);}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				qlhd.setBackground(new java.awt.Color(220, 220, 220));
				txtqlhd.setForeground(Color.black);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					changeMainInfo(5);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception ex) {
                                Logger.getLogger(QLSieuThiGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		ncc=new JButton();
		ImageIcon iconsupp=new ImageIcon("image/supplier.png");
		JLabel icon5=new JLabel(iconsupp);
		icon5.setBounds(30, 23, 20, 20);
		txtncc=new JLabel("Nhà Cung Cấp");
		txtncc.setFont(new Font("Tahoma", 1, 15));
		txtncc.setBounds(70,18,180,30);
		txtncc.setForeground(Color.white);
		ncc.setLayout(null);
		ncc.setFocusable(false);
		ncc.setBorder(BorderFactory.createEmptyBorder());
		ncc.setBackground(new java.awt.Color(79,79,79));
		ncc.setPreferredSize(d);
		ncc.add(txtncc);
		ncc.add(icon5);
		ncc.addMouseListener(new MouseListener() {
			
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
				if(check6==0) {
				ncc.setBackground(new java.awt.Color(79,79,79));
				txtncc.setForeground(Color.white);}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				ncc.setBackground(new java.awt.Color(220, 220, 220));
				txtncc.setForeground(Color.black);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					changeMainInfo(6);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception ex) {
                                Logger.getLogger(QLSieuThiGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		nhapxuat=new JButton();
		ImageIcon iconNX=new ImageIcon("image/NX.png");
		JLabel icon6=new JLabel(iconNX);
		icon6.setBounds(30, 23, 20, 20);
		txtNX=new JLabel("Nhập Hàng");
		txtNX.setFont(new Font("Tahoma", 1, 15));
		txtNX.setBounds(70,18,180,30);
		txtNX.setForeground(Color.white);
		nhapxuat.setLayout(null);
		nhapxuat.setFocusable(false);
		nhapxuat.setBorder(BorderFactory.createEmptyBorder());
		nhapxuat.setBackground(new java.awt.Color(79,79,79));
		nhapxuat.setPreferredSize(d);
		nhapxuat.add(txtNX);
		nhapxuat.add(icon6);
		nhapxuat.addMouseListener(new MouseListener() {
			
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
				if(check7==0) {
				nhapxuat.setBackground(new java.awt.Color(79,79,79));
				txtNX.setForeground(Color.white);}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				nhapxuat.setBackground(new java.awt.Color(220, 220, 220));
				txtNX.setForeground(Color.black);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					changeMainInfo(7);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception ex) {
                                Logger.getLogger(QLSieuThiGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		phieunhaphang=new JButton();
		JLabel icon8=new JLabel(new ImageIcon("image/import-ticket.png"));
		icon8.setBounds(28, 21, 24, 24);
		txtpnh=new JLabel("Phiếu Nhập Hàng");
		txtpnh.setFont(new Font("Tahoma", 1, 15));
		txtpnh.setBounds(70,18,180,30);
		txtpnh.setForeground(Color.white);
		phieunhaphang.setLayout(null);
		phieunhaphang.setFocusable(false);
		phieunhaphang.setBorder(BorderFactory.createEmptyBorder());
		phieunhaphang.setBackground(new java.awt.Color(79,79,79));
		phieunhaphang.setPreferredSize(d);
		phieunhaphang.add(txtpnh);
		phieunhaphang.add(icon8);
		phieunhaphang.addMouseListener(new MouseListener() {
			
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
				if(check8==0) {
				phieunhaphang.setBackground(new java.awt.Color(79,79,79));
				txtpnh.setForeground(Color.white);}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				phieunhaphang.setBackground(new java.awt.Color(220, 220, 220));
				txtpnh.setForeground(Color.black);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					changeMainInfo(8);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception ex) {
                                Logger.getLogger(QLSieuThiGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		thongke=new JButton();
		JLabel icon9=new JLabel(new ImageIcon("image/chart.png"));
		icon9.setBounds(28, 21, 24, 24);
		txtthongke=new JLabel("Thống Kê");
		txtthongke.setFont(new Font("Tahoma", 1, 15));
		txtthongke.setBounds(70,18,180,30);
		txtthongke.setForeground(Color.white);
		thongke.setLayout(null);
		thongke.setFocusable(false);
		thongke.setBorder(BorderFactory.createEmptyBorder());
		thongke.setBackground(new java.awt.Color(79,79,79));
		thongke.setPreferredSize(d);
		thongke.add(txtthongke);
		thongke.add(icon9);
		thongke.addMouseListener(new MouseListener() {
			
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
				if(check9==0) {
				thongke.setBackground(new java.awt.Color(79,79,79));
				txtthongke.setForeground(Color.white);}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				thongke.setBackground(new java.awt.Color(220, 220, 220));
				txtthongke.setForeground(Color.black);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					changeMainInfo(9);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception ex) {
                                Logger.getLogger(QLSieuThiGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		qlquyen=new JButton();
		JLabel icon10=new JLabel(new ImageIcon("image/role.png"));
		icon10.setBounds(28, 21, 24, 24);
		txtqlquyen=new JLabel("Quản Lý Quyền");
		txtqlquyen.setFont(new Font("Tahoma", 1, 15));
		txtqlquyen.setBounds(70,18,180,30);
		txtqlquyen.setPreferredSize(d);
		txtqlquyen.setForeground(Color.white);
		qlquyen.setLayout(null);
		qlquyen.setFocusable(false);
		qlquyen.setBorder(BorderFactory.createEmptyBorder());
		qlquyen.setBackground(new java.awt.Color(79,79,79));
		qlquyen.setPreferredSize(d);
		qlquyen.add(txtqlquyen);
		qlquyen.add(icon10);
		qlquyen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				if(check10==0) {
					qlquyen.setBackground(new java.awt.Color(79,79,79));
					txtqlquyen.setForeground(Color.white);}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				qlquyen.setBackground(new java.awt.Color(220, 220, 220));
				txtqlquyen.setForeground(Color.black);
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					changeMainInfo(10);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		

		contentLeft.add(scrollPane);
		contentLeft.add(trangchu);

		ArrayList<JButton> listMenu = new ArrayList<>();
		listMenu.add(banhang);
		listMenu.add(qlsp);
		listMenu.add(qlnv);
		listMenu.add(qlkh);
		listMenu.add(qlhd);
		listMenu.add(ncc);
		listMenu.add(nhapxuat);
		listMenu.add(phieunhaphang);
		listMenu.add(thongke);
		listMenu.add(qlquyen);

		try {
			Role_CategoryBUS rcbus = new Role_CategoryBUS();
			int lengthMenu = 0;
			for(Role_CategoryDTO item : rcbus.readList()){
				if(DangNhapBUS.login.role==item.getMaQuyen()){
					lengthMenu+=70;
					contentMenu.add(listMenu.get(item.getMaDM()-1));
				}
			}
			contentMenu.setPreferredSize(new Dimension(250,lengthMenu));

		}catch (Exception e){
			e.printStackTrace();
		}
		
		
		add(contentLeft, BorderLayout.WEST);
		add(main,BorderLayout.CENTER);
		add(title,BorderLayout.NORTH);

		
		setVisible(true);
	}
	public void changeMainInfo(int i) throws ClassNotFoundException, SQLException, Exception 
    {
        switch(i)
        {
            case 0: 
                main.removeAll();
                main.add(new TrangChuGUI());
                main.repaint();
                main.revalidate();
            break;
            case 1: 
            	clickItem();
            	banhang.setBackground(new java.awt.Color(220, 220, 220));
				txtbanhang.setForeground(Color.black);
				check1=1;
                main.removeAll();
                main.add(new BanHangGUI());
                main.repaint();
                main.revalidate();
            break;
            case 2: 
            	clickItem();
            	qlsp.setBackground(new java.awt.Color(220, 220, 220));
				txtqlsp.setForeground(Color.black);
				check2=1;
                main.removeAll();
                main.add(new SanPhamGUI());
                main.repaint();
                main.revalidate();
            break;
            case 3: 
            	clickItem();
            	qlnv.setBackground(new java.awt.Color(220, 220, 220));
				txtqlnv.setForeground(Color.black);
				check3=1;
                main.removeAll();
                main.add(new NhanVienGUI());
                main.repaint();
                main.revalidate();
            break;
            case 4: 
            	clickItem();
	            qlkh.setBackground(new java.awt.Color(220, 220, 220));
				txtqlkh.setForeground(Color.black);
				check4=1;
				main.removeAll();
	            main.add(new KhachHangGUI());
	            main.repaint();
	            main.revalidate();
			break;
            case 5: 
            	clickItem();
            	qlhd.setBackground(new java.awt.Color(220, 220, 220));
				txtqlhd.setForeground(Color.black);
				check5=1;
                main.removeAll();
                main.add(new HoaDonGUI());
                main.repaint();
                main.revalidate();
            break;
            case 6:
            	clickItem();
            	ncc.setBackground(new java.awt.Color(220, 220, 220));
				txtncc.setForeground(Color.black);
				check6=1;
				main.removeAll();
                main.add(new NhaCungCapGUI());
                main.repaint();
                main.revalidate();
            break;
            case 7:
            	clickItem();
            	nhapxuat.setBackground(new java.awt.Color(220, 220, 220));
				txtNX.setForeground(Color.black);
				check7=1;
				main.removeAll();
                main.add(new NhapHangGUI());
                main.repaint();
                main.revalidate();
            break;
            case 8:
            	clickItem();
            	phieunhaphang.setBackground(new java.awt.Color(220, 220, 220));
				txtpnh.setForeground(Color.black);
				check8=1;
				main.removeAll();
                main.add(new PhieuNhapHangGUI());
                main.repaint();
                main.revalidate();
            break;
            case 9:
            	clickItem();
            	thongke.setBackground(new java.awt.Color(220, 220, 220));
				txtthongke.setForeground(Color.black);
				check9=1;
				main.removeAll();
                main.add(new ThongKeGUI());
                main.repaint();
                main.revalidate();
            break;
            case 10:
				clickItem();
				qlquyen.setBackground(new java.awt.Color(220, 220, 220));
				txtqlquyen.setForeground(Color.black);
				
				check10=1;
				main.removeAll();
				main.add(new QuanLyQuyenGUI());
				main.repaint();
				main.revalidate();
				break;
        }
    }
	
	public void clickItem() {
		banhang.setBackground(new java.awt.Color(79,79,79));
		txtbanhang.setForeground(Color.white);
		qlsp.setBackground(new java.awt.Color(79,79,79));
		txtqlsp.setForeground(Color.white);
		qlnv.setBackground(new java.awt.Color(79,79,79));
		txtqlnv.setForeground(Color.white);
		qlkh.setBackground(new java.awt.Color(79,79,79));
		txtqlkh.setForeground(Color.white);
		qlhd.setBackground(new java.awt.Color(79,79,79));
		txtqlhd.setForeground(Color.white);
		ncc.setBackground(new java.awt.Color(79,79,79));
		txtncc.setForeground(Color.white);
		nhapxuat.setBackground(new java.awt.Color(79,79,79));
		txtNX.setForeground(Color.white);
		phieunhaphang.setBackground(new java.awt.Color(79,79,79));
		txtpnh.setForeground(Color.white);
		thongke.setBackground(new java.awt.Color(79,79,79));
		txtthongke.setForeground(Color.white);
		qlquyen.setBackground(new java.awt.Color(79,79,79));
		txtqlquyen.setForeground(Color.white);
		check1=0;check2=0;check3=0;check4=0;check5=0;check6=0;check7=0;check8=0;check9=0;check10=0;
	}
     
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
		QLSieuThiGUI t=new QLSieuThiGUI();

	}
}

