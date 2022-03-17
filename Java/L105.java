import java.util.Arrays;

public class L105 {
    public static void main(String[] args) {
        int[] preorder={3, 9, 20, 15, 7};
        int[] inorder={9,3,15,20,7};
        TreeNode2 tree = buildTree(preorder, inorder);
        System.out.println(tree);

    }

    public static TreeNode2 buildTree(int[] preorder, int[] inorder) {
        int pLen=preorder.length,iLen=inorder.length;
        if (pLen==0) return null;

        TreeNode2 node=new TreeNode2(preorder[0],null,null);
        if (pLen==1) return node;

        int splitIndex=-1;
        for (int i = 0; i < iLen; i++) {
            if (inorder[i]==preorder[0]){
                splitIndex=i;
                break;
            }
        }

        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, splitIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, splitIndex + 1, iLen);

        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, splitIndex+1);
        int[] preorderRight = Arrays.copyOfRange(preorder, splitIndex+1, pLen);

        node.left=buildTree(preorderLeft,inorderLeft);
        node.right=buildTree(preorderRight,inorderRight);

        return node;
    }
}
