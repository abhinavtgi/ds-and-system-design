package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

//https://leetcode.com/problems/monotone-increasing-digits/description/
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {

        //idea is to find 1st index where that violates monotonic increasing condition i.e.
        // s.charAt(i)>s.charAt(i+1). So we just decreasing the element i by 1 and make all next
        //elements as 9.
        //but when we find that, one thing to check if the previous char is equal to this
        // so if we decrease this char then that element becomes larger
        //eg 2 5 5 5 5 4 6 9, here if we make right most 5 to 4 to make monotonic increasing
        //then other 5s violates condition so we have decrease pivotIndex till the previous elements
        //are equal
        StringBuilder s = new StringBuilder(n+"");

        int pivotIndex=-1;
        for(int i=0;i<s.length()-1;i++) {

            //first time violation so find pivotIndex and break
            if(s.charAt(i)>s.charAt(i+1)) {
                pivotIndex=i;
                int j=i;

                //move to previous element and check till when they are equal
                while(j-1>=0 && s.charAt(j)==s.charAt(j-1)) {
                    pivotIndex=j-1;
                    j--;
                }
                break;
            }
        }

        //no pivotIndex found so number is monotonic increasing already
        if(pivotIndex==-1) {
            return n;
        }

        //decrease the char at pivotIndex by 1
        int temp = s.charAt(pivotIndex)-'0'-1;
        char c = (char) (temp+'0');

        s.setCharAt(pivotIndex, c);
        pivotIndex++;

        //make all the next elements as 9
        while(pivotIndex<s.length()) {
            s.setCharAt(pivotIndex,'9');
            pivotIndex++;
        }

        return Integer.parseInt(s.toString());
    }
}
