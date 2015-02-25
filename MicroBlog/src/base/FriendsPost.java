package base;
import java.util.Date;

import base.User;

public class FriendsPost extends Post{
	private User friend;

	
	public FriendsPost(String content, Date date, User user) {
		super(date, content);
		
		this.friend = user;
	}

	public User getUser() {
		return friend;
	}

	public void setUser(User user) {
		this.friend = user;
	}
	
	@Override
	public String toString() {
		return friend +"\n"+super.getDate()+"\n"+super.getContent();
	}
}
