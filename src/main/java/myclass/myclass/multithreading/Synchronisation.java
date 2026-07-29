package myclass.myclass.multithreading;

public class Synchronisation {

	static class a {
		Boolean a;

		public Boolean getA() {
			return a;
		}

		public void setA(Boolean a) {
			this.a = a;
		}

	}

	public static void main(String[] Args) {
		a a1 = new a();
		System.out.println(a1.getA());
	}

}
