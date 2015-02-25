/**
 * This is the trial of javadoc
 * 
 * @author chungmingchow
 * @param accepted input arguments
 * @return values of the method
 */
package base;
import java.util.Date;

public class Post {
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
	/**
	 * Check whether this object equals object o
	 * @param object o
	 * @return Boolean
	 */
	public boolean equals(Object o){
		boolean ans = true;
		//Should it be equal compared to itself?
		if (this ==o) 
			return true;
		//What if object is null?
		if(o==null)
			return false;
		//Are they the same class?
		//You can get the class of object o
		if(getClass() !=o.getClass())
			return false;
		
		//You can transfer object o to POST
		Post post = (Post) o;
		
		//In what circumstance will you think that post A is equal to post B?
		if(content == null){
			if(post.content !=null)
				return false;
		}else if (!content.equals(post.content))
			return false;
		
		return ans;
	}
	
	@Override
	public int hashCode(){
		int hashCode =0;
		//TODO
		//You should give hashCode a unique value?
		//You can use the hashCode of your attributes
		//date.hashCode();
		//content.hashCode();
		final int p=31;
		hashCode = p*hashCode+((content==null)?0:content.hashCode());
		
		return hashCode;
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
}
