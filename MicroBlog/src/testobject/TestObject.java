package testobject;
import java.util.Date;
import base.User;
import base.FriendsPost;

public class TestObject {
 public static void main(String[] args) {
	 	User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		String content = "This is my first post";
		
		Date date = new Date();
		FriendsPost postFromFriend = new FriendsPost(content, date, user);
		
		System.out.println(postFromFriend);
		System.out.println(postFromFriend.contains("first"));
		System.out.println(postFromFriend.contains("HKUST"));
}
}
