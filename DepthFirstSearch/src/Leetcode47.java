import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * Leetcode 47 - Permutations II ***
 */
public class Leetcode47 {
    List<List<Integer>> res;
    Map<Integer, Integer> map;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        DFS(map, new ArrayList<>());
        return res;
    }

    private void DFS(Map<Integer, Integer> map, List<Integer> list) {
        if (map.size() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        Set<Integer> set = new HashSet<>(map.keySet());
        for (int k : set) {
            list.add(k);
            if (map.get(k) == 1) {
                map.remove(k);
            } else {
                map.put(k, map.get(k) - 1);
            }
            DFS(map, list);
            list.remove(list.size() - 1);
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
    }

    public static void main(String[] args) {
        Leetcode47 Solution = new Leetcode47();

        int[] test1Array = new int[]{2, 2, 4};
        System.out.println(Solution.permuteUnique(test1Array).toString());

        int[] test2Array = new int[]{2, 3, 4, 4};
        System.out.println(Solution.permuteUnique(test2Array).toString());

    }
}
