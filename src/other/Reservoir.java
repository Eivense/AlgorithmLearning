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
        //water 用于保存最大存水量
        int water=0;

        //如果只有一根柱子围不住水。
        if(arr==null||arr.length<=1) {
            return 0;
        }
        //left 保存每个元素左边的最大值
        int[] left = new int[arr.length];
        //right 保存每个元素右边的最大值
        int[] right = new int[arr.length];

        int leftLargest=0,rightLargest=0;

        // 找出所有元素左边的最大值
        for(int i=0;i<arr.length;i++) {
            leftLargest=Math.max(leftLargest,arr[i]);
            left[i]=leftLargest;
        }

        // 找出所有元素右边的最大值
        for(int i=arr.length-1;i>=0;i--) {
            rightLargest=Math.max(rightLargest,arr[i]);
            right[i] = rightLargest;
        }

        for(int i=0;i<arr.length;i++){

            // 左右两边更小的那个值决定了高度
            int min=Math.min(left[i],right[i]);

            if(min>arr[i]){
                water+=min-arr[i];
            }
        }

        return water;
    }


    public static void main(String[] args) {
        int a[] = {5, 2, 1, 6, 3, 4, 2};
        System.out.println(water1(a));
    }
}
