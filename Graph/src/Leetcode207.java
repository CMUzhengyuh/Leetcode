import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Leetcode 207 - Course Schedule
 */
public class Leetcode207 {
    /**
     * Topological Sorting
     */
    public boolean canFinishTS(int numCourses, int[][] prerequisites) {
        Set<Integer> zeroDegree = new HashSet<>();
        int[] degree = new int[numCourses];
        for (int row = 0; row < prerequisites.length; row++) {
            degree[prerequisites[row][0]]++;
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) zeroDegree.add(i);
        }
        if (zeroDegree.isEmpty()) return false;
        while (!zeroDegree.isEmpty()) {
            Iterator<Integer> iterator = zeroDegree.iterator();
            int course = iterator.next();
            zeroDegree.remove(course);
            for (int row = 0; row < prerequisites.length; row++) {
                int[] edge = prerequisites[row];
                if (edge[1] == course) {
                    degree[edge[0]]--;
                    if (degree[edge[0]] == 0) zeroDegree.add(edge[0]);
                }
            }
        }
        for (int i = 0; i < degree.length; i++)
            if (degree[i] != 0) return false;
        return true;
    }

    /**
     * Depth First Search
     */
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        boolean[] canFinish = new boolean[numCourses];
        boolean[] waitingList = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!DFS(i,prerequisites,waitingList,canFinish)) { return false; }
        }
        return true;
    }
    public boolean DFS(int course, int[][] prerequisites, boolean[] waitingList, boolean[] canFinish) {
        if (canFinish[course]) { return true; }
        if (waitingList[course]) { return false; }
        waitingList[course] = true;
        for (int[] pair : prerequisites) {
            if (pair[0] == course) {
                if (!DFS(pair[1],prerequisites,waitingList,canFinish)) { return false; }
            }
        }
        waitingList[course] = false;
        canFinish[course] = true;
        return true;
    }

    public static void main(String[] args) {
        Leetcode207 Solution = new Leetcode207();

        int[][] test1Pre = new int[][]{{1, 0}};
        System.out.println(Solution.canFinishTS(2, test1Pre));
        System.out.println(Solution.canFinishDFS(2, test1Pre));


        int[][] test2Pre = new int[][]{{1, 0}, {1, 2}, {0, 2}};
        System.out.println(Solution.canFinishTS(3, test2Pre));
        System.out.println(Solution.canFinishDFS(2, test1Pre));


        int[][] test3Pre = new int[][]{{1, 0}, {2, 1}, {0, 2}};
        System.out.println(Solution.canFinishTS(3, test3Pre));
        System.out.println(Solution.canFinishDFS(2, test1Pre));

    }
}
