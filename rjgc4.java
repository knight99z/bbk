package zuoye4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Collator;
import java.util.Locale;
import java.util.Scanner;

public class rjgc4 {
	String SE;
	String SS;
	int x;

	public void setSE(String SE) {
		this.SE = SE;
	}

	public void setSS(String SS) {
		this.SS = SS;
	}

	public void setx(int i) {
		this.x = i;
	}

	public String getSE() {
		return SE;
	}

	public String getSS() {
		return SS;
	}

	public int getx() {
		return x;
	}

	public static void main(String[] args) {
		Collator collator=Collator.getInstance(Locale.CHINA);
		char ch[] = new char[999];
		int a1[]=new int[999];
		int a2[]=new int[999];
		String type ="";
		int a[] =new int[999];
		Scanner in = new Scanner(System.in);
		File file1 = new File("E://zuoye2//yq_in_04.txt");
		 File file2 = new File("E://zuoye2//yp_out_04.txt");
		FileWriter fwriter = null;
		FileReader freader = null;
		try {
			rjgc4[] rjgc4 = new rjgc4[1000];
			freader = new FileReader(file1);
			 fwriter=new FileWriter(file2);
			int count = freader.read(ch);
			int n = 0,m=0;
			for (int i = 0; i < count;) {
				rjgc4[n] = new rjgc4();
				while (ch[i] != '	') {
					type += String.valueOf(ch[i]);
					i++;}
				rjgc4[n].setSE(type);
				type = "";
				i++;
				while (ch[i] != '	') {
					type += String.valueOf(ch[i]);
					i++;}
				rjgc4[n].setSS(type);
				type = "";
				i++;
				while (ch[i] >= 48 && ch[i] <= 57) {
					type += String.valueOf(ch[i]);
					i++;}
				rjgc4[n].setx(Integer.parseInt(type));
				type = "";
				n++;}			
			int k=0,i=0;a2[i]=0;
			String b=rjgc4[0].getSE();
			for(i=0;i<n;i++){
				a2[k]+=rjgc4[i].getx();
				if(!rjgc4[i].getSE().equals(a)){
					a[k]=i-m;	a1[k]=i;
					m=i;
					k++;
					b=rjgc4[i].getSE();}}
			a[k]=i-m;a1[k]=i;
			rjgc4 rjgc41=new rjgc4();
	int j=0,l;
			for(i=0;i<=k;i++){
				int n1=0;
				for(;n1<=a[i];j++){
					n1++;
					for(l=j+1;l<a1[i];l++){
						if(rjgc4[l].getx()>rjgc4[j].getx()){
							rjgc41=rjgc4[j];
							rjgc4[j]=rjgc4[l];
							rjgc4[l]=rjgc41;
						}
						else if(rjgc4[l].getx()==rjgc4[j].getx()){
									
							if(collator.compare(rjgc4[j].getSS(), rjgc4[l].getSS())>0){								
								rjgc41=rjgc4[l];
								rjgc4[l]=rjgc4[j];
								rjgc4[j]=rjgc41;
							}}}}}j=0;
for(i=0;i<=k;i++){
	fwriter.write(rjgc4[j].getSE()+"	"+a2[i]+'\r');
	for(;j<a1[i];j++){
		fwriter.write(rjgc4[j].getSS()+"	"+rjgc4[j].getx()+'\r');}}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fwriter != null) {
				try {
					fwriter.close();
				} catch (IOException e) {

					e.printStackTrace();
				}}}
}}