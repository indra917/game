package game;
import java.util.Scanner;
import java.io.*;

public class start {
	public static char[][] array = new char[][]{{'1','2','3'},{'0','0','0'},{'0','0','0'}};
	
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
            		start.array[y][x] = '0';
            		pos[0] = y;
            		pos[1] = x;
            		System.out.print(pos[0]);
            		System.out.print(pos[1]);
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
	public static void repo(int newp, char a){
		int m	= (newp-1)/3; //Baris
		int n	= (newp-1)%3; //Kolum

		System.out.print(m);
		System.out.print(n);
		System.out.print("\n");		
		start.array[m][n]	=  a;
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
		repo(newp, a);
	}
	public static int check(){
		
		return 0;
	}
	public static boolean step(){
    	Scanner input = new Scanner(System.in);
    	
    	char q= input.next().charAt(0);
    	if (q==-1)return false;
    	
    	char a= input.next().charAt(0);
    	
    	step(q, a);
    	
		return true;
		
	}
	public static void main(String []args) throws IOException{
		start.cetak();
		while(step()){
			start.cetak();	
		}
		
		
	}
	

}
