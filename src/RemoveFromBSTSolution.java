///*
//Принцип работы
//
//При удалении узла из бинарного дерева поиска возможны 3 случая
//1 удаление листа (элемента не содержащего дочерних элементов) в таком случае необходимо лишь занулить ссылку с родителя
//2 удаление элемента у которого только 1 потомок в таком случае нужно перенаправить ссылку с родителя вместо удаляемого элемента на его потомка
//3 удаление элемента у которого есть оба потомка в таком случае берем минимальный элемент из правого поддерева(заместитель) и заменяем на удаляемый элемент
//для этого у родителя удаляемого элемента необходимо поставить ссылку вместо удаляемого элемента  на заместитель а для родителя заместителя занулить ссылку на заместитель
//
//Временная сложность O(h), где h –— высота дерева. так как для поиска удаляемого элемента в худшем случае необъодимо опустить на всю высоту дерева h а так же его родителя
//для того чтобы произвести удаление нужно найти элемент заместитель за h и его родителя итого  O(h1)+O(h2)+O(h3)+O(h4)=O(h)
//Пространственная сложность O(1) так как для удаления не требуется дополнительной памяти
//
//https://contest.yandex.ru/contest/24810/run-report/68233760/
//*/
//public class Solution {
//    public static Node remove(Node root, int key) {
//        if (root == null) {
//            return null;
//        }
//        Node nodeToRemove = binarySearch(root, key);
//        if (nodeToRemove == null) {
//            return root;
//        }
//
//        Node parent = null;
//        if (!root.equals(nodeToRemove)) {
//            parent = findParent(root, nodeToRemove);
//        }
//
//
//        if (nodeToRemove.getRight() == null && nodeToRemove.getLeft() == null) {
//            if (parent != null && parent.getLeft() != null && parent.getLeft().equals(nodeToRemove)) {
//                parent.setLeft(null);
//            }
//            if (parent != null && parent.getRight() != null && parent.getRight().equals(nodeToRemove)) {
//                parent.setRight(null);
//            }
//            if (parent == null) {
//                return null;
//            } else {
//                return root;
//            }
//        }
//
//        if (nodeToRemove.getRight() == null || nodeToRemove.getLeft() == null) {
//            Node descendant = null;
//            if (nodeToRemove.getLeft() != null) {
//                descendant = nodeToRemove.getLeft();
//            }
//            if (nodeToRemove.getRight() != null) {
//                descendant = nodeToRemove.getRight();
//            }
//
//            if (parent != null && parent.getRight() != null && parent.getRight().equals(nodeToRemove)) {
//                parent.setRight(descendant);
//            }
//            if (parent != null && parent.getLeft() != null && parent.getLeft().equals(nodeToRemove)) {
//                parent.setLeft(descendant);
//            }
//            if (parent == null) {
//                return descendant;
//            } else {
//                return root;
//            }
//        }
//
//        Node substitute = null;
//        if (nodeToRemove.getRight() != null) {
//            substitute = findLeft(nodeToRemove.getRight());
//        }
//
//        Node substituteParent = findParent(nodeToRemove, substitute);
//        if (substituteParent.getLeft() != null && substituteParent.getLeft().equals(substitute)) {
//            substituteParent.setLeft(null);
//        }
//        if (substituteParent.getRight() != null && substituteParent.getRight().equals(substitute)) {
//            substituteParent.setRight(null);
//        }
//
//
//        if (parent != null && parent.getLeft() != null && parent.getLeft().equals(nodeToRemove)) {
//            parent.setLeft(substitute);
//        }
//        if (parent != null && parent.getRight() != null && parent.getRight().equals(nodeToRemove)) {
//            parent.setRight(substitute);
//        }
//
//
//        substitute.setRight(nodeToRemove.getRight());
//        substitute.setLeft(nodeToRemove.getLeft());
//
//        if (parent == null) {
//            return substitute;
//        } else {
//            return root;
//        }
//    }
//
//    private static Node binarySearch(Node root, int key) {
//        if (root.getValue() == key) {
//            return root;
//        }
//        if (root.getValue() > key) {
//            if (root.getLeft() != null) {
//                return binarySearch(root.getLeft(), key);
//            } else {
//                return null;
//            }
//        }
//        if (root.getValue() < key) {
//            if (root.getRight() != null) {
//                return binarySearch(root.getRight(), key);
//            } else {
//                return null;
//            }
//        }
//        return null;
//    }
//
//    private static Node findParent(Node root, Node target) {
//        if ((root.getLeft() != null && root.getLeft().equals(target))
//                || (root.getRight() != null && root.getRight().equals(target))) {
//            return root;
//        }
//
//        if (root.getValue() > target.getValue()) {
//            return findParent(root.getLeft(), target);
//        } else {
//            return findParent(root.getRight(), target);
//        }
//
//    }
//
//    private static Node findLeft(Node root) {
//        if (root.getLeft() == null) {
//            return root;
//        } else {
//            return findLeft(root.getLeft());
//        }
//    }
//
//    /**
//     * Comment it before submitting
//
//     private static class Node {
//     private int value;
//     private Node left;
//     private Node right;
//
//     Node(Node left, Node right, int value) {
//     this.left = left;
//     this.right = right;
//     this.value = value;
//     }
//
//     public int getValue() {
//     return value;
//     }
//
//     public Node getRight() {
//     return right;
//     }
//
//     public void setRight(Node right) {
//     this.right = right;
//     }
//
//     public Node getLeft() {
//     return left;
//     }
//
//     public void setLeft(Node left) {
//     this.left = left;
//     }
//
//     public void setValue(int value) {
//     this.value = value;
//     }
//     }
//
//
//     public static void main(String[] a) {
//     Node node4 = new Node(null, null, 266);
//     Node node3 = new Node(null, node4, 191);
//     Node node2 = new Node(node3, null, 298);
//     Node node6 = new Node(null, null, 701);
//     Node node8 = new Node(null, null, 822);
//     Node node10 = new Node(null, null, 932);
//     Node node9 = new Node(null, node10, 912);
//     Node node7 = new Node(node8, node9, 870);
//     Node node5 = new Node(node6, node7, 702);
//
//     Node node1 = new Node(null, null, 545);
//
//
//
//
//
//     Node newHead = remove(node1, 545);
//     System.out.println("sdf");
//     }
//     **/
//}