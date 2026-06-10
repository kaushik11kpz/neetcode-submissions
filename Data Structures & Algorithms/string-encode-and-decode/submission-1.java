class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String str : strs){
            int size=str.length();
            result.append(size).append("#").append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            String lenStr = str.substring(i,j);
            int size = Integer.parseInt(lenStr);
            String st = str.substring(j+1,j+size+1);
            result.add(st);
            i=j+size+1;
        }
        return result;
    }
}
