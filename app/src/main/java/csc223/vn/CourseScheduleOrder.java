package csc223.vn;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
public class CourseScheduleOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Build graph and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Step 2: Use a queue to store courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Build the course order
        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[index++] = current;

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: If we didn’t add all courses, return empty array (cycle detected)
        if (index == numCourses) {
            return order;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        CourseScheduleOrder cs = new CourseScheduleOrder();

        int[][] prerequisites1 = {{1, 0}};
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] prerequisites3 = {};

        System.out.println(Arrays.toString(cs.findOrder(2, prerequisites1))); // [0, 1]
        System.out.println(Arrays.toString(cs.findOrder(4, prerequisites2))); // [0, 1, 2, 3] or [0, 2, 1, 3]
        System.out.println(Arrays.toString(cs.findOrder(1, prerequisites3))); // [0]
    }
}
