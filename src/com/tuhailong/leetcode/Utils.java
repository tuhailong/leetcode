package com.tuhailong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static void main(String[] args) {
        // 前序与中序，构造后续
        String preStr = "12473568";
        String inStr1 = "47215386";
        Character[] preChars = new Character[preStr.length()];
        int idx = 0;
        for (char ch : preStr.toCharArray()) {
            preChars[idx++] = ch;
        }
        Character[] inChars = new Character[inStr1.length()];
        idx = 0;
        for (char ch : inStr1.toCharArray()) {
            inChars[idx++] = ch;
        }
        TreeBuilder<Character> builder1 = new PreorderAndInorderBuilder<>();
        builder1.printTree(builder1.buildTree(preChars, inChars));

        // 中序与后续，构造前序
        String inStr2 = "47215386";
        String postStr = "74258631";
        Character[] inChars2 = new Character[inStr2.length()];
        int idx2 = 0;
        for (char ch : inStr1.toCharArray()) {
            inChars2[idx2++] = ch;
        }
        Character[] postChars = new Character[postStr.length()];
        idx2 = 0;
        for (char ch : postStr.toCharArray()) {
            postChars[idx2++] = ch;
        }
        TreeBuilder<Character> builder2 = new InorderAndPostorderBuilder<>();
        builder2.printTree(builder2.buildTree(inChars, postChars));
    }

    public interface TreeBuilder<T> {
        TreeNode<T> buildTree(T[] one, T[] two);

        void printTree(TreeNode<T> root);
    }

    private static class TreeNode<T> {
        public T val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(T ch) {
            val = ch;
        }
    }

    public static class InorderAndPostorderBuilder<T> implements TreeBuilder<T> {
        private int mPostIdx;

        private T[] mInorders;
        private T[] mPostorders;

        private Map<T, Integer> mMap = new HashMap<>();


        @Override
        public TreeNode<T> buildTree(T[] inorder, T[] postorder) {
            if (inorder == null || postorder == null) {
                return null;
            }
            if (inorder.length != postorder.length) {
                return null;
            }

            this.mInorders = inorder;
            this.mPostorders = postorder;
            this.mPostIdx = mPostorders.length - 1;

            for (int i = 0; i < mInorders.length; i++) {
                mMap.put(mInorders[i], i);
            }

            return builder(0, mInorders.length - 1);
        }

        @Override
        public void printTree(TreeNode root) {
            StringBuilder buf = new StringBuilder();
            preorder(root, buf);
            System.out.println("前序遍历: " + buf.toString());
        }

        private void preorder(TreeNode<T> node, StringBuilder buf) {
            if (node == null) {
                return;
            }
            buf.append(node.val);
            preorder(node.left, buf);
            preorder(node.right, buf);
        }

        private TreeNode<T> builder(int inLid, int inRid) {
            if (inLid > inRid) {
                return null;
            }

            T postValue = mPostorders[mPostIdx];
            TreeNode node = new TreeNode(postValue);
            int index = mMap.get(postValue);

            mPostIdx--;
            node.right = builder(index + 1, inRid);
            node.left = builder(inLid, index - 1);
            return node;
        }
    }

    public static class PreorderAndInorderBuilder<T> implements TreeBuilder<T> {
        private int mPreIdx;

        private T[] mInorders;
        private T[] mPreorders;

        private Map<T, Integer> mMap = new HashMap<>();


        @Override
        public TreeNode<T> buildTree(T[] preorder, T[] inorder) {
            if (inorder == null || preorder == null) {
                return null;
            }
            if (inorder.length != preorder.length) {
                return null;
            }

            this.mInorders = inorder;
            this.mPreorders = preorder;
            this.mPreIdx = 0;

            for (int i = 0; i < mInorders.length; i++) {
                mMap.put(mInorders[i], i);
            }

            return builder(0, mInorders.length - 1);
        }

        @Override
        public void printTree(TreeNode root) {
            StringBuilder buf = new StringBuilder();
            postorder(root, buf);
            System.out.println("后续遍历: " + buf.toString());
        }

        private void postorder(TreeNode<T> node, StringBuilder buf) {
            if (node == null) {
                return;
            }
            postorder(node.left, buf);
            postorder(node.right, buf);
            buf.append(node.val);
        }

        private TreeNode<T> builder(int inLid, int inRid) {
            if (inLid > inRid) {
                return null;
            }

            T preValue = mPreorders[mPreIdx];
            TreeNode node = new TreeNode(preValue);
            int index = mMap.get(preValue);

            mPreIdx++;
            node.left = builder(inLid, index - 1);
            node.right = builder(index + 1, inRid);
            return node;
        }
    }
}
