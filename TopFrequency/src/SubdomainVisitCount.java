import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 16th - Leetcode 811 - Subdomain Visit Count
 */
public class SubdomainVisitCount {
    /**
     * Solution: HashTable
     * TC: O(n)
     * SC: O(n)
     */
    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> map = new HashMap();
        for (String str: cpdomains) {
            String[] s = str.split("\\s+");
            String[] domain = s[1].split("\\.");
            int count = Integer.valueOf(s[0]);
            String cur = "";
            for (int i = domain.length - 1; i >= 0; --i) {
                cur = domain[i] + (i < domain.length - 1 ? "." : "") + cur;
                map.put(cur, map.getOrDefault(cur, 0) + count);
            }
        }
        List<String> ans = new ArrayList();
        for (String dom: map.keySet())
            ans.add("" + map.get(dom) + " " + dom);
        return ans;
    }
}