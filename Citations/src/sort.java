

public class sort {

	
	
	



public static void main(String[] args){
	String author = new String("Patrick");
	String title = new String("Is Awesome");
	Citation c = new Citation();
	
	String author1 = new String("Annie");
	String title1 = new String("Xylophone");
	Citation c1 = new Citation();
	
	String author2 = new String("Patrick");
	String title2 = new String("Xylophone");
	Citation c2 = new Citation();
	
	String author3 = new String("CatDog");
	String title3 = new String("On Nickelodeon");
	Citation c3 = new Citation();
	
	c.setAuthor(author);
	c.setTitle(title);
	c1.setAuthor(author1);
	c1.setTitle(title1);
	c2.setAuthor(author2);
	c2.setTitle(title2);
	c3.setAuthor(author3);
	c3.setTitle(title3);
	MinHeap<Citation> mh = new MinHeap<Citation>();
	mh.insert(c);
	mh.insert(c1);
	mh.insert(c2);
	mh.insert(c3);
	
	System.out.println(mh.removeMin());
	System.out.println(mh.removeMin());
	System.out.println(mh.removeMin());
	System.out.println(mh.removeMin());
	
	createInterface gui = new createInterface();
	gui.createAndShowGUI();

//	for(String i : minh)
//		System.out.println(i);
}
}
