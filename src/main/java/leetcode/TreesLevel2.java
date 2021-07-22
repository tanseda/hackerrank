package leetcode;

import java.util.*;

/**
 * Created by stan on 19/04/2021.
 */
public class TreesLevel2 {

    //Binary Tree Inorder Traversal
    //https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/786/
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List <Integer> res = new ArrayList< >();

        inorderTraversal(root, res);

        return res;
    }

    public void inorderTraversal(TreeNode root, List <Integer> res) {
        if (root != null) {
            if (root.left != null) {
                inorderTraversal ( root.left, res);
            }
            res.add (root.val);

            if (root.right != null) {
                inorderTraversal ( root.right, res);
            }
        }
    }
    public List<Integer> inorderTraversalWithStack(TreeNode root) {
        List <Integer> res = new ArrayList < > ();
        Stack <TreeNode> stack = new Stack< >();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty() ){
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }

    //Binary Tree Zigzag Level Order Traversal
    //https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/787/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> order = new ArrayList<List<Integer>>();

        if (root == null)
            return order;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean oddLevel = true;

        while(!queue.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();

                if(oddLevel) {
                    row.add(cur.val);
                } else {
                    row.add(0, cur.val);
                }

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }

            oddLevel = !oddLevel;
            order.add(row);
        }


        return order;

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
