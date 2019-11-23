package com.tuhailong.leetcode;

/**
 * 给定一个关键词集合 words 和一个字符串 S，将所有 S 中出现的关键词加粗。
 * 所有在标签 <b> 和 </b> 中的字母都会加粗。
 * 返回的字符串需要使用尽可能少的标签，当然标签应形成有效的组合。
 * 例如，给定 words = ["ab", "bc"] 和 S = "aabcd"，需要返回 "a<b>abc</b>d"。
 * 注意返回 "a<b>a<b>b</b>c</b>d" 会使用更多的标签，因此是错误的。
 * 注：
 * words 长度的范围为 [0, 50]。
 * words[i] 长度的范围为 [1, 10]。
 * S 长度的范围为 [0, 500]。
 * 所有 words[i] 和 S 中的字符都为小写字母。
 * 链接：https://leetcode-cn.com/problems/bold-words-in-string
 *
 * @author tuhailong
 * @since 2019-11-21
 */
class LeetCode758 {
    public String boldWords(String[] words, String S) {
        if (words == null || words.length == 0) {
            return S;
        }
        boolean[] bold = new boolean[S.length()];
        for (String word: words) {
            int idx = S.indexOf(word, 0);
            while (idx != -1) {
                for (int i = idx; i < idx + word.length(); i++) {
                    bold[i] = true;
                }
                idx = S.indexOf(word, idx + 1);
            }
        }
        StringBuilder builder = new StringBuilder();
        if (bold[0]) {
            builder.append("<b>");
        }
        for (int i = 0; i < bold.length; i++) {
            builder.append(S.charAt(i));
            if (i == bold.length - 1) {
                if (bold[i]) {
                    builder.append("</b>");
                }
                break;
            }
            if (bold[i] && !bold[i + 1]) {
                builder.append("</b>");
                continue;
            }
            if (!bold[i] && bold[i + 1]) {
                builder.append("<b>");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        final String[] words = new String[] {"bc", "ab"};
        LeetCode758 ni = new LeetCode758();
        System.out.println(ni.boldWords(words, "aabcd"));
    }
}
