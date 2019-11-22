package sudokugame;

// This class is used to perform the Switch Access Scanning function.

import java.awt.Color;
import javax.swing.JButton;

public class SwitchAcessScanning 
{
	private static int row=0,coloumn=-1;
	
	// Highlight row 1
	public static void row1()
	{
		Main.btnSave.setBackground(Color.WHITE);	Main.btnCheck.setBackground(Color.WHITE);	Main.btnHelp.setBackground(Color.WHITE);
		Main.b1.setBackground(Color.YELLOW);	Main.b2.setBackground(Color.YELLOW);	Main.b3.setBackground(Color.YELLOW);
	}
	
	// Highlight row 2
	public static void row2()
	{
		Main.b1.setBackground(Color.WHITE);	Main.b2.setBackground(Color.WHITE);	Main.b3.setBackground(Color.WHITE);
		Main.b4.setBackground(Color.YELLOW);	Main.b5.setBackground(Color.YELLOW);	Main.b6.setBackground(Color.YELLOW);
	}
	
	// Highlight row 3
	public static void row3()
	{
		Main.b4.setBackground(Color.WHITE);	Main.b5.setBackground(Color.WHITE);	Main.b6.setBackground(Color.WHITE);
		Main.b7.setBackground(Color.YELLOW);	Main.b8.setBackground(Color.YELLOW);	Main.b9.setBackground(Color.YELLOW);
	}
	
	// Highlight row 4
	public static void row4()
	{
		Main.b7.setBackground(Color.WHITE);	Main.b8.setBackground(Color.WHITE);	Main.b9.setBackground(Color.WHITE);
		Main.btnNewGame.setBackground(Color.YELLOW);	Main.btnOpen.setBackground(Color.YELLOW);	Main.btnClose.setBackground(Color.YELLOW);
	}
	
	// Highlight row 5
	public static void row5()
	{
		Main.btnNewGame.setBackground(Color.WHITE);	Main.btnOpen.setBackground(Color.WHITE);	Main.btnClose.setBackground(Color.WHITE);
		Main.btnSave.setBackground(Color.YELLOW);	Main.btnCheck.setBackground(Color.YELLOW);	Main.btnHelp.setBackground(Color.YELLOW);
	}
	
	// Highlight button 1
	public static void b1()	
	{	
		Main.b1.setBackground(Color.YELLOW); Main.b2.setBackground(Color.WHITE); Main.b3.setBackground(Color.WHITE);	
	}
	
	// Highlight button 4
	public static void b4()	
	{	
		Main.b4.setBackground(Color.YELLOW); Main.b5.setBackground(Color.WHITE); Main.b6.setBackground(Color.WHITE);	
	}
	
	// Highlight button 7
	public static void b7()	
	{	
		Main.b7.setBackground(Color.YELLOW); Main.b8.setBackground(Color.WHITE); Main.b9.setBackground(Color.WHITE);	
	}
	
	// Highlight new game button
	public static void btnNewGame()	
	{	
		Main.btnNewGame.setBackground(Color.YELLOW); Main.btnOpen.setBackground(Color.WHITE); Main.btnClose.setBackground(Color.WHITE);	
	}
	
	// Highlight save button
	public static void btnSave() 
	{	
		Main.btnSave.setBackground(Color.YELLOW); Main.btnCheck.setBackground(Color.WHITE); Main.btnHelp.setBackground(Color.WHITE);	
	}
	
	// After the button is selected, reset the variables used for scanning.
	public static void reset(JButton btn)
	{	
		row=0;
		coloumn=-1;
		btn.setBackground(Color.white);	
	}
	
	public static void highlighting()
	{
		while(true)
		{
			//****************ROW HIGHLIGHTITNG***************************
			if(row==5&&coloumn==-1)row=0;
			if(row==0&&coloumn==-1)
			{	row1();	row++;	break;	}
			
			else if(row==1&&coloumn==-1)
			{	row2(); row++; break;	}
			
			else if(row==2&&coloumn==-1)
			{	row3(); row++; break;	}
			
			else if(row==3&&coloumn==-1)
			{	row4(); row++; break;	}
			
			else if(row==4&&coloumn==-1)
			{	row5(); row++; break;	}
			//************************************************************
			
			
			//******************COLOUMN OF ROW 1 *************************
			if(row==1&&coloumn==3)coloumn=0;
			if(row==1&&coloumn==0)	//b1
			{	b1();	coloumn++;	break;	}
			else if(row==1&&coloumn==1)//b2
			{	Main.b1.setBackground(Color.white);Main.b2.setBackground(Color.YELLOW);	coloumn++;	break;	}
			else if(row==1&&coloumn==2)//b3
			{	Main.b2.setBackground(Color.white);Main.b3.setBackground(Color.YELLOW);	coloumn++;	break;	}
			//*****************************************************************
			

			//******************COLOUMN OF ROW 2 *************************
			if(row==2&&coloumn==3)coloumn=0;
			if(row==2&&coloumn==0)	//b4
			{	b4();	coloumn++;	break;	}
			else if(row==2&&coloumn==1)//b5
			{	Main.b4.setBackground(Color.white);Main.b5.setBackground(Color.YELLOW);	coloumn++;	break;	}
			else if(row==2&&coloumn==2)//b6
			{	Main.b5.setBackground(Color.white);Main.b6.setBackground(Color.YELLOW);	coloumn++;	break;	}
			//*****************************************************************
			

			//******************COLOUMN OF ROW 3 *************************
			if(row==3&&coloumn==3)coloumn=0;
			if(row==3&&coloumn==0)	//b7
			{	b7();	coloumn++;	break;	}
			else if(row==3&&coloumn==1)//b8
			{	Main.b7.setBackground(Color.white);Main.b8.setBackground(Color.YELLOW);	coloumn++;	break;	}
			else if(row==3&&coloumn==2)//b9
			{	Main.b8.setBackground(Color.white);Main.b9.setBackground(Color.YELLOW);	coloumn++;	break;	}
			//*****************************************************************
			

			//******************COLOUMN OF ROW 4 *************************
			if(row==4&&coloumn==3)coloumn=0;
			if(row==4&&coloumn==0)	//btnNewGame
			{	btnNewGame();	coloumn++;	break;	}
			else if(row==4&&coloumn==1)//btnOpen
			{	Main.btnNewGame.setBackground(Color.white);Main.btnOpen.setBackground(Color.YELLOW);	coloumn++;	break;	}
			else if(row==4&&coloumn==2)//btnClose
			{	Main.btnOpen.setBackground(Color.white);Main.btnClose.setBackground(Color.YELLOW);	coloumn++;	break;	}
			//*****************************************************************
			

			//******************COLOUMN OF ROW 5 *************************
			if(row==5&&coloumn==3)coloumn=0;
			if(row==5&&coloumn==0)	//btnSave
			{	btnSave();	coloumn++;	break;	}
			else if(row==5&&coloumn==1)//btnCheck
			{	Main.btnSave.setBackground(Color.white);Main.btnCheck.setBackground(Color.YELLOW);	coloumn++;	break;	}
			else if(row==5&&coloumn==2)//btnHelp
			{	Main.btnCheck.setBackground(Color.white);Main.btnHelp.setBackground(Color.YELLOW);	coloumn++;	break;	}
			//*****************************************************************
			
			break;
		}
	}
	
	public static void selection()
	{
		while(true)
		{
			//****************ROW SELECTION*****************************************
			if(row==1&&coloumn==-1)//ROW1
			{	coloumn++;	break;	}
			else if(row==2&&coloumn==-1)//ROW2
			{	coloumn++;	break;	}
			else if(row==3&&coloumn==-1)//ROW3
			{	coloumn++;	break;	}
			else if(row==4&&coloumn==-1)//ROW4
			{	coloumn++;	break;	}
			else if(row==5&&coloumn==-1)//ROW4
			{	coloumn++;	break;	}
			//*********************************************************************
			
			//******************COLOUMN SELECTION OF ROW1**********************************
			if(row==1&&coloumn==1)//b1
			{	Main.buttonPress(Main.b1);	reset(Main.b1);	break;	}
			if(row==1&&coloumn==2)//b2
			{	Main.buttonPress(Main.b2);	reset(Main.b2);	break;	}
			if(row==1&&coloumn==3)//b3
			{	Main.buttonPress(Main.b3);	reset(Main.b3);	break;	}			
			//****************************************************************
			
			//******************COLOUMN SELECTION OF ROW2**********************************
			if(row==2&&coloumn==1)//b4
			{	Main.buttonPress(Main.b4);	reset(Main.b4);	break;	}
			if(row==2&&coloumn==2)//b5
			{	Main.buttonPress(Main.b5);	reset(Main.b5);	break;	}
			if(row==2&&coloumn==3)//b6
			{	Main.buttonPress(Main.b6);	reset(Main.b6);	break;	}
			//****************************************************************
			
			//******************COLOUMN SELECTION OF ROW3**********************************
			if(row==3&&coloumn==1)//b7
			{	Main.buttonPress(Main.b7);	reset(Main.b7);	break;	}
			if(row==3&&coloumn==2)//b8
			{	Main.buttonPress(Main.b8);	reset(Main.b8);	break;	}
			if(row==3&&coloumn==3)//b9
			{	Main.buttonPress(Main.b9);	reset(Main.b9);	break;	}
			//****************************************************************
			
			//******************COLOUMN SELECTION OF ROW4**********************************
			if(row==4&&coloumn==1)//btnNewGame
			{	Main.gameButtonPress(Main.btnNewGame);	reset(Main.btnNewGame);	break;	}
			if(row==4&&coloumn==2)//btnOpen
			{	Main.gameButtonPress(Main.btnOpen);	reset(Main.btnOpen);	break;	}
			if(row==4&&coloumn==3)//btnClose
			{	Main.gameButtonPress(Main.btnClose);	reset(Main.btnClose);	break;	}
			//****************************************************************
			
			//******************COLOUMN SELECTION OF ROW5**********************************
			if(row==5&&coloumn==1)//btnSave
			{	Main.gameButtonPress(Main.btnSave);	reset(Main.btnSave);	break;	}
			if(row==5&&coloumn==2)//btnCheck
			{	Main.gameButtonPress(Main.btnCheck);	reset(Main.btnCheck);	Main.selected="Check";	break;	}
			if(row==5&&coloumn==3)//btnHelp
			{	Main.gameButtonPress(Main.btnHelp);	reset(Main.btnHelp);	break;	}
			//****************************************************************
			break;
		}
		Main.ans=false;
	}
}
