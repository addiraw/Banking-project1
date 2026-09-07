public class Main{

    public void reverseArray(int[] arr){
        int start =0;
        int end = arr.length-1;
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;

        }
    }

    public void printArray(int[] arr){
        for(int a: arr){
            System.err.print(a+" ");
        }
    }

    public static void main(String[] args){
        System.out.println("Hello World1");
        Main m = new Main();
        int[] arr = {1,3,23,34,2,2,3};
        m.reverseArray(arr);
        m.printArray(arr);

    }
}