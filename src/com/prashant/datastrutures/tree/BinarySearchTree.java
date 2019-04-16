package com.prashant.datastrutures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	class Node {

		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
		        this.data = data;
		        right = null;
		        left = null;
		    }
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

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}


	private int size;

	public BinarySearchTree() {
		super();
		this.root = null;
	}

	public BinarySearchTree(Node root) {
		super();
		this.root = root;
	}

	public void add(int data) {
		root = addRecursive(root, data);
	}

	private Node addRecursive(Node current, int value) {
		if (current == null) {
	        return new Node(value);
	    }
	 
	    if (value < current.data) {
	        current.left = addRecursive(current.left, value);
	    } else if (value > current.data) {
	        current.right = addRecursive(current.right, value);
	    } else {
	        // value already exists
	        return current;
	    }
	 
	    return current;
	}

	private boolean find(Node node, int data) {
		boolean flag = false;
		if (node == null)
			return false;
		else if (node.data == data)
			return true;
		else {
			if (node.getData() > data)
				flag = find(node.right, data);

			else if (node.getData() < data)
				flag = find(node.left, data);
		}
		return flag;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	public int getNumberOfNodes() {
		return this.size;
	}
	///////////DFS
	
	public void preOrder(Node node) {
		if(node == null)
			return;
		else {
			System.out.print(node.data+" ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data+" ");
	    }
	}
	
	
	public void inOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			System.out.print(node.data+" ");
			postOrder(node.right);
	    }
	}
	
	
	/////BFS
	
	public void levelOrder() {
		if(root == null)
			return;
		else {
			Queue<Node> nodes = new LinkedList<>();
			nodes.add(root);
			while(!nodes.isEmpty()) {
				Node nodeTemp = nodes.remove();
				System.out.print(nodeTemp.getData()+" ");
				 
		        if (nodeTemp.left != null) {
		            nodes.add(nodeTemp.left);
		        }
		 
		        if (nodeTemp.right!= null) {
		            nodes.add(nodeTemp.right);
		        }
			}
		}
	}
}


