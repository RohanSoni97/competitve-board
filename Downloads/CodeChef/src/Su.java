// Java program to calculate the starting indices
// of substrings inside S which contains all the
// words present in List L.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Su
{
    public static ArrayList<Integer>
    findSubstring(String A, final List<String> B)
    {

        // Number of a characters of a word in list L.
        int size_word = B.get(0).length();

        // Number of words present inside list L.
        int word_count = B.size();

        // Total characters present in list L.
        int size_l = size_word * word_count;

        // Resultant vector which stores indices.
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = A.length();

        // If the total number of characters in list L
        // is more than length of string S itself.
        if (size_l > n)
        {
            return res;
        }

        // Map stores the words present in list L
        // against it's occurrences inside list L
        HashMap<String, Integer> hashMap =
                new HashMap<String, Integer>();

        for (String word : B)
        {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }


        for (int i = 0; i <= n - size_l; i++)
        {
            HashMap<String, Integer> tempMap =
                    (HashMap<String, Integer>) hashMap.clone();
            int j = i, count = word_count;

            // Traverse the substring
            while (j < i + size_l)
            {
                // Extract the word
                String word = A.substring(j, j + size_word);

                // If word not found or if frequency
                // of current word is more than required simply break.
                if (!hashMap.containsKey(word) || tempMap.get(word) == 0)
                {
                    break;
                }

                // Else decrement the count of word from hash_map
                else
                {
                    tempMap.put(word, tempMap.get(word) - 1);
                    count--;
                }
                j += size_word;
            }

            // Store the starting index of that
            // substring when all the words in
            // the list are in substring
            if (count == 0)
            {
                res.add(i);
            }

        }
        return res;
    }

    // Driver code
    public static void main(String[] args)
    {
        String S = "barfoothefoobarman";
        ArrayList<String> L =
                new ArrayList<>(Arrays.asList("foo", "bar"));
        ArrayList<Integer> indices = findSubstring(S, L);
        for (Integer i : indices)
        {
            System.out.println(i);
        }
    }
}

// This code is contributed by Manish Sakariya
