package com.prashant.datastrutures.tree;

public class BinarySearchDemo {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(6);
		bst.add(4);
		bst.add(8);
		bst.add(3);
		bst.add(5);
		bst.add(7);
		bst.add(9);
		System.out.println("\nPre Order ");
		bst.preOrder(bst.getRoot());
		System.out.println("\nPost Order ");
		bst.postOrder(bst.getRoot());
		System.out.println("\nIn Order ");
		bst.inOrder(bst.getRoot());

		System.out.println("\nLevel Order ");
		bst.levelOrder();
	}

}
