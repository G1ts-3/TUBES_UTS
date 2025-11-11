import java.util.Scanner;

public class Tipe{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String k;
        int a=0;
        int b=0;
        int c=0;

        do{
            k=in.nextLine();
            if(k.equals("A")){
                a=a+1;
            }else if(k.equals("B")){
                b=b+1;
            }else if(k.equals("C")){
                c=c+1;
            }
        }while(k.equals("A") || k.equals("B") || k.equals("C"));
        System.out.println("Tipe A : "+a);
        System.out.println("Tipe B : "+b);
        System.out.println("Tipe C : "+c);
    }
}