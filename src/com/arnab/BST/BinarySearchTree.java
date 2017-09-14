package com.arnab.BST;

import java.util.Stack;

class BinaryNode<T> {
	
	T value;
	BinaryNode<T> leftChild;
	BinaryNode<T> rightChild;
	
	public BinaryNode(T value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}
	
}

class BinaySearchTreeImpl<T> {
	
	private BinaryNode<T> root;
	
	public BinaryNode<T> getRoot() {
		return root;
	}
	
	public void add(T value) {
		root = add(root, value);
	}
	
	public BinaryNode<T> add(BinaryNode<T> node, T value) {
		if(node == null) {
			node = new BinaryNode<T>(value);
		}
		else {
			if(node.value.toString().compareTo(value.toString()) > 1)
				node.leftChild = add(node.leftChild, value);
			else if(node.value.toString().compareTo(value.toString()) < 1)
				node.rightChild = add(node.rightChild, value);
		}
		return node;
	}
	
	public boolean search(BinaryNode<T> node, int value) {
		if(node == null)
			return false;
		if(node.value.equals(value))
			return true;
		return search(node.leftChild, value) || search(node.rightChild, value);
	}
	
	public int size(BinaryNode<T> node) {
		int count = 0;
		if(node == null)
			return 0;
		count = 1 + count + size(node.leftChild);
		count = count + size(node.rightChild);
		return count;
	}
	
	public int height(BinaryNode<T> node) {
		if(node == null)
			return 0;
		int leftDepth = 1 + height(node.leftChild);
		int rightDepth = 1 + height(node.rightChild);
		return (leftDepth > rightDepth) ? leftDepth : rightDepth;
	}
	
	public int noOfLeaves(BinaryNode<T> node) {
		if(node == null)
			return 0;
		 if(node.leftChild == null && node.rightChild == null)
			 return 0;
		 int leftLeaves = noOfLeaves(node.leftChild);
		 int rightLeaves = noOfLeaves(node.rightChild);
		 return leftLeaves + rightLeaves;
	}
	
	public BinaryNode<T> rootToLeafPath(BinaryNode<T> node, Stack<T> stack) {
		Stack<T> temp = stack;
		if(node == null)
			return node;
		if(node.leftChild == null && node.rightChild == null) {
			temp.add(node.value);
			System.out.println(temp);
			temp.pop();
		}
		temp.add(node.value);
		rootToLeafPath(node.leftChild, temp);
		rootToLeafPath(node.rightChild, temp);
		temp.pop();
		return node;
	}
	
	public int noOfLeftNodes(BinaryNode<T> node) {
		int count = 0;
		if(node == null)
			return 0;
		if(node.leftChild != null)
			count = 1 + count + noOfLeftNodes(node.leftChild);
		count = count + noOfLeftNodes(node.rightChild);
		return count;
	}
	
	public boolean allAncestors(BinaryNode<T> node, int value) {
		if(node == null)
			return false;
		if(node.value.equals(value))
			return true;
		else {
			if(allAncestors(node.leftChild, value)) {
				System.out.print(node.value + ", ");
				return true;
			} else if(allAncestors(node.rightChild, value)) {
				System.out.print(node.value + ", ");
				return true;
			}
			return false;
		}
	}
	
	public int findLargestNumberLessThanN(BinaryNode<T> node, T val) {
		if(node == null || node.value.toString().compareTo(val.toString()) < 1)
			return -1;
		
	}
	
}


public class BinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a ="10";
		String b = "20";
		System.out.println(a.compareTo(b));
		
		
		BinaySearchTreeImpl<Integer> binaySearchTreeImpl = new BinaySearchTreeImpl<Integer>();
		binaySearchTreeImpl.add(50);
		binaySearchTreeImpl.add(30);
		binaySearchTreeImpl.add(20);
		binaySearchTreeImpl.add(40);
		binaySearchTreeImpl.add(10);
		binaySearchTreeImpl.add(25);
		binaySearchTreeImpl.add(70);
		binaySearchTreeImpl.add(65);
		binaySearchTreeImpl.add(90);
		binaySearchTreeImpl.add(85);
		binaySearchTreeImpl.add(100);
		
		System.out.println("BinaryTree Searched value:" +binaySearchTreeImpl.search(binaySearchTreeImpl.getRoot(), 40));
		System.out.println("BinaryTree Size:" +binaySearchTreeImpl.size(binaySearchTreeImpl.getRoot()));
		System.out.println("BinaryTree Height:" +binaySearchTreeImpl.height(binaySearchTreeImpl.getRoot()));
		System.out.println("BinaryTree No. of Leaves:" +binaySearchTreeImpl.noOfLeaves(binaySearchTreeImpl.getRoot()));
		System.out.println("BinaryTree Root To Leaf:" +binaySearchTreeImpl.rootToLeafPath(binaySearchTreeImpl.getRoot(), new Stack<Integer>()));
		System.out.println("BinaryTree No of Left Nodes:" +binaySearchTreeImpl.noOfLeftNodes(binaySearchTreeImpl.getRoot()));
		System.out.println("BinaryTree All Ancestors of Node:" +binaySearchTreeImpl.allAncestors(binaySearchTreeImpl.getRoot(), 20));
	}

}
