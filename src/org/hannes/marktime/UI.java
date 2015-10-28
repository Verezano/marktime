package org.hannes.marktime;

import java.awt.BorderLayout;

import org.hannes.marktime.Logic;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.JTable;

import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.util.Iterator;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;


public class UI extends JFrame {
	static final long serialVersionUID=0xcaffee;
	private JPanel contentPane;
	private JTextField userName;
	private JTextField password;
	private JLabel lblTime;
	private JLabel lblOffline;
	private JLabel lblLoginMsg;
	private JLabel lblBaan1;
	private JLabel lblBaan2;
	private JLabel lblPrevBaan1;
	private JLabel lblPrevBaan2;
	private JLabel prevBaan1;
	private JLabel prevBaan2;
	private JLabel prevTime2;
	private JLabel prevTime1;
	protected Logic logic;
	private JButton btnStartTijd;
	private JButton btnResetTijd;
	private JRadioButton rdbtnAchterVolging;
	private JRadioButton rdbtnBoordAanBoord;
	private JButton btnStart;
	private JTable teamTable;
	private final String[] colNames= { "Heat", "Startnummer", "Naam", "DHMix", "Categorie", "Type", "Start", "Finish" };
	private JTextField bootNummer_1;
	private JTextField bootNummer_2;
	private JTextField finishNummer_1;
	private JTextField finishNummer_2;
	private JTextField finishNummer_3;
	private JTextField finishNummer_4;
	private JTextField finishNummer_5;
	private JLabel     finishTijd_1;
	private JLabel     finishTijd_2;
	private JLabel     finishTijd_3;
	private JLabel     finishTijd_4;
	private JLabel     finishTijd_5;
	private JLabel finishNummer_6;
	private JLabel finishNummer_7;
	private JLabel finishNummer_8;
	private JLabel finishNummer_9;
	private JLabel finishNummer_10;
	private JLabel finishTijd_6;
	private JLabel finishTijd_7;
	private JLabel finishTijd_8;
	private JLabel finishTijd_9;
	private JLabel finishTijd_10;
	private Component horizontalStrut_1;
	private JLabel lblSync;
	private JLabel copyRight;

	/**
	 * Create the frame.
	 */
	public UI() {
		setTitle("MarkTime, regatta tijdregistratie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("marktime.png").getImage());
		setBounds(10, 10, 1200, 700);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Login", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.1, 0.1, 0.5, 0.5, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 2;
		gbc_verticalStrut_2.gridy = 0;
		panel.add(verticalStrut_2, gbc_verticalStrut_2);
		
		JLabel lblAanmeldenBijServer = new JLabel("Aanmelden bij server");
		lblAanmeldenBijServer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblAanmeldenBijServer = new GridBagConstraints();
		gbc_lblAanmeldenBijServer.anchor = GridBagConstraints.WEST;
		gbc_lblAanmeldenBijServer.insets = new Insets(0, 0, 5, 5);
		gbc_lblAanmeldenBijServer.gridx = 2;
		gbc_lblAanmeldenBijServer.gridy = 1;
		panel.add(lblAanmeldenBijServer, gbc_lblAanmeldenBijServer);
		
		JLabel lblNaam = new JLabel("Naam");
		lblNaam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNaam = new GridBagConstraints();
		gbc_lblNaam.anchor = GridBagConstraints.WEST;
		gbc_lblNaam.insets = new Insets(0, 0, 5, 5);
		gbc_lblNaam.gridx = 1;
		gbc_lblNaam.gridy = 2;
		panel.add(lblNaam, gbc_lblNaam);
		
		userName = new JTextField();
		userName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_userName = new GridBagConstraints();
		gbc_userName.insets = new Insets(0, 0, 5, 5);
		gbc_userName.fill = GridBagConstraints.HORIZONTAL;
		gbc_userName.gridx = 2;
		gbc_userName.gridy = 2;
		panel.add(userName, gbc_userName);
		userName.setColumns(10);
		
		JLabel lblWachtwoord = new JLabel("Wachtwoord");
		lblWachtwoord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblWachtwoord = new GridBagConstraints();
		gbc_lblWachtwoord.anchor = GridBagConstraints.WEST;
		gbc_lblWachtwoord.insets = new Insets(0, 0, 5, 5);
		gbc_lblWachtwoord.gridx = 1;
		gbc_lblWachtwoord.gridy = 3;
		panel.add(lblWachtwoord, gbc_lblWachtwoord);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.insets = new Insets(0, 0, 5, 5);
		gbc_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_password.gridx = 2;
		gbc_password.gridy = 3;
		panel.add(password, gbc_password);
		password.setColumns(5);
		
		JButton btnInloggen = new JButton("Inloggen");
		btnInloggen.setHorizontalAlignment(SwingConstants.LEFT);
		btnInloggen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnInloggen = new GridBagConstraints();
		gbc_btnInloggen.insets = new Insets(0, 0, 5, 5);
		gbc_btnInloggen.anchor = GridBagConstraints.WEST;
		gbc_btnInloggen.gridx = 2;
		gbc_btnInloggen.gridy = 4;
		panel.add(btnInloggen, gbc_btnInloggen);
		
		lblLoginMsg = new JLabel("");
		lblLoginMsg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblLoginMsg = new GridBagConstraints();
		gbc_lblLoginMsg.anchor = GridBagConstraints.WEST;
		gbc_lblLoginMsg.insets = new Insets(0, 0, 0, 5);
		gbc_lblLoginMsg.gridx = 2;
		gbc_lblLoginMsg.gridy = 5;
		panel.add(lblLoginMsg, gbc_lblLoginMsg);
		
		btnInloggen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.login(userName.getText(),password.getText());
			}
		});

		JPanel panel_start = new JPanel();
		tabbedPane.addTab("Start", null, panel_start, null);
		GridBagLayout gbl_panel_start = new GridBagLayout();
		gbl_panel_start.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_start.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_start.columnWeights = new double[]{0.3, 0.2, 0.0, 0.0, 0.2, 0.3, Double.MIN_VALUE};
		gbl_panel_start.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_start.setLayout(gbl_panel_start);
				
		JLabel lblStarttijden = new JLabel("Starttijden");
		lblStarttijden.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblStarttijden = new GridBagConstraints();
		gbc_lblStarttijden.anchor = GridBagConstraints.WEST;
		gbc_lblStarttijden.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarttijden.gridx = 1;
		gbc_lblStarttijden.gridy = 1;
		panel_start.add(lblStarttijden, gbc_lblStarttijden);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 2;
		panel_start.add(verticalStrut_3, gbc_verticalStrut_3);
		
		lblBaan1 = new JLabel("Baan 1");
		lblBaan1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblBaan1 = new GridBagConstraints();
		gbc_lblBaan1.anchor = GridBagConstraints.WEST;
		gbc_lblBaan1.insets = new Insets(0, 0, 5, 5);
		gbc_lblBaan1.gridx = 1;
		gbc_lblBaan1.gridy = 3;
		panel_start.add(lblBaan1, gbc_lblBaan1);
		
		bootNummer_1 = new JNumField(3);
		bootNummer_1.setHorizontalAlignment(SwingConstants.TRAILING);
		bootNummer_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_bootNummer_1 = new GridBagConstraints();
		gbc_bootNummer_1.insets = new Insets(0, 0, 5, 5);
		gbc_bootNummer_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_bootNummer_1.gridx = 3;
		gbc_bootNummer_1.gridy = 3;
		panel_start.add(bootNummer_1, gbc_bootNummer_1);
		bootNummer_1.setColumns(10);
		
		lblBaan2 = new JLabel("Baan 2");
		lblBaan2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblBaan2 = new GridBagConstraints();
		gbc_lblBaan2.anchor = GridBagConstraints.WEST;
		gbc_lblBaan2.insets = new Insets(0, 0, 5, 5);
		gbc_lblBaan2.gridx = 1;
		gbc_lblBaan2.gridy = 5;
		panel_start.add(lblBaan2, gbc_lblBaan2);
		
		bootNummer_2 = new JNumField(3);
		bootNummer_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		bootNummer_2.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_bootNummer_2 = new GridBagConstraints();
		gbc_bootNummer_2.insets = new Insets(0, 0, 5, 5);
		gbc_bootNummer_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_bootNummer_2.gridx = 3;
		gbc_bootNummer_2.gridy = 5;
		panel_start.add(bootNummer_2, gbc_bootNummer_2);
		bootNummer_2.setColumns(10);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 6;
		panel_start.add(verticalStrut_4, gbc_verticalStrut_4);
		
		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 3;
		gbc_btnStart.gridy = 7;
		panel_start.add(btnStart, gbc_btnStart);
		btnStart.setEnabled(false);
		
		prevTime2 = new JLabel("00:00:00");
		prevTime2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		prevTime2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_prevTime2 = new GridBagConstraints();
		gbc_prevTime2.anchor = GridBagConstraints.WEST;
		gbc_prevTime2.insets = new Insets(0, 0, 5, 5);
		gbc_prevTime2.gridx = 4;
		gbc_prevTime2.gridy = 12;
		panel_start.add(prevTime2, gbc_prevTime2);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_5.gridx = 1;
		gbc_verticalStrut_5.gridy = 19;
		panel_start.add(verticalStrut_5, gbc_verticalStrut_5);
		
		JLabel lblHiervoorGestart = new JLabel("Hiervoor gestart");
		lblHiervoorGestart.setHorizontalAlignment(SwingConstants.LEFT);
		lblHiervoorGestart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblHiervoorGestart = new GridBagConstraints();
		gbc_lblHiervoorGestart.anchor = GridBagConstraints.WEST;
		gbc_lblHiervoorGestart.insets = new Insets(0, 0, 5, 5);
		gbc_lblHiervoorGestart.gridx = 1;
		gbc_lblHiervoorGestart.gridy = 9;
		panel_start.add(lblHiervoorGestart, gbc_lblHiervoorGestart);
		
		lblPrevBaan1 = new JLabel("Baan 1");
		lblPrevBaan1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrevBaan1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPrevBaan1 = new GridBagConstraints();
		gbc_lblPrevBaan1.anchor = GridBagConstraints.WEST;
		gbc_lblPrevBaan1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrevBaan1.gridx = 1;
		gbc_lblPrevBaan1.gridy = 10;
		panel_start.add(lblPrevBaan1, gbc_lblPrevBaan1);
		
		prevBaan1 = new JLabel("baan1");
		prevBaan1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_prevBaan1 = new GridBagConstraints();
		gbc_prevBaan1.anchor = GridBagConstraints.EAST;
		gbc_prevBaan1.insets = new Insets(0, 0, 5, 5);
		gbc_prevBaan1.gridx = 3;
		gbc_prevBaan1.gridy = 10;
		panel_start.add(prevBaan1, gbc_prevBaan1);
		
		prevTime1 = new JLabel("00:00:00");
		prevTime1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		prevTime1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_prevTime1 = new GridBagConstraints();
		gbc_prevTime1.anchor = GridBagConstraints.WEST;
		gbc_prevTime1.insets = new Insets(0, 0, 5, 5);
		gbc_prevTime1.gridx = 4;
		gbc_prevTime1.gridy = 10;
		panel_start.add(prevTime1, gbc_prevTime1);
		
		lblPrevBaan2 = new JLabel("Baan 2");
		lblPrevBaan2.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrevBaan2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPrevBaan2 = new GridBagConstraints();
		gbc_lblPrevBaan2.anchor = GridBagConstraints.WEST;
		gbc_lblPrevBaan2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrevBaan2.gridx = 1;
		gbc_lblPrevBaan2.gridy = 12;
		panel_start.add(lblPrevBaan2, gbc_lblPrevBaan2);
		
		prevBaan2 = new JLabel("baan2");
		prevBaan2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_prevBaan2 = new GridBagConstraints();
		gbc_prevBaan2.anchor = GridBagConstraints.EAST;
		gbc_prevBaan2.insets = new Insets(0, 0, 5, 5);
		gbc_prevBaan2.gridx = 3;
		gbc_prevBaan2.gridy = 12;
		panel_start.add(prevBaan2, gbc_prevBaan2);
		btnStart.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  logic.start(bootNummer_1.getText(),bootNummer_2.getText());
		  }
		});

		
		JPanel panel_finish = new JPanel();
		tabbedPane.addTab("Finish", null, panel_finish, null);
		GridBagLayout gbl_panel_finish = new GridBagLayout();
		gbl_panel_finish.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_finish.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_finish.columnWeights = new double[]{0.3, 0.2, 0.2, 0.3, Double.MIN_VALUE};
		gbl_panel_finish.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_finish.setLayout(gbl_panel_finish);
		
		JLabel lblFinishtijden = new JLabel("Finishtijden");
		lblFinishtijden.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblFinishtijden = new GridBagConstraints();
		gbc_lblFinishtijden.anchor = GridBagConstraints.WEST;
		gbc_lblFinishtijden.insets = new Insets(0, 0, 5, 5);
		gbc_lblFinishtijden.gridx = 1;
		gbc_lblFinishtijden.gridy = 0;
		panel_finish.add(lblFinishtijden, gbc_lblFinishtijden);
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7.gridx = 1;
		gbc_verticalStrut_7.gridy = 1;
		panel_finish.add(verticalStrut_7, gbc_verticalStrut_7);
		
		JLabel lblStartnummer_1 = new JLabel("Startnummer");
		lblStartnummer_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblStartnummer_1 = new GridBagConstraints();
		gbc_lblStartnummer_1.anchor = GridBagConstraints.WEST;
		gbc_lblStartnummer_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartnummer_1.gridx = 1;
		gbc_lblStartnummer_1.gridy = 2;
		panel_finish.add(lblStartnummer_1, gbc_lblStartnummer_1);
		
		JLabel lblTijd = new JLabel("Tijd");
		lblTijd.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblTijd = new GridBagConstraints();
		gbc_lblTijd.insets = new Insets(0, 0, 5, 5);
		gbc_lblTijd.anchor = GridBagConstraints.WEST;
		gbc_lblTijd.gridx = 2;
		gbc_lblTijd.gridy = 2;
		panel_finish.add(lblTijd, gbc_lblTijd);
		
		finishNummer_1 = new JTextField();
		finishNummer_1.setHorizontalAlignment(SwingConstants.RIGHT);
		finishNummer_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_finishNummer_1 = new GridBagConstraints();
		gbc_finishNummer_1.anchor = GridBagConstraints.WEST;
		gbc_finishNummer_1.insets = new Insets(0, 0, 5, 5);
		gbc_finishNummer_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_finishNummer_1.gridx = 1;
		gbc_finishNummer_1.gridy = 3;
		panel_finish.add(finishNummer_1, gbc_finishNummer_1);
		finishNummer_1.setColumns(10);
		finishNummer_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c==KeyEvent.VK_ENTER || c==KeyEvent.VK_SPACE) {
					logic.finish(finishNummer_1.getText(),
							finishNummer_2.getText(),finishTijd_2.getText(),
							finishNummer_3.getText(),finishTijd_3.getText(),
							finishNummer_4.getText(),finishTijd_4.getText(),
							finishNummer_5.getText(),finishTijd_5.getText()
					);
				} else if (!((c >= '0') && (c <= '9') ||
					(c == KeyEvent.VK_BACK_SPACE) ||
					(c == KeyEvent.VK_DELETE)) ||
					finishNummer_1.getText().length()>=3
				) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		finishTijd_1 = new JLabel("");
		finishTijd_1.setHorizontalAlignment(SwingConstants.LEFT);
		finishTijd_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_finishTijd_1 = new GridBagConstraints();
		gbc_finishTijd_1.anchor = GridBagConstraints.WEST;
		gbc_finishTijd_1.insets = new Insets(0, 0, 5, 5);
		gbc_finishTijd_1.gridx = 2;
		gbc_finishTijd_1.gridy = 3;
		panel_finish.add(finishTijd_1, gbc_finishTijd_1);
		
		finishNummer_2 = new JTextField();
		finishNummer_2.setHorizontalAlignment(SwingConstants.RIGHT);
		finishNummer_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_finishNummer_2 = new GridBagConstraints();
		gbc_finishNummer_2.anchor = GridBagConstraints.WEST;
		gbc_finishNummer_2.insets = new Insets(0, 0, 5, 5);
		gbc_finishNummer_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_finishNummer_2.gridx = 1;
		gbc_finishNummer_2.gridy = 4;
		panel_finish.add(finishNummer_2, gbc_finishNummer_2);
		finishNummer_2.setColumns(10);
		finishNummer_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c==KeyEvent.VK_ENTER || c==KeyEvent.VK_SPACE) {
					logic.finish(finishNummer_1.getText(),
							finishNummer_2.getText(),finishTijd_2.getText(),
							finishNummer_3.getText(),finishTijd_3.getText(),
							finishNummer_4.getText(),finishTijd_4.getText(),
							finishNummer_5.getText(),finishTijd_5.getText()
					);
					finishNummer_1.requestFocusInWindow();
				} else if (!((c >= '0') && (c <= '9') ||
					(c == KeyEvent.VK_BACK_SPACE) ||
					(c == KeyEvent.VK_DELETE)) ||
					finishNummer_1.getText().length()>=3
				) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		finishTijd_2 = new JLabel("");
		finishTijd_2.setHorizontalAlignment(SwingConstants.LEFT);
		finishTijd_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_finishTijd_2 = new GridBagConstraints();
		gbc_finishTijd_2.anchor = GridBagConstraints.WEST;
		gbc_finishTijd_2.insets = new Insets(0, 0, 5, 5);
		gbc_finishTijd_2.gridx = 2;
		gbc_finishTijd_2.gridy = 4;
		panel_finish.add(finishTijd_2, gbc_finishTijd_2);
		
		finishNummer_3 = new JTextField(3);
		finishNummer_3.setHorizontalAlignment(SwingConstants.RIGHT);
		finishNummer_3.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_finishNummer_3 = new GridBagConstraints();
		gbc_finishNummer_3.anchor = GridBagConstraints.WEST;
		gbc_finishNummer_3.insets = new Insets(0, 0, 5, 5);
		gbc_finishNummer_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_finishNummer_3.gridx = 1;
		gbc_finishNummer_3.gridy = 5;
		panel_finish.add(finishNummer_3, gbc_finishNummer_3);
		finishNummer_3.setColumns(10);
		finishNummer_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c==KeyEvent.VK_ENTER || c==KeyEvent.VK_SPACE) {
					logic.finish(finishNummer_1.getText(),
							finishNummer_2.getText(),finishTijd_2.getText(),
							finishNummer_3.getText(),finishTijd_3.getText(),
							finishNummer_4.getText(),finishTijd_4.getText(),
							finishNummer_5.getText(),finishTijd_5.getText()
					);
					finishNummer_1.requestFocusInWindow();
				} else if (!((c >= '0') && (c <= '9') ||
					(c == KeyEvent.VK_BACK_SPACE) ||
					(c == KeyEvent.VK_DELETE)) ||
					finishNummer_1.getText().length()>=3
				) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		finishTijd_3 = new JLabel("");
		finishTijd_3.setHorizontalAlignment(SwingConstants.LEFT);
		finishTijd_3.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_finishTijd_3 = new GridBagConstraints();
		gbc_finishTijd_3.anchor = GridBagConstraints.WEST;
		gbc_finishTijd_3.insets = new Insets(0, 0, 5, 5);
		gbc_finishTijd_3.gridx = 2;
		gbc_finishTijd_3.gridy = 5;
		panel_finish.add(finishTijd_3, gbc_finishTijd_3);
		
		finishNummer_4 = new JTextField(3);
		finishNummer_4.setHorizontalAlignment(SwingConstants.RIGHT);
		finishNummer_4.setFont(new Font("Tahoma", Font.PLAIN, 28));
		finishNummer_4.setText("");
		GridBagConstraints gbc_finishNummer_4 = new GridBagConstraints();
		gbc_finishNummer_4.anchor = GridBagConstraints.WEST;
		gbc_finishNummer_4.insets = new Insets(0, 0, 5, 5);
		gbc_finishNummer_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_finishNummer_4.gridx = 1;
		gbc_finishNummer_4.gridy = 6;
		panel_finish.add(finishNummer_4, gbc_finishNummer_4);
		finishNummer_4.setColumns(10);
		finishNummer_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c==KeyEvent.VK_ENTER || c==KeyEvent.VK_SPACE) {
					logic.finish(finishNummer_1.getText(),
							finishNummer_2.getText(),finishTijd_2.getText(),
							finishNummer_3.getText(),finishTijd_3.getText(),
							finishNummer_4.getText(),finishTijd_4.getText(),
							finishNummer_5.getText(),finishTijd_5.getText()
					);
					finishNummer_1.requestFocusInWindow();
				} else if (!((c >= '0') && (c <= '9') ||
					(c == KeyEvent.VK_BACK_SPACE) ||
					(c == KeyEvent.VK_DELETE)) ||
					finishNummer_1.getText().length()>=3
				) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		finishTijd_4 = new JLabel("");
		finishTijd_4.setHorizontalAlignment(SwingConstants.LEFT);
		finishTijd_4.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_finishTijd_4 = new GridBagConstraints();
		gbc_finishTijd_4.anchor = GridBagConstraints.WEST;
		gbc_finishTijd_4.insets = new Insets(0, 0, 5, 5);
		gbc_finishTijd_4.gridx = 2;
		gbc_finishTijd_4.gridy = 6;
		panel_finish.add(finishTijd_4, gbc_finishTijd_4);
		
		finishNummer_5 = new JTextField(3);
		finishNummer_5.setFont(new Font("Tahoma", Font.PLAIN, 28));
		finishNummer_5.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 7;
		panel_finish.add(finishNummer_5, gbc_textField);
		finishNummer_5.setColumns(10);
		finishNummer_5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c==KeyEvent.VK_ENTER || c==KeyEvent.VK_SPACE) {
					logic.finish(finishNummer_1.getText(),
							finishNummer_2.getText(),finishTijd_2.getText(),
							finishNummer_3.getText(),finishTijd_3.getText(),
							finishNummer_4.getText(),finishTijd_4.getText(),
							finishNummer_5.getText(),finishTijd_5.getText()
					);
					finishNummer_1.requestFocusInWindow();
				} else if (!((c >= '0') && (c <= '9') ||
					(c == KeyEvent.VK_BACK_SPACE) ||
					(c == KeyEvent.VK_DELETE)) ||
					finishNummer_1.getText().length()>=3
				) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		finishTijd_5 = new JLabel("");
		finishTijd_5.setHorizontalAlignment(SwingConstants.LEFT);
		finishTijd_5.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_finishTijd_5 = new GridBagConstraints();
		gbc_finishTijd_5.anchor = GridBagConstraints.WEST;
		gbc_finishTijd_5.insets = new Insets(0, 0, 5, 5);
		gbc_finishTijd_5.gridx = 2;
		gbc_finishTijd_5.gridy = 7;
		panel_finish.add(finishTijd_5, gbc_finishTijd_5);
		
		finishNummer_6 = new JLabel("");
		finishNummer_6.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_finishNummer_6 = new GridBagConstraints();
		gbc_finishNummer_6.anchor = GridBagConstraints.EAST;
		gbc_finishNummer_6.insets = new Insets(0, 0, 5, 5);
		gbc_finishNummer_6.gridx = 1;
		gbc_finishNummer_6.gridy = 8;
		panel_finish.add(finishNummer_6, gbc_finishNummer_6);
		
		finishTijd_6 = new JLabel("");
		finishTijd_6.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_finishTijd_6 = new GridBagConstraints();
		gbc_finishTijd_6.anchor = GridBagConstraints.WEST;
		gbc_finishTijd_6.insets = new Insets(0, 0, 5, 5);
		gbc_finishTijd_6.gridx = 2;
		gbc_finishTijd_6.gridy = 8;
		panel_finish.add(finishTijd_6, gbc_finishTijd_6);
		
		finishNummer_7 = new JLabel("");
		finishNummer_7.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_finishNummer_7 = new GridBagConstraints();
		gbc_finishNummer_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_finishNummer_7.insets = new Insets(0, 0, 5, 5);
		gbc_finishNummer_7.gridx = 1;
		gbc_finishNummer_7.gridy = 9;
		panel_finish.add(finishNummer_7, gbc_finishNummer_7);
		
		finishTijd_7 = new JLabel("");
		finishTijd_7.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_finishTijd_7 = new GridBagConstraints();
		gbc_finishTijd_7.anchor = GridBagConstraints.WEST;
		gbc_finishTijd_7.insets = new Insets(0, 0, 5, 5);
		gbc_finishTijd_7.gridx = 2;
		gbc_finishTijd_7.gridy = 9;
		panel_finish.add(finishTijd_7, gbc_finishTijd_7);
		
		finishNummer_8 = new JLabel("");
		finishNummer_8.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_finishNummer_8 = new GridBagConstraints();
		gbc_finishNummer_8.anchor = GridBagConstraints.EAST;
		gbc_finishNummer_8.insets = new Insets(0, 0, 5, 5);
		gbc_finishNummer_8.gridx = 1;
		gbc_finishNummer_8.gridy = 10;
		panel_finish.add(finishNummer_8, gbc_finishNummer_8);
		
		finishTijd_8 = new JLabel("");
		finishTijd_8.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_finishTijd_8 = new GridBagConstraints();
		gbc_finishTijd_8.anchor = GridBagConstraints.WEST;
		gbc_finishTijd_8.insets = new Insets(0, 0, 5, 5);
		gbc_finishTijd_8.gridx = 2;
		gbc_finishTijd_8.gridy = 10;
		panel_finish.add(finishTijd_8, gbc_finishTijd_8);
		
		finishNummer_9 = new JLabel("");
		finishNummer_9.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_finishNummer_9 = new GridBagConstraints();
		gbc_finishNummer_9.anchor = GridBagConstraints.EAST;
		gbc_finishNummer_9.insets = new Insets(0, 0, 5, 5);
		gbc_finishNummer_9.gridx = 1;
		gbc_finishNummer_9.gridy = 11;
		panel_finish.add(finishNummer_9, gbc_finishNummer_9);
		
		finishTijd_9 = new JLabel("");
		finishTijd_9.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_finishTijd_9 = new GridBagConstraints();
		gbc_finishTijd_9.anchor = GridBagConstraints.WEST;
		gbc_finishTijd_9.insets = new Insets(0, 0, 5, 5);
		gbc_finishTijd_9.gridx = 2;
		gbc_finishTijd_9.gridy = 11;
		panel_finish.add(finishTijd_9, gbc_finishTijd_9);
		
		finishNummer_10 = new JLabel("");
		finishNummer_10.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_finishNummer_10 = new GridBagConstraints();
		gbc_finishNummer_10.anchor = GridBagConstraints.EAST;
		gbc_finishNummer_10.insets = new Insets(0, 0, 0, 5);
		gbc_finishNummer_10.gridx = 1;
		gbc_finishNummer_10.gridy = 12;
		panel_finish.add(finishNummer_10, gbc_finishNummer_10);
		
		finishTijd_10 = new JLabel("");
		finishTijd_10.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_finishTijd_10 = new GridBagConstraints();
		gbc_finishTijd_10.anchor = GridBagConstraints.WEST;
		gbc_finishTijd_10.insets = new Insets(0, 0, 0, 5);
		gbc_finishTijd_10.gridx = 2;
		gbc_finishTijd_10.gridy = 12;
		panel_finish.add(finishTijd_10, gbc_finishTijd_10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Time Sync", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.1, 0.1, 0.3, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		panel_1.add(verticalStrut, gbc_verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 2;
		gbc_verticalStrut_1.gridy = 0;
		panel_1.add(verticalStrut_1, gbc_verticalStrut_1);
		
		btnStartTijd = new JButton("Start tijd");
		btnStartTijd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnStartTijd.setEnabled(true);
		GridBagConstraints gbc_btnStartTijd = new GridBagConstraints();
		gbc_btnStartTijd.anchor = GridBagConstraints.WEST;
		gbc_btnStartTijd.insets = new Insets(0, 0, 5, 5);
		gbc_btnStartTijd.gridx = 1;
		gbc_btnStartTijd.gridy = 1;
		panel_1.add(btnStartTijd, gbc_btnStartTijd);
		
		btnResetTijd = new JButton("Reset tijd");
		btnResetTijd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnResetTijd.setEnabled(false);
		GridBagConstraints gbc_btnResetTijd = new GridBagConstraints();
		gbc_btnResetTijd.anchor = GridBagConstraints.WEST;
		gbc_btnResetTijd.insets = new Insets(0, 0, 5, 0);
		gbc_btnResetTijd.gridx = 2;
		gbc_btnResetTijd.gridy = 1;
		panel_1.add(btnResetTijd, gbc_btnResetTijd);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 1;
		gbc_verticalStrut_6.gridy = 2;
		panel_1.add(verticalStrut_6, gbc_verticalStrut_6);
		
		JLabel lblWedstrijdType = new JLabel("Wedstrijdtype");
		lblWedstrijdType.setHorizontalAlignment(SwingConstants.LEFT);
		lblWedstrijdType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblWedstrijdType = new GridBagConstraints();
		gbc_lblWedstrijdType.anchor = GridBagConstraints.WEST;
		gbc_lblWedstrijdType.insets = new Insets(0, 0, 5, 5);
		gbc_lblWedstrijdType.gridx = 1;
		gbc_lblWedstrijdType.gridy = 6;
		panel_1.add(lblWedstrijdType, gbc_lblWedstrijdType);
		
		rdbtnAchterVolging = new JRadioButton("Achtervolging");
		rdbtnAchterVolging.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnAchterVolging.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_rdbtnAchterVolging = new GridBagConstraints();
		gbc_rdbtnAchterVolging.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAchterVolging.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAchterVolging.gridx = 1;
		gbc_rdbtnAchterVolging.gridy = 7;
		panel_1.add(rdbtnAchterVolging, gbc_rdbtnAchterVolging);
		rdbtnAchterVolging.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.setLaneCount(1);
			}
		});
		
		rdbtnBoordAanBoord = new JRadioButton("Boord aan boord");
		rdbtnBoordAanBoord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnBoordAanBoord.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_rdbtnBoordAanBoord = new GridBagConstraints();
		gbc_rdbtnBoordAanBoord.anchor = GridBagConstraints.WEST;
		gbc_rdbtnBoordAanBoord.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnBoordAanBoord.gridx = 1;
		gbc_rdbtnBoordAanBoord.gridy = 8;
		panel_1.add(rdbtnBoordAanBoord, gbc_rdbtnBoordAanBoord);
		rdbtnBoordAanBoord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.setLaneCount(2);
			}
		});
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAchterVolging);
		group.add(rdbtnBoordAanBoord);
		
		JPanel panel_teams = new JPanel();
		tabbedPane.addTab("Teams", null, panel_teams, null);
		GridBagLayout gbl_panel_teams = new GridBagLayout();
		gbl_panel_teams.columnWidths = new int[]{0, 0, 0};
		gbl_panel_teams.rowHeights = new int[]{0, 0, 0};
		gbl_panel_teams.columnWeights = new double[]{0.05, 0.9, 0.05};
		gbl_panel_teams.rowWeights = new double[]{0.05, 0.9, 0.05};
		panel_teams.setLayout(gbl_panel_teams);
		
		JLabel lblNewLabel_1 = new JLabel("Team overzicht");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel_teams.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		teamTable = new JTable();
		teamTable.setBorder(null);
		teamTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		teamTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		teamTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 16));
		teamTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		teamTable.setModel(new DefaultTableModel(colNames, 1));
		JScrollPane teamScrollPane = new JScrollPane();
		teamScrollPane.setViewportView(teamTable);
		panel_teams.add(teamScrollPane, gbc_table);
		
				btnResetTijd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						logic.reset();
					}
				});
				
				btnStartTijd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						logic.sync();
					}
				});
		
		JPanel panel_status = new JPanel();
		contentPane.add(panel_status, BorderLayout.NORTH);
		GridBagLayout gbl_panel_status = new GridBagLayout();
		gbl_panel_status.columnWidths = new int[]{322, 59, 217, 20, 102, 20, 86, 0};
		gbl_panel_status.rowHeights = new int[]{44, 0};
		gbl_panel_status.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_status.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_status.setLayout(gbl_panel_status);
		
		JLabel lblNewLabel = new JLabel("Tijd");
		lblNewLabel.setForeground(new Color(0, 204, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel_status.add(lblNewLabel, gbc_lblNewLabel);
		
		lblTime = new JLabel("00:00:00.000");
		lblTime.setForeground(new Color(0, 204, 0));
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTime.insets = new Insets(0, 0, 0, 5);
		gbc_lblTime.gridx = 2;
		gbc_lblTime.gridy = 0;
		panel_status.add(lblTime, gbc_lblTime);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.anchor = GridBagConstraints.WEST;
		gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut.gridx = 3;
		gbc_horizontalStrut.gridy = 0;
		panel_status.add(horizontalStrut, gbc_horizontalStrut);
		
		lblOffline = new JLabel("Offline");
		lblOffline.setForeground(Color.RED);
		lblOffline.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_lblOffline = new GridBagConstraints();
		gbc_lblOffline.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblOffline.insets = new Insets(0, 0, 0, 5);
		gbc_lblOffline.gridx = 4;
		gbc_lblOffline.gridy = 0;
		panel_status.add(lblOffline, gbc_lblOffline);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.anchor = GridBagConstraints.WEST;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1.gridx = 5;
		gbc_horizontalStrut_1.gridy = 0;
		panel_status.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		lblSync = new JLabel("*sync*");
		lblSync.setForeground(new Color(0, 204, 0));
		lblSync.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblSync.setVisible(false);
		GridBagConstraints gbc_lblSync = new GridBagConstraints();
		gbc_lblSync.anchor = GridBagConstraints.WEST;
		gbc_lblSync.gridx = 6;
		gbc_lblSync.gridy = 0;
		panel_status.add(lblSync, gbc_lblSync);
		
		copyRight = new JLabel("By Johan van der Sman (johan.sman@gmail.com)");
		copyRight.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(copyRight, BorderLayout.SOUTH);
				
		logic=new Logic(this);
	}
	
	public void showLanes(int laneCount) {
		if (laneCount>1) {
			lblBaan2.setVisible(true);
			bootNummer_2.setVisible(true);
			lblPrevBaan2.setVisible(true);
			prevBaan2.setVisible(true);
			prevTime1.setVisible(true);
			rdbtnAchterVolging.setSelected(false);
			rdbtnBoordAanBoord.setSelected(true);
		} else {
			lblBaan2.setVisible(false);
			bootNummer_2.setVisible(false);
			lblPrevBaan2.setVisible(false);
			prevBaan2.setVisible(false);
			prevTime1.setVisible(false);
			rdbtnAchterVolging.setSelected(true);
			rdbtnBoordAanBoord.setSelected(false);
		}
	}
	
	public void showTime(String timeStr) {
		lblTime.setText(timeStr);
		finishTijd_1.setText(timeStr);

	}
	
	public void showOnline(Boolean online) {
		if (online) {
			lblOffline.setText("Online");
			lblOffline.setForeground(new Color(0, 204, 0));
		} else {
			lblOffline.setText("Offline");
			lblOffline.setForeground(Color.RED);
		}
		
	}

	public void showSync(Boolean ind) {
		lblSync.setVisible(ind);
	}

	public void showLoginMsg(String msg, Boolean success) {
		lblLoginMsg.setText(msg);
		if (success) {
			lblLoginMsg.setForeground(Color.decode("0x00CC00"));
		} else {
			lblLoginMsg.setForeground(Color.RED);			
		}
	}
	
	public void showTeams(List<Team> teams) {
		if (teams.size()>0) {
			DefaultTableModel teamModel=new DefaultTableModel();
			teamModel.setColumnIdentifiers(colNames);
			Iterator<Team> it=teams.iterator();
			while (it.hasNext()) {
				Team t=it.next();
				teamModel.addRow(t.giveData());
			}
			teamTable.setModel(teamModel);
		    final TableColumnModel columnModel = teamTable.getColumnModel();
			for (int column = 0; column < teamTable.getColumnCount(); column++) {
				int width = 50; // Min width
			    for (int row = 0; row < teamTable.getRowCount(); row++) {
			    	TableCellRenderer renderer = teamTable.getCellRenderer(row, column);
			        Component comp = teamTable.prepareRenderer(renderer, row, column);
			        width = Math.max(comp.getPreferredSize().width, width);
			    }
			    columnModel.getColumn(column).setPreferredWidth(width);
			}
		}
	}
	
	public Boolean confirmReset() {
		Object[] options = { "Reset", "Annuleren" };
		int answer=JOptionPane.showOptionDialog(this, "Klik reset om tijd op 0 te zetten", "Waarschuwing", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, options, options[0]);
		return answer==0;
	}
	
	public void setStartActive(Boolean ind) {
		btnStartTijd.setEnabled(ind);
		rdbtnBoordAanBoord.setEnabled(ind);
		rdbtnAchterVolging.setEnabled(ind);
	}

	public void setResetActive(Boolean ind) {
		btnResetTijd.setEnabled(ind);
		btnStart.setEnabled(ind);
	}
	
	public void setLane(int lane, int startNum) {
		if (lane==0) {
			bootNummer_1.setText(Integer.toString(startNum));
		} else if (lane==1) {
			bootNummer_2.setText(Integer.toString(startNum));
		}
	}
	
	public void setStart(int boot1, int boot2) {
		if (boot1>0) {
			bootNummer_1.setText(Integer.toString(boot1));
		} else {
			bootNummer_1.setText("");			
		}
		if (boot2>0) {
			bootNummer_2.setText(Integer.toString(boot2));
		} else {
			bootNummer_2.setText("");						
		}
	}
	
	public void setPrev(int boot1, int boot2, RelativeTime start) {
		if (boot1>0) {
			prevBaan1.setText(Integer.toString(boot1));
			prevTime1.setText(start.toString());
		} else {
			prevBaan1.setText("");			
			prevTime1.setText("");			
		}
		if (boot2>0) {
			prevBaan2.setText(Integer.toString(boot2));
			prevTime2.setText(start.toString());
		} else {
			prevBaan2.setText("");
			prevTime2.setText("");
		}
	}
	
	public void shiftFinishTimes(RelativeTime last) {
		finishNummer_10.setText(finishNummer_9.getText());
		finishNummer_9.setText(finishNummer_8.getText());
		finishNummer_8.setText(finishNummer_7.getText());
		finishNummer_7.setText(finishNummer_6.getText());
		finishNummer_6.setText(finishNummer_5.getText());
		finishNummer_5.setText(finishNummer_4.getText());
		finishNummer_4.setText(finishNummer_3.getText());
		finishNummer_3.setText(finishNummer_2.getText());
		finishNummer_2.setText(finishNummer_1.getText());
		finishNummer_1.setText("");
		finishTijd_10.setText(finishTijd_9.getText());
		finishTijd_9.setText(finishTijd_8.getText());
		finishTijd_8.setText(finishTijd_7.getText());
		finishTijd_7.setText(finishTijd_6.getText());
		finishTijd_6.setText(finishTijd_5.getText());
		finishTijd_5.setText(finishTijd_4.getText());
		finishTijd_4.setText(finishTijd_3.getText());
		finishTijd_3.setText(finishTijd_2.getText());
		finishTijd_2.setText(last.toString());
	}
	
	public void clearData() {
		finishNummer_10.setText("");
		finishNummer_9.setText("");
		finishNummer_8.setText("");
		finishNummer_7.setText("");
		finishNummer_6.setText("");
		finishNummer_5.setText("");
		finishNummer_4.setText("");
		finishNummer_3.setText("");
		finishNummer_2.setText("");
		finishNummer_1.setText("");
		finishTijd_10.setText("");
		finishTijd_9.setText("");
		finishTijd_8.setText("");
		finishTijd_7.setText("");
		finishTijd_6.setText("");
		finishTijd_5.setText("");
		finishTijd_4.setText("");
		finishTijd_3.setText("");
		finishTijd_2.setText("");
		finishTijd_1.setText("");
		bootNummer_1.setText("");
		bootNummer_2.setText("");	
		prevBaan1.setText("");
		prevBaan2.setText("");
		prevTime1.setText("");
		prevTime2.setText("");
	}
}