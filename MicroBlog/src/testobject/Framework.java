package testobject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import blog.*;
import base.*;

public class Framework {
	private JFrame mainFrame ;
	private JPanel postPanel;
	private JTextArea postTextArea,postContent ;
	private JButton refresh,post ;
	private JLabel text1 ;
	private Blog myBlog;
	
	public Framework(){
		mainFrame = new JFrame("Micro Blog Demo");
		postPanel = new JPanel(new BorderLayout());
		text1 = new JLabel("You can still input 140 Characters");
		postTextArea = new JTextArea(10,380);
		postContent = new JTextArea(10,380);
		refresh = new JButton("Refresh");
		post = new JButton("Post");
		
		//initialize myBlog
		User user =new User(1,"A", "a@cse.ust.hk");
		myBlog = new Blog(user);
		myBlog.save("/Users/chungmingchow/Desktop/comp_Java/testGUI/test.blog");
	}
	
	public void setGUI(){
		//Construct the layout of Main Windows
		mainFrame.setSize(400, 600);
		mainFrame.setLayout(new GridLayout(2,1));
		
		//Set Background Color
		Color c1= new Color(255,255,204);
		postTextArea.setBackground(c1);
		
		//Set the JTextarea LineWrap
		postTextArea.setLineWrap(true);
		postTextArea.setWrapStyleWord(true);
		postContent.setLineWrap(true);
		postContent.setWrapStyleWord(true);
		
		//Construct the JPanel
		postPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		postPanel.add(text1,BorderLayout.NORTH);
		postPanel.add(postTextArea,BorderLayout.CENTER);
		//----------------------
		JPanel p1=new JPanel();
		p1.add(refresh);
		p1.add(post);
		//--------------
		postPanel.add(p1,BorderLayout.SOUTH);
		
		mainFrame.add(postPanel);
		mainFrame.add(postContent);
		
		//Set Visible at the End
		mainFrame.setVisible(true);
		//Terminated the program when close it.
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//register the listener
		post.addActionListener(new postListener());
		refresh.addActionListener(new refreshListener());
		postTextArea.addKeyListener(new lengthListener());
		
	}
	
	class postListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			String content = postTextArea.getText();
			//TODO whether the post is empty
			if(content.length()<=0){
				text1.setText("Please input something to the post area!!");
			}
			//TODO whether the length of the post has exceeded 140
			else if(content.length()>140){
				text1.setText("Please delete some word!!");
			}
			else{
				//TODO add the post to the file
				Date date = new Date();
				Post post =new Post(date,content);
				myBlog.post(post);
				//save the Blog
				myBlog.save("/Users/chungmingchow/Desktop/comp_Java/testGUI/test.blog");
				
				//TODO display the post in the display area and clear the edit area	
				postContent.setText(content);
				postTextArea.setText("");
				text1.setText("You can still input 140 Characters");
			}
			
		};
		
	}
	
	class refreshListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			//TODO load all post to the display area
			myBlog.load("/Users/chungmingchow/Desktop/comp_Java/testGUI/test.blog");
			//get the all post
			ArrayList<Post> allposts = new ArrayList<Post>();
			allposts=myBlog.getallpost();
			//myBlog.list();
			//clear postContent
			postContent.setText("");
			//append the posts to display area	
			for(Post x:allposts){
				//postContent.append("test");
				postContent.append(x.getContent()+"\n");
				//System.out.println(x);
				//System.out.println("test");
				
			};
		};
	}
	
	class lengthListener implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e){
		}
		@Override
		public void keyPressed(KeyEvent e){
		}
		@Override
		public void keyReleased(KeyEvent e){
			//TODO Check the number of Characters
			String content = postTextArea.getText();
			int length=140-content.length();
			
			if(length<0){
				text1.setText("Your post length has exceeded 140!");
			}else {
				text1.setText("You can still input "+length+" Characters");
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Framework testblog = new Framework();
		testblog.setGUI();
	}

}
