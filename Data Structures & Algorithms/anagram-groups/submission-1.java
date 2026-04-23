class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<List<String>> buckets = Stream.of(strs)
            .collect(Collectors.groupingBy(String::length)).values()
            .stream().collect(Collectors.toList());

        for (List<String> bucket : buckets) {
            Map<Map<Character, Integer>, List<String>> anagrams  = new HashMap<>();
            for (String word : bucket) {
                Map<Character, Integer> letterFrequency = new HashMap<>();
                for (char ch : word.toCharArray()) {
                    letterFrequency.put(ch, letterFrequency
                        .getOrDefault(ch, 0) + 1);
                }
                anagrams.computeIfAbsent(letterFrequency, k -> new ArrayList<>()).add(word);
            }
            result.addAll(anagrams.values());
        }
        return result;
    }
}
