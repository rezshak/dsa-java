package stack;

public class Main {

    public static void main(String[] args) {
        Stack st = new Stack(3);
        st.push(8);
        System.out.println(st.peek());
        st.push(5);
        st.push(1);
        st.printStack();
        st.push(4);
        st.printStack();
        System.out.println(st.pop());

        st.printStack();

        System.out.println(st);
    }
}
