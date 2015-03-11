/**
 * This is the trial of javadoc
 * 
 * @author chungmingchow
 * @param accepted input arguments
 * @return values of the method
 */
package base;
import java.util.Date;

public class Post implements Comparable<Post>{
	private Date date;
	private String content;

	/**
	 * Constructor
	 * @param date
	 * @param content
	 */
	public Post(Date date, String content){
		//TODO
		//super();
		this.content=content;
		this.date=date;
	}
	
	/**
	 * @return the content of the blog
	 */
	public String getContent(){
		//TODO
		return content;
	}
	
	/**
	 * @param content
	 */
	public void setContent(String content){
		//TODO
		this.content=content;
	}
	
	/**
	 * @return the date of the blog
	 */
	public Date getDate(){
		//TODO
		return date;
	}
	
	/**
	 * @param content
	 */
	public void setDate(Date date){
		//TODO
		this.date=date;
	}
	
	
	@Override
	/**
	 * Output this object in string format
	 * @return String
	 */
	public String toString(){
		//TODO
		
		return date +"\n"+ content;
	}
	
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		Post other = (Post) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}


	/**
	 * check whether this post contains some keyword
	 * @param keyword
	 * @return 
	 */
	public boolean contains(String keyword){
		//TODO
		return content.contains(keyword);
	}
	
	@Override
	public int compareTo(Post p){
		//TODO write your code here
		return this.date.compareTo(p.date);

	}
}
