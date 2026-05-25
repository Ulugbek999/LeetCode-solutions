use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        

        let mut map = HashMap::new();
        let mut result:Vec<i32> = Vec::new();
        for i in 0..nums.len() {
            if (!map.is_empty() && map.contains_key(&nums[i])){
                result.push(i as i32);
                result.push(*map.get(&nums[i]).unwrap() as i32);
                return result;
            }

            map.insert((target - nums[i]), i);

        }

        return result;



    }
}