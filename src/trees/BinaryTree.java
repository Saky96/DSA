package trees;

import linkedList.MyLinkedList;

import java.util.*;

public class BinaryTree {
    static Scanner scn = null;
    int max = Integer.MAX_VALUE;

    public static void main(String[] args) {
        scn = new Scanner(System.in);
        TreeNode root = createTree();
//        System.out.println(root);
//        inOrder(root);
//        System.out.println(inOrderIterative(root));
//        System.out.println();
//        preOrder(root);
//        System.out.println();
//        postOrder(root);
//        System.out.println(heightOfBT(root));
//        System.out.println(sizeOfBT(root));
//        System.out.println(maxValueInBT(root));
//        levelOrderTraversal(root);
//        levelOrderTraversal2(root);
//        System.out.println(levelOrderTraversal3(root));
//        System.out.println(viewOfBT(root));
//        topViewOfBT(root);
//        bottomViewOfBT(root);
        BinaryTree bt = new BinaryTree();
        assert root != null;
        Node NodeRoot = new Node((Integer) root.val);
        bt.convertBTtoDLL(NodeRoot);
        System.out.println(bt.head);
    }


    static TreeNode createTree(){
        TreeNode root = null;
        System.out.println("Enter data: ");
        int data  = scn.nextInt();
        root = new TreeNode<>(data);
        if(root.val.equals(-1)){
            return null;
        }
        System.out.println("Enter left for data: "+data);
        root.left = createTree();
        System.out.println("Enter right for data: "+data);
        root.right = createTree();
        return root;
    }

    // Follows the Left, Node, Right (LNR) pattern
    static void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val +" ");
        inOrder(root.right);
    }

    static List<Integer> inOrderIterative(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !st.isEmpty()){
            while (cur != null){
                st.push(cur);
                cur = cur.left;
            }

            cur = st.pop();
            res.add((Integer) cur.val);
            cur = cur.right;
        }

        return res;
    }

    // Follows the (NLR) pattern
    static void preOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val +" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Follows the (LRN) pattern
    static void postOrder(TreeNode root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val +" ");
    }

    static int heightOfBT(TreeNode root){
        if(root == null) return 0;

        return Math.max(heightOfBT(root.left), heightOfBT(root.right)) + 1;
    }

    static int sizeOfBT(TreeNode root){
        if (root == null) return 0;

        return sizeOfBT(root.left) + sizeOfBT(root.right) + 1;
    }

    static int maxValueInBT(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;  // Base case

        int maxLeft = maxValueInBT(root.left); // Finding the max in left subtree
        int maxRight = maxValueInBT(root.right); // Finding the max in right subtree
        int maxSub = Math.max(maxLeft, maxRight); // Getting max by comparing left and right subtree

        return Math.max((Integer) root.val, maxSub); // Getting max by comparing the max from sub trees and root
    }

    static void levelOrderTraversal(TreeNode root){
        if(root == null) return;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            if(q.peek().left != null){
                q.offer(q.peek().left);
            }
            if(q.peek().right != null){
            q.offer(q.peek().right);
            }
            System.out.print(q.poll().val + " ");
        }
    }

    static void levelOrderTraversal2(TreeNode root){
        if(root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                if(q.isEmpty()) return;
                q.offer(null);
                System.out.println();
                continue;
            }
            System.out.print(cur.val + " ");
            if(cur.left != null){
                q.offer(cur.left);
            }
            if(cur.right != null){
                q.offer(cur.right);
            }
        }
    }

    static List<List<Integer>> levelOrderTraversal3(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();     //Use queue to store the nodes at all the levels
        List<Integer> level = new ArrayList<>(); //Use list for output
        q.offer(root);
        q.offer(null); // Null separates each level in the queue
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                res.add(level);
                if(q.isEmpty()) return res;
                q.offer(null);
                System.out.println();
                level = new ArrayList<>();
                continue;
            }
            System.out.print(cur.val + " ");
            level.add((Integer) cur.val);
            if(cur.left != null){
                q.offer(cur.left);
            }
            if(cur.right != null){
                q.offer(cur.right);
            }
        }
        return res;
    }

    static List<Integer> viewOfBT(TreeNode root){
        List<Integer> res = new ArrayList<>();
        leftView(root, 0, res);
        return res;
    }

    static void leftView(TreeNode root, int level, List<Integer> res){
        if(root == null) return;

        if(res.get(level) == res.size()){
            res.add((Integer) root.val);
        }
        leftView(root.left, level + 1, res);
        leftView(root.right, level + 1, res);
    }

    static void topViewOfBT(TreeNode root){
        Queue<Pair> q = new ArrayDeque<>();  //Using queue for level order traversal
        Map<Integer, Integer> map = new TreeMap<>(); //map for maintaining a pair of horizontal distance(hd) and the value of node

        q.offer(new Pair(0, root));

        while (!q.isEmpty()){
            Pair cur = q.poll();
            if(!map.containsKey(cur.hd)){  // Adding this condition so that if a value at hd is already filled in the map
                map.put(cur.hd, (Integer) cur.node.val);
            }

            if(cur.node.left != null){
                q.offer(new Pair(cur.hd - 1, cur.node.left));
            }

            if(cur.node.right != null){
                q.offer(new Pair(cur.hd + 1, cur.node.right));
            }
        }

        System.out.println(map);
    }

    static void bottomViewOfBT(TreeNode root){
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.offer(new Pair(0, root));

        while (!q.isEmpty()){
            Pair cur = q.poll();

            // Condition to check if a value at hd is already filled in the map is not added in bottom view.
            map.put(cur.hd, (Integer) cur.node.val);

            if(cur.node.left != null){
                q.offer(new Pair(cur.hd - 1, cur.node.left));
            }

            if(cur.node.right != null){
                q.offer(new Pair(cur.hd + 1, cur.node.right));
            }
        }

        System.out.println(map);
    }

    //Convert Binary Tree to a singly linked list
    TreeNode headNode = null;

    // We use Morris traversal with reverse pre-order (right, left, node) approach and backtracking technique
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right); //Move right
        flatten(root.left); //Move left
        root.left = null;
        root.right = headNode;

        headNode = root;
    }

    //Find the diameter of a binary tree
    int ans = 0; //To collect diameter of BT

    public int diameterOfBinaryTree(TreeNode root) {
        heightOfBinarytree(root);
        return ans;
    }

    public int heightOfBinarytree(TreeNode root){
        if(root == null) return 0;

        int leftHeight = heightOfBinarytree(root.left);
        int rightHeight = heightOfBinarytree(root.right);
        ans = Math.max(ans, leftHeight + rightHeight); //Updates the ans if it's greater than lh + rh, we can add 1 if both the leaf nodes are to be considered
        return (1+Math.max(leftHeight, rightHeight));
    }

    //Find the lowest common ancestor of two nodes in a binary tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root.val == p.val || root.val == q.val) return root; //Either p or q is equal to root

        TreeNode left = lowestCommonAncestor(root.left, p, q); // Find in left node
        TreeNode right = lowestCommonAncestor(root.right, p, q); // Find in right node

        if(left == null) return right; // if the value is not found at left subtree then we return right
        if(right == null) return left; // vice - versa

        return root; // if both left and right have value then ancestor is root
    }
    Node prev = null, head = null;
    void convertBTtoDLL(Node root){
        if(root == null) return;

        convertBTtoDLL(root.left);
        if (prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        convertBTtoDLL(root.right);
    }
}

class Node
{
    int data;
    Node left, right;

    public Node(int data)
    {
        this.data = data;
        left = right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
class Pair{
    int hd;
    TreeNode node;

    public Pair(int hd, TreeNode node) {
        this.hd = hd;
        this.node = node;
    }
}

class TreeNode<T>{
    TreeNode<T> left, right;
    T val;

    public TreeNode(T data) {
        this.val = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + val +
                '}';
    }
}
