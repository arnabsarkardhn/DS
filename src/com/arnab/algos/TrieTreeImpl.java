package com.arnab.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TrieNode<T>{
	
	private Map<Character, TrieNode<T>> children = new HashMap<Character, TrieNode<T>>();
	private boolean leaf;
	
	public Map<Character, TrieNode<T>> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode<T>> children) {
		this.children = children;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	
}

class TrieTree<T extends Comparable<T>> {
	
	private TrieNode<T> root;
	
	public TrieTree(Character c) {
		root = new TrieNode<T>();
	}		
	
	public void insert(T word) {
		Map<Character, TrieNode<T>> children = root.getChildren();
		for(int index = 0; index < word.toString().length(); index++) {
			Character c = word.toString().charAt(index);
			TrieNode<T> next;
			if(children.containsKey(c)) {
				next = children.get(c);
			} else {
				next = new TrieNode<T>();
				children.put(c, next);
			}
			children = next.getChildren();
			
			if(index == word.toString().length() - 1)
				next.setLeaf(true);
		}
	}
	
	public void prefixSearch(T prefix) {
		List<T> listOfPrefixes = prefix(prefix);
		for(T prefixList : listOfPrefixes) {
			System.out.println(prefixList);
		}
	}
	
	private List<T> prefix(T prefix) {
		
		Map<Character, TrieNode<T>> children = root.getChildren();
		TrieNode<T> next = null;
		Comparable initials = "";
		
		for(int index = 0; index < prefix.toString().length(); index++) {
			Character ch = prefix.toString().charAt(index);
			if(children.containsKey(ch)) {
				next = children.get(ch);
				children = next.getChildren();
				initials = initials.toString() + ch;
			} 
		}
		return multipleChild(initials, next, new ArrayList<T>());
	}
	
	private List<T> multipleChild(Comparable commonString, TrieNode<T> child, List<T> prefixList) {
		Map<Character, TrieNode<T>> temp = child.getChildren();
		Set<Character> keys = temp.keySet();
		if(child.isLeaf()) {
			prefixList.add((T) commonString);
		}
		for(Character ch : keys) {
			if(keys.size() > 1) {
				multipleChild(commonString.toString() + ch, temp.get(ch), prefixList);
			}	
				else multipleChild(commonString.toString() + ch, temp.get(ch), prefixList);
		}
		return prefixList;
	}
	
	public boolean search(T word) {
		if(searchNode(word))
			return true;
		else 
			return false;
	}
	
	private boolean searchNode(T word) {
		Map<Character, TrieNode<T>> children = root.getChildren();
		
		TrieNode<T> temp = null;
		for(int index = 0; index < word.toString().length(); index++) {
			Character c = word.toString().charAt(index);
			if(children.containsKey(c)) {
				temp = children.get(c);
				children = temp.getChildren();
				System.out.println("c:" + c + " size:" +children.size());
			} else
				return false;
		}
		return true;
	}
	
}

public class TrieTreeImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TrieTree<String> node = new TrieTree<String>(' ');
		node.insert("HOME");
		node.insert("HOMEMAKER");
		node.insert("HOMEOWNER");
		node.insert("HOMEMADE");
		node.insert("HOMEMADEBREW");
		node.insert("HOMESICK");
		node.insert("HAME");
		node.insert("HOMS");
		System.out.println("hi");
		System.out.println(node.search("h"));
		node.prefixSearch("HOME");
		
		TrieTree<Integer> nodeInteger = new TrieTree<Integer>(' ');
		nodeInteger.insert(new Integer(10));
		nodeInteger.insert(new Integer(20));
		nodeInteger.insert(new Integer(11));
		nodeInteger.insert(new Integer(1211));
		nodeInteger.insert(new Integer(1111));
		
		nodeInteger.prefixSearch(new Integer(10));
		
	}

}
