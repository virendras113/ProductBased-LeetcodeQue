// 299. Bulls and Cows
// Bulls and Cows

// Approach - HashMap and Character matching

class Solution {
    public String getHint(String secret, String guess) {

        HashMap<Character, Integer> s = new HashMap<>();
        HashMap<Character, Integer> g = new HashMap<>();

        int bulls = 0;
        int cows = 0;

        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
                continue;
            }
            s.put(secret.charAt(i), s.getOrDefault(secret.charAt(i), 0) + 1);
            g.put(guess.charAt(i), g.getOrDefault(guess.charAt(i), 0) + 1);
        }

        for(Map.Entry<Character, Integer> e : s.entrySet()){
            if(g.containsKey(e.getKey())){
                cows += Math.min(e.getValue(), g.get(e.getKey()));
            }
        }

        return bulls + "A" + cows + "B";
        
    }
}
