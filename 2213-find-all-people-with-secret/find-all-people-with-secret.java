import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Sort meetings by time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        // Set to store people who know the secret
        Set<Integer> secretKnowers = new HashSet<>();
        secretKnowers.add(0);
        secretKnowers.add(firstPerson);

        // Group meetings by time using a TreeMap to maintain order
        Map<Integer, List<int[]>> meetingsByTime = new TreeMap<>();
        for (int[] meeting : meetings) {
            int time = meeting[2];
            meetingsByTime.computeIfAbsent(time, k -> new ArrayList<>()).add(new int[]{meeting[0], meeting[1]});
        }

        for (int time : meetingsByTime.keySet()) {
            List<int[]> currentMeetings = meetingsByTime.get(time);
            
            // Build a graph for the current time frame, only including people in the meetings
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> peopleInTimeFrame = new HashSet<>();
            for (int[] meeting : currentMeetings) {
                int p1 = meeting[0];
                int p2 = meeting[1];
                peopleInTimeFrame.add(p1);
                peopleInTimeFrame.add(p2);
                graph.computeIfAbsent(p1, k -> new ArrayList<>()).add(p2);
                graph.computeIfAbsent(p2, k -> new ArrayList<>()).add(p1);
            }

            // Use a queue to perform BFS from people who already know the secret at this time
            Queue<Integer> queue = new LinkedList<>();
            for (int person : peopleInTimeFrame) {
                if (secretKnowers.contains(person)) {
                    queue.add(person);
                }
            }

            // BFS to spread the secret among connected components
            while (!queue.isEmpty()) {
                int currentPerson = queue.poll();
                if (graph.containsKey(currentPerson)) {
                    for (int neighbor : graph.get(currentPerson)) {
                        if (!secretKnowers.contains(neighbor)) {
                            secretKnowers.add(neighbor);
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(secretKnowers);
    }
}
