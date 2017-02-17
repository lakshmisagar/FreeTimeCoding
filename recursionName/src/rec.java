public class rec{
 
private static void printname(int n){
	if(n==0) return;
	System.out.println("Lakshmisagar");
	printname(n-1);
}

public static void main(String args[]){
	printname(4);
}

}