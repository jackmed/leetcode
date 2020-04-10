public class IsAnagram3 {
    public boolean isAnagram(String s, String t) {
        //方法三，用26长度的数组存放计数
        if (s.length() !=t.length())
            return false;

        int[] counter = new int[26];
        for(int i=0;i<s.length();i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for(int cnt: counter)
            if (cnt !=0)
                return false;

        return true;
    }
}
