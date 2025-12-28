class Solution {
    public int[] decrypt(int[] code, int k) {


        if(k == 0){
            for(int i = 0; i< code.length; i++){
                code[i] = 0;
            }
        }


        int[] result = new int[code.length];

        if(k > 0){
            for(int i = 0; i<code.length; i++){
                int sum = 0;

                for(int j = i+1; j<k+i+1; j++){
                    int idx = j;
                    if(j >= code.length){
                        idx = j%code.length;
                    }
                    sum += code[idx];
                }
                result[i] = sum;
            }
        }

        if(k < 0){
            int newK = Math.abs(k);
            for(int i = 0; i<code.length; i++){
                int sum = 0;
                for (int j = 1; j <= newK; j++) {
                    int idx = (i - j + code.length) % code.length;
                    sum += code[idx];
                }
                result[i] = sum;
            }

        }

        return result;   
    }
}