package pgWinterIntern;

import BaseKit.IQuize;

public class StringOrder implements IQuize {

    String order;
    String result;
    public StringOrder(String order) {
        this.order = order;
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < order.length(); i++) {
            char c = order.charAt(i);

            if(c == ')') {
                int index = sb.lastIndexOf("(");
                int repeat = Integer.parseInt(sb.substring(index-1, index));
                String copy = sb.substring(index+1);

                sb.replace(index-1, index+1, "");
                for(int n = 1; n < repeat; n++) {
                    sb.append(copy);
                }
            }
            else {
                sb.append(c);
            }
        }

        result = sb.toString();
    }


    public String result() {
        return result;
    }
}
