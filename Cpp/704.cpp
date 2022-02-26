#include <iostream>
#include <vector>
using namespace std;
int search(vector<int> &nums, int target);

int main()
{
    vector<int> nums;
    nums.push_back(-1);
    nums.push_back(0);
    nums.push_back(3);
    nums.push_back(5);
    nums.push_back(9);
    nums.push_back(12);
    cout << search(nums, 2) << endl;
    return 0;
}

int search(vector<int> &nums, int target)
{
    int left = 0;
    int right = nums.size() - 1;
    while (left <= right)
    {
        int middle = (left + right) / 2;
        if (nums[middle] == target) return middle;
        if (nums[middle] < target) left = middle + 1;
        if (nums[middle] > target) right = middle - 1;
    }
    return -1;
}