package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	private static int columnA;
	private static int columnB;
	private static int columnC;
	public static void hanoi(int total, int origin, int temp, int destiny ) throws IOException {
		if (total==1) {
			if(origin==1 && destiny==3) {
				columnA--;
				columnC++;
	        }else if(origin==1 && destiny==2) {
	        	columnA--;
	        	columnB++;
	        }else if(origin==2 && destiny==1) {
	        	columnA++;
	        	columnB--;
	        }else if(origin==2 && destiny==3) {
	        	columnC++;
	        	columnB--;
	        }else if(origin==3 && destiny==1) {
	        	columnC--;
	            columnA++;
	        }else if(origin==3 && destiny==2) {
	        	columnC--;
	        	columnB++;
	        }
			bw.write(columnA+" "+columnB+" "+columnC+"\n");
			return;
		}
		hanoi(total-1, origin, destiny, temp);
		if(origin==1 && destiny==3) {
			columnA--;
			columnC++;
        }else if(origin==1 && destiny==2) {
        	columnA--;
        	columnB++;
        }else if(origin==2 && destiny==1) {
        	columnA++;
        	columnB--;
        }else if(origin==2 && destiny==3) {
        	columnC++;
        	columnB--;
        }else if(origin==3 && destiny==1) {
        	columnC--;
            columnA++;
        }else if(origin==3 && destiny==2) {
        	columnC--;
        	columnB++;
        }
		
		bw.write(columnA+" "+columnB+" "+columnC+"\n");
		
		hanoi(total-1, temp, origin, destiny);
		
		
		
	}	
	
	public static void main(String[] args) throws IOException {	
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		for(int i=0; i<n; i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		for(int i=0; i<array.length; i++) {
			columnA=array[i];
			columnB=0;
			columnC=0;
			bw.write(columnA+" "+columnB+" "+columnC+"\n");
			hanoi(columnA, 1,2,3);			
			if(columnC!=array[n-1]) {
				bw.write("\n");
				
			}			
		
		}
		br.close();
		bw.close();
		
	}
	

}
