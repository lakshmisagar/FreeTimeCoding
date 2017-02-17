package WordSearchII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class wordSearch {
	static boolean result = false;

	public static List<String> findWords(char[][] board, String[] words) {
		int i = 0;
		boolean found = false;
		List<String> list = new ArrayList<String>();
		while (i < words.length) {
			int j = 0;
			char match = words[i].charAt(j);
			for (int row = 0; row < board.length; row++) {
				for (int col = 0; col < board[0].length; col++) {
					if (board[row][col] == match) {
						if(words.length == 1){
							list.add(words[i]);
						}
						else if (board[0].length > 1) {
							j++;
							if (findMatch(board, row, col, words[i].charAt(j),
									i, j, words)) {
								list.add(words[i]);
								result = false;
								found = true;
								break;
							} else {
								j--;
							}
						} else if (board[0].length == 1) {
							list.add(words[i]);
						}
					}

					if (found)
						break;
				}

				if (found)
					break;
			}
			found = false;
			i++;
		}
		Collections.sort(list);
		return list;
	}

	private static boolean findMatch(char[][] board, int row, int col,
			char match, int i, int j, String[] words) {
		if (result == true || j == words.length)
			return true;
		if (col < words.length - 1 && board[row][col + 1] == match) {
			j++;
			if (j == words[i].length()) {
				result = true;
				return true;
			}
			findMatch(board, row, col + 1, words[i].charAt(j), i, j, words);
		} else if (col > 0 && board[row][col - 1] == match) {
			j++;
			if (j == words[i].length()) {
				result = true;
				return true;
			}
			findMatch(board, row, col - 1, words[i].charAt(j), i, j, words);
		} else if (row < words.length - 1 && board[row + 1][col] == match) {
			j++;
			if (j == words[i].length()) {
				result = true;
				return true;
			}
			findMatch(board, row + 1, col, words[i].charAt(j), i, j, words);
		} else if (row > 0 && board[row - 1][col] == match) {
			j++;
			if (j == words[i].length()) {
				result = true;
				return true;
			}
			findMatch(board, row - 1, col, words[i].charAt(j), i, j, words);
		}
		if (result) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		char[][] board = new char[][] {/*
										 * {'o','a','a','n'}, {'e','t','a','e'},
										 * {'i','h','k','r'}, {'i','f','l','v'}
										 */
		{ 'a','b' }, };

		String words[] = {/* "oath","pea","eat","rain" */"ab" };
		ArrayList<String> l = (ArrayList<String>) findWords(board, words);
		int i = 0;
		while (i < l.size()) {
			System.out.println(l.get(i));
			i++;
		}
	}

}