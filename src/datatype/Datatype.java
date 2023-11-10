package datatype;

public class     Datatype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 10;
		short sh = 20;
		int in = 30;
		long ln = 40;
		// b=sh; gives err
		// b=in;
		// b=ln;
		ln = b;
		b = 127;
		b = (byte) 128;
		System.out.println(b);

		in = 1000000000;
		// in=10000000000; gives err due to big size
		// ln=10000000000; its also gives err bcz left size integer litrel and number is
		// out of range
		ln = 10000000000L;
		sh = 32000;
		 //float f=5.5; gives err due to litral double
		float f = 5.5f;
		double db = 6.3;

		// in=f; err
		f = 2.2f;
		in = (int) f;
		System.out.println(in);

		in = 2;
		f = in;
		System.out.println(f);
		char ch = 'a';
		ch = 99;
		System.out.println("test");
		System.out.println(ch+2);

		// ch=ch+2; gives err
		ch = (char) (ch + 2);
		System.out.println(ch);
		in = ch;
		System.out.println(in);
		System.out.println(2+5+"hello"+2+5);
		System.out.println(2+' '+5);
		System.out.println(2+" "+5);
		System.out.println("hello"+'\t'+"word");
		System.out.println("hello"+"\t"+"word");

	}

}
