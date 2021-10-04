import com.sun.jdi.DoubleValue;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String com = sc.nextLine();
        List<BankAccount> list = new ArrayList<>();

        while(!com.equals("End")){
            String[] coms = com.split("\\s+");
            switch(coms[0]){
                case "Create":
                    BankAccount account = new BankAccount();
                    list.add(account);
                    System.out.println("Account ID" + account.getId() + " created");
                    break;
                case "Deposit":
                    int index = Integer.parseInt(coms[1]);
                    int sum = Integer.parseInt(coms[2]);
                    if(index - 1 < list.size() && index - 1 >= 0){
                        list.get(index - 1).deposit(sum);
                        System.out.printf("Deposited %d to ID%d%n", sum, list.get(index - 1).getId());
                    }else{
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double inter = Double.parseDouble(coms[1]);
                    BankAccount.setInterestRate(inter);
                    break;
                case "GetInterest":
                    int id = Integer.parseInt(coms[1]);
                    if(id - 1 < list.size() && id - 1 >= 0){
                        int year = Integer.parseInt(coms[2]);
                        System.out.printf("%.2f%n", list.get(id - 1).getInterest(year));
                    }else{
                        System.out.println("Account does not exist");
                    }
                    break;
                default:
                    break;
            }


            com = sc.nextLine();
        }

    }
}


