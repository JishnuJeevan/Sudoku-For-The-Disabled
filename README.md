# Sudoku-For-The-Disabled
A GUI Sudoku that can be played using step or switch access scanning
## Abstract
This is a sudoku game that can be played by a single player. But instead of going to a particular cell and typing in the number, we type the number using step scanning or switch access scanning[1]. These kinds of scanning methods are used by people with movement disablilties for communication. I have implemented this scanning method to show how it can be used to play grid like games like sudoku. It may also be extened to play other grid like games like chess, go etc. In step scanning the highlighting of cells is done by the right mouse button and the selection of the cells is done by the left mouse button. In switch access scanning the highlighting of the cell happens after every time step (usually 1 second or 2) and the selection is done by a single mouse button (here I have used the left mouse button).
## Prerequisites
In order for the following program to work, make sure you have done the following: <br>
1. Make sure you have Net Beans or Eclipse IDE for Java Installed.
2. For this SQLiteConnection.java class to work do the following. <br>
2.1. In the "jarfiles" folder there will be "sqlite-jdbc-3.16.1.jar" folder. <br>
2.2. Configure JRE System Library and add the "sqlite-jdbc-3.16.1.jar" file to the JRE System library. <br>
## Instructions
1. All button in the game can be navigated using step or switch access scanning. 
2. The only thing that can't be done is change from step scanning to switch scanning or vise versa. This has to be done manually using the mouse. Also if you want to change the switch access scanning time, you need to do that manually also.
3. To enter a value in a cell, use step or switch access scanning to enter (row, column, number) values and the game will automatically put the number that you have enterd into the appropriate cell. After entering row the cursor will move to column grid, then it will move to the value grid. Once all three values have been entered, the value is entered in the cell.
4. The new game button is used to create a new game. 
5. The open button is used to open an existing game. 
6. Close is used to close the game.
7. Save is used to save the current state of the game.
8. Check is used to check if the solution you have enterd is correct. This should be done after the entire grids is filled. If it is correct a message "Sudoku Solved" will be displayed. If it is not correct a message "Sudoku not solved" will be displayed.
9. Help is used to provide help. If help is pressed once, a cell is automatically filled by the program making the game a bit easier.
## Reference
1. https://en.wikipedia.org/wiki/Switch_access_scanning
2. Code for solving sudoku using backtracking: https://github.com/murat-aka/Sudoku/blob/master/src/sudoku/Sudoku.java
