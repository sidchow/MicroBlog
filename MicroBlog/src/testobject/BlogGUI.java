package testobject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.text.Position;

public class BlogGUI implements ActionListener {
	
	private JFrame mainFrame = new JFrame("Micro Blog Demo");
	private JLabel countChar = new JLabel("Count the input");
	private JTextArea postTextArea = new JTextArea(10,380);
	private JTextField postContent = new JTextField("Here is all the post!");
	private JButton refreshBT = new JButton("Refresh");
	private JButton postBT = new JButton("Post");
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == postBT){
			postContent.setText("You click POST!!");
		}else if(e.getSource() == refreshBT){
			postContent.setText("You click REFRESH!!");
		};
			
	};
	
	public BlogGUI(){
		
	}
	
	public void setWindow(){
		//Construct the layout of Main Windows
		mainFrame.setSize(400, 600);
		mainFrame.setLayout(new GridLayout(2,1));
		
		//Set Background Color
		Color c1= new Color(255,255,204);
		postTextArea.setBackground(c1);
		
		/**
		refreshBT.setBackground(Color.CYAN);
		refreshBT.setOpaque(true);
		refreshBT.setBorderPainted(false);
		postBT.setBackground(Color.blue);
		postBT.setOpaque(true);
		postBT.setBorderPainted(false);
		*/
		//Set Initial Value
		postTextArea.setText("What's on your mind?");
		
		//Construct the JPanel
		JPanel mainp= new JPanel(new BorderLayout());
		mainp.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		mainp.add(countChar,BorderLayout.NORTH);
		mainp.add(postTextArea,BorderLayout.CENTER);
		//----------------------
		JPanel p1=new JPanel();
		p1.add(refreshBT);
		p1.add(postBT);
		//--------------
		mainp.add(p1,BorderLayout.SOUTH);
		
		mainFrame.add(mainp);
		mainFrame.add(postContent);
		
		//Set Visible at the End
		mainFrame.setVisible(true);
		//Terminated the program when close it.
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//register with button
		postBT.addActionListener(this);
		refreshBT.addActionListener(this);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlogGUI blogGUI = new BlogGUI();
		blogGUI.setWindow();


	}

}
