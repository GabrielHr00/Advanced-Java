import java.util.*;

public class TheHeiganDance_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Double damage = Double.parseDouble(sc.nextLine());
        int playerRow = 7;
        int playerCol = 7;
        double heiganLife = 3000000;
        int playerLife = 18500;
        String previousMagic = "";
        String lastMagic = "";

        while(playerLife > 0 && heiganLife > 0){
            if(playerLife > 0){
                heiganLife -= damage;
            }
            if(previousMagic.equals("Cloud")){
                playerLife -= 3500;
                previousMagic = "";
            }
            if(playerLife <= 0 || heiganLife <= 0){
                break;
            }

            String[] command = sc.nextLine().split("\\s+");
            String magic = command[0];
            int rowAttack = Integer.parseInt(command[1]);
            int colAttack = Integer.parseInt(command[2]);

            if(isInAttackRange(rowAttack, colAttack, playerRow, playerCol)){
                if(!isInAttackRange(rowAttack, colAttack, playerRow - 1, playerCol) && wallOnTheMap(playerRow - 1)){
                    playerRow--;
                    lastMagic = "";
                }else if(!isInAttackRange(rowAttack, colAttack, playerRow, playerCol + 1) && wallOnTheMap(playerCol + 1)){
                    playerCol++;
                    lastMagic = "";
                }else if(!isInAttackRange(rowAttack, colAttack, playerRow + 1, playerCol) && wallOnTheMap(playerRow + 1)){
                    playerRow++;
                    lastMagic = "";
                }else if(!isInAttackRange(rowAttack, colAttack, playerRow, playerCol - 1) && wallOnTheMap(playerCol - 1)){
                    playerCol--;
                    lastMagic = "";
                }
                else{
                    // if the player cannot move - damage him
                    if(magic.equals("Cloud")){
                        playerLife -= 3500;
                        previousMagic = "Cloud";
                        lastMagic = "Cloud";
                    }
                    else{
                        playerLife -= 6000;
                        previousMagic = "Eruption";
                        lastMagic = "Eruption";
                    }
                }
            }
       }

        // heigan
        System.out.print("Heigan: ");
        if (heiganLife <= 0) {
            System.out.println("Defeated!");
        } else {
            System.out.printf(String.format("%.2f%n", heiganLife));
        }
        // player
        System.out.print("Player: ");
        if (playerLife <= 0) {
            System.out.print("Killed by ");
            if(lastMagic.equals("Cloud")){
                System.out.println("Plague Cloud");
            }
            else{
                System.out.println(lastMagic);
            }
        } else {
            System.out.printf(String.format("%d%n", playerLife));
        }
        System.out.println("Final position: " + playerRow + ", " + playerCol);
    }

    private static boolean wallOnTheMap(int position) {
        return position >= 0 && position < 15;
    }

    private static boolean isInAttackRange(int rowAttack, int colAttack, int playerRow, int playerCol) {
//        boolean here = false;
//        Map<Integer, Integer> map = new LinkedHashMap<>();
//        map.put(rowAttack - 1, colAttack - 1);
//        map.put(rowAttack - 1, colAttack);
//        map.put(rowAttack - 1, colAttack + 1);
//        map.put(rowAttack, colAttack + 1);
//        map.put(rowAttack + 1, colAttack + 1);
//        map.put(rowAttack + 1, colAttack);
//        map.put(rowAttack + 1, colAttack - 1);
//        map.put(rowAttack, colAttack - 1);
//
//        if(map.containsKey(playerRow)){
//            for (var s: map.entrySet()) {
//                if(s.getKey() == playerRow && s.getValue() == playerCol){
//                    here = true;
//                    break;
//                }
//            }
//        }
//
//        return here;
        return ((rowAttack - 1 <= playerRow && playerRow <= rowAttack + 1)
                && (colAttack - 1 <= playerCol && playerCol <= colAttack + 1));
    }
}
