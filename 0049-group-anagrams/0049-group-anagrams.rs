use std::collections::HashMap;


impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        
        let mut map: HashMap<String, Vec<String>> = HashMap::new();
        let mut result: Vec<Vec<String>> = Vec::new();

        for word in strs.iter() {

            let mut bytes = word.as_bytes().to_vec();
            bytes.sort();
            let sorted_word = String::from_utf8(bytes).unwrap();

            if map.contains_key(&sorted_word) {
                map.get_mut(&sorted_word).unwrap().push(word.clone());
            }else{
                map.insert(String::from(sorted_word), vec![String::from(word.clone())]);
            }
        }

        for (key, value) in map.iter() {
            result.push(value.clone());
        }

        return result;

    }
}