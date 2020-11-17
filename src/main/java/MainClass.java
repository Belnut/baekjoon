import java.io.*;

public class MainClass {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Integer.parseInt(br.readLine());

            //run

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write("\n");
            bw.flush();
            bw.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}