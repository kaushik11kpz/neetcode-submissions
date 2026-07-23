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
                char[] ch = currNode.toCharArray();
                for(int j=0;j<ch.length;j++){
                    char original = ch[j];
                    for(char c='a';c<='z';c++){
                        if(c==original){
                            continue;
                        }
                        ch[j]=c;
                        String newStr = new String(ch);
                        if(wordSet.contains(newStr)){
                            queue.add(newStr);
                            wordSet.remove(newStr);
                        }
                    }
                    ch[j]=original;
                }
            }
        }
        return 0;
    }
}
