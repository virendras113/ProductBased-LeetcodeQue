//593. Valid Square

import java.math.BigDecimal;  
class Solution {
    
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        double arr[] = new double[6];
        
        arr[0] = distance(p1, p2);
        arr[1] = distance(p1, p3);
        arr[2] = distance(p1, p4);
        arr[3] = distance(p2, p3);
        arr[4] = distance(p2, p4);
        arr[5] = distance(p3, p4);

        //System.out.println(dist1 + " " + dist2 + " " + dist3);

        Arrays.sort(arr);

        double min = arr[0];

        if(arr[5] == min) return false;

        int sideCount = 0;
        int diagCount = 0;

        for(int i=0; i<6; i++){
            if(min == arr[i]){
                sideCount++;
            }else if(min * 2 == arr[i]){
                diagCount++;
            }
        }

        if(sideCount == 4 && diagCount == 2){
            return true;
        }

        return false;
        
    }

    public static double distance(int p1[] ,int p2[]){

        int x1 = p1[0];
        int y1 = p1[1];

        int x2 = p2[0];
        int y2 = p2[1];

        int dist = (int)Math.pow((x2 - x1), 2) + (int)Math.pow((y2 - y1), 2);

        return dist;

    }
}
