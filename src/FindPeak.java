public class FindPeak
{
	// TC O(log*n)
	//SC O(1)
	public int findPeakElement(int[] num) {
		if (num==null||num.length==0) return -1;
		int low = 0;
		int high = num.length-1;
		while (low<=high){
			int mid = low + (high-low)/2;
			if ((mid==0 || num[mid]>num[mid-1])&&(mid==num.length-1||num[mid]>num[mid+1]))
				return mid;
			else if (mid!=0&&num[mid]<num[mid-1])
				high = mid-1;
			else
				low = mid+1;
		}
		return 99;
	}
}
