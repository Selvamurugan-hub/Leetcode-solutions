class Solution {
    private int start = 0, maxLen = 1;

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        for (int i = 0; i < s.length() - 1; i++) {
            expand(s, i, i);     // odd length  "aba"
            expand(s, i, i + 1); // even length "abba"
        }

        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // left+1 and right-1 are the actual palindrome boundaries
        int len = right - left - 1;
        if (len > maxLen) {
            maxLen = len;
            start = left + 1;
        }
    }
}
