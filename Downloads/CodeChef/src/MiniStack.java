import java.util.Stack;

class MyStack{
    Stack<Integer> stack;
    Integer minELe;
    public MyStack() {
        this.stack = new Stack<Integer>();
    }
    Integer getMin()
    {
        if(stack.isEmpty())
            return -1;
        else return minELe;
    }
    void push(int x)
    {
        if(stack.isEmpty())
        {
            minELe=x;
            stack.push(x);
            return;
        }
        if(x<minELe)
        {
            stack.push(2*x-minELe);
            minELe=x;
        }
        else stack.push(x);
    }
    void pop()
    {
        if(stack.empty())
            return;
        Integer temp=stack.pop();

        if(temp<minELe)
        {
            minELe=2*minELe-temp;
        }
    }
    Integer top()
    {
        if(stack.isEmpty())
        {
            return -1;
        }
        Integer t=stack.peek();
        if(t<minELe)
            return minELe;
        else
            return t;
    }

}

public class MiniStack {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(3);
        s.push(5);
        System.out.println(s.getMin());
        s.push(2);
        s.push(1);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.top());
    }
}

