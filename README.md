# Sujiko Puzzle Assistant

Sujiko is a puzzle which uses a 3x3 grid with 4 sum cells in the center of every 2x2 square inside grid (except the middle one). Digits from 1 to 9 should be placed inside each square so that the sum obtained must be the one inside sum cell.

The input file receives a 3x3 matrix and a list of 4 elements, where each sum is inside the square group of its index.

Main Design Patterns used were Singleton for the Grid, Command and Template. The code also respects the Model-View-Controller architecture.

In order to test the puzzle, you can use the files ending in _sujiko in the 'puzzle' folder. You can use 'Solve' mode, you can directly modify numbers in the grid and then ask the puzzle assistant so 'Solve', or you can 'Undo'/'Redo'/'Undo all'/'Redo all'/'Clear' operations.

Link: https://youtu.be/sJ7DJFTgwko
