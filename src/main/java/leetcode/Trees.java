package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by stan on 12/04/2021.
 */
public class Trees {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /*
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).
    A valid BST is defined as follows:
        - The left subtree of a node contains only nodes with keys less than the node's key.
        - The right subtree of a node contains only nodes with keys greater than the node's key.
        - Both the left and right subtrees must also be binary search trees.
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer lowLimit, Integer upLimit) {
        if (root == null) return true;
        System.out.println(" " + root.val + " lowLimit : " + lowLimit + " upLimit : " + upLimit);

        if ((lowLimit != null && root.val <= lowLimit) || (upLimit != null && root.val >= upLimit)) {
            return false;
        }

        return isValidBST(root.right, root.val, upLimit) && isValidBST(root.left, lowLimit, root.val);
    }

    //Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode root, TreeNode symmetric) {
        if (root == null && symmetric == null ) return true;

        if (root == null) return false;
        if (symmetric == null) return false;

        if(root.val != symmetric.val)
            return false;

        return isSymmetric(root.left, symmetric.right) && isSymmetric(root.right, symmetric.left);
    }

    //Given the root of a binary tree, return the level order traversal of its nodes' values.
    //(i.e., from left to right, level by level).
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();

        traverseLevelOrder(root, levelOrder);

        return levelOrder;
    }

    public void traverseLevelOrder(TreeNode root, List<List<Integer>> levelOrder) {
        if(root == null) return ;
        //[3,9,20,null,null,15,7]

        Deque<TreeNode> nextToVisit = new ArrayDeque<>();
        nextToVisit.addLast(root);
        do {
            List<Integer> currentLevel = new ArrayList<>();

            int size = nextToVisit.size();
            for(int i = 0; i < size; i++){
                TreeNode node = nextToVisit.pollFirst();
                currentLevel.add(node.val);
                if(node.left != null){
                    nextToVisit.addLast(node.left);
                }

                if(node.right != null){
                    nextToVisit.addLast(node.right);
                }
            }

            levelOrder.add(currentLevel);
        } while(!nextToVisit.isEmpty());
    }

    //Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
    //A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
    public TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBST(nums, 0, nums.length);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (end - start == 0) return null;

        if (end - start == 1) return new TreeNode(nums[start]);

        int middle = ((end - start)/2) + start;
        int rootVal = nums[middle];

        return new TreeNode(rootVal, sortedArrayToBST(nums, start, middle), sortedArrayToBST(nums, middle + 1, end));

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
