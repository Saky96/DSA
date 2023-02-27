package stacks;

import java.util.Arrays;

public class ArrayStack {
    int[] arr;
    int capacity;
    int top;

    ArrayStack(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        this.top = -1;
    }

    void push(int ele) throws Exception {
        if(top >= capacity -1){
            throw new Exception("Stack Overflow");
        }
        top++;
        arr[top] = ele;
    }

    int pop() throws Exception{
        if(top == -1){
            throw new Exception("Stack Underflow");
        }
        int res = arr[top];
        top--;
        return res;
    }

    int peek() throws Exception{
        if(top == -1){
            throw new Exception("Stack Underflow");
        }
        return arr[top];
    }

    Boolean isEmpty(){
        return top == -1;
    }

    int size(){
        return top + 1;
    }

    void display(){
        if(top == -1){
            System.out.println("[]");
        }
        else {
            System.out.print("[");
            for (int i = 0; i <= top; i++) {
                if(i==top){
                    System.out.print(arr[i]);
                }
                else {
                    System.out.print(arr[i]+", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayStack st = new ArrayStack(4);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.display();
        st.pop();
        st.display();
        System.out.println(st.size());
        st.push(8);
//        st.push(9);
        st.pop();
        st.pop();
        st.pop();
        st.pop();
//        st.pop();

    }
}
