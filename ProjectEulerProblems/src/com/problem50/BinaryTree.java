package com.problem50;

public class BinaryTree {
	private Node root;

	public BinaryTree(int[] numbers) {
		root = null;
		addArray(numbers, 0, numbers.length);
	}
	
	public void add(int value) {
		root = addRecursive(root, value);
	}
	
	private void addArray(int[] numbers, int min, int max) {
		if (max == min) return;
		if (max - min == 1) {
			add(numbers[min]);
		}
		int middle = (max + min) / 2;
		add(numbers[middle]);
		addArray(numbers, min, middle);
		addArray(numbers, middle + 1, max);
	}
	
	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}
		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		}
		
		return current;
	}
	
}

class Node {
	public int value;
	public Node left;
	public Node right;
	
	public Node(int value) {
		this.value = value;
		left = null;
		right = null;
	}
	
	public String toString() {
		return Integer.toString(value);
	}
}
