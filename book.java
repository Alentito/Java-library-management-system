package library;

import java.io.InputStream;
import java.sql.Blob;

public class book {
	
	private int bookid;
	private String title,author,genre,rating,count;
	//InputStream bookimage;
	Blob bookimage;
	
	public book(int bookid,String title,String  author,String genre,String rating,Blob bookimage,String count )
	{
		this.bookid=bookid;
		this.title=title;
		this.author=author;
		this.genre=genre;
		this.rating=rating;
		this.bookimage=bookimage;
		this.count=count;
	}
	public int getbookid()
	{
		return bookid;
	}
	public String gettitle()
	{
		return title;
	}
	public String getauthor()
	{
		return author;
	}
	public String getgenre()
	{
		return genre;
	}
	public String getrating()
	{
		return rating;
	}
	public Blob getbookimage()
	{
		return bookimage;
	}
	public String getcount()
	{
		return count;
	}

}
