package com.ilan.auto.deploy;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import com.google.common.base.Strings;
import com.ilan.auto.deploy.service.ReadResouce;
import com.ilan.auto.deploy.service.RootPath;
import com.ilan.auto.deploy.service.swing.JTextFieldLimit;

public class SwingControlDemo {

	JWindow window;
	JFrame jframe;
	Container container;
	JLabel userLabel;
	JLabel passwordLabel;
	JLabel envLabel;
	JTextField userTextField;
	JPasswordField passwordField;
	JCheckBox showPassword;
	JButton loginButton;
	JButton resetButton;

	String s1[] = { "Jalpaiguri", "Mumbai", "Noida", "Kolkata", "New Delhi" };
	JList<String> vegList;
	JScrollPane vegListScrollPane;

	JMenuBar mb;
	JMenu m1;
	JMenu m2;

	JMenuItem mi1_New;
	JMenuItem mi2_Open;
	JMenuItem mi3_Print;

	public SwingControlDemo() {

		jframe = new JFrame("Auto Deployment");
		container = jframe.getContentPane();
		userLabel = new JLabel("Commit ID: ");
		passwordLabel = new JLabel("Password: ");
		envLabel = new JLabel("Environment: ");
		userTextField = new JTextField();
		passwordField = new JPasswordField();
		showPassword = new JCheckBox("Show Password");
		loginButton = new JButton("DEPLOY");
		resetButton = new JButton("RESET");

		String s1[] = { "Jalpaiguri", "Mumbai", "Noida", "Kolkata", "New Delhi" };
		vegList = new JList<String>(s1);
		vegListScrollPane = new JScrollPane(vegList);

		mb = new JMenuBar();
		m1 = new JMenu("File");
		m2 = new JMenu("About");

		mi1_New = new JMenuItem("New");
		mi2_Open = new JMenuItem("Open");
		mi3_Print = new JMenuItem("Print");

		this.window = new JWindow();
		ImageIcon loading = new ImageIcon(ReadResouce.getInstance().getFilePath("BrokenCircle.gif"));
		window.getContentPane().add(new JLabel("loading... ", loading, SwingConstants.CENTER));

		window.setBounds(500, 150, 500, 500);
		window.setVisible(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

		window.setVisible(false);

	}

	public void easyLoadFrame() {
		JFrame jframe = createJrame();
		loadFrame();
		jframe.setVisible(true);

		window.dispose();
	}

	private JFrame createJrame() {
		jframe.setSize(500, 500);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		return jframe;
	}

	private void loadFrame() {
		setLayoutManager();
		design();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		addMenuActionEvent();
		closeJframe();

	}

	private void setLayoutManager() {
		container.setLayout(null);
	}

	private void design() {
		container.setBackground(Color.GRAY);

		userTextField.setDocument(new JTextFieldLimit(7));

		vegListScrollPane.setViewportView(vegList);
		vegList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		vegList.setVisibleRowCount(3);
		vegList.setLayoutOrientation(JList.VERTICAL);

		mb.setBackground(Color.RED);

	}

	private void setLocationAndSize() {

		userLabel.setBounds(50, 150, 100, 30);
		passwordLabel.setBounds(50, 220, 100, 30);
		userTextField.setBounds(180, 150, 150, 30);
		passwordField.setBounds(180, 220, 150, 30);
		showPassword.setBounds(180, 250, 150, 30);
		envLabel.setBounds(50, 290, 100, 30);
		vegListScrollPane.setBounds(182, 290, 145, 70);
		loginButton.setBounds(50, 400, 150, 40);
		resetButton.setBounds(250, 400, 150, 40);

	}

	private void addComponentsToContainer() {
		showHeader();
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(showPassword);
		container.add(loginButton);
		container.add(resetButton);
		container.add(envLabel);
		container.add(vegListScrollPane);

		// m1.add(mi1_New);
		m1.add(mi2_Open);
		m1.add(mi3_Print);

		mb.add(m1);
		mb.add(m2);
		jframe.setJMenuBar(mb);
	}

	private void addActionEvent() {
		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String userText = userTextField.getText();
				String pwdText = String.valueOf(passwordField.getPassword());

				String errorMsg = "";
				String dotBullet = "\u2022";
				String triangularBullet = "\u2023";
				String newLine = "\n" + " " + dotBullet + "  ";

				if (Strings.isNullOrEmpty(userText) || Strings.isNullOrEmpty(userText)) {
					errorMsg += " " + dotBullet + "  " + "Commit ID is Empty";
				} else {
					if (userText.length() < 7) {
						errorMsg += " " + dotBullet + "  " + "Commit ID is less than 7 Character";
					}
				}

				if (Strings.isNullOrEmpty(pwdText) || Strings.isNullOrEmpty(pwdText)) {

					if (Strings.isNullOrEmpty(errorMsg) || Strings.isNullOrEmpty(errorMsg)) {
						errorMsg += "Password is Empty";
					} else {
						errorMsg += newLine + "Password is Empty";
					}
				}

				if (!vegList.getSelectedValuesList().isEmpty() && vegList.getSelectedIndex() != -1) {

					ArrayList lst = (ArrayList) vegList.getSelectedValuesList();

					System.out.println(lst);

				} else {

					if (Strings.isNullOrEmpty(errorMsg) || Strings.isNullOrEmpty(errorMsg)) {
						errorMsg += "Select atleast one env to deploy";
					} else {
						errorMsg += newLine + "Select atleast one environment to deploy";
					}

				}

				if (errorMsg != null && !errorMsg.isEmpty()) {
					JOptionPane.showMessageDialog(jframe, errorMsg, "Error!", JOptionPane.ERROR_MESSAGE);

				}
			}
		});

		resetButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				userTextField.setText("");
				passwordField.setText("");
				showPassword.setSelected(false);
				vegList.clearSelection();

			}
		});

		showPassword.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (showPassword.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('*');
				}

			}
		});

	}

	private void addMenuActionEvent() {

		mi1_New.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		mi2_Open.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO on click of Open

				// Create an object of JFileChooser class
				JFileChooser j = new JFileChooser(RootPath.getInstance().getRootPath());

				// Invoke the showsOpenDialog function to show the save dialog
				int r = j.showOpenDialog(null);

				// If the user selects a file
				if (r == JFileChooser.APPROVE_OPTION) {
					// Set the label to the path of the selected directory
					File openedFile = new File(j.getSelectedFile().getAbsolutePath());

					try {
						if (!Desktop.isDesktopSupported()) {
							JOptionPane.showMessageDialog(jframe, "Desktop is not supported");
							return;
						}

						Desktop desktop = Desktop.getDesktop();
						if (openedFile.exists())
							desktop.open(openedFile);

					} catch (Exception evt) {
						JOptionPane.showMessageDialog(jframe, evt.getMessage());
					}
				}
				// If the user cancelled the operation
				else {
					JOptionPane.showMessageDialog(jframe, "the user cancelled the operation");
				}

			}
		});

		mi3_Print.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO on click Print

				try {
					// print the file
					// t.print();
				} catch (Exception evt) {
					JOptionPane.showMessageDialog(jframe, evt.getMessage());
				}

			}
		});

	}

	private void showHeader() {
		ImageIcon icon = new ImageIcon(new ImageIcon(ReadResouce.getInstance().getFilePath("automated-deployment.png"))
				.getImage().getScaledInstance(250, 125, Image.SCALE_DEFAULT));

		JLabel headerLabel = new JLabel(icon, JLabel.CENTER);

		headerLabel.setBounds(130, 15, 250, 125);

		container.add(headerLabel);
	}

	private void closeJframe() {
		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.out.println("Call ur method here");
				System.exit(0);
			}
		});
	}

}
