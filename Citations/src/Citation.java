import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Citation implements Comparable<Citation>{
	String author;
	String title;
	String editor;
	String source;
	String pubdate;
	
	public Citation(){
		author = title = editor = source = pubdate = new String();
		
	}
	
	public Citation(String a, String t, String e, String s, String p){
		author = a;
		title = t;
		editor = e;
		source = s;
		pubdate = p;
	}
	
	public int compareTo(Citation c){
		DateFormat  dateFormat = new SimpleDateFormat("MM dd yyyy");
		Date date = new Date();
		String ret = author+". \""+title+".\" "+editor+". "+source+", "+pubdate+". "+date+".";
		
		if(c.toString().compareTo(ret) < 0)
			return 1;
		else if(c.toString().compareTo(ret) > 0)
			return -1;
		else
			return 0;
	}
	
	public String toString(){
		DateFormat  dateFormat = new SimpleDateFormat("MM dd yyyy");
		Date date = new Date();
	
			String ret = author+title+editor+source+pubdate+date+".";



		

		
		return ret;
	}
	
	public void setAuthor(String h){author = h+". ";}
	public void setTitle(String t){title = "\""+t+".\" ";}
	public void setEditor(String e){editor = e+". ";}
	public void setSource(String s){source = s+", ";}
	public void setPubdate(String p){pubdate = p+". ";}

}
