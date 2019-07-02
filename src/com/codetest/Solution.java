package com.codetest;

import java.util.Arrays;
import java.util.Scanner;
	
	public class Solution {
		interface KnapsackProblem{
			int knapsackSolver(int k, int[] nums);
		}
      public static void main(String[] args) {
    	  
       KnapsackProblem  knapsackProblem = (int k, int[] nums) -> {
  	        Arrays.sort(nums);
  	        int[] table = new int[k+1];
  	        table[0] = 0;//empty set
  	        
  	        for(int i=1; i<k+1; i++){
  	            table[i] = 0;
  	            for(int j=0;j<nums.length && nums[j]<=i; j++){
  	                table[i] = Math.max(table[i-nums[j]] + nums[j], table[i]);
  	            }           
  	        }
  	        return table[k];
  	    };
    	  
	   System.out.println("Enter the numbers");
        try(Scanner s = new Scanner(System.in)){
            int t = s.nextInt();           
            while(t-->0){ 
            int n = s.nextInt(), k = s.nextInt();
            int[] nums = new int[n];
            for(int i=0; i<n; i++)
                nums[i] = s.nextInt();
            System.out.println(knapsackProblem.knapsackSolver(k, nums));
        
            }
        }
	   
        System.out.println("The time taken to excute the program is :"+System.nanoTime()+" nanoseconds");
	 }
      
	}

