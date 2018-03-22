class StackX {
    private int maxSize;//size of the stack array
    private long[] stackArray;
    private int top;

    //-----------------------------------------
    public StackX(int s){
        maxSize = s;
        stackArray = new long[maxSize];//create array
        top = -1;
    }

    //-----------------------------------------
    public void push(long j)//put item on top of stack
    {
        stackArray[++top] = j;
    }

    //-----------------------------------------
    public long pop()//take item from top of stack
    {
        return stackArray[top--];


    }

    //-----------------------------------------
    public long peak()//peak at top stack
    {
        return  stackArray[top];
    }

    //-----------------------------------------
    public boolean isEmpty()//true if stack is empty
    {
        return(top == -1);
    }

    //-----------------------------------------
    public boolean isFull()//true if stack is full
    {
        return (top==maxSize-1);
    }

    //-----------------------------------------
}//end class StackX
class StackApp{
    public static void main(String[] args)
    {
        StackX theStack = new StackX(10);//Make new stack
        theStack.push(20);//push items onto stack
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while (!theStack.isEmpty())//until it's empty,
        {
            long value = theStack.pop();
            System.out.println(value);
            System.out.println("");
        }//end whil
        System.out.println("");

    }//end main
}//end class StackApp

