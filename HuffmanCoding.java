import java.util.*;

class Node{
    int freq;
    char ch;
    Node left,right;

    //constructor for leaf node
    Node(int freq,char ch){
        this.freq=freq;
        this.ch=ch;
        left=right=null;
    }

    //constructor for internal nodes
    Node(int freq,Node left,Node right){
        this.ch='-';
        this.freq=freq;
        this.left=left;
        this.right=right;
    }
}

class HuffmanCoding{
    public static void PrintCoding(Node root,String code){
        if(root==null)
              return;
        if(root.left==null&&root.right==null){
            System.out.println(root.ch+":"+code);
            return;
        }
        PrintCoding(root.left,code+"0");
        PrintCoding(root.right,code+"1");
    }


    public static void main(String args[]){
        char chars[]={'a','b','c','d','e'};
        int freqs[]={12,4,19,1,7};

        PriorityQueue<Node> pq=new PriorityQueue<>(Comparator.comparingInt(a->a.freq));

        for(int i=0;i<chars.length;i++){
            pq.add(new Node(freqs[i],chars[i]));
        }

        while(pq.size()>1){
            Node left=pq.poll();
            Node right=pq.poll();

            Node parent=new Node(left.freq+right.freq,left,right);
            pq.add(parent);
        }
        Node root=pq.poll();
        System.out.println("-----Huffman codes are-----");

        PrintCoding(root,"");
    }
}