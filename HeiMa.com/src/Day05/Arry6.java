package Day05;
//二维数组求和
public class Arry6 {
	public static void main(String[] args){
		int[][] arr={{10,20,13,40},{15,12,121},{50,60},{80,90,101}};
		int sum=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				sum+=arr[i][j];
			}			
		}
		System.out.println(sum);
	}
}
