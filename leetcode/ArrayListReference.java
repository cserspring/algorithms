package tst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class A {
	private ArrayList<Integer> list;
	public A() {}
	public A(ArrayList<Integer> list) {
		this.list = list;
	}
	public ArrayList<Integer> getList() {
		return list;
	}
	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
	
	/*
	 * For the attributes, copy it one by one.
	 * */
	@Override
	public A clone(){
		A a = new A();
		a.list = new ArrayList<Integer>(this.list);
		return a;
	}
}

class B extends A {
	private int i;
	public B() { }
	public B(ArrayList<Integer> list, int i) {
		super(list);
		this.i = i;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
public class ArrayListReference {
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1000);
		list.add(1000);
		if (list.get(0).equals(list.get(1))) {
			System.out.println("Integer compare, please use equals.");
		}
		if (list.get(0) != list.get(1)) {
			System.out.println("Integer compare, please do not use ==");
		}
		
		System.out.println("When you iterate through the list, don't do add or delete operations,"
				+ " as the size is changing.");
		A a = new A(list);
		A b = new A(list);
		list.add(2000);
		System.out.println(a.getList().get(2));
		System.out.println(b.getList().get(2));
		
		A c = a.clone();
		System.out.println(c.getList().get(0));
		System.out.println(c.getList().get(1));
		System.out.println(c.getList().get(2));
		
		/*
		 * Here, it is A, but you can also store B, and you can get it.
		 * */
		ArrayList<A> objectList = new ArrayList<A>();
		objectList.add(a);
		objectList.add(b);
		B d = new B(list, 1);
		objectList.add(d);
		
		for (int j = 0; j < objectList.size(); ++j) {
			if (objectList.get(j) instanceof B) {
				System.out.println(((B)objectList.get(j)).getI());
			}
		}
		
		Set<Integer> setInt = new HashSet<Integer>();
		setInt.add(1);
		setInt.add(1);
		System.out.println("Set Size:" + setInt.size());
		
		String s = "sabcd";
		String tmp = s;
		tmp = tmp.substring(0,1);
		System.out.println(s);
	} 
}
