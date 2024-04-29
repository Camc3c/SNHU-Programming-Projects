//
// Project Three: Corner Grocer
//
// Author: Cameron Chenault
//
// Date: 04/21/2024
//

#ifndef ITEMCOUNTER_H
#define ITEMCOUNTER_H

#include <map>
#include <string>

class ItemCounter {
private:
    std::map<std::string, int> itemCounts;

public:
    ItemCounter();

    void countItemsFromFile(const std::string& filename);

    int getFrequencyOfItem(const std::string& item);

    void printAllItemCounts() const;

    void printHistogram() const;

    void writeBackupToFile(const std::string& filename) const;
};

#endif