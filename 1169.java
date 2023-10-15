// 1169. Invalid Transactions

class Solution {
    public List<String> invalidTransactions(String[] arr) {

        String name[] = new String[arr.length];
        int time[] = new int[arr.length];
        int amt[] = new int[arr.length];
        String city[] = new String[arr.length];

        int ind = 0;

        for(String a : arr){

            String temp[] = a.split("\\,");

            name[ind] = temp[0];
            time[ind] = Integer.parseInt(temp[1]);
            amt[ind] = Integer.parseInt(temp[2]);
            city[ind++] = temp[3];

        }

        // System.out.println(Arrays.toString(city));

        HashSet<Integer> inds = new HashSet<>();

        List<String> res = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(amt[i] > 1000){
                inds.add(i);
                res.add(arr[i]);
            }
        }

        for(int i=0; i<arr.length; i++){

            for(int j=i+1; j<arr.length; j++){

                if(name[i].equals(name[j]) && !city[i].equals(city[j]) && Math.abs(time[i] - time[j]) <= 60){
                    if(!inds.contains(j)){
                        inds.add(j);
                        res.add(arr[j]);
                    }

                    if(!inds.contains(i)){
                        inds.add(i);
                        res.add(arr[i]);
                    }
                }

            }

        }

        return res;
        
    }
}
