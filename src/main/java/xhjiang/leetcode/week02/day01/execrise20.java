package xhjiang.leetcode.week02.day01;

import java.util.HashMap;
import java.util.Stack;


/**
 * @description: 有效的括号
 * @author: xhjiang
 * @date: 2025/2/17 17:12
 */
public class execrise20 {
    //用一个数据结构存储括号类型
    private static final HashMap<Character,Character> characterHashMap=new HashMap<>(){
        {
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }
    };
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> characterStack=new Stack<>();
        //字符串遍历
        for (char c:s.toCharArray()){
            //如果是左括号，压入
            if (c=='(' || c=='[' || c=='{'){
                characterStack.push(c);
            }
            //如果是右括号，就先判断栈是否空了，其次不空判断栈的栈顶元素是否匹配，不匹配返回false
            else if (c==')'||c==']'||c=='}'){
                if (characterStack.isEmpty()){
                    return false;
                }
                char top=characterStack.pop();
                if(c!=characterHashMap.get(top)){
                    return false;
                }
            }
        }
        //排除了这么多的false情况，最后可以返回true了
        //return true;

        //最后不应该是上面，而是应该检查栈是否为空，空的话就是true
        return characterStack.isEmpty();
    }

    public static void main(String[] args) {
        execrise20 ex20=new execrise20();
        boolean a=ex20.isValid("([])");
        System.out.println(a);
    }
}
