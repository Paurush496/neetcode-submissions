class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] prereqRem = new int[numCourses];
        List<Integer>[] follows = new List[numCourses];
        for (int[] prereq : prerequisites) {
            prereqRem[prereq[0]]++;
            List<Integer> list = follows[prereq[1]];
            if (list == null) {
                follows[prereq[1]] = new ArrayList<Integer>(List.of(prereq[0]));
            } else {
                follows[prereq[1]].add(prereq[0]);
            }
        }

        ArrayDeque<Integer> topPrereq = new ArrayDeque<>();
        for (int i = 0; i < prereqRem.length; i++) {
            if (prereqRem[i] == 0)
                topPrereq.push(i);
        }
        while (!topPrereq.isEmpty()) {
            int top = topPrereq.pop();
            if (follows[top] != null) {
                for (int i : follows[top]) {
                    if (--prereqRem[i] == 0)
                        topPrereq.push(i);
                }
            }
        }
        for (int rem : prereqRem) {
            if (rem != 0)
                return false;
        }
        return true;
    }
}
