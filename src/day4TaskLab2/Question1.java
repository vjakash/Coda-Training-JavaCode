package day4TaskLab2;

public class Question1 {
	public static void main(String[] args) {
		byte b=10;
		short sh=100;
		int i=100;
		long lg=1000;
		float f=20.2f;
		double db=200.22;
		char ch='a';
		boolean bool=false;
		int arr[]= {1,2,3};
		NoOfBalls noBall=new NoOfBalls();
		System.out.println(b+" "+sh+" "+i+" "+lg+" "+f+" "+db+" "+ch+" "+bool+" "+noBall.balls);
		System.out.println();
		for(int item:arr) {
			System.out.print(item+"\t");
		}
		changeVal(b,sh,i,lg,f,db,ch,bool,arr,noBall);
		System.out.println();
		System.out.println(b+" "+sh+" "+i+" "+lg+" "+f+" "+db+" "+ch+" "+bool+" "+noBall.balls);
		System.out.println();
		for(int item:arr) {
			System.out.print(item+"\t");
		}
		
		
	}
	public static void changeVal(byte b,short sh,int i,long lg,float f,double db,char ch,boolean bool,int arr[],NoOfBalls noBall) {
		b=0;
		sh=0;
		i=0;
		f=0f;
		db=0;
		ch='b';
		bool=true;
		arr[0]=100;
		noBall.balls=10;
	}
}
class NoOfBalls{
	int balls=0;
}