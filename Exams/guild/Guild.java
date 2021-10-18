package guild;
import java.util.*;

public class Guild {
    private String name;
    private int capacity;
    private Map<String, Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashMap<>();
    }

    public void addPlayer(Player player){
        if(capacity > roster.size()){
            roster.put(player.getName(), player);
        }
    }

    public boolean removePlayer(String name){
        return this.roster.remove(name) != null;
    }

    public void promotePlayer(String name){
        if(roster.containsKey(name)){
            roster.get(name).setRank("Member");
        }
    }

    public void demotePlayer(String name){
        if(roster.containsKey(name)) {
            roster.get(name).setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz){
        List<String> list = new ArrayList<>();

        for (var e : roster.entrySet()) {
            if(e.getValue().getClazz().equals(clazz)){
                list.add(e.getKey());
            }
        }

        Player[] arr = new Player[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Player remove = this.roster.remove(list.get(i));
            arr[i] = remove;
        }
        return arr;
    }

    public int count(){
        return this.roster.size();
    }

    public String report(){
        StringBuilder si = new StringBuilder();
        si.append(String.format("Players in the guild: %s:%n", this.name));

        for (var i :roster.values()) {
            si.append(i).append(System.lineSeparator());
        }
        return si.toString().trim();
    }
}
