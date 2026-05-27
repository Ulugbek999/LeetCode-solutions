use std::collections::HashMap;


impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {
        

        let mut map1: HashMap<char, i32> = HashMap::new();
        let mut map2: HashMap<char, i32> = HashMap::new();

        if  s.len() != t.len() {
            return false;
        }

        for c in s.chars() {
            *map1.entry(c).or_insert(0) += 1;
        }

        for c in t.chars() {
            *map2.entry(c).or_insert(0) += 1;
        }
        

        for (key, value)in  map1.iter() {
            if(!map2.contains_key(key) || value != map2.get(key).unwrap()){
                return false;
            }
        }

        return true;

    }
}