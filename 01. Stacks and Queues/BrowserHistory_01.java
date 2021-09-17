import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();

        String current = null;
        while(!input.equals("Home")){
            boolean has = false;
            if(input.equals("back")){
                if(!stack.isEmpty()){
                    current = stack.pop();
                }
                else{
                    System.out.println("no previous URLs");
                    has = true;
                }
            }else{
                if(current != null){
                    stack.push(current);
                }
                current = input;
            }

            if(!has){
                System.out.println(current);
            }
            input = sc.nextLine();
        }

    }
}
