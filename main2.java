package game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.List;
import java.awt.Point;
import java.io.*;

public class start {
	//private static Point final Object = 1;
	public static char[][] array = new char[][]{{'1','2','3'},{'0','0','0'},{'0','0','0'}};
	public static int[] cur_pos = new int[]{1,2,3};
	public static void cetak(){
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
            	System.out.print(start.array[i][j]);
            }
            System.out.print("\n");
        }
	}

/*	
	public static int input() throws IOException{
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
            	Scanner input = new Scanner(System.in);
            	start.array[i][j]= input.nextInt();
            	if (start.array[i][j]==-1)return -1;
            }
            //System.out.print("\n");
        }
        return 1;
	}
*/
	public static int[] check_pos(char a){
		int[] pos;
		pos = new int[2];
        for (int y=0;y<3;y++) {
            for (int x=0;x<3;x++) {
            	if(start.array[y][x]==a){
            		pos[0] = y;
            		pos[1] = x;
            		/*
            		System.out.print(pos[0]);
            		System.out.print(pos[1]);
            		*/
            		System.out.print("\n");
            	}
            }
            //System.out.print("\n");
        }
        return(pos);
        //return pos[];
	}
	
	
	public static int position(int[] state){
		/*System.out.print((3*state[0])+(state[1]+1));
		System.out.print("\n");*/		
		return (3*state[0])+(state[1]+1);
	}
	public static int repo(int newp, char a){
		int m	= (newp-1)/3; //Baris
		int n	= (newp-1)%3; //Kolum
		/*
		System.out.print(m);
		System.out.print(n);
		System.out.print("\n");
		*/
		if(start.array[m][n]=='0'){
	        for (int y=0;y<3;y++) {
	            for (int x=0;x<3;x++) {
	            	if(start.array[y][x]==a){
	            		start.array[y][x] = '0';
	            	}
	            }
	        }			
			start.array[m][n]	=  a;
			return 1;
		}
		return -1;
	}
	public static void step(char q, char a){
		int[] state = check_pos(a);
		int p	= position(state);
		int newp = -1;
		if (q == 'w' && state[0]%3!=0){			
			newp	= (p - 3) % (3 * 3);
		}
		else if(q == 'a' && state[1]%3!=0){
			newp	= (p - 1);
		}
		else if(q == 'd' && state[1]/2!=1){
			newp	= (p + 1) ;
		}
		else if(q == 'x' && state[0]/2!=1){
			newp	= (p + 3) % 10;
		}
		else if(q == 'c' && ((state[0]==0 && state[1]==0)||(state[0]==1 && state[1]==1))){
			newp	= (p + 4) % 10;
		}
		else if(q == 'z' && ((state[0]==0 && state[1]==2)||(state[0]==1 && state[1]==1))){
			newp	= (p + 2) % 10;
		}
		else if (q == 'q' && ((state[0]==2 && state[1]==2)||(state[0]==1 && state[1]==1))){			
			newp	= (p - 4) % (3 * 3);
		}
		else if (q == 'e' && ((state[0]==2 && state[1]==0)||(state[0]==1 && state[1]==1))){			
			newp	= (p - 2) % (3 * 3);
		}
		if(repo(newp, a)!=-1)
			start.cur_pos[Character.getNumericValue(a)-1] = newp; 
	}
	public static boolean contain_1_9(){
		if(cur_pos[0]==1 || cur_pos[1]==1 || cur_pos[2]==1 ||cur_pos[0]==9 || cur_pos[1]==9 || cur_pos[2]==9){
			return true;
		}
		return false;
	}
	
	public static int sama_kolom(){
		if (((start.cur_pos[0]-1)/3 == (start.cur_pos[1]-1)/3) && ((start.cur_pos[0]-1)/3==(start.cur_pos[2]-1)/3)){
			return start.cur_pos[0]/3;
		}
		return -1;
	}
	
	public static int check_win(){
		//List list = (List) Arrays.asList(start.cur_pos);
		if(start.cur_pos[0]%3==1 && start.cur_pos[1]%3==1 && start.cur_pos[2]%3==1){
			return 1;
		}
		else if(start.cur_pos[0]%3==2 && start.cur_pos[1]%3==2 && start.cur_pos[2]%3==2){
			return 1;
		}
		else if(start.cur_pos[0]%3==0 && start.cur_pos[1]%3==0 && start.cur_pos[2]%3==0){
			return 1;
		}
		else if(!contain_1_9() && start.cur_pos[0]%2==1 && start.cur_pos[1]%2==1 && start.cur_pos[2]%2==1){
				return 1;
		}
		else if(start.cur_pos[0]%4==1 && start.cur_pos[1]%4==1 && start.cur_pos[2]%4==1){
			return 1;
		}
		else if(sama_kolom()!=-1 && sama_kolom()!=0){
			return 1;
		}
			
			
		return -1;
	}
	public static int step(){
    	Scanner input = new Scanner(System.in);
    	
    	char q= input.next().charAt(0);
    	if (q==-1)return -1;
    	
    	char a= input.next().charAt(0);
    	
    	start.step(q, a);
    	if(start.check_win()==1)return 1;
		return 0;
		
	}
	public static void main(String []args) throws IOException{
		start.cetak();
		int a = 0;
		while(a == 0){
			/*
			for(int i=0;i<3;i++){
				System.out.println(cur_pos[i]);
			}
			*/
			a	= step();
			start.cetak();			
			if(a==1){
				System.out.println("Anda Menang!");
			}
		}
		
		
	}
	

}
