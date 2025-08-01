import java.util.ArrayList;
import java.util.Arrays;

public class Arraylist {
    public static void main(String[] args) {
        ArrayList<String> friendsArraylist = new ArrayList<>(Arrays.asList("Terry", "Joan", "Mercy"));
        friendsArraylist.add("Lorna");
        //System.out.println(friendsArraylist.get(2));
     //   friendsArraylist.set(0, "Hyline");
       // friendsArraylist.add(0, "Terry");
        //System.out.println(friendsArraylist);

        //for loop
        for (int i = 0; i < friendsArraylist.size(); i++) ;
       // {
         //   System.out.println(friendsArraylist);
        //}
        //for-each loop
        for (String i :friendsArraylist) ;
        {
            System.out.println(friendsArraylist);
        }
    }
}
