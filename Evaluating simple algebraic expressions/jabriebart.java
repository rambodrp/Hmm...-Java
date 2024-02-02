import java.util.Arrays;
import java.util.Scanner;
public class jabriebart{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replaceAll("-", " - ") ;
        input = input.replaceAll("\\+", " + ") ;
        String[] tokens = input.split(" ");
        int c = 0 ;
        String flag = "+" ;
        for (String i : tokens){
            if(i.equals(" ") || i.equals("")){
                continue ;
            }
            if (i.equals("+")) {
                flag = "+";
            } else if (i.equals("-")) {
                flag = "-";
            }
            else {
                if (flag.equals("+")){
                    c += Integer.parseInt(i); 
                }
                else {
                    c -= Integer.parseInt(i); 
                }
            }
        }   
        System.out.println(c);
    }
}