package com.redgate.development.tests.readers;
 
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Reader {

	public static int count=0;

	//generic method that returns a SortedSet of Map.Entry -> used for printing
	private static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
		SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
				int res = e2.getValue().compareTo(e1.getValue());
				return res != 0 ? res : 1;
			}
		});
		sortedEntries.addAll(map.entrySet());
		return sortedEntries;
	}
	
	
	// Print words by frequency and then alphabetically -> returns sorted set for unit testing
	public static SortedSet<?> print(ArrayList<String> list) {
		Map<String, Integer> countMap = new TreeMap<>();

		for (int i = 0; i < list.size(); i++) {
			String word = list.get(i);
			Integer count = countMap.get(word);
			if (count == null) {
				count = 0;
			}

			countMap.put(word, (count.intValue() + 1));
		}
		
		// Call generic method above to 'sort' map
		 System.out.println(entriesSortedByValues(countMap));
		 return entriesSortedByValues(countMap);
	}

	
	
	// Count how many words there are
	public static void count(SimpleCharacterReader stream) {
		char c;
		try {
			while (true) {
				c = getReader(stream);

				// Assume a word is found when there's a space, new line or tab
				// (Inaccuracies handled later)
				if ((c == ' ') || (c == '\n') || (c == '\t')) {
					count++;
				}
			}
		} catch (EOFException eof) {
			stream.Dispose();
		}
	}

	
	
	// Read chars
	public static char getReader(ICharacterReader reader) throws EOFException {
		return reader.GetNextChar();
	}

	
	
	public static ArrayList<String> store(ICharacterReader info) throws EOFException {
		String temp = "";
		String word = "";

		// Store words in an array (Order does not matter)
		String[] arr = new String[count];
		int i = 0;
		while (i < count) {
			char c = info.GetNextChar();
			if (Character.isLetterOrDigit(c)) {
				// Change all strings to lower case for counting -> E.g. so that
				// (The = the)
				temp = Character.toString(c);
				word += temp.toLowerCase();
			} else if (c == ' ' || c == '\n' || c == '\t') {
				arr[i++] = word;
				word = "";
			}
		}

		
		// Add valid words ONLY to an ArrayList and return it
		ArrayList<String> list = new ArrayList<String>();

		temp = "";
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] != " " && arr[j] != null && arr[j] != "") {
				temp = arr[j];
			}
			list.add(temp);
		}
		return list;
	}
	
	
	public static void main(String[] args) throws EOFException {

		SimpleCharacterReader stream = new SimpleCharacterReader();

		// Count how many words we have
		count(stream);

		// Reset stream and store in ArrayList
		stream = new SimpleCharacterReader();
		ArrayList<String> words = store(stream);

		// Print the List Using a TreeMap -> easy to count frequencies
		print(words);
	}

}