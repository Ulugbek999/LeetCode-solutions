impl Solution {
    pub fn get_concatenation(nums: Vec<i32>) -> Vec<i32> {

        let mut ans: Vec<i32> = Vec::new();

        for i in 0..nums.len()*2 {
            
            ans.push(nums[(i%nums.len())]);
        }

        return ans;
    }
}