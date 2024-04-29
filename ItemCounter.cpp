//
// Project Three: Corner Grocer
//
// Author: Cameron Chenault
//
// Date: 04/21/2024
//

#include "ItemCounter.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <algorithm>

using namespace std;

ItemCounter::ItemCounter() {}

void ItemCounter::countItemsFromFile(const string& filename) {
    // Opening file
    ifstream file(filename);
    // Throwing error if file does not open
    if (!file.is_open()) {
        cerr << "Unable to open file: " << filename << endl;
        return;
    }

    string item;
    while (getline(file, item)) {
        // Remove leading and trailing whitespaces
        item.erase(item.find_last_not_of(" \t\n\r\f\v") + 1);
        item.erase(0, item.find_first_not_of(" \t\n\r\f\v"));

        // Increment count
        itemCounts[item]++;
    }
    // Closing file
    file.close();
}
// Method to get frequency of items
int ItemCounter::getFrequencyOfItem(const string& item) {
    return itemCounts[item];
}
// Method for printing counts of all items
void ItemCounter::printAllItemCounts() const {
    for (const auto& pair : itemCounts) {
        cout << pair.first << " " << pair.second << endl;
    }
}
// Method for printing item histogram
void ItemCounter::printHistogram() const {
    for (const auto& pair : itemCounts) { // Auto is used to generate types of items
        cout << pair.first << " ";
        for (int i = 0; i < pair.second; ++i) {
            cout << "*";
        }
        cout << endl;
    }
}
// Method the wrirtes data to a .dat file
void ItemCounter::writeBackupToFile(const string& filename) const {
    // Opening file
    ofstream outFile(filename);
    // Throwing error if file does not open
    if (!outFile.is_open()) {
        cerr << "Unable to create backup file: " << filename << endl;
        return;
    }

    for (const auto& pair : itemCounts) {
        outFile << pair.first << " " << pair.second << endl;
    }
    // Closing file
    outFile.close();
}