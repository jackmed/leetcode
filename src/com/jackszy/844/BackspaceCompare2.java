import java.util.Stack;

public class BackspaceCompare2 {
    public static void main(String[] args) {
        System.out.println(new BackspaceCompare2().backspaceCompare("ab##", "c#d#"));
    }

    //方法二：不用栈，用StringBuilder处理字符串
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    //格式化字符串 （这里主要到技巧是维护一个下标index用于操作StringBuilder的字符）
    String build(String S) {
        StringBuilder res = new StringBuilder(S);

        int index=0;
        for(int i=0;i<S.length();i++) {
            index++;
            if (S.charAt(i) =='#') {
                res.deleteCharAt(--index);
                if (index>0) {
                    index--;
                    res.deleteCharAt(index);
                }
            }
        }
        return res.toString();
    }
}
