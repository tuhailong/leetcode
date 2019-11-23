package com.tuhailong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 * 找到所有长度为 n 的中心对称数。
 * 示例 :
 * 输入:  n = 2
 * 输出: ["11","69","88","96"]
 * 链接：https://leetcode-cn.com/problems/strobogrammatic-number-ii
 *
 * @author tuhailong
 * @since 2019-11-18
 */
class LeetCode247 {
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        char[] buf = new char[n];
        dfs(ans, buf, 0, n - 1);
        return ans;
    }

    private void dfs(List<String> ans, char[] buf, int l, int r) {
        if (l > r) {
            ans.add(String.valueOf(buf));
            return;
        } else if (l == r) {
            buf[l] = '0';
            ans.add(String.valueOf(buf));
            buf[l] = '1';
            ans.add(String.valueOf(buf));
            buf[l] = '8';
            ans.add(String.valueOf(buf));
            return;
        }

        if (l > 0) {
            buf[l] = '0';
            buf[r] = '0';
            dfs(ans, buf, l + 1, r - 1);
        }

        buf[l] = '1';
        buf[r] = '1';
        dfs(ans, buf, l + 1, r - 1);

        buf[l] = '8';
        buf[r] = '8';
        dfs(ans, buf, l + 1, r - 1);

        buf[l] = '6';
        buf[r] = '9';
        dfs(ans, buf, l + 1, r - 1);
        buf[l] = '9';
        buf[r] = '6';
        dfs(ans, buf, l + 1, r - 1);
    }

    public List<String> findStrobogrammaticMyself(int n) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
        HashMap<Integer, List<String>> map = new HashMap<>();
        List<String> rets = helper(n, map);
        Iterator<String> iterator = rets.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().startsWith("0")) {
                iterator.remove();
            }
        }
        return rets;
    }

    private List<String> helper(int n, HashMap<Integer, List<String>> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        List<String> tmp;
        if (n == 1) {
            tmp = new ArrayList<>(Arrays.asList("0", "1", "8"));
            map.put(1, tmp);
            return tmp;
        }
        if (n == 2) {
            tmp = new ArrayList<>(Arrays.asList("00", "11", "69", "88", "96"));
            map.put(2, tmp);
            return tmp;
        }
        tmp = helper(2, map);
        List<String> tep = helper(n - 2, map);
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            for (int j = 0; j < tep.size(); j++) {
                ret.add(tmp.get(i).charAt(0) + tep.get(j) + tmp.get(i).charAt(1));
            }
        }
        return ret;
    }
}
