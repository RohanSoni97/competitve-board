
class BinarySearch {

    int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        int leftChild=Integer.MAX_VALUE;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == x)
               {
                    if(leftChild>m) {
                        leftChild = m;

                    }
               }

            if (arr[m] < x)
                l = m + 1;

            else
                r = m - 1;
        }



        return leftChild;
    }
    int binarySearchRightChild(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        int rightChild=-1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == x)
            {
                if(rightChild<m) {
                    rightChild = m;

                }
            }

            if (arr[m] <= x)
                l = m + 1;

            else
                r = m - 1;
        }

       // binarySearch(arr,x)

        return rightChild;
    }
    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = { 5, 7, 7, 8, 8, 10 };
        int n = arr.length;
        int x = 8;

        System.out.println(ob.binarySearch(arr,x)+" "+ob.binarySearchRightChild(arr,x));
    }
}
