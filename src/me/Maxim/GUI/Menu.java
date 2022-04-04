package me.Maxim.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

	JComboBox<String> subjects;
	JTextArea age;
	JButton submit;
	JLabel desc;
	JLabel error;
	JPanel p1;
	JPanel p2;
	JPanel p3;
	JPanel mainPanel;

	public Menu() {
		init();
	}

	public void submit() {
		try {
			int i = Integer.parseInt(age.getText());
			if (i > 15) {
				error.setText("You are too old!");
			}
			else if (i < 14) {
				error.setText("You are too young!");
			}
			else {
				error.setText("Signed up for " + subjects.getItemAt(subjects.getSelectedIndex()) + " GCSE!");
			}
		}
		catch (Exception e) {
			error.setText("Age is not a valid number!");
		}
	}

	public void exit() {
		dispose();
		System.exit(0);
	}

	public void init() {
		String[] options = {"Biology", "Chemistry", "Physics", "English", "Spanish", "Chinese", "Russian",
				"Maths", "Further Maths", "Economics", "Business Studies", "Sociology", "Art", "Drama", "History",
				"Geography", "Computer Science", "PE", "English Lit"};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		subjects = new JComboBox<>(options);
		subjects.setVisible(true);
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		mainPanel = new JPanel();
		p1.setOpaque(false);
		p2.setOpaque(false);
		p3.setOpaque(false);
		p1.setSize(600, 50);
		p2.setSize(600, 50);
		p3.setSize(600, 50);
		mainPanel.setSize(600, 200);
		mainPanel.setOpaque(false);
		desc = new JLabel();
		desc.setVisible(true);
		desc.setText("Please select your subject and enter your age!");
		p1.add(desc);
		error = new JLabel();
		error.setVisible(true);
		error.setText("");
		age = new JTextArea(1, 10);
		age.setVisible(true);
		submit = new JButton();
		submit.setVisible(true);
		submit.setText("Submit");
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		p2.add(subjects);
		p2.add(age);
		p2.add(submit);
		p3.add(error);

		setSize(600, 200);

		mainPanel.add(p1);
		mainPanel.add(p2);
		mainPanel.add(p3);
		add(mainPanel);
		setLayout(null);
		mainPanel.setLayout(null);
		p1.setBounds(0, 0, 600, 50);
		p2.setBounds(0, 50, 600, 50);
		p3.setBounds(0, 100, 600, 50);
	}

}
