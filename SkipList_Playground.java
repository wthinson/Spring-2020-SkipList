package SKPLIST_A4;

public class SkipList_Playground {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test3();
	}
	
	private static void test3() {
		SkipList_Interface list = new SkipList(30);
		list.setProbability(0.5);
		list.setSeed(0);
		System.out.println("=== INSERT ===");
		list.insert(1);
		System.out.println(list);
		list.insert(2);
		System.out.println(list);
//		System.out.println("=== REMOVE ===");
//		for(double i = 4; i >= 0; i --) {
//			if (list.remove(i)) {
//				System.out.println(i);
//				System.out.println(list);
//			}
//		}
//		System.out.println("=== INSERT ===");
//		for(double i = 0; i < 5; i ++) {
//			list.insert(i);
//			System.out.println(list);
//		}
		System.out.println("=== THE END ===");
	}
	private static void test2() {
		SkipList_Interface list = new SkipList(5);
		System.out.println("=== INSERT ===");
		for(double i = 0; i < 5; i ++) {
			list.insert(i);
			System.out.println(list);
		}
		System.out.println("=== REMOVE ===");
		for(double i = 4; i >= 0; i --) {
			if (list.remove(i)) {
				System.out.println(i);
				System.out.println(list);
			}
		}
		System.out.println("=== INSERT ===");
		for(double i = 0; i < 5; i ++) {
			list.insert(i);
			System.out.println(list);
		}
		System.out.println("=== THE END ===");
	}

	private static void test1() {
		SkipList_Interface list = new SkipList(5);
		System.out.println("=== INSERT ===");
		for(double i = 0; i < 10; i ++) {
			list.insert(i);
			System.out.println(list);
		}
		//	    System.out.println(list);
		//	    System.out.println("=== CONTAINS ===");
		//	    for(double i = -5; i < 15; i ++) {
		//	      System.out.println(i + ": " + list.contains(i));
		//	    }
		System.out.println("=== REMOVE ===");
		for(double i = -5; i < 15; i +=2) {
			//	      System.out.println(i + ": " + list.remove(i));
			if (list.remove(i)) {
				System.out.println(list);
			}
		}
		//	    System.out.println(list);
		//	    System.out.println("=== CONTAINS ===");
		//	    for(double i = -5; i < 15; i ++) {
		//	      System.out.println(i + ": " + list.contains(i));
		//	    }
		System.out.println("=== INSERT ===");
		for(double i = 0; i < 10; i ++) {
			list.insert(i);
			System.out.println(list);
		}
		//	    System.out.println(list);
	}
}
