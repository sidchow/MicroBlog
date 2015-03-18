package blog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import base.*;


public class Blog implements Serializable{
private User user;
private ArrayList<Post> allpost;

/**
 * Constructor
 * @param user
 */
public Blog(User user){
	//TODO
	this.user=user;
	this.allpost= new ArrayList<Post>();
}

/**
 * @param user
 */
public void setUser(User user){
	//TODO
	this.user=user;
}

/**
 * @param user
 */
public User getUser(){
	//TODO
	return user;
}

/**
 * create a new post in your blog
 * @param post
 */
public void post(Post p){
	//TODO add Post p to your blog
	allpost.add(p);
	//TODO print a message if succeed
	System.out.println("A new Post:");
	System.out.println(p);
}

/**
 * list all posts in the blog
 */
public void list(){
	//TODO
	System.out.println("Current posts:");
	for(Post x:allpost){
		System.out.println(x);
	}
}

/**
 * delete a post from the blog
 * @param index
 */
public void delete(int index){
	//Is the index legal? The index should be neither too high nor negative.
	//If the index is legal, delete the corresponding Post
	//Otherwise print a fault message.
	if (index>=allpost.size()||index<0)
		System.out.println("Illegal deletion.");
	else allpost.remove(index);
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((allpost == null) ? 0 : allpost.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Blog other = (Blog) obj;
	if (allpost == null) {
		if (other.allpost != null)
			return false;
	} else if (!allpost.equals(other.allpost))
		return false;
	if (user == null) {
		if (other.user != null)
			return false;
	} else if (!user.equals(other.user))
		return false;
	return true;
}

@Override
public String toString(){
	//TODO
	return user+"";
}

/**
 * Serch posts created in month and mentioned someone
 * 
 * @param month
 * @param someone
 */
public void search(int month, String someone){
	Calendar cal = Calendar.getInstance();
	//search from all posts
	for (Post p: allpost){
		//get the current post's month (note that Calendar.Month starts
		//with 0, not 1)
		cal.setTime(p.getDate());
		int postMonth = cal.get(Calendar.MONTH)+1;
		
		//TODO write your code here
		if(postMonth==month){
			if(p.getContent().contains(someone)){
				System.out.println(p);
			}
		}
	}
}

/**
 * Setup the allpost for search
 * @param allp
 */
public void setPosts(ArrayList<Post> allp){
	allpost=allp;
}

public void save(String filepath){
	//TODO Auto-generated method stub
	
	try{
		FileOutputStream fs = new FileOutputStream(filepath);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		os.writeObject(this);
		os.close();
	}catch(Exception ex){
		ex.printStackTrace();
	}
}

public void load(String filepath){
	//TODO Auto-generated method stub
	try{
		FileInputStream fs = new FileInputStream(filepath);
		ObjectInputStream os = new ObjectInputStream(fs);
		Object myBlog = os.readObject();
		Blog newblog = (Blog) myBlog;
		this.user=newblog.user;
		this.allpost=newblog.allpost;
		os.close();
	}catch(FileNotFoundException e){
		System.out.println("Wait! There is something wrong. I cannot find the file..");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
