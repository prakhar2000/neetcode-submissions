class Solution {
    public boolean diffByOne(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1)
                return false;
        }

        return diff == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        List<String> allWords = new ArrayList<>(wordList);
        if (!allWords.contains(beginWord)) {
            allWords.add(beginWord);
        }

        List<List<Integer>> l = new ArrayList<>();

        for (int i = 0; i < allWords.size(); i++) {
            l.add(i, new ArrayList<>());
        }

        for (int i = 0; i < allWords.size(); i++) {
            for (int j = i + 1; j < allWords.size(); j++) {
                String w1 = allWords.get(i);
                String w2 = allWords.get(j);

                if (diffByOne(w1, w2)) {
                    l.get(i).add(j);
                    l.get(j).add(i);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[allWords.size()];

        int startIdx = allWords.indexOf(beginWord);
        int endIdx = allWords.indexOf(endWord);
        q.offer(startIdx);
        vis[startIdx] = true;

        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int curr = q.poll();
                if (curr == endIdx)
                    return steps;

                for (int nei : l.get(curr)) {
                    if (!vis[nei]) {
                        vis[nei] = true;
                        q.offer(nei);
                    }
                }
            }

            steps++;
        }
        return 0;
    }
}
