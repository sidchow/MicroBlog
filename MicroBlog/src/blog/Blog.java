package blog;
import java.util.ArrayList;

import base.*;


public class Blog {
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

}
