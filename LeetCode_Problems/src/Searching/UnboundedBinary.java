package Searching;

class Binary{
    
    public static int BinarySearch(int [] arr, int low, int high, int element){
        if (low<=high){
            int mid = (low+high)/2;
            if (arr[mid]==element) return mid;
            else if (arr[mid]>element) return BinarySearch(arr,low,mid-1,element);
            else return BinarySearch(arr,mid+1,high,element);
        }
        return -1;
    }
    
    public static int FindIndex(int[] arr, int x){
        if (arr[0]==x) return 0;
        int i = 1;
        while(arr[i]<x) i = i*2;
        if(arr[i]==x) return i;
        return BinarySearch(arr, i/2+1, i-1, x);
    }

    public static void main(String[] args) {
        int [] arr = {1,5,8,10,12,20,25,30,35,50,100,120,121,300,350,355,401};
        System.out.println(FindIndex(arr, 12));
        System.out.println(FindIndex(arr, 401));
        System.out.println(FindIndex(arr, 32));
    }
}