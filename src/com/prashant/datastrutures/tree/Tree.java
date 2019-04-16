package com.prashant.datastrutures.tree;

public class Tree {

	static class Node {

		private int data;
		private Node left;
		private Node right;

		public Node() {
			super();
			this.data = 0;
			this.left = null;
			this.right = null;
		}

		public int getData() {
			return data;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public void setData(int data) {
			this.data = data;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

	private Node root;

	private int size;

	public Tree() {
		super();
		this.root = null;
	}

	public Tree(Node root) {
		super();
		this.root = root;
	}

	public boolean addLeftChild(Node node) {
		if (node == null)
			return false;
		if (root == null)
			root = node;
		else {
			Node tempNode = root;
			while (tempNode.getLeft() != null) {
				tempNode = tempNode.getLeft();
			}
			tempNode.setLeft(node);
			size++;
		}
		return true;
	}

	public boolean addRightChild(Node node) {
		if (node == null)
			return false;
		if (root == null)
			root = node;
		else {
			Node tempNode = root;
			while (tempNode.getRight() != null) {
				tempNode = tempNode.getRight();
			}
			tempNode.setRight(node);
			size++;
		}
		return true;
	}

	public int getNumberOfNodes() {
		return this.size;
	}
}
