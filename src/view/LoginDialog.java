package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JPasswordField;

import model.Account;

public class LoginDialog extends JDialog implements FreeRegistrationEventListener,RequestAccountEventListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private FreeRegistrationDialog freeRegistrationDialog;
	private LogInEventListener loginListener;
	private FreeRegistrationEventListener freeRegListener;
	private RequestAccountEventListener reqlistener;
	private boolean isExistingAccount;

	/**
	 * Create the dialog.
	 */
	public LoginDialog(JFrame parent) {
		super(parent,"Log In",true);//true sets modal
		freeRegistrationDialog = new FreeRegistrationDialog(this);
		
		setBounds(100, 100, 400, 235);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
			JLabel lblUsername = new JLabel("Username");
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_lblUsername = new GridBagConstraints();
			gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsername.anchor = GridBagConstraints.EAST;
			gbc_lblUsername.gridx = 2;
			gbc_lblUsername.gridy = 1;
			contentPanel.add(lblUsername, gbc_lblUsername);
		
		
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 4;
			gbc_textField.gridy = 1;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		
		
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblPassword.anchor = GridBagConstraints.EAST;
			gbc_lblPassword.gridx = 2;
			gbc_lblPassword.gridy = 2;
			contentPanel.add(lblPassword, gbc_lblPassword);
		
		
			passwordField = new JPasswordField();
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.insets = new Insets(0, 0, 5, 5);
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 4;
			gbc_passwordField.gridy = 2;
			contentPanel.add(passwordField, gbc_passwordField);
		
		
			JButton btnLogIn = new JButton("Log In");
			btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_btnLogIn = new GridBagConstraints();
			gbc_btnLogIn.insets = new Insets(0, 0, 5, 5);
			gbc_btnLogIn.gridx = 4;
			gbc_btnLogIn.gridy = 3;
			contentPanel.add(btnLogIn, gbc_btnLogIn);
			btnLogIn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String username = textField.getText();
					String pass = new String(passwordField.getPassword());
					Account account = new Account(username,pass,false);
					if (loginListener!=null)
					loginListener.loginEventOccurred(account);
				}
			});
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
						
				JButton btnRegFree = new JButton("Register Free");
				btnRegFree.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						freeRegistrationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						freeRegistrationDialog.setFreeRegistrationEventOberservers(LoginDialog.this);
						freeRegistrationDialog.setRequestAccountEventListener(LoginDialog.this);
						freeRegistrationDialog.setVisible(true);
					}
				});
				buttonPane.add(btnRegFree);
			
	}
	
	public void validateUserName(){
		
	}
	public void validatePassword(){
		
	}
	
	public boolean isAccountTaken(boolean b){
		freeRegistrationDialog.isAccountTaken(b);

		return b;
	}

	public void setLogInEventListener(LogInEventListener listener) {
		this.loginListener = listener;
	}

	public void setFreeRegEventListener(FreeRegistrationEventListener listener) {
		this.freeRegListener = listener;
	}


	
	//FreeRegistrationDialog calling this method, pass event object to MainFrame
	@Override
	public void FreeRegistrationEventOccurred(FreeRegistrationEvent e) { 
		if (freeRegListener == null){
			System.out.println("in Login: freeRegListener = null");
		}
		freeRegListener.FreeRegistrationEventOccurred(e);
	}

	public void setRequestEventAccountListener(RequestAccountEventListener listener) {
		this.reqlistener = listener;
	}

	@Override
	public void requestAccountEventOccurred(RequestAccountEvent e) {
		reqlistener.requestAccountEventOccurred(e);
	}

	public boolean isValidLogin(boolean b) {
		if (b == true){
			JOptionPane.showMessageDialog(null, "Successful Login");
		}else{
			JOptionPane.showMessageDialog(null, "Login Failed");
		}
		return false;

	}

}
