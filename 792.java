// 792. Number of Matching Subsequences

/* Approach - HashMap for storing repetative words in "words" array.
            - Two pointers for checking the subsequence status.
            - Counter to be appended when status is true.
*/

class Solution {
    public int numMatchingSubseq(String s, String[] words) {

        int res = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        char sFreq[] = s.toCharArray();

        for(String word : map.keySet()){
            
            char wFreq[] = word.toCharArray();

            int i = 0;
            int j = 0;

            while(i < s.length() && j < word.length()){
                if(sFreq[i] == wFreq[j]){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }

            if(j == word.length()){
                res += map.get(word);
            }
        }

        return res;
        
    }
}

      
