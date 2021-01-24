package guiProject;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GUISecondBox extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISecondBox frame = new GUISecondBox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUISecondBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		//JFrame frame = new JFrame("My Password Saver");
		setSize(755, 322);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// main containers and Layouts
		JPanel mainPanel = new JPanel();
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		JPanel leftPanel = new JPanel();
		mainPanel.add(leftPanel);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(new Color(255, 228, 196));
		rightPanel.setForeground(Color.BLACK);
		mainPanel.add(rightPanel);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

		// left side
		JLabel passwordSaverLabel = new JLabel("My Password Saver                 ");
		passwordSaverLabel.setBackground(new Color(255, 228, 196));
		passwordSaverLabel.setForeground(new Color(205, 92, 92));
		passwordSaverLabel.setFont(new Font("Stencil", Font.BOLD, 18));
		leftPanel.add(passwordSaverLabel);

		JTextArea platformArea = new JTextArea();
		platformArea.setFont(new Font("Century Gothic", Font.BOLD, 10));
		platformArea.setBackground(new Color(255, 218, 185));
		platformArea.setForeground(Color.BLACK);
		platformArea.setBounds(100, 20, 165, 25);
		platformArea.setEditable(false);
		leftPanel.add(platformArea);
		File myObj = new File("filename.txt");
		String text = "";
		try {
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				text += myReader.nextLine() + "\n";
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			try {
				myObj.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		platformArea.setText(text);

		// right side
	
		
		JLabel nameLabel = new JLabel("Name of platform:");
		nameLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rightPanel.add(nameLabel);
		JTextField nameText = new JTextField();
		nameText.setFont(new Font("Century Gothic", Font.BOLD, 11));
		rightPanel.add(nameText);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rightPanel.add(emailLabel);
		JTextField emailText = new JTextField();
		emailText.setFont(new Font("Century Gothic", Font.BOLD, 11));
		rightPanel.add(emailText);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rightPanel.add(usernameLabel);
		JTextField usernameText = new JTextField();
		usernameText.setFont(new Font("Century Gothic", Font.BOLD, 11));
		rightPanel.add(usernameText);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rightPanel.add(passwordLabel);
		JTextField passwordText = new JTextField();
		passwordText.setFont(new Font("Century Gothic", Font.BOLD, 11));
		rightPanel.add(passwordText);
		
		JLabel linkLabel = new JLabel("Link:");
		linkLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rightPanel.add(linkLabel);
		JTextField linkText = new JTextField();
		linkText.setFont(new Font("Century Gothic", Font.BOLD, 11));
		rightPanel.add(linkText);	
	
	

		JButton saveButton = new JButton("Save");
		saveButton.setVerticalAlignment(SwingConstants.BOTTOM);
		saveButton.setFont(new Font("Stencil", Font.PLAIN, 15));
		saveButton.setForeground(new Color(255, 255, 255));
		saveButton.setBackground(new Color(205, 92, 92));
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = nameText.getText();
				String email = emailText.getText();
				String username = usernameText.getText();
				String password = passwordText.getText();
				String link = linkText.getText();
				if (name.isEmpty() && email.isEmpty() && username.isEmpty() && password.isEmpty() && link.isEmpty()) {
					return;
				}
				String text = "name: " + name + "\n"
				+ "email: " + email + "\n" 
				+ "username: " + username + "\n"
				+ "password: " + password + "\n" 
				+ "link: " + link + "\n";
				try {
					FileWriter myWriter = new FileWriter("filename.txt",true);
					myWriter.write(text);
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
				
				File myObj = new File("filename.txt");
				text = "";
				try {
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						text += myReader.nextLine() + "\n";
					}
					myReader.close();
				} catch (FileNotFoundException e) {
					try {
						myObj.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				platformArea.setText(text);

			}
		});
		rightPanel.add(saveButton);

		JLabel inspirationLabel = new JLabel("Choosing a hard-to-guess, but easy-to-remember password is important!");
		inspirationLabel.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		rightPanel.add(inspirationLabel);
		



		pack();
	}
}