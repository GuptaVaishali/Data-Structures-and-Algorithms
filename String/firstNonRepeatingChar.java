import java.util.*;
	// Java program to find first 
	// non-repeating character 
	// Note : hashmap is used 

	class IndCount { 
		int count, index; 

		// constructor for first occurrence 
		public IndCount(int index) 
		{ 
			this.count = 1; 
			this.index = index; 
		} 

		// method for updating count 
		public void incCount() 
		{ 
			this.count++; 
		} 
	} 
	class firstNonRepeatingChar { 
		static final int NO_OF_CHARS = 256; 

		static HashMap<Character, IndCount> m
			= new HashMap<Character, IndCount>(NO_OF_CHARS); 

		/* calculate count of characters 
		in the passed string */
		static void getCharCountArray(String str) 
		{ 
			for (int i = 0; i < str.length(); i++) { 
				// If character already occurred, 
				if (m.containsKey(str.charAt(i))) { 
					// updating count 
					m.get(str.charAt(i)).incCount(); 
				} 

				// If it's first occurrence, then store 
				// the index and count = 1 
				else { 
					m.put(str.charAt(i), new IndCount(i)); 
				} 
			} 
		} 

		/* The method returns index of first non-repeating 
		character in a string. If all characters are repeating 
		then returns -1 */
		static int SearchingChallenge(String str) 
		{ 
			getCharCountArray(str); 
			int result = Integer.MAX_VALUE, i; 
			for (Map.Entry<Character, IndCount> entry : m.entrySet()) 
			{ 
				int c=entry.getValue().count; 
				int ind=entry.getValue().index; 
				if(c==1 && ind < result) 
				{ 
					result=ind; 
				} 
			} 
			

			return result; 
		} 

		// Driver method 
		public static void main(String[] args) 
		{ 
			Scanner sc = new Scanner(System.in);
			String str  = sc.nextLine();
			int index = SearchingChallenge(str); 

		//	System.out.println( 
		//		index == Integer.MAX_VALUE 
		//			? "Either all characters are repeating "
		//				+ " or string is empty"
		//			: "First non-repeating character is "
		//				+ str.charAt(index));
			
			System.out.println(str.charAt(index));
		} 
	} 

