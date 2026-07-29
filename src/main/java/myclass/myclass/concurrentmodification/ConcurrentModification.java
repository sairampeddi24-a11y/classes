package myclass.myclass.concurrentmodification;

import java.util.Iterator;
import java.util.List;

public class ConcurrentModification {
	
	public static void main(String [] args) {
		List<String> names = List.of("sai","Ram","peddi");
		Iterator<String> itr = names.iterator();
		while(itr.hasNext()) {
			System.out.println("name :::"+itr.next());
			itr.remove();
		}
	}

}
