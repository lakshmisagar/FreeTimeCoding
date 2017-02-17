package Greedy;

import java.util.Scanner;

public class grid {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		for (int q = 0; q < n; q++) {
			int matrix = Integer.parseInt(s.nextLine());
			boolean result = true;
			char[][] M = new char[matrix][matrix];
			for (int i = 0; i < matrix; i++) {
				String l = s.nextLine();
				for (int j = 0; j < l.length(); j++) {
					M[i][j] = l.charAt(j);
				}
			}
			/*
			 * for (int z = 0; z < matrix; z++) { for (int i = 0; i < matrix;
			 * i++) { for (int j = 0; j < matrix; j++) { if (j > 0 && M[i][j] <
			 * M[i][j - 1]) { char temp = M[i][j]; M[i][j] = M[i][j - 1]; M[i][j
			 * - 1] = temp; } } } }
			 */
			// bubble
			for (int i = 0; i < matrix; i++) {
				for (int z = 0; z < matrix; z++) {
					for (int j = 0; j < matrix; j++) {
						if (M[i][j] > M[i][j+1]) {
							char temp = M[i][j];
							M[i][j] = M[i][j+1];
							M[i][j+1] = temp;
						}
					}
				}
			}

			System.out.println("output");
			for (int i = 0; i < matrix; i++) {
				for (int j = 0; j < matrix; j++) {
					System.out.print(M[i][j]);
				}
				System.out.println();
			}

			boolean found = false;
			for (int i = 1; i < matrix; i++) {
				for (int j = 0; j < matrix; j++) {
					if (M[i][j] < M[i - 1][j]) {
						result = false;
						found = true;
						break;
					} else if (M[i][j] > M[i - 1][j]) {
						found = true;
					}
				}
				if (found)
					break;
			}
			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
