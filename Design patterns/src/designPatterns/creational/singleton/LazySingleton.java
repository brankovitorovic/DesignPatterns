package designPatterns.creational.singleton;

import java.io.Serializable;

class LazySingleton implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5358420250751531892L;

// cannot new this class, however
	// * instance can be created deliberately (reflection)
	// * instance can be created accidentally (serialization)
	private LazySingleton() {
		System.out.println("Singleton is initializing");
	}

	private static LazySingleton INSTANCE;

	private int value = 0;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	// generated getter
	public static LazySingleton getInstance() {
		if( INSTANCE == null) {
			INSTANCE = new LazySingleton();
		}
		return INSTANCE;
	}
}

class LazySingletonDemo {
	public static void main(String[] args) throws Exception {
		BasicSingleton singleton = BasicSingleton.getInstance();
		singleton.setValue(111);

		System.out.println(singleton.getValue());
	}
}