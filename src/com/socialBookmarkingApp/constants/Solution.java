package com.socialBookmarkingApp.constants;
import java.util.*;
import java.io.*;
class Solution{
    static long find_cost(long N, int hcost, int vcost){
        long res = N*(N-1);
        res *= Math.min(hcost,vcost);
        long temp = (N-1)*(Math.max(hcost,vcost));
        return res + temp;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] ns = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        
    }
}
