import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Leetcode 305 - Number of Island II
 */
public class Leetcode305 {

    private int[] unionFind;

    private int find(int i) {
        if (unionFind[i] < 0) return -1;
        while (i != unionFind[i]) {
            i = unionFind[i];
        }
        return i;
    }

    private void union(int i, int j) {
        unionFind[find(j)] = unionFind[find(i)];
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        List<Integer> list = new ArrayList<>();
        int res = 0;
        unionFind = new int[m * n];
        Arrays.fill(unionFind, -1);
        for (int[] position : positions) {
            int curX = position[0], curY = position[1];
            /**
             * Check if land  already existed
             */
            if (unionFind[curX * n + curY] < 0) {
                unionFind[curX * n + curY] = curX * n + curY;
                res++;
            }
            for (int f = 0; f < 4; f++) {
                int newX = curX + dir[f][0], newY = curY + dir[f][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && find(newX * n + newY) != find(curX * n + curY) && find(newX * n + newY) >= 0) {
                    union(newX * n + newY, curX * n + curY);
                    res--;
                }
            }
            list.add(res);
        }
        return list;
    }

    public static void main(String[] args) {
        Leetcode305 Solution = new Leetcode305();

        int[][] test1Positions = new int[][]{{0, 0}, {0, 1}, {1, 1}, {2, 2}};
        System.out.println(Solution.numIslands2(3, 3,test1Positions));
    }

}