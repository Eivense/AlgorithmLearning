package leetcode.leetcode353;

import java.util.*;

/**
 * 353. 贪吃蛇
 * https://leetcode-cn.com/problems/design-snake-game/
 *
 * @author Eivense
 * @date 2021/9/2 10:24 下午
 */
public class SnakeGame {

    private int width;
    private int height;

    private LinkedList<Integer[]> snake;
    private Queue<int[]> foodQueue;
    private int score;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        // 初始化蛇
        this.snake = new LinkedList<>();
        this.snake.add(new Integer[]{0, 0});
        // 初始化食物
        this.foodQueue = new LinkedList<>();
        this.foodQueue.addAll(Arrays.asList(food));

    }

    public int move(String direction) {
        // 蛇头
        Integer[] head = snake.peek();
        Integer[] newHead = new Integer[2];
        switch (direction) {
            // 往右
            case "R":
                newHead=new Integer[]{head[0],head[1]+1};
                break;
            // 往左
            case "L":
                newHead=new Integer[]{head[0],head[1]-1};
                break;
            // 往下
            case "D":
                newHead=new Integer[]{head[0]+1,head[1]};
                break;
            // 往上
            case "U":
                newHead=new Integer[]{head[0]-1,head[1]};
                break;
        }

        Integer[] tail = snake.removeLast();
        // 碰到墙则结束
        if(isDead(newHead)||isDeadSelf(newHead)){
            return -1;
        }

        if (!foodQueue.isEmpty()) {
            int[] food = foodQueue.peek();
            snake.addFirst(newHead);
            // 吃到食物
            if (newHead[0] == food[0] && newHead[1] == food[1]) {
                this.score++;
                // 吃到食物 则删除食物
                foodQueue.remove();
                snake.addLast(tail);
            }
        }else{
            snake.addFirst(newHead);
        }

        return score;
    }

    public boolean isDead(Integer[] newHead) {
        int x = newHead[0];
        int y = newHead[1];

        // 撞墙
        if (x < 0 || x >= height || y < 0 || y >= width) {
            return true;
        }
        return false;
    }

    public boolean isDeadSelf(Integer[] newHead) {
        for (Integer[] body : snake) {
            if (body[0].equals(newHead[0]) && body[1].equals(newHead[1])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame(3, 3, new int[][]{{0,1}, {0, 2},{1,2},{2,2},{2,1},{2,0},{1,0}});

        System.out.println(snakeGame.move("R")); // 返回 0
        System.out.println(snakeGame.move("R")); // 返回 0
        System.out.println(snakeGame.move("D")); // 返回 1 ，蛇吃掉了第一个食物，同时第二个食物出现在 (0, 1)
        System.out.println(snakeGame.move("D")); // 返回 1
        System.out.println(snakeGame.move("L")); // 返回 2 ，蛇吃掉了第二个食物，没有出现更多食物
        System.out.println(snakeGame.move("L")); // 返回 -1 ，蛇与边界相撞，游戏结束
        System.out.println(snakeGame.move("U")); // 返回 -1 ，蛇与边界相撞，游戏结束
        System.out.println(snakeGame.move("U")); // 返回 -1 ，蛇与边界相撞，游戏结束
        System.out.println(snakeGame.move("R")); // 返回 -1 ，蛇与边界相撞，游戏结束
        System.out.println(snakeGame.move("R")); // 返回 -1 ，蛇与边界相撞，游戏结束
        System.out.println(snakeGame.move("D")); // 返回 -1 ，蛇与边界相撞，游戏结束
        System.out.println(snakeGame.move("D")); // 返回 -1 ，蛇与边界相撞，游戏结束
        System.out.println(snakeGame.move("L")); // 返回 -1 ，蛇与边界相撞，游戏结束
        System.out.println(snakeGame.move("L")); // 返回 -1 ，蛇与边界相撞，游戏结束
        System.out.println(snakeGame.move("U")); // 返回 -1 ，蛇与边界相撞，游戏结束
        System.out.println(snakeGame.move("R")); // 返回 -1 ，蛇与边界相撞，游戏结束
        System.out.println(snakeGame.move("U")); // 返回 -1 ，蛇与边界相撞，游戏结束

    }
}
