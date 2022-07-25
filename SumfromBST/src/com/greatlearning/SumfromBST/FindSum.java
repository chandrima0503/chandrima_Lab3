package com.greatlearning.SumfromBST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FindSum {
	ArrayList<Integer> list=new ArrayList<Integer>();
    int count=0;
    
    //Creating inner class Node
	public static class Node {
		//Write a Node class to create a Binary Search Tree
		int data;
		public Node left;//Left Node of the BST
		public Node right;//Right Node of the BST
		
		public Node(int data) {
			//Constructor for Node class
			super();
			this.data = data;
		}
	}
	
	//insert method to enter data into tree into either left or right node
	private Node insert(Node root, int i) {
		if (root==null) {
            root=new Node(i);
            return root;
        }
        if (i < root.data) {
        	//If inserted value is less than root data then insert in left of root
            root.left = insert(root.left, i);
        }
        else{
        	//If inserted value is more than root data then insert in right of root
            root.right=insert(root.right,i);
            }
        return root;
	}
	
	//Fetching the inorder traversal of BST and adding it to ArrayList
	public void InOrder(Node root){
        if (root==null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.data+" ");
        list.add(root.data);
        InOrder(root.right);
        count++;
    }
	
	//Method to find the pairs whose sum equal to given sum
    private void FindPairSum(Node root, int sum) {
        InOrder(root);
        int start = 0;
        int end = list.size()-1;
        System.out.println(" ");

        ArrayList<Integer> result = new ArrayList<>();
        while (start < end) {
            //System.out.println("Start: " + start + " End :" + end);
            if (list.get(start) + list.get(end) == sum) {
                result.add(list.get(start));
                result.add(list.get(end));
                Iterator<Integer> out=result.iterator();
                System.out.print("Pair Found!. The elements are : ");
                while(out.hasNext()){
                    System.out.print(out.next()+" ");
                }
                break;
            }
            if (list.get(start) + list.get(end) < sum) {
                start++;
            } else {
                end--;
            }
            if(start==end){
                System.out.println("Pair not Found!");
            }

        }
     }
    
    public static void main(String[] args) {
    	//Creating an object of scanner class
        Scanner sc=new Scanner(System.in);
        Node root=null;
        FindSum tree=new FindSum();
        
        //Creating BST by inserting value in tree
        root=tree.insert(null,40);
        tree.insert(root,20);
        tree.insert(root,60);
        tree.insert(root,10);
        tree.insert(root,30);
        tree.insert(root,50);
        tree.insert(root,70);

        System.out.print("The elements of the tree are :");
        tree.InOrder(root);
        System.out.println("");
        System.out.println("Please Enter the Target Sum: ");
        int sum=sc.nextInt();
        System.out.print("Inorder Traversal :");
        tree.FindPairSum(root,sum);
        sc.close();
    }
}
    