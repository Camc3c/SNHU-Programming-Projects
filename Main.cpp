//
// Project Three: Corner Grocer
//
// Author: Cameron Chenault
//
// Date: 04/21/2024
//

#include <iostream>
#include "ItemCounter.h"

using namespace std;

int main() {
    ItemCounter itemCounter;
    itemCounter.countItemsFromFile("CS210_Project_Three_Input_File.txt");

    // Do while function to choose option
    int choice;
    do {
        // Menu option
        cout << "\nMenu Options:\n";
        cout << "1. Find frequency of a specific item\n";
        cout << "2. Print frequency of all items\n";
        cout << "3. Print histogram of item frequency\n";
        cout << "4. Exit\n";
        cout << "Enter your choice (1-4): ";
        cin >> choice;

        switch (choice) {
            // Option 1
            case 1: {
                string itemToFind;
                cout << "Enter the item to find: ";
                cin.ignore();
                getline(cin, itemToFind);

                int frequency = itemCounter.getFrequencyOfItem(itemToFind);
                cout << "Frequency of '" << itemToFind << "': " << frequency << endl;
                break;
            }
            // Option 2
            case 2: {
                cout << "Frequency of all items:\n";
                itemCounter.printAllItemCounts();
                break;
            }
            // Option 3
            case 3: {
                cout << "Histogram of item frequency:\n";
                itemCounter.printHistogram();
                break;
            }
            // Option 4
            case 4:
                cout << "Exiting the program...\n";
                break;
            // Choice prompt
            default:
                cout << "Invalid choice. Please enter a number between 1 and 4.\n";
        }
    } while (choice != 4);

    // Backing up data
    itemCounter.writeBackupToFile("frequency.dat");

    return 0;
}