package csc223.vn;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Create graph and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize the graph (one list per course)
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Fill graph and in-degree info
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];

            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Step 2: Add all courses with no prerequisites (inDegree = 0) to the queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Process the queue
        int takenCourses = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            takenCourses++;

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: Return whether we were able to take all courses
        return takenCourses == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();

        int[][] prerequisites1 = {{1, 0}};
        int[][] prerequisites2 = {{1, 0}, {0, 1}};

        System.out.println(cs.canFinish(2, prerequisites1)); // true
        System.out.println(cs.canFinish(2, prerequisites2)); // false
    }
}
