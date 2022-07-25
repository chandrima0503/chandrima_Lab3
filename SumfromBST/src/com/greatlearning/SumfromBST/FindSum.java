package com.greatlearning.SumfromBST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FindSum {
	ArrayList<Integer> list=new ArrayList<Integer>();
    int count=0;
    
	public static class Node {
		int data;
		public Node left;
		public Node right;
		
		public Node(int data) {
			super();
			this.data = data;
		}
	}
	
	static Node newNode(int key) {
		Node temp=new Node(key);
		temp.left=null;
		temp.right=null;
		
		return temp;
	}
	
	private Node insert(Node root, int i) {
		if (root==null) {
            root=new Node(i);
            return root;
        }
        if (i < root.data) {
            root.left = insert(root.left, i);
        }
        else{
            root.right=insert(root.right,i);
            }
        return root;
	}
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
        Scanner sc=new Scanner(System.in);
        Node root=null;
        FindSum pair=new FindSum();
        root=pair.insert(null,40);
        pair.insert(root,20);
        pair.insert(root,60);
        pair.insert(root,10);
        pair.insert(root,30);
        pair.insert(root,50);
        pair.insert(root,70);

        System.out.print("The elements of the tree are :");
        pair.InOrder(root);
        System.out.println("");
        System.out.println("Please Enter the Target Sum: ");
        int sum=sc.nextInt();
        System.out.print("Inorder Traversal :");
        pair.FindPairSum(root,sum);
        sc.close();
    }
}
    