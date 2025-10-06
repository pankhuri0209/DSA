package Neetcode.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class topoSort {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build adj list and indegree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        //build graph: prerequisites[i] = [a, b] means b → a
        for (int[] preq: prerequisites) {
            int pre= preq[0];
            int course=preq[1];

            graph.get(course).add(pre);
            indegree[pre]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        //process queue
        int coursesCompleted = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            coursesCompleted++;
            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        return coursesCompleted == numCourses;
    }
}
