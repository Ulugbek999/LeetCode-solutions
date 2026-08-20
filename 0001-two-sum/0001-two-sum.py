class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        my_dict = {}

        for i in range(len(nums)):
            
            compliment = target - nums[i]
            
            if nums[i] in my_dict:
                return [my_dict[nums[i]], i]
            else:
                my_dict[compliment] = i
            

        return [0, 0]

        