package designPatterns.creational.prototype;

import java.io.Serializable;
//import org.apache.commons.lang3.SerializationUtils;

class Foo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8083363288216300823L;
	public int stuff;
	public String whatever;

	public Foo(int stuff, String whatever) {
		this.stuff = stuff;
		this.whatever = whatever;
	}

	@Override
	public String toString() {
		return "Foo{" + "stuff=" + stuff + ", whatever='" + whatever + '\'' + '}';
	}
}

class Prototype {
	public static void main(String[] args) {
		Foo foo = new Foo(42, "life");
// 	  use apache commons!
//    Foo foo2 = SerializationUtils.roundtrip(foo);
//
//    foo2.whatever = "xyz";

		System.out.println(foo);
//    System.out.println(foo2);
	}
}