package other;


/**
 * 蓄水池问题 头条面试
 *
 * 给定一个一维数组用来描述海拔高度，相邻的海拔高度不同，则下雨后低洼处会有积水，
 * 假定雨水足够，能够填满所有的洼地，计算下雨后所有低洼地段的总蓄水量。
 *
 * 验证数据：
 * [5,2,1,4,3]  5
 * [5,2,1,6,3,4,2]   8
 *
 * https://blog.csdn.net/u013309870/article/details/70978279
 *
 * 递归 https://www.cnblogs.com/hxsyl/p/4153457.html
 *
 * https://blog.csdn.net/mw_nice/article/details/82663857
 *
 *
 *
 */
public class Reservoir {


    // 递归

    private static int water(int[] arr,int start,int end,int result) {
        if (end - start <= 1)
            return result;

        // first：start和end之间最高的墙
        // second：start和end之间第二高的墙
        int first = 0, second = 0;
        // firstIndex：第一高的墙在wallHeights中的索引
        // secondIndex：第二高的墙在wallHeights中的索引
        int firstIndex = 0, secondIndex = 0;
        // 两堵墙必须至少有一堵墙的距离
        // 开始获取第一高和第二高墙的砖数
        for (int i = start; i <= end; i++) {
            if (arr[i] > first) {
                second = first;
                secondIndex = firstIndex;
                first = arr[i];
                firstIndex = i;
            } else if (arr[i] > second) {
                second = arr[i];
                secondIndex = i;
            }
        }

        // 获取左侧墙的索引
        int startIndex = Math.min(firstIndex, secondIndex);
        // 获取右侧墙的索引
        int endIndex = Math.max(firstIndex, secondIndex);
        // 计算距离
        int distance = endIndex - startIndex;
        // 如果第一高的墙和第二高的墙之间至少有一堵墙，那么开始计算这两堵墙之间可以放多少个单位的水
        if (distance > 1) {
            result = result + (distance - 1) * second;
            // 减去这两堵墙之间的砖数
            for (int i = startIndex + 1; i < endIndex; i++) {
                result -= arr[i];
            }

        }
        // 开始递归处理左侧墙距离开始位置能放多少水
        result=water(arr,start, startIndex,result);
        // 开始递归处理右侧墙距离结束位置能放多少水
        result=water(arr,endIndex, end,result);

        return result;
    }



    public static int water1(int []arr)
    {
        int water=0;
        //water 用于保存最大存水量
        if(arr==null||arr.length<=1)
            return 0;
        //如果只有一根柱子围不住水。
        int leftLargest=0,rightLargest=0;
        //leftLargest,rightLargest 分别用于保存遍过程中，当前元素左边最大值，和右边最大值。
        for(int i=0;i<arr.length;i++)
        {
            leftLargest=0;
            rightLargest=0;
            for(int j=0;j<i;j++)
                leftLargest=Math.max(leftLargest,arr[j]);
            //先求出当前元素左边最大值。
            for(int j=arr.length-1;j>i;j--)
                rightLargest=Math.max(rightLargest, arr[j]);
            //最求出当前元素右边最大值
            water+=Math.min(leftLargest, rightLargest)>arr[i]?Math.min(leftLargest, rightLargest)-arr[i]:0;
//左边最大值和右边最大值的最小值与当前元素比较如果小于当前元素，则当前元素上水量为0，围不住水，如果大于当前元素，则减去当前元素得到存水量。
        }
        return water;
    }


    public static void main(String[] args) {
        int a[] = {5, 2, 1, 6, 3, 4, 2};
        System.out.println(water(a,0,a.length-1,0));
    }
}
