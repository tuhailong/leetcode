package com.tuhailong.leetcode.exams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author tuhailong
 * @since 2019-11-25
 */
class Exam191122 {
    private static final HashSet<Character> UPPER_CASES = new HashSet<>();

    static {
        for (int i = 'A'; i <= 'Z'; i++) {
            UPPER_CASES.add((char) i);
        }
    }

    /**
     * 单词首字母大写，处理字符串，要求以单词为单位进行倒序处理，
     * 例如：
     * 输入：“MyNameIsTom”
     * 输出： “yMemaNsImoT”
     * 输入：“LowLL”
     * 输出：“woLLL”
     */
    public String reverseSentence(String str) {
        StringBuilder ans = new StringBuilder();
        final char[] chs = str.toCharArray();
        StringBuilder tmp = new StringBuilder();
        int idx = 0;
        while (idx < chs.length) {
            if (UPPER_CASES.contains(chs[idx])) {
                ans.append(tmp.reverse());
                tmp = new StringBuilder();
            }
            tmp.append(chs[idx]);
            ++idx;
        }
        ans.append(tmp.reverse());
        return ans.toString();
    }

    /**
     * 实验室电脑，从0~N编号，但是不小心搞乱的顺序，需要重排，计算交换的最小次数
     * 例如：
     * 输入: [2, 0 ,1]
     * 输出： 2
     * 解释：调换2和0，变成[0,2,1],调换2和1，变成[0,1,2]，共计2次；
     * 输入： [0,1,2,3,4,5]
     * 输出：0
     */
    public int swap(int[] array) {
        int cnt = 0;
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minIdx = j;
                }
            }
            if (array[i] != min) {
                ++cnt;
            }
            array[i] ^= array[minIdx];
            array[minIdx] ^= array[i];
            array[i] ^= array[minIdx];
        }
        return cnt;
    }

    /**
     * 进程PID，其父进程为PPID，父进程可以有一个或多个子进程，如果父进程ID为0，则表示其就是父进程。
     * kIll一个进程ID，则杀死其所有关联的子进程和自己， 指定PID和和其对应的PPID列表，并给出kill ,请计算关联进程列表。
     * 例如：
     * 输入：
     * PID: [1, 3, 10, 5]
     * PPID:[3, 0, 5, 3]
     * kill: 5
     *    3
     *  /   \
     * 1     5
     *      /
     *     10
     * 输出: [10, 5]
     * 注意：
     * 1. PID与PPID是对应的；
     * 2. PID列表个数>= 1;
     * 3. O(n^2)的算法，通过的用例很少；
     */
    public List<Integer> terminateProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int ppidsCount = ppid.size();
        for (int i = 0; i < ppidsCount; i++) {
            HashSet<Integer> set = map.getOrDefault(ppid.get(i), new HashSet<>());
            set.add(pid.get(i));
            map.put(ppid.get(i), set);
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            Integer id = queue.poll();
            ans.add(id);
            HashSet<Integer> pidSet = map.get(id);
            if (pidSet == null) {
                continue;
            }
            for (int i : pidSet) {
                queue.offer(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Exam191122 ni = new Exam191122();
        System.out.println(ni.reverseSentence("LowLL"));
        System.out.println(ni.reverseSentence("MyNameIsTom"));
        System.out.println(ni.swap(new int[] {1, 2, 3, 4, 5}));
    }
}
