package com.tuhailong.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。
 * 这样，我们可以持续进行 “移位” 操作，从而生成如下移位序列：
 * "abc" -> "bcd" -> ... -> "xyz"
 * 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。
 * 示例：
 * 输入: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
 * 输出:
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 * 链接：https://leetcode-cn.com/problems/group-shifted-strings
 *
 * @author tuhailong
 * @since 2019-12-02
 */
class LeetCode249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            if (str == null) {
                continue;
            }
            String key = encode(str);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String encode(String str) {
        char[] chs = str.toCharArray();
        int diff = chs[0] - 'a';
        for (int i = 0; i < chs.length; i++) {
            chs[i] -= diff;
            if (chs[i] < 'a') {
                chs[i] += 26;
            }
        }
        return new String(chs);
    }

    public List<List<String>> groupStringsMine(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (String str : strings) {
            if (str == null) {
                continue;
            }
            char[] chs = str.toCharArray();
            for (int i = 1; i < chs.length; i++) {
                int diff = chs[i] - chs[i - 1];
                if (diff < 0) {
                    diff += 26;
                }
                builder.append(diff).append('#');
            }
            int len = builder.length();
            String key = len == 0 ? "#" : builder.substring(0, len - 1);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
            builder.delete(0, len);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> list : map.values()) {
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs1 = {"ab", "ba"};
        String[] strs2 = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        LeetCode249 ni = new LeetCode249();
        //ni.groupStrings(strs1);
        ni.groupStrings(strs2);
    }
}
