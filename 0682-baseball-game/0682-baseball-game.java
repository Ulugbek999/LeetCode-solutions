class Solution {
    public int calPoints(String[] operations) {


        Stack<String> stack = new Stack<>();

        for(String str : operations){
            


            if(str.equals("C") && !stack.isEmpty()){
                stack.pop();
            }else if(str.equals("D")){
                String lastNum = stack.pop();
                int num = Integer.parseInt(lastNum);
                num = num * 2;
                String newNum = Integer.toString(num);
                stack.push(lastNum);
                stack.push(newNum);
            }else if(str.equals("+")){
                String num1 = stack.pop();
                int num12 = Integer.parseInt(num1);
                String num2 = stack.pop();
                int num22 = Integer.parseInt(num2);
                int num3 = num12 + num22;
                stack.push(num2);
                stack.push(num1);
                String num33 = Integer.toString(num3);
                stack.push(num33);     
            }else{
                stack.push(str);
            }

            // if(stack.isEmpty()==false)
            // System.out.println(stack.peek());



        }

        int result = 0;
        while(stack.isEmpty() == false){
            result += Integer.parseInt(stack.pop());
        }

        return result;

    }
}