package com.codetest;

import java.util.Scanner;

public class Solution2 {
	
	interface KnapsackProblem{
		int knapsackSolver(int k, int[] weights);
	};
	
	interface Weighs{
    	int[] parseWeighs(String weight , int totalWeights);
	};
    
    public static void main(String[] args) {
    	
	KnapsackProblem knapSackProblem = (int total, int[] weights) -> {
		int[] values = new int[total + 1];
		int totalWeights = weights.length;
		values[0] = 0;

		for (int i = 0; i < totalWeights; i++)
			for (int j = weights[i]; j <= total; j++) {
				values[j] = Math.max(values[j], values[j - weights[i]]
						+ weights[i]);
			}
		return values[total];
	};
	
	Weighs weighs= (String weight , int totalWeights)-> {
		String[] values = weight.split(" ");
		int[] weights = new int[totalWeights];
		for(int i = 0 ; i < totalWeights ; i++){
			System.out.println(values[i]);
			weights[i] = Integer.parseInt(values[i].toString().trim());
		}
		return weights;
	};
	

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
		int totalInput = in.nextInt();
		for(int i = 0 ; i < totalInput ; i++){
			int totalWeights = in.nextInt();
			int total = in.nextInt();
			in.nextLine();
			String weight = in.nextLine();
			int[] weights = weighs.parseWeighs(weight, totalWeights);
			System.out.println("\n"+knapSackProblem.knapsackSolver(total, weights));
		}
		in.close();
		 System.out.println("The time taken to excute the program is :"+System.nanoTime()+" nanoseconds");
    }
    
}
