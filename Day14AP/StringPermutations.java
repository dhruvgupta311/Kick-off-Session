import java.util.*;

public class StringPermutations{
    // Iterative method for permutations
    public static List<String> getPermutationsIterative(String str){
        List<String> result = new ArrayList<>();
        result.add(str);
        for (int i = 1; i < str.length(); i++) {
            List<String> temp = new ArrayList<>();
            for (String s : result) {
                for (int j = 0; j <= s.length(); j++) {
                    temp.add(s.substring(0, j) + str.charAt(i) + s.substring(j));
                }
            }
            result = temp;
        }
        return result;
    }

    // Recursive method for permutations
    public static List<String> getPermutationsRecursive(String str) {
        if (str.length()==1){
            List<String> result=new ArrayList<>();
            result.add(str);
            return result;
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++){
            String rest = str.substring(0, i) + str.substring(i + 1);
            for (String perm : getPermutationsRecursive(rest)) {
                result.add(str.charAt(i) + perm);
            }
        }
        return result;
    }

    // Check if arrays returned by both methods are equal
    public static void main(String[] args){
        String s = "abc";
        List<String> iterPerms = getPermutationsIterative(s);
        List<String> recPerms = getPermutationsRecursive(s);

        System.out.println("Iterative Permutations: " + iterPerms);
        System.out.println("Recursive Permutations: " + recPerms);
        System.out.println("Are both results equal? " + iterPerms.equals(recPerms));
    }
}
