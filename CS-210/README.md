### README.md

---

# Corner Grocer Item Tracking Program

This program is designed to help the Corner Grocer analyze the items purchased throughout the day and provide functionalities such as finding the frequency of specific items, printing the frequency of all items, and displaying a histogram of item frequencies.

### Files Included:
- **ItemCounter.h**: Header file containing the declaration of the `ItemCounter` class.
- **ItemCounter.cpp**: Implementation file containing the definitions of the `ItemCounter` class functions.
- **Main.cpp**: Main program file that uses the `ItemCounter` class to perform item tracking functionalities.
- **CS210_Project_Three_Input_File.txt**: Input file containing the list of items purchased.

### Usage Instructions:
1. **Compilation**:
   - Compile `ItemCounter.cpp` and `Main.cpp` files together:
     ```sh
     g++ ItemCounter.cpp Main.cpp -o GrocerItemTracker
     ```

2. **Running the Program**:
   - Execute the compiled program:
     ```sh
     ./GrocerItemTracker
     ```
   - Follow the menu options to:
     - Find the frequency of a specific item.
     - Print the frequency of all items.
     - Display a histogram of item frequencies.
     - Exit the program.

3. **Input File**:
   - Ensure that `CS210_Project_Three_Input_File.txt` is present in the same directory as the executable.
   - The input file should contain the list of items purchased, with each item on a separate line.

4. **Output**:
   - The program will display the results based on the chosen menu option:
     - Frequency of a specific item.
     - Frequency of all items.
     - Histogram of item frequencies.

5. **Backup Data**:
   - The program will create a backup file named `frequency.dat` with item frequencies for backup purposes.

### Additional Notes:
- The `ItemCounter` class is used to handle item counting and file operations.
- Input validation is not implemented in this version.
- Please make sure all source files (`ItemCounter.h`, `ItemCounter.cpp`, `Main.cpp`) are in the same directory.

---