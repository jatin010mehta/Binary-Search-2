public class SearchRange
{
	// TC O(log*n)
	//SC O(1)
	public int[] searchRange(int[] nums, int target)
	{
		if (nums==null||nums.length==0) return new int[]{-1,-1};
		if (nums[0]>target||nums[nums.length-1]<target) return new int[]{-1,-1};
		int firstIndex = findTheFirstIndex(nums,target);
		if (firstIndex==-1)
			return new int[]{-1,-1};
		int lastIndex = findTheLastIndex(nums,target);
		return new int[]{firstIndex,lastIndex};
	}

	private int findTheLastIndex(int[] nums, int target)
	{
		int low = 0;
		int high = nums.length-1;
		while (low<=high){
			int mid = low +(high-low)/2;
			if (nums[mid]==target){
				if (mid==nums.length-1||nums[mid+1]!=nums[mid])
					return mid;
				else
					low = mid+1;
			}else if (nums[mid]>target)
				high = mid-1;
			else
				low = mid+1;
		}
		return -1;
	}

	private int findTheFirstIndex(int[] nums, int target)
	{
		int low = 0;
		int high = nums.length-1;
		while (low<=high){
			int mid = low +(high-low)/2;
			if (nums[mid]==target){
				if (mid==0||nums[mid-1]!=nums[mid])
					return mid;
				else
					high = mid-1;
			}else if (nums[mid]>target)
				high = mid-1;
			else
				low = mid+1;
		}
		return -1;
	}
}
