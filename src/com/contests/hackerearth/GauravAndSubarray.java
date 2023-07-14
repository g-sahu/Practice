package com.contests.hackerearth;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array consisting of non-negative integers. Now, you need to answer queries of the following type given an integer K in each query.
 * You need to find the minimum length L of any subarray of A, such that if all elements of this subarray are represented in binary notation and concatenated to form a binary string, 
 * then no of 1's in the resulting string is at least K.
 * 
 * Input Format:
 * The first line of the input consists of two space-separated integers N and Q.
 * The second line contains N space separated integers, where the integer denotes 
 * Next Q lines contains a non-negative integer K.
 * 
 * Output Format:
 * For each query out of the Q ones, print the answer on a new line. If for a paritcular query no valid subarray exists, then print -1 instead as the answer to that query. 
 * 
 * Sample Input
 * 4 3
 * 1 2 4 8
 * 1
 * 2
 * 3
 * 
 * Sample Output
 * 1
 * 2
 * 3
 * 
 * Explanation
 * For first query consider subarray A[1,1], then binary string representing A[1,1] is 01 which has one 1's.
 * For second query consider subarray A[1,2], then binary string is 0110 which has two 1's.
 * Similarly, for third query consider subarray A[1,3].
 * 
 * @author gasahu
 *
 */
public class GauravAndSubarray {
	private static Map<String, Long> memo = new HashMap<>();

	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		Reader sc = new Reader();
		int n = sc.nextInt();
		int q = sc.nextInt();
		int arr[] = new int[n];
		int k;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<q; i++) {
			k = sc.nextInt();
			System.out.println(minimumLengthSubarray(arr, k));
		}
		
		sc.close();
	}
	
	private static int minimumLengthSubarray(int arr[], int k) {
		int l = arr.length;
		int min = -1;
		String key = null;
		
		for(int i=0; i<l; i++) {
			for(int j=i; j<l; j++) {
				key = i + "," + j;
				
				if(!memo.containsKey(key)) {
					if(i == j) {
						memo.put(key, (long) Integer.bitCount(arr[j]));
					} else {
						memo.put(key, memo.get(i + "," + (j-1)) + (long) Integer.bitCount(arr[j]));
					}
				}
				
				if(memo.get(key) >= k) {
					if(min == -1) {
						min  = (j - i + 1);
					} else {
						min = (j - i + 1) < min ? (j - i + 1) : min;
					}
					
					if(min == 1) {
						return min;
					} else {
						break;
					}
				}
			}
		}
		
		return min;
	}
	
	static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                
                buf[cnt++] = (byte) c;
            }
            
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            
            while (c <= ' ')
                c = read();
            
            boolean neg = (c == '-');
            
            if (neg)
                c = read();
            
            do {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            
            return ret;
        }
 
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            
            while (c <= ' ')
                c = read();
            
            boolean neg = (c == '-');
            
            if (neg)
                c = read();
            
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            
            if (neg)
                return -ret;
            
            return ret;
        }
 
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            
            while (c <= ' ')
                c = read();
            
            boolean neg = (c == '-');
            
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            
            return ret;
        }
 
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException {
            if (din == null)
                return;
            
            din.close();
        }
    }
}
