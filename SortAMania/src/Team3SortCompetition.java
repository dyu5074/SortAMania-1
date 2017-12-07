import java.util.Arrays;
import java.util.Random;
public abstract class Team3SortCompetition extends SortCompetition{
	public static void main (String[] args)
	{
		/*int [] newarray = {14,6,9,2,8,9,11,5,24,10};
		int [] inputTenThousand = new int[10000];              
	    for (int a = 0; a < inputTenThousand.length; a++) {
	       inputTenThousand [a] = (int) (Math.random () * 10000);
	    }
		long startTime = System.nanoTime();
		System.out.print(challengeOne(newarray));
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Time Taken in nanoseconds: " + totalTime);
		
		String [] TenThousandStrings = new String [10000];
		TenThousandStrings = generateRandomWords(10000);
		String query = "axbwc";
		long startTime1 = System.nanoTime();
		System.out.print(challengeTwo(TenThousandStrings, query));
		long endTime1 = System.nanoTime();
		long totalTime1 = endTime1 - startTime1;
		System.out.println("Time Taken in nanoseconds: " + totalTime1);
		
		int[][] arr1 = new int[10000][10000];

	    for (int x = 0; x < 10000; x++) {
	        for (int y = 0; y < 10000; y++) {
	            arr1[x][y] = (int) (Math.random () * 1000);;
	        }   
	    } 
	    
		long startTime3 = System.nanoTime();
		System.out.print(challengeFour(arr1));
		long endTime3 = System.nanoTime();
		long totalTime3 = endTime3 - startTime3;
		System.out.println("Time Taken in nanoseconds: " + totalTime3);
		*/
		//test cases
	}
	public int challengeOne(int[] arr)
	{
		int median = 0;
		for(int i=0;i<arr.length;i++)
		{
			for (int j = i; j > 0; j--)	
			{
				if(arr[j] < arr[j-1])
				{
					swap(arr,j,j-1);
				}
			}
		}
		median = getmedian(arr);
		return median;
	}
	public int challengeTwo(String[] arr, String query)
	{
		arr = mergeSort(arr);
		return binarySearch(arr, query);
	}
	public int challengeThree(int[] arr)
	{
		int median = 0;
		for(int i=0;i<arr.length;i++)
		{
			for (int j = i; j > 0; j--)	
			{
				if(arr[j] < arr[j-1])
				{
					swap(arr,j,j-1);
				}
			}
		}
		median = getmedian(arr);
		return median;
	}
	public int challengeFour(int[][] arr)
	{
		int[] medval= new int[arr.length];
		int i=0;
		for(int j=0; j<arr.length;j++)
		{
			medval[i]=challengeOne(arr[j]);
			i++;
		}
		
		return getmedian(medval);
	}
	public void swap(int[]arr,int i,int j)
	{
		int x = arr[i];
		arr[i] = arr[j];
		arr[j] = x;
	}
	public int getmedian(int[] arr)
	{
		int median = 0;
		if (arr.length % 2 == 1)
		{
			median = arr[arr.length/2];
		}
		else
		{
			median = (arr[arr.length/2] + arr[(arr.length/2)-1])/2;
		}
		return median;
	}
	public String[] merge(String[] list1, String[] list2)
	{
		int newlist = 0;
		int newlist2 = 0;
		int newlist3 = 0;
		String[] newarray = new String[list1.length + list2.length];
		while(newlist < list1.length || newlist2 < list2.length)
		{
			if (newlist == list1.length)
			{
				newarray[newlist3] = list2[newlist2];
				newlist2++;
			}
			else if (newlist2 == list2.length)
			{
				newarray[newlist3] = list1[newlist];
				newlist++;
			}
			else if (list1[newlist].compareTo(list2[newlist2]) < 0)
			{
				newarray[newlist3] = list1[newlist];
				newlist++;
			}
			else 
			{
				newarray[newlist3] = list2[newlist2];
				newlist2++;
			}
			newlist3++;
		}
		return newarray;
	}
	public String[] mergeSort(String[] list)
	{
		if (list.length <= 1) 
		{
			return list;
		}
		else
		{
			int x=list.length/2;
			String[] temp1 = Arrays.copyOfRange(list,0,x);
			String[] temp2 = Arrays.copyOfRange(list,x,list.length);
			return merge(mergeSort(temp1),mergeSort(temp2));
		}
	}
	public int binarySearch(String[] arr, String query) {
	    int low = 0;
	    int high = arr.length - 1;
	    int mid;

	    while (low <= high) {
	        mid = (low + high) / 2;

	        if (arr[mid].compareTo(query) < 0) {
	            low = mid + 1;
	        } else if (arr[mid].compareTo(query) > 0) {
	            high = mid - 1;
	        } else {
	            return mid;
	        }
	    }

	    return -1;
	}
	public void printArraystring(String[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			System.out.print(arr[i]+",");
		}
		System.out.print(arr[arr.length-1]);
	}
	public void swapstring(String[]arr,int i,int j)
	{
		String x = arr[i];
		arr[i] = arr[j];
		arr[j] = x;
	}
	public String[] generateRandomWords(int numberOfWords)
	{
	    String[] randomStrings = new String[numberOfWords];
	    Random random = new Random();
	    for(int i = 0; i < numberOfWords; i++)
	    {
	        char[] word = new char[5];
	        for(int j = 0; j < word.length; j++)
	        {
	            word[j] = (char)('a' + random.nextInt(26));
	        }
	        randomStrings[i] = new String(word);
	    }
	    return randomStrings;
	}
	public String greeting()
	{
		return "Hello there, we will destroy everyone in this challenge";
	}
}
