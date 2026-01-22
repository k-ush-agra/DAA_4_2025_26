import java.util.*;

public class Experiment_2 {

    static class Node {
        char data;
        int freq;
        Node left, right;

        Node(char data, int freq) {
            this.data = data;
            this.freq = freq;
            left = right = null;
        }
    }

    static class Compare implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.freq - b.freq;
        }
    }

    static void storeCodes(Node root, String str, Map<Character, String> huffmanCode) {
        if (root == null) return;

        if (root.data != '$') {
            huffmanCode.put(root.data, str);
        }

        storeCodes(root.left, str + "0", huffmanCode);
        storeCodes(root.right, str + "1", huffmanCode);
    }

    static void decode(Node root, String s) {
        Node curr = root;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                curr = curr.left;
            else
                curr = curr.right;

            if (curr.left == null && curr.right == null) {
                System.out.print(curr.data);
                curr = root;
            }
        }
    }

    static void Huffman(String text) {

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Compare());

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            minHeap.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (minHeap.size() > 1) {
            Node left = minHeap.poll();
            Node right = minHeap.poll();

            Node top = new Node('$', left.freq + right.freq);
            top.left = left;
            top.right = right;

            minHeap.add(top);
        }

        Node root = minHeap.peek();

        Map<Character, String> huffmanCode = new HashMap<>();
        storeCodes(root, "", huffmanCode);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        StringBuilder encodedString = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedString.append(huffmanCode.get(c));
        }

        System.out.println("\nEncoded String: " + encodedString);
        System.out.print("Decoded String: ");
        decode(root, encodedString.toString());
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();
        Huffman(text);
        sc.close();
    }
}
