import java.util.Arrays;

public class L106 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode2 tree = buildTree(inorder, postorder);
        System.out.println(tree);

        inorder = new int[]{2, 1};
        postorder = new int[]{2, 1};
        tree = buildTree(inorder, postorder);
        System.out.println(tree);

    }

    public static TreeNode2 buildTree(int[] inorder, int[] postorder) {
        int iLen = inorder.length, pLen = postorder.length;
        TreeNode2 tree = buildTree(inorder, 0, iLen, postorder, 0, pLen);
        return tree;
    }

    private static TreeNode2 buildTree(int[] inorder, int iBeginIndex, int iEndIndex, int[] postorder, int pBeginIndex, int pEndIndex) {
        //int iLen = iEndIndex, pLen = pEndIndex;
        if (pEndIndex == pBeginIndex) return null;

        TreeNode2 node = new TreeNode2(postorder[pEndIndex - 1], null, null);

        if (pEndIndex - pBeginIndex == 1) return node;

        int splitIndex = 0;
        for (int i = pBeginIndex; i < iEndIndex; i++) {
            if (inorder[i] == postorder[pEndIndex - 1]) {
                splitIndex = i;
                break;
            }
        }

        node.left = buildTree(inorder, iBeginIndex, splitIndex, postorder, pBeginIndex, pBeginIndex + (splitIndex - iBeginIndex));
        node.right = buildTree(inorder, splitIndex + 1, iEndIndex, postorder, pBeginIndex + (splitIndex - iBeginIndex), pEndIndex - 1);

        return node;
    }
}
