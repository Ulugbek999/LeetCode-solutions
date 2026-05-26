use std::collections::HashSet;

impl Solution {
    pub fn contains_duplicate(nums: Vec<i32>) -> bool {
        
        let mut set: HashSet<i32> = HashSet::new();

        for i in 0..nums.len() {
            if(set.contains(&nums[i])) {
                return true;
            }
            set.insert(nums[i]);
        }

        return false;

    }
}