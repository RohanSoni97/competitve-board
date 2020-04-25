import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BM {
    public static void main(String[] args) throws IOException {


        int x=3,left_child=0;

        int arr[][]={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        ArrayList<ArrayList<Integer>> a =new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<3;i++)
        {ArrayList<Integer> temp=new ArrayList<>();;
            for (int j=0;j<4;j++)
            {

                temp.add(arr[i][j]);
            }
            a.add(temp);
        }
        searchMatrix(a,x);
//        left_child= binarySearch(arr,x);
//        if(left_child!= Integer.MAX_VALUE || left_child!=-1)
//        {
//            if(arr[left_child][0]!=x)
//                left_child= binarySearch(arr[left_child],x);
//        }
//        if(left_child!=-1)
//        System.out.println(1);
//        else System.out.println(-1);

    }
    public  static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        if(a.size() < 1) return 0;

        int yLength = a.get(0).size();

        int max = (a.size() * yLength) - 1;
        int min = 0;
        int mid;
        int x;
        int y;
        while(min <= max){
            mid = min + ((max - min)/2);
            x = mid / yLength;
            y = mid % yLength;
            if(a.get(x).get(y) == b){
                return 1;
            }else if (a.get(x).get(y) > b){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        return 0;


    }
  static int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    static int binarySearch(int[][] arr, int x)
    {
        int l = 0, r = arr.length - 1;
        int leftChild=Integer.MAX_VALUE;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m][0] == x)
            {

                return m;
            }

            if (arr[m][0] < x && m+1<=r && arr[m+1][0]>=x)
                {
                    return m;
                }
            else if(arr[m][0] < x)
                l = m + 1;

            else if(arr[m][0]>x && m-1>=l && arr[m-1][0]<=x)
                {
                    return m-1;
                }
            else
                r = m - 1;
        }



        return leftChild;
    }
}
/*





public class Solution {
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
	    if(a.size() < 1) return 0;

	    int yLength = a.get(0).size();

	    int max = (a.size() * yLength) - 1;
	    int min = 0;
	    int mid;
	    int x;
	    int y;
	    while(min <= max){
	        mid = min + ((max - min)/2);
	        x = mid / yLength;
	        y = mid % yLength;
	        if(a.get(x).get(y) == b){
	            return 1;
	        }else if (a.get(x).get(y) > b){
	            max = mid - 1;
	        }else{
	            min = mid + 1;
	        }
	    }

	    return 0;


	}
}


 */