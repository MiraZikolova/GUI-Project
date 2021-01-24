package guiProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class GUIVerification {

	public static <secondbox> void main(String[] args) {
		// Creating instance of JFrame
		JFrame frame = new JFrame("Verification");
		// Setting the width and height of frame
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * Creating panel. This is same as a div tag in HTML We can create several
		 * panels and add them to specific positions in a JFrame. Inside panels we can
		 * add text fields, buttons and other components.
		 */
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		// adding panel to frame
		frame.getContentPane().add(panel);
		/*
		 * calling user defined method for adding components to the panel.
		 */

		/*
		 * We will discuss about layouts in the later sections of this tutorial. For now
		 * we are setting the layout to null
		 */
		panel.setLayout(null);

		// Creating JLabel
		JLabel userLabel = new JLabel("Username:");
		userLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		/*
		 * This method specifies the location and size of component. setBounds(x, y,
		 * width, height) here (x,y) are cordinates from the top left corner and
		 * remaining two arguments are the width and height of the component.
		 */
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);

		/*
		 * Creating text field where user is supposed to enter user name.
		 */
		JTextField userText = new JTextField(20);
		userText.setFont(new Font("Century Gothic", Font.BOLD, 12));
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);

		// Same process for password label and text field.
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);

		/*
		 * This is similar to text field but it hides the user entered data and displays
		 * dots instead to protect the password like we normally see on login screens.
		 */
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setFont(new Font("Century Gothic", Font.BOLD, 12));
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);

		// Creating login button
		JButton loginButton = new JButton("ENTER");
		loginButton.setBackground(new Color(245, 245, 245));
		loginButton.setFont(new Font("Century Gothic", Font.BOLD, 14));
		loginButton.setBounds(100, 102, 80, 25);
		panel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname = userText.getText();
				String pswrd = passwordText.getText();
				
				if(uname.equals ("name") && pswrd.equals("password")) {
					JOptionPane.showMessageDialog(frame, "Correct! You are allowed to view the following information.");
					
					GUISecondBox second = new GUISecondBox();
					second.setVisible(true);
					frame.setVisible(false);
					
			}else {
				JOptionPane.showMessageDialog(frame, "Incorrect username or password! Please try again.");
			}
		}
		});
		// Setting the frame visibility to true
		frame.setVisible(true);

	}

}