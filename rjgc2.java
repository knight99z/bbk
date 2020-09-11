package zuoye2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class rjgc2 {
	public static void main(String[] args) {
		File yqin = new File("C:\\zuoye\\yq_in.txt");
		File yqout = new File("C:\\zuoye\\yq_out.txt");
		FileWriter fw=null;
		
		FileReader fr = null;
		try {
		
			fr = new FileReader(yqin);
			fw=new FileWriter(yqout);
			char ch[] = new char[3012];
			int count;
			String sh[] = new String[10000];
			count = fr.read(ch);
			String a = "ʡ";
			char b = a.charAt(0);
			int n = 0;
			String y;
			String x;
			String z;
			int j, sum;

			for (int i = 0; i < count; i++) {
				if (ch[i + 2] == b) {
					x = String.valueOf(ch[i]);
					y = String.valueOf(ch[i + 1]);

					z = x + y;
					i = i + 3;
					sum = 0;
					for (j = 0; j <= n; j++) {
						if (z.equals(sh[j])) {

							sum++;

						}
					}

					if (sum == 0) {
						sh[n] = z;

						fw.write('\r'+z+a+'\r');
					}

					n++;

				} else

					while (ch[i + 3] != b&&i<=count) {

						fw.write(ch[i]);
						i++;

					}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} 
		finally {
			
				 if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
		try {
			boolean creat = yqout.createNewFile();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	
	}
}
