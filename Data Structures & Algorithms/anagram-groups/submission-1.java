class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Hashmap approach
        //          HashMap<String, List<String>> hm = new HashMap<>();
        //          for(int i=0;i< strs.length;i++){
        //              char[] arr= strs[i].toCharArray();
        //              Arrays.sort(arr);
        //              String key = new String(arr);

        //             if(hm.containsKey(key)){
        //                 List<String> list= hm.get(key);
        //                 list.add(strs[i]);
        //                 hm.put(key, list);

        //             }else{
        //                 hm.put(key, new ArrayList<>(List.of(strs[i])));
        //             }

        //         }

        // return new ArrayList<>(hm.values());

        // Freqarray approach

        HashMap<String, List<String>> hm = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] count = new int[26];
            for (char c : strs[i].toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder uid= new StringBuilder();
            for(int c: count){
                uid.append(c);
                uid.append('#');
            }

            String key = uid.toString();

            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(strs[i]);
        }
        return new ArrayList<>(hm.values());
    }
}
