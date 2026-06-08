impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {

        if strs.is_empty() {
            return String::new();
        }

        let shortest_word = strs.iter().map(|w| w.len()).min().unwrap();

        let first_word = strs[0].as_bytes();

        for i in 0..shortest_word {

            let c = first_word[i];

            for word in strs.iter().skip(1) {

                if c != word.as_bytes()[i] {
                    return strs[0][..i].to_string();
                }
            }
        }

        return strs[0][..shortest_word].to_string();

    }
}