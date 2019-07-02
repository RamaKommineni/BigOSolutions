package com.codetest;

import java.util.Scanner;

public class Solution3 {
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t;
        t = scan.nextInt();
        for( int i = 0; i < t; i++) {
            int n, k;
            n = scan.nextInt();
            k = scan.nextInt();
            int[] arr = new int[n];
            for( int  j = 0; j < n; j++) {
                arr[j] = scan.nextInt();
            }
            System.out.println("\n"+knapsack(arr, k ,n-1)); 
        }
        scan.close();
    }
    
    public static int knapsack( int[] arr, int k, int n) {
        if( n < 0)
            return 0;
        if(arr[n] > k)
            return knapsack(arr, k, n - 1);
        return Math.max(knapsack(arr, k - arr[n], n ) + arr[n], knapsack(arr, k, n -1));
    }

}
