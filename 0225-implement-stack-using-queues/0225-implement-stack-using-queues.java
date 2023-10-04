
class MyStack {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        // Create a new queue to store elements
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // Add the new element to the queue
        queue.offer(x);
        int size = queue.size();
        
        // Move the new element to the front of the queue
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // Remove and return the front element of the queue
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        // Peek and return the front element of the queue without removing it
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        // Check if the queue is empty
        return queue.isEmpty();
    }
}