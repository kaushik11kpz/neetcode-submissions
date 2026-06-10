class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<List<Integer>,List<String>> map = new HashMap<>();
        for(String str : strs){
            int freq[]=new int[26];
            for(int i=0;i<str.length();i++){
                freq[str.charAt(i)-'a']++;
            }
            List<Integer> strFreq = new ArrayList<>();
            for(int num : freq){
                strFreq.add(num);
            }
            if(!map.containsKey(strFreq)){
                List<String> value = new ArrayList<>();
                value.add(str);
                map.put(strFreq,value);
            }else{
                map.get(strFreq).add(str);
            }
        }
        for(List<String> val : map.values()){
            list.add(val);
        }
        return list;
    }
}
