import DataStructure.ComplexListNode;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/4
 * Time: 下午2:22
 */
public class CloneComplxListNode {
    public static ComplexListNode Clone(ComplexListNode head){
        cloneNext(head);
        cloneSibling(head);
        return spiltList(head);
    }

    private static void cloneNext(ComplexListNode head){
        ComplexListNode curNode = head;
        while(curNode != null){
            ComplexListNode newNode = new ComplexListNode(curNode.val);
            ComplexListNode nextNode = curNode.nextNode;
            curNode.nextNode = newNode;
            newNode.nextNode = nextNode;
            curNode = newNode.nextNode;
        }
    }

    private static void cloneSibling(ComplexListNode head){
        ComplexListNode curNode = head;
        while (curNode != null){
            ComplexListNode clonedNode = curNode.nextNode;
            if (curNode.siblingNode != null){
                clonedNode.siblingNode = curNode.siblingNode.nextNode;
            }
            curNode = clonedNode.nextNode;
        }
    }

    private static ComplexListNode spiltList(ComplexListNode head){
        ComplexListNode curNode = head;
        ComplexListNode clonedHead = new ComplexListNode();
        ComplexListNode clonedNode = new ComplexListNode();

        if (curNode != null){
            clonedNode = curNode.nextNode;
            clonedHead = curNode.nextNode;
            curNode.nextNode = clonedNode.nextNode;
            curNode = curNode.nextNode;
        }

        while (curNode != null){
            clonedNode.nextNode = curNode.nextNode;
            clonedNode = clonedNode.nextNode;
            curNode.nextNode = clonedNode.nextNode;
            curNode = curNode.nextNode;
        }
        return clonedHead;

    }
}
