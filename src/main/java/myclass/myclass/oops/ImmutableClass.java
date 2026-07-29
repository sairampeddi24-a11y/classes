package myclass.myclass.oops;

public final class ImmutableClass {

	public static void main(String[] args) {
		Student s1 = new Student("peddi", 0);
		Student s2 = new Student("nnfn", 1);
		System.out.println("peddi :"+s1.getId()+" second is "+s2.getId());

	}

}

final class Student {

	private final String name;
	private final int id;

	Student(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	

}
