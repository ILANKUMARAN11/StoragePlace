package com.ilan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class LoginFrame {

    /**
	 * 
	 */
	
	JFrame jframe=new JFrame();
	Container container = jframe.getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");


    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO on click on login button
				
				 String userText;
		            String pwdText;
		            userText = userTextField.getText();
		            pwdText = passwordField.getText();
		            if (userText.equalsIgnoreCase("mehtab") && pwdText.equalsIgnoreCase("12345")) {
		                JOptionPane.showMessageDialog(jframe, "Login Successful");
		            } else {
		                JOptionPane.showMessageDialog(jframe, "Invalid Username or Password");
		            }
				
			}
		});
        
        
        resetButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO on click on Reset button
				userTextField.setText("");
	            passwordField.setText("");
	            showPassword.setSelected(false);
				
			}
		});
        
        
        showPassword.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO on click on Show passord
				
				if (showPassword.isSelected()) {
	                passwordField.setEchoChar((char) 0);
	            } else {
	                passwordField.setEchoChar('*');
	            }
				
			}
		});
    }
    
    
    public void closeJframe() {
		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.out.println("Call ur method here");
				System.exit(0);
			}
		});
	}


    

}

public class Login {
    public static void main(String[] a) {
        LoginFrame frame = new LoginFrame();
        
        frame.jframe.setTitle("Login Form");
        frame.jframe.setVisible(true);
        frame.jframe.setBounds(10, 10, 370, 600);
        frame.jframe.setResizable(false);
        frame.closeJframe();

    }

}