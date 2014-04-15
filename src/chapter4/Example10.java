package chapter4;
class MyClass{
	int i;
}
class Example10 extends MyClass {
	public static void main(String[] args)
	{
		MyClass[] a;
		a = new MyClass[10];
		for(int j=0;j<a.length;j++){
			a[j] = new MyClass();
			a[j].i=j;
		}
		for(int j=0;j<a.length;j++){
			System.out.print(a[j].i);
		}
		
	}
}