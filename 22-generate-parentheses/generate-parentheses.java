class Solution {
    public boolean validString(String str, int n) {
        int count = 0;

        for(char s : str.toCharArray()) {
            if(s == '(') {
                count++;
            } else {
                count--;
            }

            if(count < 0) {
                return false;
            }
        }
        return (count == 0 ? true : false);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Queue<String> ds = new LinkedList<>();

        ds.add("");

        while(!ds.isEmpty()) {
            String curr = ds.remove();
            if(curr.length() == 2*n) {
                if(validString(curr, n)) {
                    res.add(curr);
                }
                continue;
            }

            ds.add(curr + "(");
            ds.add(curr + ")");
        }
        return res;
    }
}