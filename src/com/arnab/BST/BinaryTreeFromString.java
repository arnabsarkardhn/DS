package com.arnab.BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * http://massivealgorithms.blogspot.com/2017/04/leetcode-536-construct-binary-tree-from.html
 * Input: "4(2(3)(1))(6(5))"
 *  Output: return the tree root node representing the following tree:
 *
 *      4
 *    /   \
 *   2     6
 *  / \   / 
 * 3   1 5   
 * @author arnasarkar
 *
 */
class Node {
	
	Character value;
	Node leftChild;
	Node rightChild;
	
	public Node() {}
	
	public Node(char value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	//4(2(3)(1))(6(5)(8))
	public Node stringToTree(String param) {
		Stack<Node> temp = new Stack<>();
		for(int i = 0; i < param.length(); i++) {
			Character ch = param.charAt(i);
			if (ch == ')') {
				temp.pop();
			} else if (ch >= '0' && ch <= '9') {
				Node node = new Node(ch);
				if(temp.size() == 0) {
					temp.push(node);
				} else if (temp.peek().leftChild == null) {
					Node left = temp.peek();
					left.leftChild = node;
					temp.push(node);
				} else {
					Node right = temp.peek();
					right.rightChild = node;
					temp.push(node);
				}
			} 
		}
		return temp.pop();
	}
	
	public void levelOrderTraversal(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.println(temp.value);
			if (temp.leftChild != null)
				queue.add(temp.leftChild);
			if (temp.rightChild != null) 
				queue.add(temp.rightChild);
		}
	}
	
	public String toString() {
		return value.toString();
	}
	
}

public class BinaryTreeFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node();
		node.levelOrderTraversal((node.stringToTree("9(4(2(3)(1))(6(5)(8)))")));
	}

}
