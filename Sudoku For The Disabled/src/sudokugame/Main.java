package sudokugame;

// This is the main window.

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.*;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	public JFrame frmSudoku;
	public static JTextField fieldRow,fieldColumn,fieldValue;
	public static boolean r=false,c=false,v=false;
	public static JTextField btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	public static JTextField btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18;
	public static JTextField btn19,btn20,btn21,btn22,btn23,btn24,btn25,btn26,btn27;
	public static JTextField btn28,btn29,btn30,btn31,btn32,btn33,btn34,btn35,btn36;
	public static JTextField btn37,btn38,btn39,btn40,btn41,btn42,btn43,btn44,btn45;
	public static JTextField btn46,btn47,btn48,btn49,btn50,btn51,btn52,btn53,btn54;
	public static JTextField btn55,btn56,btn57,btn58,btn59,btn60,btn61,btn62,btn63;
	public static JTextField btn64,btn65,btn66,btn67,btn68,btn69,btn70,btn71,btn72;
	public static JTextField btn73,btn74,btn75,btn76,btn77,btn78,btn79,btn80,btn81;
	public static JTextField messageField;
	public static int[][] sudokuInt=new int [9][9];
	public static int[][] sudokuString=new int[9][9];
	public static boolean[] filled=new boolean[81];
	public static int count;
	static Connection conn=null;
	public static PreparedStatement pst;
	public static ResultSet rs;
	public static String scanning;
	public static int timeInMs;
	public static JTextField timeField;
	public static JRadioButton rdbtnStepScanning;
	public static JRadioButton rdbtnSwitchAcess;
	public static JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,btnNewGame,btnOpen,btnClose,btnSave,btnCheck,btnHelp;
	public static boolean ans=false,a;
	public static String selected="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmSudoku.setVisible(true);
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// This function is used to enter the number in the cell by the user.
	// The user will enter the row, column and number in the UI.
	// The program will take those three values and then enter the number in the appropriate place.
	public static void buttonPress(JButton btn) 
	{
		while(true)
		{
			// If user has entered the row value
			if(r==false)
			{	
				fieldRow.setText(btn.getText());	
				r=true;		
				break;	
			}
			
			// If the user has entered the column value
			if(r=true&&c==false)
			{	
				fieldColumn.setText(btn.getText());	
				c=true;	break;	
			}
			
			// If the user has entered the number
			if(r=true&&c==true)
			{	
				fieldValue.setText(btn.getText());	
				v=true;	
			}
			
			// Place the number in the appropriate location.
			// Numbers entered by the user are marked in red
			if(r==true&&c==true&&v==true)
			{
				/*------------------------ Entering numbers first row ----------------------------------------------------------------------------------*/
				if(fieldRow.getText().equals("1")&&fieldColumn.getText().equals("1")&&filled[0]==false)
				{	
					btn1.setText(fieldValue.getText());	
					btn1.setForeground(Color.RED);	
				}
				else if(fieldRow.getText().equals("1")&&fieldColumn.getText().equals("2")&&filled[1]==false)
				{	btn2.setText(fieldValue.getText());	btn2.setForeground(Color.RED);	}
				else if(fieldRow.getText().equals("1")&&fieldColumn.getText().equals("3")&&filled[2]==false)
				{	btn3.setText(fieldValue.getText());	btn3.setForeground(Color.RED);	}
				else if(fieldRow.getText().equals("1")&&fieldColumn.getText().equals("4")&&filled[3]==false)
				{	btn4.setText(fieldValue.getText());	btn4.setForeground(Color.RED);	}
				else if(fieldRow.getText().equals("1")&&fieldColumn.getText().equals("5")&&filled[4]==false)
				{	btn5.setText(fieldValue.getText());	btn5.setForeground(Color.RED);	}
				else if(fieldRow.getText().equals("1")&&fieldColumn.getText().equals("6")&&filled[5]==false)
				{	btn6.setText(fieldValue.getText());	btn6.setForeground(Color.RED);	}
				else if(fieldRow.getText().equals("1")&&fieldColumn.getText().equals("7")&&filled[6]==false)
				{	btn7.setText(fieldValue.getText());	btn7.setForeground(Color.RED);	}
				else if(fieldRow.getText().equals("1")&&fieldColumn.getText().equals("8")&&filled[7]==false)
				{	btn8.setText(fieldValue.getText());	btn8.setForeground(Color.RED);	}
				else if(fieldRow.getText().equals("1")&&fieldColumn.getText().equals("9")&&filled[8]==false)
				{	btn9.setText(fieldValue.getText());	btn9.setForeground(Color.RED);	}
				
				/*------------------------ Entering numbers second row ----------------------------------------------------------------------------------*/
				else if(fieldRow.getText().equals("2")&&fieldColumn.getText().equals("1")&&filled[9]==false)
				{	btn10.setText(fieldValue.getText());	btn10.setForeground(Color.RED);	}
				else if(fieldRow.getText().equals("2")&&fieldColumn.getText().equals("2")&&filled[10]==false)
				{	btn11.setText(fieldValue.getText());	btn11.setForeground(Color.RED);	}
				else if(fieldRow.getText().equals("2")&&fieldColumn.getText().equals("3")&&filled[11]==false)
				{	btn12.setText(fieldValue.getText());	btn12.setForeground(Color.RED);	}
				else if(fieldRow.getText().equals("2")&&fieldColumn.getText().equals("4")&&filled[12]==false)
				{	btn13.setText(fieldValue.getText());	btn13.setForeground(Color.RED);	}
				else if(fieldRow.getText().equals("2")&&fieldColumn.getText().equals("5")&&filled[13]==false)
				{	btn14.setText(fieldValue.getText());	btn14.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("2")&&fieldColumn.getText().equals("6")&&filled[14]==false)
				{	btn15.setText(fieldValue.getText());	btn15.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("2")&&fieldColumn.getText().equals("7")&&filled[15]==false)
				{	btn16.setText(fieldValue.getText());	btn16.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("2")&&fieldColumn.getText().equals("8")&&filled[16]==false)
				{	btn17.setText(fieldValue.getText());	btn17.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("2")&&fieldColumn.getText().equals("9")&&filled[17]==false)
				{	btn18.setText(fieldValue.getText());	btn18.setForeground(Color.RED); }
				
				/*------------------------ Entering numbers third row ----------------------------------------------------------------------------------*/
				else if(fieldRow.getText().equals("3")&&fieldColumn.getText().equals("1")&&filled[18]==false)
				{	btn19.setText(fieldValue.getText());	btn19.setForeground(Color.RED);	}	
				else if(fieldRow.getText().equals("3")&&fieldColumn.getText().equals("2")&&filled[19]==false)
				{	btn20.setText(fieldValue.getText());	btn20.setForeground(Color.RED);	}
				else if(fieldRow.getText().equals("3")&&fieldColumn.getText().equals("3")&&filled[20]==false)
				{	btn21.setText(fieldValue.getText());	btn21.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("3")&&fieldColumn.getText().equals("4")&&filled[21]==false)
				{	btn22.setText(fieldValue.getText());	btn22.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("3")&&fieldColumn.getText().equals("5")&&filled[22]==false)
				{	btn23.setText(fieldValue.getText());	btn23.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("3")&&fieldColumn.getText().equals("6")&&filled[23]==false)
				{	btn24.setText(fieldValue.getText());	btn24.setForeground(Color.RED);	}
				else if(fieldRow.getText().equals("3")&&fieldColumn.getText().equals("7")&&filled[24]==false)
				{	btn25.setText(fieldValue.getText());	btn25.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("3")&&fieldColumn.getText().equals("8")&&filled[25]==false)	
				{	btn26.setText(fieldValue.getText());	btn26.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("3")&&fieldColumn.getText().equals("9")&&filled[26]==false)
				{	btn27.setText(fieldValue.getText());	btn27.setForeground(Color.RED);	}
				
				/*------------------------ Entering numbers fourth row ----------------------------------------------------------------------------------*/
				else if(fieldRow.getText().equals("4")&&fieldColumn.getText().equals("1")&&filled[27]==false)
				{	btn28.setText(fieldValue.getText());	btn28.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("4")&&fieldColumn.getText().equals("2")&&filled[28]==false)
				{	btn29.setText(fieldValue.getText());	btn29.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("4")&&fieldColumn.getText().equals("3")&&filled[29]==false)
				{	btn30.setText(fieldValue.getText());	btn30.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("4")&&fieldColumn.getText().equals("4")&&filled[30]==false)
				{	btn31.setText(fieldValue.getText());	btn31.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("4")&&fieldColumn.getText().equals("5")&&filled[31]==false)
				{	btn32.setText(fieldValue.getText());	btn32.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("4")&&fieldColumn.getText().equals("6")&&filled[32]==false)
				{	btn33.setText(fieldValue.getText());	btn33.setForeground(Color.RED); }	
				else if(fieldRow.getText().equals("4")&&fieldColumn.getText().equals("7")&&filled[33]==false)
				{	btn34.setText(fieldValue.getText());	btn34.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("4")&&fieldColumn.getText().equals("8")&&filled[34]==false)
				{	btn35.setText(fieldValue.getText());	btn35.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("4")&&fieldColumn.getText().equals("9")&&filled[35]==false)
				{	btn36.setText(fieldValue.getText());	btn36.setForeground(Color.RED); }
				
				/*------------------------ Entering numbers fifth row ----------------------------------------------------------------------------------*/
				else if(fieldRow.getText().equals("5")&&fieldColumn.getText().equals("1")&&filled[36]==false)
				{	btn37.setText(fieldValue.getText());	btn37.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("5")&&fieldColumn.getText().equals("2")&&filled[37]==false)
				{	btn38.setText(fieldValue.getText());	btn38.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("5")&&fieldColumn.getText().equals("3")&&filled[38]==false)
				{	btn39.setText(fieldValue.getText());	btn39.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("5")&&fieldColumn.getText().equals("4")&&filled[39]==false)
				{	btn40.setText(fieldValue.getText());	btn40.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("5")&&fieldColumn.getText().equals("5")&&filled[40]==false)
				{	btn41.setText(fieldValue.getText());	btn41.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("5")&&fieldColumn.getText().equals("6")&&filled[41]==false)
				{	btn42.setText(fieldValue.getText());	btn42.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("5")&&fieldColumn.getText().equals("7")&&filled[42]==false)
				{	btn43.setText(fieldValue.getText());	btn43.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("5")&&fieldColumn.getText().equals("8")&&filled[43]==false)
				{	btn44.setText(fieldValue.getText());	btn44.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("5")&&fieldColumn.getText().equals("9")&&filled[44]==false)
				{	btn45.setText(fieldValue.getText());	btn45.setForeground(Color.RED); }
				
				/*------------------------ Entering numbers sixth row ----------------------------------------------------------------------------------*/
				else if(fieldRow.getText().equals("6")&&fieldColumn.getText().equals("1")&&filled[45]==false)	
				{	btn46.setText(fieldValue.getText());	btn46.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("6")&&fieldColumn.getText().equals("2")&&filled[46]==false)
				{	btn47.setText(fieldValue.getText());	btn47.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("6")&&fieldColumn.getText().equals("3")&&filled[47]==false)
				{	btn48.setText(fieldValue.getText());	btn48.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("6")&&fieldColumn.getText().equals("4")&&filled[48]==false)
				{	btn49.setText(fieldValue.getText());	btn49.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("6")&&fieldColumn.getText().equals("5")&&filled[49]==false)
				{	btn50.setText(fieldValue.getText());	btn50.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("6")&&fieldColumn.getText().equals("6")&&filled[50]==false)
				{	btn51.setText(fieldValue.getText());	btn51.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("6")&&fieldColumn.getText().equals("7")&&filled[51]==false)
				{	btn52.setText(fieldValue.getText());	btn52.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("6")&&fieldColumn.getText().equals("8")&&filled[52]==false)
				{	btn53.setText(fieldValue.getText());	btn53.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("6")&&fieldColumn.getText().equals("9")&&filled[53]==false)
				{	btn54.setText(fieldValue.getText());	btn54.setForeground(Color.RED); }
				
				/*------------------------ Entering numbers seventh row ----------------------------------------------------------------------------------*/
				else if(fieldRow.getText().equals("7")&&fieldColumn.getText().equals("1")&&filled[54]==false)
				{	btn55.setText(fieldValue.getText());	btn55.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("7")&&fieldColumn.getText().equals("2")&&filled[55]==false)
				{	btn56.setText(fieldValue.getText());	btn56.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("7")&&fieldColumn.getText().equals("3")&&filled[56]==false)
				{	btn57.setText(fieldValue.getText());	btn57.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("7")&&fieldColumn.getText().equals("4")&&filled[57]==false)
				{	btn58.setText(fieldValue.getText());	btn58.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("7")&&fieldColumn.getText().equals("5")&&filled[58]==false)
				{	btn59.setText(fieldValue.getText());	btn59.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("7")&&fieldColumn.getText().equals("6")&&filled[59]==false)
				{	btn60.setText(fieldValue.getText());	btn60.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("7")&&fieldColumn.getText().equals("7")&&filled[60]==false)
				{	btn61.setText(fieldValue.getText());	btn61.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("7")&&fieldColumn.getText().equals("8")&&filled[61]==false)
				{	btn62.setText(fieldValue.getText());	btn62.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("7")&&fieldColumn.getText().equals("9")&&filled[62]==false)
				{	btn63.setText(fieldValue.getText());	btn63.setForeground(Color.RED); }
				
				/*------------------------ Entering numbers eighth row ----------------------------------------------------------------------------------*/
				else if(fieldRow.getText().equals("8")&&fieldColumn.getText().equals("1")&&filled[63]==false)
				{	btn64.setText(fieldValue.getText());	btn64.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("8")&&fieldColumn.getText().equals("2")&&filled[64]==false)
				{	btn65.setText(fieldValue.getText());	btn65.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("8")&&fieldColumn.getText().equals("3")&&filled[65]==false)
				{	btn66.setText(fieldValue.getText());	btn66.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("8")&&fieldColumn.getText().equals("4")&&filled[66]==false)
				{	btn67.setText(fieldValue.getText());	btn67.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("8")&&fieldColumn.getText().equals("5")&&filled[67]==false)
				{	btn68.setText(fieldValue.getText());	btn68.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("8")&&fieldColumn.getText().equals("6")&&filled[68]==false)
				{	btn69.setText(fieldValue.getText());	btn69.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("8")&&fieldColumn.getText().equals("7")&&filled[69]==false)
				{	btn70.setText(fieldValue.getText());	btn70.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("8")&&fieldColumn.getText().equals("8")&&filled[70]==false)
				{	btn71.setText(fieldValue.getText());	btn71.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("8")&&fieldColumn.getText().equals("9")&&filled[71]==false)
				{	btn72.setText(fieldValue.getText());	btn72.setForeground(Color.RED); }
				
				/*------------------------ Entering numbers ninth row ----------------------------------------------------------------------------------*/
				else if(fieldRow.getText().equals("9")&&fieldColumn.getText().equals("1")&&filled[72]==false)
				{	btn73.setText(fieldValue.getText());	btn73.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("9")&&fieldColumn.getText().equals("2")&&filled[73]==false)
				{	btn74.setText(fieldValue.getText());	btn74.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("9")&&fieldColumn.getText().equals("3")&&filled[74]==false)
				{	btn75.setText(fieldValue.getText());	btn75.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("9")&&fieldColumn.getText().equals("4")&&filled[75]==false)
				{	btn76.setText(fieldValue.getText());	btn76.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("9")&&fieldColumn.getText().equals("5")&&filled[76]==false)
				{	btn77.setText(fieldValue.getText());	btn77.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("9")&&fieldColumn.getText().equals("6")&&filled[77]==false)
				{	btn78.setText(fieldValue.getText());	btn78.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("9")&&fieldColumn.getText().equals("7")&&filled[78]==false)
				{	btn79.setText(fieldValue.getText());	btn79.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("9")&&fieldColumn.getText().equals("8")&&filled[79]==false)
				{	btn80.setText(fieldValue.getText());	btn80.setForeground(Color.RED); }
				else if(fieldRow.getText().equals("9")&&fieldColumn.getText().equals("9")&&filled[80]==false)
				{	btn81.setText(fieldValue.getText());	btn81.setForeground(Color.RED); }
				
				
				else	messageField.setText("Invalid position");
				fieldRow.setText("");fieldColumn.setText("");fieldValue.setText("");
				r=c=v=false;
				break;
				
			}
			break;
		}
	}
		
	// This function is used to fill the grid with numbers for the player to solve.
	// We will insert a few random number in a few cells.
	// We then solve the sudoku with the few cells.
	// If the sudoku can be solved, we will make a UI grid and present it to the user.
	public static boolean makeSudokuInteger()
	{
		boolean makable=false;
		Random rand=new Random();
		int x,y,n;
		int [][] userGrid=new int[9][9];
		n=1+rand.nextInt(9);
		for(int i=1;i<=n;++i)
		{
			x=rand.nextInt(9);
			y=rand.nextInt(9);
			if(userGrid[x][y]==0)
				userGrid[x][y]=i;
		}
		makable=SudokuSolver.startSolving(userGrid);
		return makable;
	}
	
	// This function is used to print the numbers to the user grid.
	// Here we won't print the entire solved sudoku to the grid.
	// We will remove a few cells so to make it look like an actual sudoku.
	public static void extractSolution(int [][] matrix)
	{
		sudokuInt=matrix;
		printToUI(sudokuInt);
		removeCells();
	}
	
	// We will take the integer matrix (solved sudoku) and convert it to a string and print it to a sudoku UI.
	public static void printToUI(int [][] sudokuInt)
	{
		btn1.setText(Integer.toString(sudokuInt[0][0]));	btn2.setText(Integer.toString(sudokuInt[0][1]));	btn3.setText(Integer.toString(sudokuInt[0][2]));
		btn4.setText(Integer.toString(sudokuInt[0][3]));	btn5.setText(Integer.toString(sudokuInt[0][4]));	btn6.setText(Integer.toString(sudokuInt[0][5]));
		btn7.setText(Integer.toString(sudokuInt[0][6]));	btn8.setText(Integer.toString(sudokuInt[0][7]));	btn9.setText(Integer.toString(sudokuInt[0][8]));
		
		btn10.setText(Integer.toString(sudokuInt[1][0]));	btn11.setText(Integer.toString(sudokuInt[1][1]));	btn12.setText(Integer.toString(sudokuInt[1][2]));
		btn13.setText(Integer.toString(sudokuInt[1][3]));	btn14.setText(Integer.toString(sudokuInt[1][4]));	btn15.setText(Integer.toString(sudokuInt[1][5]));
		btn16.setText(Integer.toString(sudokuInt[1][6]));	btn17.setText(Integer.toString(sudokuInt[1][7]));	btn18.setText(Integer.toString(sudokuInt[1][8]));
	
		btn19.setText(Integer.toString(sudokuInt[2][0]));	btn20.setText(Integer.toString(sudokuInt[2][1]));	btn21.setText(Integer.toString(sudokuInt[2][2]));
		btn22.setText(Integer.toString(sudokuInt[2][3]));	btn23.setText(Integer.toString(sudokuInt[2][4]));	btn24.setText(Integer.toString(sudokuInt[2][5]));
		btn25.setText(Integer.toString(sudokuInt[2][6]));	btn26.setText(Integer.toString(sudokuInt[2][7]));	btn27.setText(Integer.toString(sudokuInt[2][8]));
	
		btn28.setText(Integer.toString(sudokuInt[3][0]));	btn29.setText(Integer.toString(sudokuInt[3][1]));	btn30.setText(Integer.toString(sudokuInt[3][2]));
		btn31.setText(Integer.toString(sudokuInt[3][3]));	btn32.setText(Integer.toString(sudokuInt[3][4]));	btn33.setText(Integer.toString(sudokuInt[3][5]));
		btn34.setText(Integer.toString(sudokuInt[3][6]));	btn35.setText(Integer.toString(sudokuInt[3][7]));	btn36.setText(Integer.toString(sudokuInt[3][8]));
	
		btn37.setText(Integer.toString(sudokuInt[4][0]));	btn38.setText(Integer.toString(sudokuInt[4][1]));	btn39.setText(Integer.toString(sudokuInt[4][2]));
		btn40.setText(Integer.toString(sudokuInt[4][3]));	btn41.setText(Integer.toString(sudokuInt[4][4]));	btn42.setText(Integer.toString(sudokuInt[4][5]));
		btn43.setText(Integer.toString(sudokuInt[4][6]));	btn44.setText(Integer.toString(sudokuInt[4][7]));	btn45.setText(Integer.toString(sudokuInt[4][8]));
	
		btn46.setText(Integer.toString(sudokuInt[5][0]));	btn47.setText(Integer.toString(sudokuInt[5][1]));	btn48.setText(Integer.toString(sudokuInt[5][2]));
		btn49.setText(Integer.toString(sudokuInt[5][3]));	btn50.setText(Integer.toString(sudokuInt[5][4]));	btn51.setText(Integer.toString(sudokuInt[5][5]));
		btn52.setText(Integer.toString(sudokuInt[5][6]));	btn53.setText(Integer.toString(sudokuInt[5][7]));	btn54.setText(Integer.toString(sudokuInt[5][8]));
	
		btn55.setText(Integer.toString(sudokuInt[6][0]));	btn56.setText(Integer.toString(sudokuInt[6][1]));	btn57.setText(Integer.toString(sudokuInt[6][2]));
		btn58.setText(Integer.toString(sudokuInt[6][3]));	btn59.setText(Integer.toString(sudokuInt[6][4]));	btn60.setText(Integer.toString(sudokuInt[6][5]));
		btn61.setText(Integer.toString(sudokuInt[6][6]));	btn62.setText(Integer.toString(sudokuInt[6][7]));	btn63.setText(Integer.toString(sudokuInt[6][8]));
	
		btn64.setText(Integer.toString(sudokuInt[7][0]));	btn65.setText(Integer.toString(sudokuInt[7][1]));	btn66.setText(Integer.toString(sudokuInt[7][2]));
		btn67.setText(Integer.toString(sudokuInt[7][3]));	btn68.setText(Integer.toString(sudokuInt[7][4]));	btn69.setText(Integer.toString(sudokuInt[7][5]));
		btn70.setText(Integer.toString(sudokuInt[7][6]));	btn71.setText(Integer.toString(sudokuInt[7][7]));	btn72.setText(Integer.toString(sudokuInt[7][8]));
	
		btn73.setText(Integer.toString(sudokuInt[8][0]));	btn74.setText(Integer.toString(sudokuInt[8][1]));	btn75.setText(Integer.toString(sudokuInt[8][2]));
		btn76.setText(Integer.toString(sudokuInt[8][3]));	btn77.setText(Integer.toString(sudokuInt[8][4]));	btn78.setText(Integer.toString(sudokuInt[8][5]));
		btn79.setText(Integer.toString(sudokuInt[8][6]));	btn80.setText(Integer.toString(sudokuInt[8][7]));	btn81.setText(Integer.toString(sudokuInt[8][8]));
	
		for(int i=0;i<81;++i)
			filled[i]=true;
	}
	
	// Used to remove a few random cells, so that it will become a sudoku.
	public static void removeCells()
	{
		Random obj=new Random();
		int numberOfCellToRemove=27+obj.nextInt((72-27)+1);
		// In easy case will remove 27 cells. In hard case will remove 72 cell i.e. only 9 cells are filled
		int buttonNumber;
		for(int i=1;i<=numberOfCellToRemove;++i)
		{
			buttonNumber=obj.nextInt(81);
			switch(buttonNumber)
			{
				case 0:		btn1.setText("");	break;
				case 1:		btn2.setText("");	break;
				case 2:		btn3.setText("");	break;
				case 3:		btn4.setText("");	break;
				case 4:		btn5.setText("");	break;
				case 5:		btn6.setText("");	break;
				case 6:		btn7.setText("");	break;
				case 7:		btn8.setText("");	break;
				case 8:		btn9.setText("");	break;
				
				case 9:		btn10.setText("");	break;
				case 10:	btn11.setText("");	break;
				case 11:	btn12.setText("");	break;
				case 12:	btn13.setText("");	break;
				case 13:	btn14.setText("");	break;
				case 14:	btn15.setText("");	break;
				case 15:	btn16.setText("");	break;
				case 16:	btn17.setText("");	break;
				case 17:	btn18.setText("");	break;
				
				case 18:	btn19.setText("");	break;
				case 19:	btn20.setText("");	break;
				case 20:	btn21.setText("");	break;
				case 21:	btn22.setText("");	break;
				case 22:	btn23.setText("");	break;
				case 23:	btn24.setText("");	break;
				case 24:	btn25.setText("");	break;
				case 25:	btn26.setText("");	break;
				case 26:	btn27.setText("");	break;
				
				case 27:	btn28.setText("");	break;
				case 28:	btn29.setText("");	break;
				case 29:	btn30.setText("");	break;
				case 30:	btn31.setText("");	break;
				case 31:	btn32.setText("");	break;
				case 32:	btn33.setText("");	break;
				case 33:	btn34.setText("");	break;
				case 34:	btn35.setText("");	break;
				case 35:	btn36.setText("");	break;
				
				case 36:	btn37.setText("");	break;
				case 37:	btn38.setText("");	break;
				case 38:	btn39.setText("");	break;
				case 39:	btn40.setText("");	break;
				case 40:	btn41.setText("");	break;
				case 41:	btn42.setText("");	break;
				case 42:	btn43.setText("");	break;
				case 43:	btn44.setText("");	break;
				case 44:	btn45.setText("");	break;
				
				case 45:	btn46.setText("");	break;
				case 46:	btn47.setText("");	break;
				case 47:	btn48.setText("");	break;
				case 48:	btn49.setText("");	break;
				case 49:	btn50.setText("");	break;
				case 50:	btn51.setText("");	break;
				case 51:	btn52.setText("");	break;
				case 52:	btn53.setText("");	break;
				case 53:	btn54.setText("");	break;
				
				case 54:	btn55.setText("");	break;
				case 55:	btn56.setText("");	break;
				case 56:	btn57.setText("");	break;
				case 57:	btn58.setText("");	break;
				case 58:	btn59.setText("");	break;
				case 59:	btn60.setText("");	break;
				case 60:	btn61.setText("");	break;
				case 61:	btn62.setText("");	break;
				case 62:	btn63.setText("");	break;
				
				case 63:	btn64.setText("");	break;
				case 64:	btn65.setText("");	break;
				case 65:	btn66.setText("");	break;
				case 66:	btn67.setText("");	break;
				case 67:	btn68.setText("");	break;
				case 68:	btn69.setText("");	break;
				case 69:	btn70.setText("");	break;
				case 70:	btn71.setText("");	break;
				case 71:	btn72.setText("");	break;
				
				case 72:	btn73.setText("");	break;
				case 73:	btn74.setText("");	break;
				case 74:	btn75.setText("");	break;
				case 75:	btn76.setText("");	break;
				case 76:	btn77.setText("");	break;
				case 77:	btn78.setText("");	break;
				case 78:	btn79.setText("");	break;
				case 79:	btn80.setText("");	break;
				case 80:	btn81.setText("");	break;
			}
			filled[buttonNumber]=false;
		}
	}
	
	// Save the state of the game.
	// We will just take the entire 9x9 matrix and store it in a row wise manner.
	// Save all 81 cell values to a table, having 81 rows
	public static void saveGame()
	{
		try 
		{
			// Delete contents from the table if it already has data
			pst=conn.prepareStatement("delete from SaveSudoku");
			pst.execute();
			pst.close();
			
			pst=conn.prepareStatement("delete from SolveSudoku");
			pst.execute();
			pst.close();
		} 
		catch (SQLException e1) {	e1.printStackTrace();	}
		
		try 
		{
			/*	Saving the contents of sudokuInt in the table SolveSudoku
		  	SolveSudoku is used to save the solution of the sudoku. 
		 	The solution needs to be saved onto the table as it is to be later used for seeing if solved sudoku is correct.	*/
			
			pst=conn.prepareStatement("insert into SolveSudoku values(?)");
			for(int i=0;i<9;++i)
			{
				for(int j=0;j<9;++j)
				{
					pst.setInt(1, sudokuInt[i][j]);
					pst.execute();
				}
			}
			pst.close();
		} 
		catch (SQLException e) {	e.printStackTrace();	}
		
		try 
		{
			/*	Saving the contents of gui in table SolveSudku	*/
			
			pst=conn.prepareStatement("insert into SaveSudoku values(?,?)");
			
			// ********** Row 1 *******************************************
			pst.setString(1, btn1.getText());	pst.setString(2, String.valueOf(filled[0]));	pst.execute();			
			pst.setString(1, btn2.getText());	pst.setString(2, String.valueOf(filled[1]));	pst.execute();			
			pst.setString(1, btn3.getText());	pst.setString(2, String.valueOf(filled[2]));	pst.execute();			
			pst.setString(1, btn4.getText());	pst.setString(2, String.valueOf(filled[3]));	pst.execute();			
			pst.setString(1, btn5.getText());	pst.setString(2, String.valueOf(filled[4]));	pst.execute();			
			pst.setString(1, btn6.getText());	pst.setString(2, String.valueOf(filled[5]));	pst.execute();			
			pst.setString(1, btn7.getText());	pst.setString(2, String.valueOf(filled[6]));	pst.execute();			
			pst.setString(1, btn8.getText());	pst.setString(2, String.valueOf(filled[7]));	pst.execute();			
			pst.setString(1, btn9.getText());	pst.setString(2, String.valueOf(filled[8]));	pst.execute();
			
			//**************** Row 2 *********************************
			pst.setString(1, btn10.getText());	pst.setString(2, String.valueOf(filled[9]));	pst.execute();			
			pst.setString(1, btn11.getText());	pst.setString(2, String.valueOf(filled[10]));	pst.execute();			
			pst.setString(1, btn12.getText());	pst.setString(2, String.valueOf(filled[11]));	pst.execute();			
			pst.setString(1, btn13.getText());	pst.setString(2, String.valueOf(filled[12]));	pst.execute();			
			pst.setString(1, btn14.getText());	pst.setString(2, String.valueOf(filled[13]));	pst.execute();			
			pst.setString(1, btn15.getText());	pst.setString(2, String.valueOf(filled[14]));	pst.execute();			
			pst.setString(1, btn16.getText());	pst.setString(2, String.valueOf(filled[15]));	pst.execute();			
			pst.setString(1, btn17.getText());	pst.setString(2, String.valueOf(filled[16]));	pst.execute();			
			pst.setString(1, btn18.getText());	pst.setString(2, String.valueOf(filled[17]));	pst.execute();
			
			//**************** Row 3 *********************************
			pst.setString(1, btn19.getText());	pst.setString(2, String.valueOf(filled[18]));	pst.execute();			
			pst.setString(1, btn20.getText());	pst.setString(2, String.valueOf(filled[19]));	pst.execute();			
			pst.setString(1, btn21.getText());	pst.setString(2, String.valueOf(filled[20]));	pst.execute();			
			pst.setString(1, btn22.getText());	pst.setString(2, String.valueOf(filled[21]));	pst.execute();			
			pst.setString(1, btn23.getText());	pst.setString(2, String.valueOf(filled[22]));	pst.execute();			
			pst.setString(1, btn24.getText());	pst.setString(2, String.valueOf(filled[23]));	pst.execute();			
			pst.setString(1, btn25.getText());	pst.setString(2, String.valueOf(filled[24]));	pst.execute();			
			pst.setString(1, btn26.getText());	pst.setString(2, String.valueOf(filled[25]));	pst.execute();			
			pst.setString(1, btn27.getText());	pst.setString(2, String.valueOf(filled[26]));	pst.execute();
			
			//**************** Row 4 *********************************
			pst.setString(1, btn28.getText());	pst.setString(2, String.valueOf(filled[27]));	pst.execute();			
			pst.setString(1, btn29.getText());	pst.setString(2, String.valueOf(filled[28]));	pst.execute();			
			pst.setString(1, btn30.getText());	pst.setString(2, String.valueOf(filled[29]));	pst.execute();			
			pst.setString(1, btn31.getText());	pst.setString(2, String.valueOf(filled[30]));	pst.execute();			
			pst.setString(1, btn32.getText());	pst.setString(2, String.valueOf(filled[31]));	pst.execute();			
			pst.setString(1, btn33.getText());	pst.setString(2, String.valueOf(filled[32]));	pst.execute();			
			pst.setString(1, btn34.getText());	pst.setString(2, String.valueOf(filled[33]));	pst.execute();			
			pst.setString(1, btn35.getText());	pst.setString(2, String.valueOf(filled[34]));	pst.execute();			
			pst.setString(1, btn36.getText());	pst.setString(2, String.valueOf(filled[35]));	pst.execute();
			
			//**************** Row 5 *********************************
			pst.setString(1, btn37.getText());	pst.setString(2, String.valueOf(filled[36]));	pst.execute();			
			pst.setString(1, btn38.getText());	pst.setString(2, String.valueOf(filled[37]));	pst.execute();			
			pst.setString(1, btn39.getText());	pst.setString(2, String.valueOf(filled[38]));	pst.execute();			
			pst.setString(1, btn40.getText());	pst.setString(2, String.valueOf(filled[39]));	pst.execute();			
			pst.setString(1, btn41.getText());	pst.setString(2, String.valueOf(filled[40]));	pst.execute();			
			pst.setString(1, btn42.getText());	pst.setString(2, String.valueOf(filled[41]));	pst.execute();			
			pst.setString(1, btn43.getText());	pst.setString(2, String.valueOf(filled[42]));	pst.execute();			
			pst.setString(1, btn44.getText());	pst.setString(2, String.valueOf(filled[43]));	pst.execute();			
			pst.setString(1, btn45.getText());	pst.setString(2, String.valueOf(filled[44]));	pst.execute();
			
			//**************** Row 6 *********************************
			pst.setString(1, btn46.getText());	pst.setString(2, String.valueOf(filled[45]));	pst.execute();			
			pst.setString(1, btn47.getText());	pst.setString(2, String.valueOf(filled[46]));	pst.execute();			
			pst.setString(1, btn48.getText());	pst.setString(2, String.valueOf(filled[47]));	pst.execute();			
			pst.setString(1, btn49.getText());	pst.setString(2, String.valueOf(filled[48]));	pst.execute();			
			pst.setString(1, btn50.getText());	pst.setString(2, String.valueOf(filled[49]));	pst.execute();			
			pst.setString(1, btn51.getText());	pst.setString(2, String.valueOf(filled[50]));	pst.execute();			
			pst.setString(1, btn52.getText());	pst.setString(2, String.valueOf(filled[51]));	pst.execute();			
			pst.setString(1, btn53.getText());	pst.setString(2, String.valueOf(filled[52]));	pst.execute();			
			pst.setString(1, btn54.getText());	pst.setString(2, String.valueOf(filled[53]));	pst.execute();
			
			//**************** Row 7 *********************************
			pst.setString(1, btn55.getText());	pst.setString(2, String.valueOf(filled[54]));	pst.execute();			
			pst.setString(1, btn56.getText());	pst.setString(2, String.valueOf(filled[55]));	pst.execute();			
			pst.setString(1, btn57.getText());	pst.setString(2, String.valueOf(filled[56]));	pst.execute();			
			pst.setString(1, btn58.getText());	pst.setString(2, String.valueOf(filled[57]));	pst.execute();			
			pst.setString(1, btn59.getText());	pst.setString(2, String.valueOf(filled[58]));	pst.execute();			
			pst.setString(1, btn60.getText());	pst.setString(2, String.valueOf(filled[59]));	pst.execute();			
			pst.setString(1, btn61.getText());	pst.setString(2, String.valueOf(filled[60]));	pst.execute();			
			pst.setString(1, btn62.getText());	pst.setString(2, String.valueOf(filled[61]));	pst.execute();			
			pst.setString(1, btn63.getText());	pst.setString(2, String.valueOf(filled[62]));	pst.execute();
			
			//**************** Row 8 *********************************
			pst.setString(1, btn64.getText());	pst.setString(2, String.valueOf(filled[63]));	pst.execute();			
			pst.setString(1, btn65.getText());	pst.setString(2, String.valueOf(filled[64]));	pst.execute();			
			pst.setString(1, btn66.getText());	pst.setString(2, String.valueOf(filled[65]));	pst.execute();			
			pst.setString(1, btn67.getText());	pst.setString(2, String.valueOf(filled[66]));	pst.execute();			
			pst.setString(1, btn68.getText());	pst.setString(2, String.valueOf(filled[67]));	pst.execute();			
			pst.setString(1, btn69.getText());	pst.setString(2, String.valueOf(filled[68]));	pst.execute();			
			pst.setString(1, btn70.getText());	pst.setString(2, String.valueOf(filled[69]));	pst.execute();			
			pst.setString(1, btn71.getText());	pst.setString(2, String.valueOf(filled[70]));	pst.execute();			
			pst.setString(1, btn72.getText());	pst.setString(2, String.valueOf(filled[71]));	pst.execute();
			
			//**************** Row 9 *********************************
			pst.setString(1, btn73.getText());	pst.setString(2, String.valueOf(filled[72]));	pst.execute();			
			pst.setString(1, btn74.getText());	pst.setString(2, String.valueOf(filled[73]));	pst.execute();			
			pst.setString(1, btn75.getText());	pst.setString(2, String.valueOf(filled[74]));	pst.execute();			
			pst.setString(1, btn76.getText());	pst.setString(2, String.valueOf(filled[75]));	pst.execute();			
			pst.setString(1, btn77.getText());	pst.setString(2, String.valueOf(filled[76]));	pst.execute();			
			pst.setString(1, btn78.getText());	pst.setString(2, String.valueOf(filled[77]));	pst.execute();			
			pst.setString(1, btn79.getText());	pst.setString(2, String.valueOf(filled[78]));	pst.execute();			
			pst.setString(1, btn80.getText());	pst.setString(2, String.valueOf(filled[79]));	pst.execute();			
			pst.setString(1, btn81.getText());	pst.setString(2, String.valueOf(filled[80]));	pst.execute();
			
			pst.close();
			
		} 
		catch (SQLException e) {	e.printStackTrace();	}
		messageField.setText("Game saved");		
	}
	
	// If a game exist, open the game.
	public static void openGame() throws SQLException
	{
		// Take the contents of the table SolveSudoku and save it in matrix sudokuInt
		pst=conn.prepareStatement("select * from SolveSudoku");
		rs=pst.executeQuery();
		for(int i=0;i<9;++i)
		{
			for(int j=0;j<9;++j)
			{
				rs.next();
				sudokuInt[i][j]=rs.getInt("value");
			}
		}
		pst.close(); rs.close();
		/*for(int i=0;i<9;++i)
		{
			for(int j=0;j<9;++j)
			{
				System.out.print(sudokuInt[i][j]+" ");
			}
			System.out.println();
		}*/
		
		// Take the contents of the table SaveSudoku and store it in UI
		pst=conn.prepareStatement("select * from SaveSudoku");
		rs=pst.executeQuery();
		
		int buttonNumber=0;
		
		//--------------------------- Setting the number ------------------------------------------------------------------------------------
		//******************************** Row 1**********************************************************************************************
		rs.next();	btn1.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn2.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn3.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn4.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn5.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn6.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn7.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn8.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn9.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		
		//******************************** Row 2**********************************************************************************************
		rs.next();	btn10.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn11.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn12.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn13.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn14.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn15.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn16.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn17.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn18.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		
		//******************************** Row 3**********************************************************************************************
		rs.next();	btn19.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn20.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn21.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn22.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn23.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn24.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn25.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn26.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn27.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		
		//******************************** Row 4**********************************************************************************************
		rs.next();	btn28.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn29.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn30.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn31.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn32.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn33.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn34.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn35.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn36.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		
		//******************************** Row 5**********************************************************************************************
		rs.next();	btn37.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn38.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn39.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn40.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn41.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn42.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn43.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn44.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn45.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;	
		
		//******************************** Row 6**********************************************************************************************
		rs.next();	btn46.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn47.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn48.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn49.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn50.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn51.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn52.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn53.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn54.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;	
		
		//******************************** Row 7**********************************************************************************************
		rs.next();	btn55.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn56.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn57.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn58.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn59.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn60.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn61.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn62.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn63.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;	
		
		//******************************** Row 8**********************************************************************************************
		rs.next();	btn64.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn65.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn66.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn67.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn68.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn69.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn70.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn71.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn72.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;	
		
		//******************************** Row 8**********************************************************************************************
		rs.next();	btn73.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn74.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn75.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn76.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn77.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn78.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn79.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn80.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;
		rs.next();	btn81.setText(rs.getString("value"));	filled[buttonNumber]=Boolean.parseBoolean(rs.getString("filled"));	buttonNumber++;	
		
		//------------------------Setting the color--------
		//*********** ROW 1********************************
		if(filled[0]==false) btn1.setForeground(Color.red);	
		if(filled[1]==false) btn2.setForeground(Color.red);	
		if(filled[2]==false) btn3.setForeground(Color.red);	
		if(filled[3]==false) btn4.setForeground(Color.red);	
		if(filled[4]==false) btn5.setForeground(Color.red);	
		if(filled[5]==false) btn6.setForeground(Color.red);	
		if(filled[6]==false) btn7.setForeground(Color.red);	
		if(filled[7]==false) btn8.setForeground(Color.red);	
		if(filled[8]==false) btn9.setForeground(Color.red);	
		
		//************ROW 2*********************************
		if(filled[9]==false) btn10.setForeground(Color.red);	
		if(filled[10]==false) btn11.setForeground(Color.red);	
		if(filled[11]==false) btn12.setForeground(Color.red);	
		if(filled[12]==false) btn13.setForeground(Color.red);	
		if(filled[13]==false) btn14.setForeground(Color.red);	
		if(filled[14]==false) btn15.setForeground(Color.red);	
		if(filled[15]==false) btn16.setForeground(Color.red);	
		if(filled[16]==false) btn17.setForeground(Color.red);	
		if(filled[17]==false) btn18.setForeground(Color.red);	
		
		//************ROW 3*********************************
		if(filled[18]==false) btn19.setForeground(Color.red);	
		if(filled[19]==false) btn20.setForeground(Color.red);	
		if(filled[20]==false) btn21.setForeground(Color.red);	
		if(filled[21]==false) btn22.setForeground(Color.red);	
		if(filled[22]==false) btn23.setForeground(Color.red);	
		if(filled[23]==false) btn24.setForeground(Color.red);	
		if(filled[24]==false) btn25.setForeground(Color.red);	
		if(filled[25]==false) btn26.setForeground(Color.red);	
		if(filled[26]==false) btn27.setForeground(Color.red);	
		
		//************ROW 4*********************************
		if(filled[27]==false) btn28.setForeground(Color.red);	
		if(filled[28]==false) btn29.setForeground(Color.red);	
		if(filled[29]==false) btn30.setForeground(Color.red);	
		if(filled[30]==false) btn31.setForeground(Color.red);	
		if(filled[31]==false) btn32.setForeground(Color.red);	
		if(filled[32]==false) btn33.setForeground(Color.red);	
		if(filled[33]==false) btn34.setForeground(Color.red);	
		if(filled[34]==false) btn35.setForeground(Color.red);	
		if(filled[35]==false) btn36.setForeground(Color.red);	
		
		//************ROW 5*********************************
		if(filled[36]==false) btn37.setForeground(Color.red);	
		if(filled[37]==false) btn38.setForeground(Color.red);	
		if(filled[38]==false) btn39.setForeground(Color.red);	
		if(filled[39]==false) btn40.setForeground(Color.red);	
		if(filled[40]==false) btn41.setForeground(Color.red);	
		if(filled[41]==false) btn42.setForeground(Color.red);	
		if(filled[42]==false) btn43.setForeground(Color.red);	
		if(filled[43]==false) btn44.setForeground(Color.red);	
		if(filled[44]==false) btn45.setForeground(Color.red);	
		
		//************ROW 6*********************************
		if(filled[45]==false) btn46.setForeground(Color.red);	
		if(filled[46]==false) btn47.setForeground(Color.red);	
		if(filled[47]==false) btn48.setForeground(Color.red);	
		if(filled[48]==false) btn49.setForeground(Color.red);	
		if(filled[49]==false) btn50.setForeground(Color.red);	
		if(filled[50]==false) btn51.setForeground(Color.red);	
		if(filled[51]==false) btn52.setForeground(Color.red);	
		if(filled[52]==false) btn53.setForeground(Color.red);	
		if(filled[53]==false) btn54.setForeground(Color.red);	
		
		//************ROW 7*********************************
		if(filled[54]==false) btn55.setForeground(Color.red);	
		if(filled[55]==false) btn56.setForeground(Color.red);	
		if(filled[56]==false) btn57.setForeground(Color.red);	
		if(filled[57]==false) btn58.setForeground(Color.red);	
		if(filled[58]==false) btn59.setForeground(Color.red);	
		if(filled[59]==false) btn60.setForeground(Color.red);	
		if(filled[60]==false) btn61.setForeground(Color.red);	
		if(filled[61]==false) btn62.setForeground(Color.red);	
		if(filled[62]==false) btn63.setForeground(Color.red);	
		
		//************ROW 8 *********************************
		if(filled[63]==false) btn64.setForeground(Color.red);	
		if(filled[64]==false) btn65.setForeground(Color.red);	
		if(filled[65]==false) btn66.setForeground(Color.red);	
		if(filled[66]==false) btn67.setForeground(Color.red);	
		if(filled[67]==false) btn68.setForeground(Color.red);	
		if(filled[68]==false) btn69.setForeground(Color.red);	
		if(filled[69]==false) btn70.setForeground(Color.red);	
		if(filled[70]==false) btn71.setForeground(Color.red);	
		if(filled[71]==false) btn72.setForeground(Color.red);	
		
		//************ROW 9 *********************************
		if(filled[72]==false) btn73.setForeground(Color.red);	
		if(filled[73]==false) btn74.setForeground(Color.red);	
		if(filled[74]==false) btn75.setForeground(Color.red);	
		if(filled[75]==false) btn76.setForeground(Color.red);	
		if(filled[76]==false) btn77.setForeground(Color.red);	
		if(filled[77]==false) btn78.setForeground(Color.red);	
		if(filled[78]==false) btn79.setForeground(Color.red);	
		if(filled[79]==false) btn80.setForeground(Color.red);	
		if(filled[80]==false) btn81.setForeground(Color.red);	
	}
	
	// Loading the system configuration. 
	public static void loadSystemConfig()
	{
		try
		{
			pst=conn.prepareStatement("select * from SystemConfig");
			rs=pst.executeQuery();
			scanning=rs.getString("Scanning");
			timeInMs=rs.getInt("time");
			pst.close();
			rs.close();
			
			if(scanning.equals("Step Scanning"))
			{
				rdbtnStepScanning.setSelected(true);
				rdbtnSwitchAcess.setSelected(false);
				timeField.setText(Integer.toString(timeInMs));
			}
			
			if(scanning.equals("Switch Acess Scanning"))
			{
				rdbtnStepScanning.setSelected(false);
				rdbtnSwitchAcess.setSelected(true);
				timeField.setText(Integer.toString(timeInMs));
			}
			
		} 
		catch (SQLException e) {e.printStackTrace();}
		
	}
	
	// We are writting the functions of button together in a single function
	public static void gameButtonPress(JButton btn)
	{
		if(btn.equals(btnNewGame))
		{
			messageField.setText("");
			
			btn1.setForeground(Color.black);btn2.setForeground(Color.black);btn3.setForeground(Color.black);
			btn4.setForeground(Color.black);btn5.setForeground(Color.black);btn6.setForeground(Color.black);
			btn7.setForeground(Color.black);btn8.setForeground(Color.black);btn9.setForeground(Color.black);
			
			btn10.setForeground(Color.black);btn11.setForeground(Color.black);btn12.setForeground(Color.black);
			btn13.setForeground(Color.black);btn14.setForeground(Color.black);btn15.setForeground(Color.black);
			btn16.setForeground(Color.black);btn17.setForeground(Color.black);btn18.setForeground(Color.black);
			
			btn19.setForeground(Color.black);btn20.setForeground(Color.black);btn21.setForeground(Color.black);
			btn22.setForeground(Color.black);btn23.setForeground(Color.black);btn24.setForeground(Color.black);
			btn25.setForeground(Color.black);btn26.setForeground(Color.black);btn27.setForeground(Color.black);
			
			btn28.setForeground(Color.black);btn29.setForeground(Color.black);btn30.setForeground(Color.black);
			btn31.setForeground(Color.black);btn32.setForeground(Color.black);btn33.setForeground(Color.black);
			btn34.setForeground(Color.black);btn35.setForeground(Color.black);btn36.setForeground(Color.black);
			
			btn37.setForeground(Color.black);btn38.setForeground(Color.black);btn39.setForeground(Color.black);
			btn40.setForeground(Color.black);btn41.setForeground(Color.black);btn42.setForeground(Color.black);
			btn43.setForeground(Color.black);btn44.setForeground(Color.black);btn45.setForeground(Color.black);
			
			btn46.setForeground(Color.black);btn47.setForeground(Color.black);btn48.setForeground(Color.black);
			btn49.setForeground(Color.black);btn50.setForeground(Color.black);btn51.setForeground(Color.black);
			btn52.setForeground(Color.black);btn53.setForeground(Color.black);btn54.setForeground(Color.black);
			
			btn55.setForeground(Color.black);btn56.setForeground(Color.black);btn57.setForeground(Color.black);
			btn58.setForeground(Color.black);btn59.setForeground(Color.black);btn60.setForeground(Color.black);
			btn61.setForeground(Color.black);btn62.setForeground(Color.black);btn63.setForeground(Color.black);
			
			btn64.setForeground(Color.black);btn64.setForeground(Color.black);btn66.setForeground(Color.black);
			btn67.setForeground(Color.black);btn68.setForeground(Color.black);btn69.setForeground(Color.black);
			btn70.setForeground(Color.black);btn71.setForeground(Color.black);btn72.setForeground(Color.black);
			
			btn73.setForeground(Color.black);btn74.setForeground(Color.black);btn75.setForeground(Color.black);
			btn76.setForeground(Color.black);btn77.setForeground(Color.black);btn78.setForeground(Color.black);
			btn79.setForeground(Color.black);btn80.setForeground(Color.black);btn81.setForeground(Color.black);
			
			while(!makeSudokuInteger());
		}
		else if(btn.equals(btnOpen))
		{
			try 
			{
				openGame();
			} catch (SQLException e) {	e.printStackTrace();	}
		}
		else if(btn.equals(btnClose))
			System.exit(0);
		else if(btn.equals(btnSave))
		{
			saveGame();
		}
		else if(btn.equals(btnCheck))
		{
			sudokuString[0][0]=Integer.parseInt(btn1.getText());	sudokuString[0][1]=Integer.parseInt(btn2.getText());	sudokuString[0][2]=Integer.parseInt(btn3.getText());
			sudokuString[0][3]=Integer.parseInt(btn4.getText());	sudokuString[0][4]=Integer.parseInt(btn5.getText());	sudokuString[0][5]=Integer.parseInt(btn6.getText());
			sudokuString[0][6]=Integer.parseInt(btn7.getText());	sudokuString[0][7]=Integer.parseInt(btn8.getText());	sudokuString[0][8]=Integer.parseInt(btn9.getText());

			sudokuString[1][0]=Integer.parseInt(btn10.getText());	sudokuString[1][1]=Integer.parseInt(btn11.getText());	sudokuString[1][2]=Integer.parseInt(btn12.getText());
			sudokuString[1][3]=Integer.parseInt(btn13.getText());	sudokuString[1][4]=Integer.parseInt(btn14.getText());	sudokuString[1][5]=Integer.parseInt(btn15.getText());
			sudokuString[1][6]=Integer.parseInt(btn16.getText());	sudokuString[1][7]=Integer.parseInt(btn17.getText());	sudokuString[1][8]=Integer.parseInt(btn18.getText());
				
			sudokuString[2][0]=Integer.parseInt(btn19.getText());	sudokuString[2][1]=Integer.parseInt(btn20.getText());	sudokuString[2][2]=Integer.parseInt(btn21.getText());
			sudokuString[2][3]=Integer.parseInt(btn22.getText());	sudokuString[2][4]=Integer.parseInt(btn23.getText());	sudokuString[2][5]=Integer.parseInt(btn24.getText());
			sudokuString[2][6]=Integer.parseInt(btn25.getText());	sudokuString[2][7]=Integer.parseInt(btn26.getText());	sudokuString[2][8]=Integer.parseInt(btn27.getText());
			
			sudokuString[3][0]=Integer.parseInt(btn28.getText());	sudokuString[3][1]=Integer.parseInt(btn29.getText());	sudokuString[3][2]=Integer.parseInt(btn30.getText());
			sudokuString[3][3]=Integer.parseInt(btn31.getText());	sudokuString[3][4]=Integer.parseInt(btn32.getText());	sudokuString[3][5]=Integer.parseInt(btn33.getText());
			sudokuString[3][6]=Integer.parseInt(btn34.getText());	sudokuString[3][7]=Integer.parseInt(btn35.getText());	sudokuString[3][8]=Integer.parseInt(btn36.getText());
			
			sudokuString[4][0]=Integer.parseInt(btn37.getText());	sudokuString[4][1]=Integer.parseInt(btn38.getText());	sudokuString[4][2]=Integer.parseInt(btn39.getText());
			sudokuString[4][3]=Integer.parseInt(btn40.getText());	sudokuString[4][4]=Integer.parseInt(btn41.getText());	sudokuString[4][5]=Integer.parseInt(btn42.getText());
			sudokuString[4][6]=Integer.parseInt(btn43.getText());	sudokuString[4][7]=Integer.parseInt(btn44.getText());	sudokuString[4][8]=Integer.parseInt(btn45.getText());
			
			sudokuString[5][0]=Integer.parseInt(btn46.getText());	sudokuString[5][1]=Integer.parseInt(btn47.getText());	sudokuString[5][2]=Integer.parseInt(btn48.getText());
			sudokuString[5][3]=Integer.parseInt(btn49.getText());	sudokuString[5][4]=Integer.parseInt(btn50.getText());	sudokuString[5][5]=Integer.parseInt(btn51.getText());
			sudokuString[5][6]=Integer.parseInt(btn52.getText());	sudokuString[5][7]=Integer.parseInt(btn53.getText());	sudokuString[5][8]=Integer.parseInt(btn54.getText());
			
			sudokuString[6][0]=Integer.parseInt(btn55.getText());	sudokuString[6][1]=Integer.parseInt(btn56.getText());	sudokuString[6][2]=Integer.parseInt(btn57.getText());
			sudokuString[6][3]=Integer.parseInt(btn58.getText());	sudokuString[6][4]=Integer.parseInt(btn59.getText());	sudokuString[6][5]=Integer.parseInt(btn60.getText());
			sudokuString[6][6]=Integer.parseInt(btn61.getText());	sudokuString[6][7]=Integer.parseInt(btn62.getText());	sudokuString[6][8]=Integer.parseInt(btn63.getText());
			
			sudokuString[7][0]=Integer.parseInt(btn64.getText());	sudokuString[7][1]=Integer.parseInt(btn65.getText());	sudokuString[7][2]=Integer.parseInt(btn66.getText());
			sudokuString[7][3]=Integer.parseInt(btn67.getText());	sudokuString[7][4]=Integer.parseInt(btn68.getText());	sudokuString[7][5]=Integer.parseInt(btn69.getText());
			sudokuString[7][6]=Integer.parseInt(btn70.getText());	sudokuString[7][7]=Integer.parseInt(btn71.getText());	sudokuString[7][8]=Integer.parseInt(btn72.getText());
			
			sudokuString[8][0]=Integer.parseInt(btn73.getText());	sudokuString[8][1]=Integer.parseInt(btn74.getText());	sudokuString[8][2]=Integer.parseInt(btn75.getText());
			sudokuString[8][3]=Integer.parseInt(btn76.getText());	sudokuString[8][4]=Integer.parseInt(btn77.getText());	sudokuString[8][5]=Integer.parseInt(btn78.getText());
			sudokuString[8][6]=Integer.parseInt(btn79.getText());	sudokuString[8][7]=Integer.parseInt(btn80.getText());	sudokuString[8][8]=Integer.parseInt(btn81.getText());
			
			
			/*for(int i=0;i<9;++i)
			{
				for(int j=0;j<9;++j)
				{
					System.out.print(sudokuString[i][j]+" ");
				}
				System.out.println();
			}*/
			
			count=0;
			for(int i=0;i<9;++i)
			{
				for(int j=0;j<9;++j)
				{
					if(sudokuInt[i][j]==sudokuString[i][j])
						count++;
				}
			}
				if(count==81)	//All 81 numbers are same as original generated sudoku
					messageField.setText("Sudoku Solved");
				else
					messageField.setText("Sudoku Unsolved");
		}
		
		else if(btn.equals(btnHelp))
		{
			Random obj=new Random();
			int buttonNumber,count=0;
			while(true)
			{
				for(int i=0;i<81;++i)
				{
					if(filled[i]==true)
						count++;
				}
				if(count==81)
				{
					messageField.setText("Sudoku Solved");
					break;
				}
				buttonNumber=obj.nextInt(81);
				if(filled[buttonNumber]==true)	continue;
				switch(buttonNumber)
				{
					case 0:		btn1.setText(Integer.toString(sudokuInt[0][0]));	btn1.setForeground(Color.BLACK);	break;
					case 1:		btn2.setText(Integer.toString(sudokuInt[0][1]));	btn2.setForeground(Color.BLACK);	break;
					case 2:		btn3.setText(Integer.toString(sudokuInt[0][2]));	btn3.setForeground(Color.BLACK);	break;
					case 3:		btn4.setText(Integer.toString(sudokuInt[0][3]));	btn4.setForeground(Color.BLACK);	break;
					case 4:		btn5.setText(Integer.toString(sudokuInt[0][4]));	btn5.setForeground(Color.BLACK);	break;
					case 5:		btn6.setText(Integer.toString(sudokuInt[0][5]));	btn6.setForeground(Color.BLACK);	break;
					case 6:		btn7.setText(Integer.toString(sudokuInt[0][6]));	btn7.setForeground(Color.BLACK);	break;
					case 7:		btn8.setText(Integer.toString(sudokuInt[0][7]));	btn8.setForeground(Color.BLACK);	break;
					case 8:		btn9.setText(Integer.toString(sudokuInt[0][8]));	btn9.setForeground(Color.BLACK);	break;
					
					case 9:		btn10.setText(Integer.toString(sudokuInt[1][0]));	btn10.setForeground(Color.BLACK);	break;
					case 10:	btn11.setText(Integer.toString(sudokuInt[1][1]));	btn11.setForeground(Color.BLACK);	break;
					case 11:	btn12.setText(Integer.toString(sudokuInt[1][2]));	btn12.setForeground(Color.BLACK);	break;
					case 12:	btn13.setText(Integer.toString(sudokuInt[1][3]));	btn13.setForeground(Color.BLACK);	break;
					case 13:	btn14.setText(Integer.toString(sudokuInt[1][4]));	btn14.setForeground(Color.BLACK);	break;
					case 14:	btn15.setText(Integer.toString(sudokuInt[1][5]));	btn15.setForeground(Color.BLACK);	break;
					case 15:	btn16.setText(Integer.toString(sudokuInt[1][6]));	btn16.setForeground(Color.BLACK);	break;
					case 16:	btn17.setText(Integer.toString(sudokuInt[1][7]));	btn17.setForeground(Color.BLACK);	break;
					case 17:	btn18.setText(Integer.toString(sudokuInt[1][8]));	btn18.setForeground(Color.BLACK);	break;
					
					case 18:	btn19.setText(Integer.toString(sudokuInt[2][0]));	btn19.setForeground(Color.BLACK);	break;
					case 19:	btn20.setText(Integer.toString(sudokuInt[2][1]));	btn20.setForeground(Color.BLACK);	break;
					case 20:	btn21.setText(Integer.toString(sudokuInt[2][2]));	btn21.setForeground(Color.BLACK);	break;
					case 21:	btn22.setText(Integer.toString(sudokuInt[2][3]));	btn22.setForeground(Color.BLACK);	break;
					case 22:	btn23.setText(Integer.toString(sudokuInt[2][4]));	btn23.setForeground(Color.BLACK);	break;
					case 23:	btn24.setText(Integer.toString(sudokuInt[2][5]));	btn24.setForeground(Color.BLACK);	break;
					case 24:	btn25.setText(Integer.toString(sudokuInt[2][6]));	btn25.setForeground(Color.BLACK);	break;
					case 25:	btn26.setText(Integer.toString(sudokuInt[2][7]));	btn26.setForeground(Color.BLACK);	break;
					case 26:	btn27.setText(Integer.toString(sudokuInt[2][8]));	btn27.setForeground(Color.BLACK);	break;
					
					case 27:	btn28.setText(Integer.toString(sudokuInt[3][0]));	btn28.setForeground(Color.BLACK);	break;
					case 28:	btn29.setText(Integer.toString(sudokuInt[3][1]));	btn29.setForeground(Color.BLACK);	break;
					case 29:	btn30.setText(Integer.toString(sudokuInt[3][2]));	btn30.setForeground(Color.BLACK);	break;
					case 30:	btn31.setText(Integer.toString(sudokuInt[3][3]));	btn31.setForeground(Color.BLACK);	break;
					case 31:	btn32.setText(Integer.toString(sudokuInt[3][4]));	btn32.setForeground(Color.BLACK);	break;
					case 32:	btn33.setText(Integer.toString(sudokuInt[3][5]));	btn33.setForeground(Color.BLACK);	break;
					case 33:	btn34.setText(Integer.toString(sudokuInt[3][6]));	btn34.setForeground(Color.BLACK);	break;
					case 34:	btn35.setText(Integer.toString(sudokuInt[3][7]));	btn35.setForeground(Color.BLACK);	break;
					case 35:	btn36.setText(Integer.toString(sudokuInt[3][8]));	btn36.setForeground(Color.BLACK);	break;
					
					case 36:	btn37.setText(Integer.toString(sudokuInt[4][0]));	btn37.setForeground(Color.BLACK);	break;
					case 37:	btn38.setText(Integer.toString(sudokuInt[4][1]));	btn38.setForeground(Color.BLACK);	break;
					case 38:	btn39.setText(Integer.toString(sudokuInt[4][2]));	btn39.setForeground(Color.BLACK);	break;
					case 39:	btn40.setText(Integer.toString(sudokuInt[4][3]));	btn40.setForeground(Color.BLACK);	break;
					case 40:	btn41.setText(Integer.toString(sudokuInt[4][4]));	btn41.setForeground(Color.BLACK);	break;
					case 41:	btn42.setText(Integer.toString(sudokuInt[4][5]));	btn42.setForeground(Color.BLACK);	break;
					case 42:	btn43.setText(Integer.toString(sudokuInt[4][6]));	btn43.setForeground(Color.BLACK);	break;
					case 43:	btn44.setText(Integer.toString(sudokuInt[4][7]));	btn44.setForeground(Color.BLACK);	break;
					case 44:	btn45.setText(Integer.toString(sudokuInt[4][8]));	btn45.setForeground(Color.BLACK);	break;
					
					case 45:	btn46.setText(Integer.toString(sudokuInt[5][0]));	btn46.setForeground(Color.BLACK);	break;
					case 46:	btn47.setText(Integer.toString(sudokuInt[5][1]));	btn47.setForeground(Color.BLACK);	break;
					case 47:	btn48.setText(Integer.toString(sudokuInt[5][2]));	btn48.setForeground(Color.BLACK);	break;
					case 48:	btn49.setText(Integer.toString(sudokuInt[5][3]));	btn49.setForeground(Color.BLACK);	break;
					case 49:	btn50.setText(Integer.toString(sudokuInt[5][4]));	btn50.setForeground(Color.BLACK);	break;
					case 50:	btn51.setText(Integer.toString(sudokuInt[5][5]));	btn51.setForeground(Color.BLACK);	break;
					case 51:	btn52.setText(Integer.toString(sudokuInt[5][6]));	btn52.setForeground(Color.BLACK);	break;
					case 52:	btn53.setText(Integer.toString(sudokuInt[5][7]));	btn53.setForeground(Color.BLACK);	break;
					case 53:	btn54.setText(Integer.toString(sudokuInt[5][8]));	btn54.setForeground(Color.BLACK);	break;
					
					case 54:	btn55.setText(Integer.toString(sudokuInt[6][0]));	btn55.setForeground(Color.BLACK);	break;
					case 55:	btn56.setText(Integer.toString(sudokuInt[6][1]));	btn56.setForeground(Color.BLACK);	break;
					case 56:	btn57.setText(Integer.toString(sudokuInt[6][2]));	btn57.setForeground(Color.BLACK);	break;
					case 57:	btn58.setText(Integer.toString(sudokuInt[6][3]));	btn58.setForeground(Color.BLACK);	break;
					case 58:	btn59.setText(Integer.toString(sudokuInt[6][4]));	btn59.setForeground(Color.BLACK);	break;
					case 59:	btn60.setText(Integer.toString(sudokuInt[6][5]));	btn60.setForeground(Color.BLACK);	break;
					case 60:	btn61.setText(Integer.toString(sudokuInt[6][6]));	btn61.setForeground(Color.BLACK);	break;
					case 61:	btn62.setText(Integer.toString(sudokuInt[6][7]));	btn62.setForeground(Color.BLACK);	break;
					case 62:	btn63.setText(Integer.toString(sudokuInt[6][8]));	btn63.setForeground(Color.BLACK);	break;
					
					case 63:	btn64.setText(Integer.toString(sudokuInt[7][0]));	btn64.setForeground(Color.BLACK);	break;
					case 64:	btn65.setText(Integer.toString(sudokuInt[7][1]));	btn65.setForeground(Color.BLACK);	break;
					case 65:	btn66.setText(Integer.toString(sudokuInt[7][2]));	btn66.setForeground(Color.BLACK);	break;
					case 66:	btn67.setText(Integer.toString(sudokuInt[7][3]));	btn67.setForeground(Color.BLACK);	break;
					case 67:	btn68.setText(Integer.toString(sudokuInt[7][4]));	btn68.setForeground(Color.BLACK);	break;
					case 68:	btn69.setText(Integer.toString(sudokuInt[7][5]));	btn69.setForeground(Color.BLACK);	break;
					case 69:	btn70.setText(Integer.toString(sudokuInt[7][6]));	btn70.setForeground(Color.BLACK);	break;
					case 70:	btn71.setText(Integer.toString(sudokuInt[7][7]));	btn71.setForeground(Color.BLACK);	break;
					case 71:	btn72.setText(Integer.toString(sudokuInt[7][8]));	btn72.setForeground(Color.BLACK);	break;
					
					case 72:	btn73.setText(Integer.toString(sudokuInt[8][0]));	btn73.setForeground(Color.BLACK);	break;
					case 73:	btn74.setText(Integer.toString(sudokuInt[8][1]));	btn74.setForeground(Color.BLACK);	break;
					case 74:	btn75.setText(Integer.toString(sudokuInt[8][2]));	btn75.setForeground(Color.BLACK);	break;
					case 75:	btn76.setText(Integer.toString(sudokuInt[8][3]));	btn76.setForeground(Color.BLACK);	break;
					case 76:	btn77.setText(Integer.toString(sudokuInt[8][4]));	btn77.setForeground(Color.BLACK);	break;
					case 77:	btn78.setText(Integer.toString(sudokuInt[8][5]));	btn78.setForeground(Color.BLACK);	break;
					case 78:	btn79.setText(Integer.toString(sudokuInt[8][6]));	btn79.setForeground(Color.BLACK);	break;
					case 79:	btn80.setText(Integer.toString(sudokuInt[8][7]));	btn80.setForeground(Color.BLACK);	break;
					case 80:	btn81.setText(Integer.toString(sudokuInt[8][8]));	btn81.setForeground(Color.BLACK);	break;
				}
				filled[buttonNumber]=true;
				break;
			}
		}
			
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Main() throws ClassNotFoundException, SQLException 
	{
		conn=SQLiteConnection.getConnection();
		initialize();
		loadSystemConfig();
		
	}

	public boolean select()
	{
		
		frmSudoku.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1)
				ans=true;			
		}});
		return ans;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSudoku = new JFrame();
		frmSudoku.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(scanning.equals("Step Scanning"))
					StepScanning.executeHighlighting(e);
				else if(scanning.equals("Switch Acess Scanning"))
				{
					if(e.getClickCount()==2)
					{
						Timer timer = new Timer();
						timer.schedule(new TimerTask() {
								@Override public void run() 
								{
									a=select(); 
								if(a==true)
								{
									SwitchAcessScanning.selection();
									if(selected.equals("Check"))
									{
										selected="";
										timer.cancel();
										timer.purge();
									}
									else SwitchAcessScanning.highlighting();
								}else SwitchAcessScanning.highlighting();} } ,1000,timeInMs);
					}
				}
		}
		});
		frmSudoku.setAlwaysOnTop(true);
		frmSudoku.setResizable(false);
		frmSudoku.getContentPane().setBackground(Color.WHITE);
		frmSudoku.setFont(new Font("Arial", Font.BOLD, 12));
		frmSudoku.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Sudoku.png")));
		frmSudoku.setTitle("Sudoku");
		frmSudoku.setBounds(200, 150, 900, 500);
		frmSudoku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSudoku.getContentPane().setLayout(null);
								
		btn1 = new JTextField("");
		btn1.setHorizontalAlignment(SwingConstants.CENTER);
		btn1.setFont(new Font("Arial", Font.BOLD, 20));
		btn1.setForeground(Color.BLACK);
		btn1.setBackground(Color.WHITE);
		btn1.setBounds(30, 10, 40, 40);
		frmSudoku.getContentPane().add(btn1);
		
		btn2 = new JTextField("");
		btn2.setHorizontalAlignment(SwingConstants.CENTER);
		btn2.setFont(new Font("Arial", Font.BOLD, 20));
		btn2.setForeground(Color.BLACK);
		btn2.setBackground(Color.WHITE);
		btn2.setBounds(70, 10, 40, 40);
		frmSudoku.getContentPane().add(btn2);
		
		btn3 = new JTextField("");
		btn3.setHorizontalAlignment(SwingConstants.CENTER);
		btn3.setFont(new Font("Arial", Font.BOLD, 20));
		btn3.setForeground(Color.BLACK);
		btn3.setBackground(Color.WHITE);
		btn3.setBounds(110, 10, 40, 40);
		frmSudoku.getContentPane().add(btn3);
		
		btn4 = new JTextField("");
		btn4.setHorizontalAlignment(SwingConstants.CENTER);
		btn4.setFont(new Font("Arial", Font.BOLD, 20));
		btn4.setForeground(Color.BLACK);
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.setBounds(150, 10, 40, 40);
		frmSudoku.getContentPane().add(btn4);
		
		btn5 = new JTextField("");
		btn5.setHorizontalAlignment(SwingConstants.CENTER);
		btn5.setFont(new Font("Arial", Font.BOLD, 20));
		btn5.setForeground(Color.BLACK);
		btn5.setBackground(Color.LIGHT_GRAY);
		btn5.setBounds(190, 10, 40, 40);
		frmSudoku.getContentPane().add(btn5);
		
		btn6 = new JTextField("");
		btn6.setHorizontalAlignment(SwingConstants.CENTER);
		btn6.setFont(new Font("Arial", Font.BOLD, 20));
		btn6.setForeground(Color.BLACK);
		btn6.setBackground(Color.LIGHT_GRAY);
		btn6.setBounds(230, 10, 40, 40);
		frmSudoku.getContentPane().add(btn6);
		
		btn7 = new JTextField("");
		btn7.setHorizontalAlignment(SwingConstants.CENTER);
		btn7.setFont(new Font("Arial", Font.BOLD, 20));
		btn7.setForeground(Color.BLACK);
		btn7.setBackground(Color.WHITE);
		btn7.setBounds(270, 10, 40, 40);
		frmSudoku.getContentPane().add(btn7);
		
		btn8 = new JTextField("");
		btn8.setHorizontalAlignment(SwingConstants.CENTER);
		btn8.setFont(new Font("Arial", Font.BOLD, 20));
		btn8.setForeground(Color.BLACK);
		btn8.setBackground(Color.WHITE);
		btn8.setBounds(310, 10, 40, 40);
		frmSudoku.getContentPane().add(btn8);
		
		btn10 = new JTextField("");
		btn10.setHorizontalAlignment(SwingConstants.CENTER);
		btn10.setFont(new Font("Arial", Font.BOLD, 20));
		btn10.setForeground(Color.BLACK);
		btn10.setBackground(Color.WHITE);
		btn10.setBounds(30, 50, 40, 40);
		frmSudoku.getContentPane().add(btn10);
		
		btn11 = new JTextField("");
		btn11.setHorizontalAlignment(SwingConstants.CENTER);
		btn11.setFont(new Font("Arial", Font.BOLD, 20));
		btn11.setForeground(Color.BLACK);
		btn11.setBackground(Color.WHITE);
		btn11.setBounds(70, 50, 40, 40);
		frmSudoku.getContentPane().add(btn11);
		
		btn12 = new JTextField("");
		btn12.setHorizontalAlignment(SwingConstants.CENTER);
		btn12.setFont(new Font("Arial", Font.BOLD, 20));
		btn12.setForeground(Color.BLACK);
		btn12.setBackground(Color.WHITE);
		btn12.setBounds(110, 50, 40, 40);
		frmSudoku.getContentPane().add(btn12);
		
		btn13 = new JTextField("");
		btn13.setHorizontalAlignment(SwingConstants.CENTER);
		btn13.setFont(new Font("Arial", Font.BOLD, 20));
		btn13.setForeground(Color.BLACK);
		btn13.setBackground(Color.LIGHT_GRAY);
		btn13.setBounds(150, 50, 40, 40);
		frmSudoku.getContentPane().add(btn13);
		
		btn14 = new JTextField("");
		btn14.setHorizontalAlignment(SwingConstants.CENTER);
		btn14.setFont(new Font("Arial", Font.BOLD, 20));
		btn14.setForeground(Color.BLACK);
		btn14.setBackground(Color.LIGHT_GRAY);
		btn14.setBounds(190, 50, 40, 40);
		frmSudoku.getContentPane().add(btn14);
		
		btn15 = new JTextField("");
		btn15.setHorizontalAlignment(SwingConstants.CENTER);
		btn15.setFont(new Font("Arial", Font.BOLD, 20));
		btn15.setForeground(Color.BLACK);
		btn15.setBackground(Color.LIGHT_GRAY);
		btn15.setBounds(230, 50, 40, 40);
		frmSudoku.getContentPane().add(btn15);
		
		btn16 = new JTextField("");
		btn16.setHorizontalAlignment(SwingConstants.CENTER);
		btn16.setFont(new Font("Arial", Font.BOLD, 20));
		btn16.setForeground(Color.BLACK);
		btn16.setBackground(Color.WHITE);
		btn16.setBounds(270, 50, 40, 40);
		frmSudoku.getContentPane().add(btn16);
		
		btn17 = new JTextField("");
		btn17.setHorizontalAlignment(SwingConstants.CENTER);
		btn17.setFont(new Font("Arial", Font.BOLD, 20));
		btn17.setForeground(Color.BLACK);
		btn17.setBackground(Color.WHITE);
		btn17.setBounds(310, 50, 40, 40);
		frmSudoku.getContentPane().add(btn17);
		
		btn19 = new JTextField("");
		btn19.setHorizontalAlignment(SwingConstants.CENTER);
		btn19.setFont(new Font("Arial", Font.BOLD, 20));
		btn19.setForeground(Color.BLACK);
		btn19.setBackground(Color.WHITE);
		btn19.setBounds(30, 90, 40, 40);
		frmSudoku.getContentPane().add(btn19);
		
		btn20 = new JTextField("");
		btn20.setHorizontalAlignment(SwingConstants.CENTER);
		btn20.setFont(new Font("Arial", Font.BOLD, 20));
		btn20.setForeground(Color.BLACK);
		btn20.setBackground(Color.WHITE);
		btn20.setBounds(70, 90, 40, 40);
		frmSudoku.getContentPane().add(btn20);
		
		btn21 = new JTextField("");
		btn21.setHorizontalAlignment(SwingConstants.CENTER);
		btn21.setFont(new Font("Arial", Font.BOLD, 20));
		btn21.setForeground(Color.BLACK);
		btn21.setBackground(Color.WHITE);
		btn21.setBounds(110, 90, 40, 40);
		frmSudoku.getContentPane().add(btn21);
		
		btn22 = new JTextField("");
		btn22.setHorizontalAlignment(SwingConstants.CENTER);
		btn22.setFont(new Font("Arial", Font.BOLD, 20));
		btn22.setForeground(Color.BLACK);
		btn22.setBackground(Color.LIGHT_GRAY);
		btn22.setBounds(150, 90, 40, 40);
		frmSudoku.getContentPane().add(btn22);
		
		btn23 = new JTextField("");
		btn23.setHorizontalAlignment(SwingConstants.CENTER);
		btn23.setFont(new Font("Arial", Font.BOLD, 20));
		btn23.setForeground(Color.BLACK);
		btn23.setBackground(Color.LIGHT_GRAY);
		btn23.setBounds(190, 90, 40, 40);
		frmSudoku.getContentPane().add(btn23);
		
		btn24 = new JTextField("");
		btn24.setHorizontalAlignment(SwingConstants.CENTER);
		btn24.setFont(new Font("Arial", Font.BOLD, 20));
		btn24.setForeground(Color.BLACK);
		btn24.setBackground(Color.LIGHT_GRAY);
		btn24.setBounds(230, 90, 40, 40);
		frmSudoku.getContentPane().add(btn24);
		
		btn25 = new JTextField("");
		btn25.setHorizontalAlignment(SwingConstants.CENTER);
		btn25.setFont(new Font("Arial", Font.BOLD, 20));
		btn25.setForeground(Color.BLACK);
		btn25.setBackground(Color.WHITE);
		btn25.setBounds(270, 90, 40, 40);
		frmSudoku.getContentPane().add(btn25);
		
		btn26 = new JTextField("");
		btn26.setHorizontalAlignment(SwingConstants.CENTER);
		btn26.setFont(new Font("Arial", Font.BOLD, 20));
		btn26.setForeground(Color.BLACK);
		btn26.setBackground(Color.WHITE);
		btn26.setBounds(310, 90, 40, 40);
		frmSudoku.getContentPane().add(btn26);
		
		btn28 = new JTextField("");
		btn28.setHorizontalAlignment(SwingConstants.CENTER);
		btn28.setFont(new Font("Arial", Font.BOLD, 20));
		btn28.setForeground(Color.BLACK);
		btn28.setBackground(Color.LIGHT_GRAY);
		btn28.setBounds(30, 130, 40, 40);
		frmSudoku.getContentPane().add(btn28);
		
		btn29 = new JTextField("");
		btn29.setHorizontalAlignment(SwingConstants.CENTER);
		btn29.setFont(new Font("Arial", Font.BOLD, 20));
		btn29.setForeground(Color.BLACK);
		btn29.setBackground(Color.LIGHT_GRAY);
		btn29.setBounds(70, 130, 40, 40);
		frmSudoku.getContentPane().add(btn29);
		
		btn30 = new JTextField("");
		btn30.setHorizontalAlignment(SwingConstants.CENTER);
		btn30.setFont(new Font("Arial", Font.BOLD, 20));
		btn30.setForeground(Color.BLACK);
		btn30.setBackground(Color.LIGHT_GRAY);
		btn30.setBounds(110, 130, 40, 40);
		frmSudoku.getContentPane().add(btn30);
		
		btn31 = new JTextField("");
		btn31.setHorizontalAlignment(SwingConstants.CENTER);
		btn31.setFont(new Font("Arial", Font.BOLD, 20));
		btn31.setForeground(Color.BLACK);
		btn31.setBackground(Color.WHITE);
		btn31.setBounds(150, 130, 40, 40);
		frmSudoku.getContentPane().add(btn31);
		
		btn32 = new JTextField("");
		btn32.setHorizontalAlignment(SwingConstants.CENTER);
		btn32.setFont(new Font("Arial", Font.BOLD, 20));
		btn32.setForeground(Color.BLACK);
		btn32.setBackground(Color.WHITE);
		btn32.setBounds(190, 130, 40, 40);
		frmSudoku.getContentPane().add(btn32);
		
		btn33 = new JTextField("");
		btn33.setHorizontalAlignment(SwingConstants.CENTER);
		btn33.setFont(new Font("Arial", Font.BOLD, 20));
		btn33.setForeground(Color.BLACK);
		btn33.setBackground(Color.WHITE);
		btn33.setBounds(230, 130, 40, 40);
		frmSudoku.getContentPane().add(btn33);
		
		btn34 = new JTextField("");
		btn34.setHorizontalAlignment(SwingConstants.CENTER);
		btn34.setFont(new Font("Arial", Font.BOLD, 20));
		btn34.setForeground(Color.BLACK);
		btn34.setBackground(Color.LIGHT_GRAY);
		btn34.setBounds(270, 130, 40, 40);
		frmSudoku.getContentPane().add(btn34);
		
		btn35 = new JTextField("");
		btn35.setHorizontalAlignment(SwingConstants.CENTER);
		btn35.setFont(new Font("Arial", Font.BOLD, 20));
		btn35.setForeground(Color.BLACK);
		btn35.setBackground(Color.LIGHT_GRAY);
		btn35.setBounds(310, 130, 40, 40);
		frmSudoku.getContentPane().add(btn35);
		
		btn37 = new JTextField("");
		btn37.setHorizontalAlignment(SwingConstants.CENTER);
		btn37.setFont(new Font("Arial", Font.BOLD, 20));
		btn37.setForeground(Color.BLACK);
		btn37.setBackground(Color.LIGHT_GRAY);
		btn37.setBounds(30, 170, 40, 40);
		frmSudoku.getContentPane().add(btn37);
		
		btn46 = new JTextField("");
		btn46.setHorizontalAlignment(SwingConstants.CENTER);
		btn46.setForeground(Color.BLACK);
		btn46.setFont(new Font("Arial", Font.BOLD, 20));
		btn37.setHorizontalAlignment(SwingConstants.CENTER);
		btn37.setFont(new Font("Arial", Font.BOLD, 20));
		btn37.setForeground(Color.BLACK);
		btn46.setBackground(Color.LIGHT_GRAY);
		btn46.setBounds(30, 210, 40, 40);
		frmSudoku.getContentPane().add(btn46);
		
		btn55 = new JTextField("");
		btn55.setHorizontalAlignment(SwingConstants.CENTER);
		btn55.setFont(new Font("Arial", Font.BOLD, 20));
		btn55.setForeground(Color.BLACK);
		btn55.setBackground(Color.WHITE);
		btn55.setBounds(30, 250, 40, 40);
		frmSudoku.getContentPane().add(btn55);
		
		btn64 = new JTextField("");
		btn64.setHorizontalAlignment(SwingConstants.CENTER);
		btn64.setFont(new Font("Arial", Font.BOLD, 20));
		btn64.setForeground(Color.BLACK);
		btn64.setBackground(Color.WHITE);
		btn64.setBounds(30, 290, 40, 40);
		frmSudoku.getContentPane().add(btn64);
		
		btn73 = new JTextField("");
		btn73.setHorizontalAlignment(SwingConstants.CENTER);
		btn73.setFont(new Font("Arial", Font.BOLD, 20));
		btn73.setForeground(Color.BLACK);
		btn73.setBackground(Color.WHITE);
		btn73.setBounds(30, 330, 40, 40);
		frmSudoku.getContentPane().add(btn73);
		
		btn38 = new JTextField("");
		btn38.setHorizontalAlignment(SwingConstants.CENTER);
		btn38.setFont(new Font("Arial", Font.BOLD, 20));
		btn38.setForeground(Color.BLACK);
		btn38.setBackground(Color.LIGHT_GRAY);
		btn38.setBounds(70, 170, 40, 40);
		frmSudoku.getContentPane().add(btn38);
		
		btn39 = new JTextField("");
		btn39.setHorizontalAlignment(SwingConstants.CENTER);
		btn39.setFont(new Font("Arial", Font.BOLD, 20));
		btn39.setForeground(Color.BLACK);
		btn39.setBackground(Color.LIGHT_GRAY);
		btn39.setBounds(110, 170, 40, 40);
		frmSudoku.getContentPane().add(btn39);
		
		btn40 = new JTextField("");
		btn40.setHorizontalAlignment(SwingConstants.CENTER);
		btn40.setFont(new Font("Arial", Font.BOLD, 20));
		btn40.setForeground(Color.BLACK);
		btn40.setBackground(Color.WHITE);
		btn40.setBounds(150, 170, 40, 40);
		frmSudoku.getContentPane().add(btn40);
		
		btn41 = new JTextField("");
		btn41.setHorizontalAlignment(SwingConstants.CENTER);
		btn41.setFont(new Font("Arial", Font.BOLD, 20));
		btn41.setForeground(Color.BLACK);
		btn41.setBackground(Color.WHITE);
		btn41.setBounds(190, 170, 40, 40);
		frmSudoku.getContentPane().add(btn41);
		
		btn42 = new JTextField("");
		btn42.setHorizontalAlignment(SwingConstants.CENTER);
		btn42.setFont(new Font("Arial", Font.BOLD, 20));
		btn42.setForeground(Color.BLACK);
		btn42.setBackground(Color.WHITE);
		btn42.setBounds(230, 170, 40, 40);
		frmSudoku.getContentPane().add(btn42);
		
		btn43 = new JTextField("");
		btn43.setHorizontalAlignment(SwingConstants.CENTER);
		btn43.setFont(new Font("Arial", Font.BOLD, 20));
		btn43.setForeground(Color.BLACK);
		btn43.setBackground(Color.LIGHT_GRAY);
		btn43.setBounds(270, 170, 40, 40);
		frmSudoku.getContentPane().add(btn43);
		
		btn44 = new JTextField("");
		btn44.setHorizontalAlignment(SwingConstants.CENTER);
		btn44.setFont(new Font("Arial", Font.BOLD, 20));
		btn44.setForeground(Color.BLACK);
		btn44.setBackground(Color.LIGHT_GRAY);
		btn44.setBounds(310, 170, 40, 40);
		frmSudoku.getContentPane().add(btn44);
		
		btn47 = new JTextField("");
		btn47.setHorizontalAlignment(SwingConstants.CENTER);
		btn47.setFont(new Font("Arial", Font.BOLD, 20));
		btn47.setForeground(Color.BLACK);
		btn47.setBackground(Color.LIGHT_GRAY);
		btn47.setBounds(70, 210, 40, 40);
		frmSudoku.getContentPane().add(btn47);
		
		btn48 = new JTextField("");
		btn48.setHorizontalAlignment(SwingConstants.CENTER);
		btn48.setFont(new Font("Arial", Font.BOLD, 20));
		btn48.setForeground(Color.BLACK);
		btn48.setBackground(Color.LIGHT_GRAY);
		btn48.setBounds(110, 210, 40, 40);
		frmSudoku.getContentPane().add(btn48);
		
		btn49 = new JTextField("");
		btn49.setHorizontalAlignment(SwingConstants.CENTER);
		btn49.setFont(new Font("Arial", Font.BOLD, 20));
		btn49.setForeground(Color.BLACK);
		btn49.setBackground(Color.WHITE);
		btn49.setBounds(150, 210, 40, 40);
		frmSudoku.getContentPane().add(btn49);
		
		btn50 = new JTextField("");
		btn50.setHorizontalAlignment(SwingConstants.CENTER);
		btn50.setFont(new Font("Arial", Font.BOLD, 20));
		btn50.setForeground(Color.BLACK);
		btn50.setBackground(Color.WHITE);
		btn50.setBounds(190, 210, 40, 40);
		frmSudoku.getContentPane().add(btn50);
		
		btn51 = new JTextField("");
		btn51.setHorizontalAlignment(SwingConstants.CENTER);
		btn51.setFont(new Font("Arial", Font.BOLD, 20));
		btn51.setForeground(Color.BLACK);
		btn51.setBackground(Color.WHITE);
		btn51.setBounds(230, 210, 40, 40);
		frmSudoku.getContentPane().add(btn51);
		
		btn52 = new JTextField("");
		btn52.setHorizontalAlignment(SwingConstants.CENTER);
		btn52.setFont(new Font("Arial", Font.BOLD, 20));
		btn52.setForeground(Color.BLACK);
		btn52.setBackground(Color.LIGHT_GRAY);
		btn52.setBounds(270, 210, 40, 40);
		frmSudoku.getContentPane().add(btn52);
		
		btn53 = new JTextField("");
		btn53.setHorizontalAlignment(SwingConstants.CENTER);
		btn53.setFont(new Font("Arial", Font.BOLD, 20));
		btn53.setForeground(Color.BLACK);
		btn53.setBackground(Color.LIGHT_GRAY);
		btn53.setBounds(310, 210, 40, 40);
		frmSudoku.getContentPane().add(btn53);
		
		btn56 = new JTextField("");
		btn56.setHorizontalAlignment(SwingConstants.CENTER);
		btn56.setFont(new Font("Arial", Font.BOLD, 20));
		btn56.setForeground(Color.BLACK);
		btn56.setBackground(Color.WHITE);
		btn56.setBounds(70, 250, 40, 40);
		frmSudoku.getContentPane().add(btn56);
		
		btn57 = new JTextField("");
		btn57.setHorizontalAlignment(SwingConstants.CENTER);
		btn57.setFont(new Font("Arial", Font.BOLD, 20));
		btn57.setForeground(Color.BLACK);
		btn57.setBackground(Color.WHITE);
		btn57.setBounds(110, 250, 40, 40);
		frmSudoku.getContentPane().add(btn57);
		
		btn58 = new JTextField("");
		btn58.setHorizontalAlignment(SwingConstants.CENTER);
		btn58.setFont(new Font("Arial", Font.BOLD, 20));
		btn58.setForeground(Color.BLACK);
		btn58.setBackground(Color.LIGHT_GRAY);
		btn58.setBounds(150, 250, 40, 40);
		frmSudoku.getContentPane().add(btn58);
		
		btn59 = new JTextField("");
		btn59.setHorizontalAlignment(SwingConstants.CENTER);
		btn59.setFont(new Font("Arial", Font.BOLD, 20));
		btn59.setForeground(Color.BLACK);
		btn59.setBackground(Color.LIGHT_GRAY);
		btn59.setBounds(190, 250, 40, 40);
		frmSudoku.getContentPane().add(btn59);
		
		btn60 = new JTextField("");
		btn60.setHorizontalAlignment(SwingConstants.CENTER);
		btn60.setFont(new Font("Arial", Font.BOLD, 20));
		btn60.setForeground(Color.BLACK);
		btn60.setBackground(Color.LIGHT_GRAY);
		btn60.setBounds(230, 250, 40, 40);
		frmSudoku.getContentPane().add(btn60);
		
		btn61 = new JTextField("");
		btn61.setHorizontalAlignment(SwingConstants.CENTER);
		btn61.setFont(new Font("Arial", Font.BOLD, 20));
		btn61.setForeground(Color.BLACK);
		btn61.setBackground(Color.WHITE);
		btn61.setBounds(270, 250, 40, 40);
		frmSudoku.getContentPane().add(btn61);
		
		btn62 = new JTextField("");
		btn62.setHorizontalAlignment(SwingConstants.CENTER);
		btn62.setFont(new Font("Arial", Font.BOLD, 20));
		btn62.setForeground(Color.BLACK);
		btn62.setBackground(Color.WHITE);
		btn62.setBounds(310, 250, 40, 40);
		frmSudoku.getContentPane().add(btn62);
		
		btn65 = new JTextField("");
		btn65.setHorizontalAlignment(SwingConstants.CENTER);
		btn65.setFont(new Font("Arial", Font.BOLD, 20));
		btn65.setForeground(Color.BLACK);
		btn65.setBackground(Color.WHITE);
		btn65.setBounds(70, 290, 40, 40);
		frmSudoku.getContentPane().add(btn65);
		
		btn66 = new JTextField("");
		btn66.setHorizontalAlignment(SwingConstants.CENTER);
		btn66.setFont(new Font("Arial", Font.BOLD, 20));
		btn66.setForeground(Color.BLACK);
		btn66.setBackground(Color.WHITE);
		btn66.setBounds(110, 290, 40, 40);
		frmSudoku.getContentPane().add(btn66);
		
		btn67 = new JTextField("");
		btn67.setHorizontalAlignment(SwingConstants.CENTER);
		btn67.setFont(new Font("Arial", Font.BOLD, 20));
		btn67.setForeground(Color.BLACK);
		btn67.setBackground(Color.LIGHT_GRAY);
		btn67.setBounds(150, 290, 40, 40);
		frmSudoku.getContentPane().add(btn67);
		
		btn68 = new JTextField("");
		btn68.setHorizontalAlignment(SwingConstants.CENTER);
		btn68.setFont(new Font("Arial", Font.BOLD, 20));
		btn68.setForeground(Color.BLACK);
		btn68.setBackground(Color.LIGHT_GRAY);
		btn68.setBounds(190, 290, 40, 40);
		frmSudoku.getContentPane().add(btn68);
		
		btn69 = new JTextField("");
		btn69.setHorizontalAlignment(SwingConstants.CENTER);
		btn69.setFont(new Font("Arial", Font.BOLD, 20));
		btn69.setForeground(Color.BLACK);
		btn69.setBackground(Color.LIGHT_GRAY);
		btn69.setBounds(230, 290, 40, 40);
		frmSudoku.getContentPane().add(btn69);
		
		btn70 = new JTextField("");
		btn70.setHorizontalAlignment(SwingConstants.CENTER);
		btn70.setFont(new Font("Arial", Font.BOLD, 20));
		btn70.setForeground(Color.BLACK);
		btn70.setBackground(Color.WHITE);
		btn70.setBounds(270, 290, 40, 40);
		frmSudoku.getContentPane().add(btn70);
		
		btn71 = new JTextField("");
		btn71.setHorizontalAlignment(SwingConstants.CENTER);
		btn71.setFont(new Font("Arial", Font.BOLD, 20));
		btn71.setForeground(Color.BLACK);
		btn71.setBackground(Color.WHITE);
		btn71.setBounds(310, 290, 40, 40);
		frmSudoku.getContentPane().add(btn71);
		
		btn74 = new JTextField("");
		btn74.setHorizontalAlignment(SwingConstants.CENTER);
		btn74.setFont(new Font("Arial", Font.BOLD, 20));
		btn74.setForeground(Color.BLACK);
		btn74.setBackground(Color.WHITE);
		btn74.setBounds(70, 330, 40, 40);
		frmSudoku.getContentPane().add(btn74);
		
		btn75 = new JTextField("");
		btn75.setHorizontalAlignment(SwingConstants.CENTER);
		btn75.setFont(new Font("Arial", Font.BOLD, 20));
		btn75.setForeground(Color.BLACK);
		btn75.setBackground(Color.WHITE);
		btn75.setBounds(110, 330, 40, 40);
		frmSudoku.getContentPane().add(btn75);
		
		btn76 = new JTextField("");
		btn76.setHorizontalAlignment(SwingConstants.CENTER);
		btn76.setFont(new Font("Arial", Font.BOLD, 20));
		btn76.setForeground(Color.BLACK);
		btn76.setBackground(Color.LIGHT_GRAY);
		btn76.setBounds(150, 330, 40, 40);
		frmSudoku.getContentPane().add(btn76);
		
		btn77 = new JTextField("");
		btn77.setHorizontalAlignment(SwingConstants.CENTER);
		btn77.setFont(new Font("Arial", Font.BOLD, 20));
		btn77.setForeground(Color.BLACK);
		btn77.setBackground(Color.LIGHT_GRAY);
		btn77.setBounds(190, 330, 40, 40);
		frmSudoku.getContentPane().add(btn77);
		
		btn78 = new JTextField("");
		btn78.setHorizontalAlignment(SwingConstants.CENTER);
		btn78.setFont(new Font("Arial", Font.BOLD, 20));
		btn78.setForeground(Color.BLACK);
		btn78.setBackground(Color.LIGHT_GRAY);
		btn78.setBounds(230, 330, 40, 40);
		frmSudoku.getContentPane().add(btn78);
		
		btn79 = new JTextField("");
		btn79.setHorizontalAlignment(SwingConstants.CENTER);
		btn79.setFont(new Font("Arial", Font.BOLD, 20));
		btn79.setForeground(Color.BLACK);
		btn79.setBackground(Color.WHITE);
		btn79.setBounds(270, 330, 40, 40);
		frmSudoku.getContentPane().add(btn79);
		
		btn80 = new JTextField("");
		btn80.setHorizontalAlignment(SwingConstants.CENTER);
		btn80.setFont(new Font("Arial", Font.BOLD, 20));
		btn80.setForeground(Color.BLACK);
		btn80.setBackground(Color.WHITE);
		btn80.setBounds(310, 330, 40, 40);
		frmSudoku.getContentPane().add(btn80);
		
		btn9 = new JTextField("");
		btn9.setHorizontalAlignment(SwingConstants.CENTER);
		btn9.setFont(new Font("Arial", Font.BOLD, 20));
		btn9.setForeground(Color.BLACK);
		btn9.setBackground(Color.WHITE);
		btn9.setBounds(350, 10, 40, 40);
		frmSudoku.getContentPane().add(btn9);
		
		btn18 = new JTextField("");
		btn18.setHorizontalAlignment(SwingConstants.CENTER);
		btn18.setFont(new Font("Arial", Font.BOLD, 20));
		btn18.setForeground(Color.BLACK);
		btn18.setBackground(Color.WHITE);
		btn18.setBounds(350, 50, 40, 40);
		frmSudoku.getContentPane().add(btn18);
		
		btn27 = new JTextField("");
		btn27.setHorizontalAlignment(SwingConstants.CENTER);
		btn27.setFont(new Font("Arial", Font.BOLD, 20));
		btn27.setForeground(Color.BLACK);
		btn27.setBackground(Color.WHITE);
		btn27.setBounds(350, 90, 40, 40);
		frmSudoku.getContentPane().add(btn27);
		
		btn36 = new JTextField("");
		btn36.setHorizontalAlignment(SwingConstants.CENTER);
		btn36.setFont(new Font("Arial", Font.BOLD, 20));
		btn36.setForeground(Color.BLACK);
		btn36.setBackground(Color.LIGHT_GRAY);
		btn36.setBounds(350, 130, 40, 40);
		frmSudoku.getContentPane().add(btn36);
		
		btn45 = new JTextField("");
		btn45.setHorizontalAlignment(SwingConstants.CENTER);
		btn45.setFont(new Font("Arial", Font.BOLD, 20));
		btn45.setForeground(Color.BLACK);
		btn45.setBackground(Color.LIGHT_GRAY);
		btn45.setBounds(350, 170, 40, 40);
		frmSudoku.getContentPane().add(btn45);
		
		btn54 = new JTextField("");
		btn54.setHorizontalAlignment(SwingConstants.CENTER);
		btn54.setFont(new Font("Arial", Font.BOLD, 20));
		btn54.setForeground(Color.BLACK);
		btn54.setBackground(Color.LIGHT_GRAY);
		btn54.setBounds(350, 210, 40, 40);
		frmSudoku.getContentPane().add(btn54);
		
		btn63 = new JTextField("");
		btn63.setHorizontalAlignment(SwingConstants.CENTER);
		btn63.setFont(new Font("Arial", Font.BOLD, 20));
		btn63.setForeground(Color.BLACK);
		btn63.setBackground(Color.WHITE);
		btn63.setBounds(350, 250, 40, 40);
		frmSudoku.getContentPane().add(btn63);
		
		btn72 = new JTextField("");
		btn72.setHorizontalAlignment(SwingConstants.CENTER);
		btn72.setFont(new Font("Arial", Font.BOLD, 20));
		btn72.setForeground(Color.BLACK);
		btn72.setBackground(Color.WHITE);
		btn72.setBounds(350, 290, 40, 40);
		frmSudoku.getContentPane().add(btn72);
		
		btn81 = new JTextField("");
		btn81.setHorizontalAlignment(SwingConstants.CENTER);
		btn81.setFont(new Font("Arial", Font.BOLD, 20));
		btn81.setForeground(Color.BLACK);
		btn81.setBackground(Color.WHITE);
		btn81.setBounds(350, 330, 40, 40);
		frmSudoku.getContentPane().add(btn81);
		
		JLabel labelRow1 = new JLabel("1");
		labelRow1.setHorizontalAlignment(SwingConstants.CENTER);
		labelRow1.setFont(new Font("Arial", Font.BOLD, 12));
		labelRow1.setBounds(10, 10, 20, 40);
		frmSudoku.getContentPane().add(labelRow1);
		
		JLabel labelRow2 = new JLabel("2");
		labelRow2.setHorizontalAlignment(SwingConstants.CENTER);
		labelRow2.setFont(new Font("Arial", Font.BOLD, 12));
		labelRow2.setBounds(10, 50, 20, 40);
		frmSudoku.getContentPane().add(labelRow2);
		
		JLabel labelRow3 = new JLabel("3");
		labelRow3.setHorizontalAlignment(SwingConstants.CENTER);
		labelRow3.setFont(new Font("Arial", Font.BOLD, 12));
		labelRow3.setBounds(10, 90, 20, 40);
		frmSudoku.getContentPane().add(labelRow3);
		
		JLabel labelRow4 = new JLabel("4");
		labelRow4.setHorizontalAlignment(SwingConstants.CENTER);
		labelRow4.setFont(new Font("Arial", Font.BOLD, 12));
		labelRow4.setBounds(10, 130, 20, 40);
		frmSudoku.getContentPane().add(labelRow4);
		
		JLabel labelRow5 = new JLabel("5");
		labelRow5.setHorizontalAlignment(SwingConstants.CENTER);
		labelRow5.setFont(new Font("Arial", Font.BOLD, 12));
		labelRow5.setBounds(10, 170, 20, 40);
		frmSudoku.getContentPane().add(labelRow5);
		
		JLabel labelRow6 = new JLabel("6");
		labelRow6.setHorizontalAlignment(SwingConstants.CENTER);
		labelRow6.setFont(new Font("Arial", Font.BOLD, 12));
		labelRow6.setBounds(10, 210, 20, 40);
		frmSudoku.getContentPane().add(labelRow6);
		
		JLabel labelRow7 = new JLabel("7");
		labelRow7.setHorizontalAlignment(SwingConstants.CENTER);
		labelRow7.setFont(new Font("Arial", Font.BOLD, 12));
		labelRow7.setBounds(10, 250, 20, 40);
		frmSudoku.getContentPane().add(labelRow7);
		
		JLabel labelRow8 = new JLabel("8\r\n");
		labelRow8.setHorizontalAlignment(SwingConstants.CENTER);
		labelRow8.setFont(new Font("Arial", Font.BOLD, 12));
		labelRow8.setBounds(10, 290, 20, 40);
		frmSudoku.getContentPane().add(labelRow8);
		
		JLabel labelRow9 = new JLabel("9");
		labelRow9.setHorizontalAlignment(SwingConstants.CENTER);
		labelRow9.setFont(new Font("Arial", Font.BOLD, 12));
		labelRow9.setBounds(10, 330, 20, 40);
		frmSudoku.getContentPane().add(labelRow9);
		
		JLabel labelColumn1 = new JLabel("1");
		labelColumn1.setHorizontalAlignment(SwingConstants.CENTER);
		labelColumn1.setFont(new Font("Arial", Font.BOLD, 12));
		labelColumn1.setBounds(30, 370, 40, 20);
		frmSudoku.getContentPane().add(labelColumn1);
		
		JLabel labelColumn2 = new JLabel("2");
		labelColumn2.setHorizontalAlignment(SwingConstants.CENTER);
		labelColumn2.setFont(new Font("Arial", Font.BOLD, 12));
		labelColumn2.setBounds(70, 370, 40, 20);
		frmSudoku.getContentPane().add(labelColumn2);
		
		JLabel labelColumn3 = new JLabel("3");
		labelColumn3.setHorizontalAlignment(SwingConstants.CENTER);
		labelColumn3.setFont(new Font("Arial", Font.BOLD, 12));
		labelColumn3.setBounds(110, 370, 40, 20);
		frmSudoku.getContentPane().add(labelColumn3);
		
		JLabel labelColumn4 = new JLabel("4");
		labelColumn4.setHorizontalAlignment(SwingConstants.CENTER);
		labelColumn4.setFont(new Font("Arial", Font.BOLD, 12));
		labelColumn4.setBounds(150, 370, 40, 20);
		frmSudoku.getContentPane().add(labelColumn4);
		
		JLabel labelColumn5 = new JLabel("5");
		labelColumn5.setHorizontalAlignment(SwingConstants.CENTER);
		labelColumn5.setFont(new Font("Arial", Font.BOLD, 12));
		labelColumn5.setBounds(190, 370, 40, 20);
		frmSudoku.getContentPane().add(labelColumn5);
		
		JLabel labelColumn6 = new JLabel("6");
		labelColumn6.setHorizontalAlignment(SwingConstants.CENTER);
		labelColumn6.setFont(new Font("Arial", Font.BOLD, 12));
		labelColumn6.setBounds(230, 370, 40, 20);
		frmSudoku.getContentPane().add(labelColumn6);
		
		JLabel labelColumn7 = new JLabel("7");
		labelColumn7.setHorizontalAlignment(SwingConstants.CENTER);
		labelColumn7.setFont(new Font("Arial", Font.BOLD, 12));
		labelColumn7.setBounds(270, 370, 40, 20);
		frmSudoku.getContentPane().add(labelColumn7);
		
		JLabel labelColumn8 = new JLabel("8");
		labelColumn8.setHorizontalAlignment(SwingConstants.CENTER);
		labelColumn8.setFont(new Font("Arial", Font.BOLD, 12));
		labelColumn8.setBounds(310, 370, 40, 20);
		frmSudoku.getContentPane().add(labelColumn8);
		
		JLabel labelColumn9 = new JLabel("9");
		labelColumn9.setHorizontalAlignment(SwingConstants.CENTER);
		labelColumn9.setFont(new Font("Arial", Font.BOLD, 12));
		labelColumn9.setBounds(350, 370, 40, 20);
		frmSudoku.getContentPane().add(labelColumn9);
		
		btnOpen = new JButton("Open");
		btnOpen.setBackground(Color.WHITE);
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameButtonPress(btnOpen);
			}
		});
		btnOpen.setForeground(Color.BLACK);
		btnOpen.setFont(new Font("Arial", Font.BOLD, 15));
		btnOpen.setBounds(710, 180, 80, 30);
		frmSudoku.getContentPane().add(btnOpen);
		
		btnNewGame = new JButton("New");
		btnNewGame.setBackground(Color.WHITE);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameButtonPress(btnNewGame);
			}
		});
		btnNewGame.setForeground(Color.BLACK);
		btnNewGame.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewGame.setBounds(630, 180, 80, 30);
		frmSudoku.getContentPane().add(btnNewGame);
		
		btnClose = new JButton("Close");
		btnClose.setBackground(Color.WHITE);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameButtonPress(btnClose);
			}
		});
		btnClose.setForeground(Color.BLACK);
		btnClose.setFont(new Font("Arial", Font.BOLD, 15));
		btnClose.setBounds(790, 180, 80, 30);
		frmSudoku.getContentPane().add(btnClose);
		
		b1 = new JButton("1");
		b1.setBackground(Color.WHITE);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonPress(b1);
			}
		});
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("Arial", Font.BOLD, 24));
		b1.setBounds(720, 10, 50, 50);
		frmSudoku.getContentPane().add(b1);
		
		b2 = new JButton("2");
		b2.setBackground(Color.WHITE);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonPress(b2);
			}
		});
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("Arial", Font.BOLD, 24));
		b2.setBounds(770, 10, 50, 50);
		frmSudoku.getContentPane().add(b2);
		
		b3 = new JButton("3");
		b3.setBackground(Color.WHITE);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPress(b3);
			}
		});
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("Arial", Font.BOLD, 24));
		b3.setBounds(820, 10, 50, 50);
		frmSudoku.getContentPane().add(b3);
		
		b4 = new JButton("4");
		b4.setBackground(Color.WHITE);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPress(b4);
			}
		});
		b4.setForeground(Color.BLACK);
		b4.setFont(new Font("Arial", Font.BOLD, 24));
		b4.setBounds(720, 60, 50, 50);
		frmSudoku.getContentPane().add(b4);
		
		b5 = new JButton("5");
		b5.setBackground(Color.WHITE);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPress(b5);
			}
		});
		b5.setForeground(Color.BLACK);
		b5.setFont(new Font("Arial", Font.BOLD, 24));
		b5.setBounds(770, 60, 50, 50);
		frmSudoku.getContentPane().add(b5);
		
		b6 = new JButton("6");
		b6.setBackground(Color.WHITE);
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPress(b6);
			}
		});
		b6.setForeground(Color.BLACK);
		b6.setFont(new Font("Arial", Font.BOLD, 24));
		b6.setBounds(820, 60, 50, 50);
		frmSudoku.getContentPane().add(b6);
		
		b7 = new JButton("7");
		b7.setBackground(Color.WHITE);
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPress(b7);
			}
		});
		b7.setForeground(Color.BLACK);
		b7.setFont(new Font("Arial", Font.BOLD, 24));
		b7.setBounds(720, 110, 50, 50);
		frmSudoku.getContentPane().add(b7);
		
		b8 = new JButton("8");
		b8.setBackground(Color.WHITE);
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPress(b8);
			}
		});
		b8.setForeground(Color.BLACK);
		b8.setFont(new Font("Arial", Font.BOLD, 24));
		b8.setBounds(770, 110, 50, 50);
		frmSudoku.getContentPane().add(b8);
		
		b9 = new JButton("9");
		b9.setBackground(Color.WHITE);
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPress(b9);
			}
		});
		b9.setForeground(Color.BLACK);
		b9.setFont(new Font("Arial", Font.BOLD, 24));
		b9.setBounds(820, 110, 50, 50);
		frmSudoku.getContentPane().add(b9);
		
		btnCheck = new JButton("Check");
		btnCheck.setBackground(Color.WHITE);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameButtonPress(btnCheck);
			}
		});
		btnCheck.setForeground(Color.BLACK);
		btnCheck.setFont(new Font("Arial", Font.BOLD, 15));
		btnCheck.setBounds(710, 210, 80, 30);
		frmSudoku.getContentPane().add(btnCheck);
		
		btnSave = new JButton("Save");
		btnSave.setBackground(Color.WHITE);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameButtonPress(btnSave);	
			}
		});
		btnSave.setForeground(Color.BLACK);
		btnSave.setFont(new Font("Arial", Font.BOLD, 15));
		btnSave.setBounds(630, 210, 80, 30);
		frmSudoku.getContentPane().add(btnSave);
		
		btnHelp = new JButton("Help");
		btnHelp.setBackground(Color.WHITE);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameButtonPress(btnHelp);
			}
		});
		btnHelp.setForeground(Color.BLACK);
		btnHelp.setFont(new Font("Arial", Font.BOLD, 15));
		btnHelp.setBounds(790, 210, 80, 30);
		frmSudoku.getContentPane().add(btnHelp);
		
		fieldRow = new JTextField();
		fieldRow.setHorizontalAlignment(SwingConstants.CENTER);
		fieldRow.setForeground(Color.BLACK);
		fieldRow.setFont(new Font("Arial", Font.BOLD, 24));
		fieldRow.setBackground(Color.WHITE);
		fieldRow.setBounds(650, 10, 50, 50);
		frmSudoku.getContentPane().add(fieldRow);
		fieldRow.setColumns(10);
		
		fieldColumn = new JTextField();
		fieldColumn.setHorizontalAlignment(SwingConstants.CENTER);
		fieldColumn.setForeground(Color.BLACK);
		fieldColumn.setFont(new Font("Arial", Font.BOLD, 24));
		fieldColumn.setColumns(10);
		fieldColumn.setBackground(Color.WHITE);
		fieldColumn.setBounds(650, 60, 50, 50);
		frmSudoku.getContentPane().add(fieldColumn);
		
		fieldValue = new JTextField();
		fieldValue.setHorizontalAlignment(SwingConstants.CENTER);
		fieldValue.setForeground(Color.BLACK);
		fieldValue.setFont(new Font("Arial", Font.BOLD, 24));
		fieldValue.setColumns(10);
		fieldValue.setBackground(Color.WHITE);
		fieldValue.setBounds(650, 110, 50, 50);
		frmSudoku.getContentPane().add(fieldValue);
		
		JLabel labelRow = new JLabel("Row");
		labelRow.setHorizontalAlignment(SwingConstants.CENTER);
		labelRow.setFont(new Font("Arial", Font.BOLD, 12));
		labelRow.setBackground(Color.WHITE);
		labelRow.setBounds(600, 10, 50, 20);
		frmSudoku.getContentPane().add(labelRow);
		
		JLabel labelColumn = new JLabel("Column");
		labelColumn.setHorizontalAlignment(SwingConstants.CENTER);
		labelColumn.setFont(new Font("Arial", Font.BOLD, 12));
		labelColumn.setBackground(Color.WHITE);
		labelColumn.setBounds(600, 60, 50, 20);
		frmSudoku.getContentPane().add(labelColumn);
		
		JLabel labelValue = new JLabel("Value");
		labelValue.setHorizontalAlignment(SwingConstants.CENTER);
		labelValue.setFont(new Font("Arial", Font.BOLD, 12));
		labelValue.setBackground(Color.WHITE);
		labelValue.setBounds(600, 110, 50, 20);
		frmSudoku.getContentPane().add(labelValue);
		
		messageField = new JTextField();
		messageField.setForeground(Color.BLACK);
		messageField.setHorizontalAlignment(SwingConstants.CENTER);
		messageField.setFont(new Font("Arial", Font.BOLD, 24));
		messageField.setBackground(Color.WHITE);
		messageField.setBounds(630, 250, 240, 60);
		frmSudoku.getContentPane().add(messageField);
		messageField.setColumns(10);
		
		JLabel labelMessage = new JLabel("Message");
		labelMessage.setHorizontalAlignment(SwingConstants.CENTER);
		labelMessage.setForeground(Color.BLACK);
		labelMessage.setFont(new Font("Arial", Font.BOLD, 12));
		labelMessage.setBounds(630, 310, 100, 20);
		frmSudoku.getContentPane().add(labelMessage);
		
		rdbtnStepScanning = new JRadioButton("Step Scanning");
		rdbtnStepScanning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					//Delete original value before entering new one
					pst=conn.prepareStatement("delete from SystemConfig");
					pst.execute();
					pst.close();
					
					// Now enter new configuration
					pst=conn.prepareStatement("insert into SystemConfig values(?,?)");
					pst.setString(1, "Step Scanning");
					pst.setInt(2, 0);
					pst.execute();
					pst.close();
					
					// Load new system coonfig
					loadSystemConfig();
				} 
				catch (SQLException e) {	e.printStackTrace();	}
			}
		});
		rdbtnStepScanning.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnStepScanning.setBounds(601, 342, 109, 23);
		frmSudoku.getContentPane().add(rdbtnStepScanning);
		
		rdbtnSwitchAcess = new JRadioButton("Switch Acess");
		rdbtnSwitchAcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					//Delete original value before entering new one
					pst=conn.prepareStatement("delete from SystemConfig");
					pst.execute();
					pst.close();
					
					// Now enter new configuration
					pst=conn.prepareStatement("insert into SystemConfig values(?,?)");
					pst.setString(1, "Switch Acess Scanning");
					pst.setInt(2,Integer.parseInt(timeField.getText()));
					pst.execute();
					pst.close();
					
					// Load new system coonfig
					loadSystemConfig();
				} 
				catch (SQLException e) {	e.printStackTrace();	}
				
			}
		});
		rdbtnSwitchAcess.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnSwitchAcess.setBounds(761, 342, 109, 23);
		frmSudoku.getContentPane().add(rdbtnSwitchAcess);
		
		timeField = new JTextField();
		timeField.setFont(new Font("Arial", Font.BOLD, 12));
		timeField.setBounds(790, 390, 80, 20);
		frmSudoku.getContentPane().add(timeField);
		timeField.setColumns(10);
		
		JLabel lblEnterTimeIn = new JLabel("Enter Time in ms");
		lblEnterTimeIn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterTimeIn.setFont(new Font("Arial", Font.BOLD, 12));
		lblEnterTimeIn.setBounds(630, 390, 160, 20);
		frmSudoku.getContentPane().add(lblEnterTimeIn);
	}
}
