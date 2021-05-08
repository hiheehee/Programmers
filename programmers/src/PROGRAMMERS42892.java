import java.util.Arrays;

public class PROGRAMMERS42892 {
	static int[][] tree;
    static Node root;
    static StringBuffer post = new StringBuffer();
    static StringBuffer pre = new StringBuffer();
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        tree = new int[nodeinfo.length][3];

        for(int i = 0; i < nodeinfo.length; i++){
            tree[i][0] = i+1; // index
            tree[i][1] = nodeinfo[i][0]; // x
            tree[i][2] = nodeinfo[i][1]; // y
        }
        
        Arrays.sort(tree, (o1, o2)-> {
            if(o1[2] == o2[2]){
               return o1[1] - o2[1]; 
            }else{
               return o2[2] - o1[2];
            }
        });
        
        root = new Node(tree[0][0], tree[0][1], tree[0][2]);
        for(int i = 1; i < nodeinfo.length; i++){
            Node nextNode = new Node(tree[i][0], tree[i][1], tree[i][2]); 
            putNode(root, nextNode);
        }
        
        postOrder(root);
        preOrder(root);
        
        String preTemp[] = pre.toString().split(" ");
        for(int i = 0; i < preTemp.length; i++){
            answer[0][i] = Integer.parseInt(preTemp[i]);
        }
        
        String postTemp[] = post.toString().split(" ");
        for(int i = 0; i < postTemp.length; i++){
            answer[1][i] = Integer.parseInt(postTemp[i]);
        }

        return answer;
    }
    
    static void putNode(Node startNode, Node inputNode) { 
        if(inputNode.x < startNode.x) { 
            if(startNode.left != null) { 
                putNode(startNode.left, inputNode); 
            }else { 
                startNode.left = inputNode; 
            } 
        }else { 
            if(startNode.right != null) { 
                putNode(startNode.right, inputNode); 
            }else { 
                startNode.right = inputNode; 
            } 
        } 
    }
    
    // 후위 순회 
    static void postOrder(Node node) { 
        if(node.left != null) postOrder(node.left); 
        if(node.right != null) postOrder(node.right); 
        post.append(node.ind+" "); 
    }

    // 전위 순회 
    static void preOrder(Node node) { 
        pre.append(node.ind+" "); 
        if(node.left != null) preOrder(node.left); 
        if(node.right != null) preOrder(node.right);  
    }
    
    static class Node{
        Node left;
        Node right;
        int ind;
        int x;
        int y;
        
        Node(int ind, int x, int y){
            this.ind = ind;
            this.x = x;
            this.y = y;
        }
    }
}