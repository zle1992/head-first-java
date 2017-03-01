
class A{
	int ivar=7;
	void m1(){
		System.out.print("A M1     ");
	}
	void m2(){
		System.out.print("A M2     ");
	}	
	void m3(){
		System.out.print("A M3     ");
	}	
}
class B extends A {

	void m1(){
		System.out.print("B M1    ");
	}
}

class C extends B{

	void m3(){
		System.out.print("C M3    "+(ivar+6));
	}
}
public class ch7 {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		A a2 = new C();
		a2.m1();
		a2.m2();
		a2.m3();

	}
}