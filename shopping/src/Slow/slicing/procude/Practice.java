package Slow.slicing.procude;

import java.util.HashMap;
import java.util.Iterator;

public class Practice {
	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put("1","3");
		hm.put("2","4");
		hm.put("5","100");
		hm.remove("2");
		//hm.clear();
		Iterator iterator = hm.keySet().iterator();
		while (iterator.hasNext()){
			String key=(String)iterator.next();
			String nums=(String)hm.get(key);
			System.out.println("key===="+key+" num="+nums);
		}
	}
}
