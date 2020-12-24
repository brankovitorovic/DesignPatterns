package designPatterns.creational.singleton;

import java.io.Serializable;

class BasicSingleton implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5358420250751531892L;

// cannot new this class, however
	// * instance can be created deliberately (reflection)
	// * instance can be created accidentally (serialization)
	private BasicSingleton() {
		System.out.println("Singleton is initializing");
	}

	private static final BasicSingleton INSTANCE = new BasicSingleton();

	private int value = 0;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	// generated getter
	public static BasicSingleton getInstance() {
		return INSTANCE;
	}
}

class BasicSingletonDemo {
	public static void main(String[] args) throws Exception {
		BasicSingleton singleton = BasicSingleton.getInstance();
		singleton.setValue(111);

		System.out.println(singleton.getValue());
	}
}