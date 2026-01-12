class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """

        map = {}
        for i in range(len(nums)):
            if(nums[i] in map and i - map[nums[i]] <= k): 
                return True
            map[nums[i]] = i

        #print(map)
        return False