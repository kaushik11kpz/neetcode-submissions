class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        if(!wordSet.contains(endWord) || beginWord.equals(endWord)){
            return 0;
        }
        queue.add(beginWord);
        int ladderSize=0;
        while(!queue.isEmpty()){
            ladderSize++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                String currNode = queue.poll();
                if(currNode.equals(endWord)){
                    return ladderSize;
                }
                for(int j=0;j<currNode.length();j++){
                    for(char c='a';c<='z';c++){
                        if(c==currNode.charAt(j)){
                            continue;
                        }
                        String newStr = currNode.substring(0,j) + c + currNode.substring(j+1);
                        if(wordSet.contains(newStr)){
                            queue.add(newStr);
                            wordSet.remove(newStr);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
