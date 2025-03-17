package xhjiang.leetcode.week04.mon;

/**
 * 发糖果问题
 * 1、每个孩子必须得到一个糖果
 * 2、相邻的孩子评分高的必须比低的多一个糖果（相同的话不要求必须高
 */
public class execrise135 {
    public int candy(int[] ratings) {
        int size = ratings.length;
        int candy[] = new int[size];
        //通通初始化为1
        for (int i = 0; i < size; i++) {
            candy[i] = 1;
        }
        //这里很巧妙，我刚开始从0~size，这样比较的时候会有candy[i+1]>candy[i]会越出界
        //后面我如果从1开始，比较i和i-1的话，就不会出现越界了
        for (int i = 1; i < size; i++) {
            //从左到右，右侧评分高，右侧糖果+1
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
//            else if (ratings[i] < ratings[i - 1]) {
//                candy[i] = 1;
//            } else if (ratings[i] == ratings[i - 1]) {
//                candy[i] = candy[i - 1];
//            }
        }

        // 从右到左遍历
        for (int i = size - 2; i >= 0; i--) {
            //从右到左，左侧评分高，左侧糖果+1
            if (ratings[i] > ratings[i+1]) {
                //错误写法
//                candy[i]i = candy[i+1] + 1;
                //正确写法
                candy[i] = Math.max(candy[i+1] + 1,candy[i]);
            }
//            else if (ratings[i+1] < ratings[i]) {
//                candy[i] = candy[i];
//            } else if (ratings[i] == ratings[i - 1]) {
//                candy[i] = candy[i - 1];
//            }
        }
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += candy[i];
        }
        return total;
    }

    public static void main(String[] args) {
        execrise135 solution = new execrise135();
        int[] ratings = {1, 0, 2}; // 示例输入
        int result = solution.candy(ratings);
        System.out.println("所需糖果总数：" + result); // 预期输出：5

        int[] ratings1 = {1, 2, 2}; // 示例输入
        int result1 = solution.candy(ratings);
        System.out.println("所需糖果总数：" + result1); // 预期输出：4
    }
}
