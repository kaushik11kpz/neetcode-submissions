class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char s[] = str.toCharArray();
            Arrays.sort(s);
            String key = new String(s);
            if(!map.containsKey(key)){
                List<String> value = new ArrayList<>();
                value.add(str);
                map.put(key,value);
            }else{
                map.get(key).add(str);
            }
        }
        for(List<String> val : map.values()){
            list.add(val);
        }
        return list;
    }
}
