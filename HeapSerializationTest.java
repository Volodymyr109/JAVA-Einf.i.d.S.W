package heap;


import java.io.*;

public class HeapSerializationTest {

    public static void main(String[]args) throws IOException, ClassNotFoundException {
        Heap<Integer> heap = new Heap<>();
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);

        // Serialize the heap to a file
        String filename = "heap.ser";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(heap);
        }

        // Deserialize the heap from the file
        Heap<Integer> deserializedHeap;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            deserializedHeap = (Heap<Integer>) in.readObject();
        }

        // Compare the original heap and the deserialized heap
        if(heap.size()== deserializedHeap.size()) {
        	System.out.println("passt1");
        }

        while (!heap.empty() && !deserializedHeap.empty()) {

            if((heap.deleteFirst()).toString().equals((deserializedHeap.deleteFirst()).toString())) {
            	System.out.println("passt2");
            }
        }

        if(heap.empty()&&deserializedHeap.empty()) {
        	System.out.println("true3");
        }
    }
}

