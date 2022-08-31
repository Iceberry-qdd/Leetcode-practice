#include <iostream>
#include <vector>
using namespace std;

int maxProduct(vector<int> &nums)
{
    int n1 = 0, n2 = 0, idx1 = -1;
    for (int i = 0; i < nums.size(); i++)
    {
        if (nums[i] > n1)
        {
            n1 = nums[i];
            idx1 = i;
        }
    }

    for (int i = 0; i < nums.size(); i++)
    {
        if (i == idx1) continue;
        n2 = nums[i] > n2 ? nums[i] : n2;
    }

    return (n1 - 1) * (n2 - 1);
}

int main()
{
    setlocale(LC_ALL, "chs");
    vector<int> arr;
    arr.push_back(3);
    arr.push_back(4);
    arr.push_back(5);
    arr.push_back(2);
    int result = maxProduct(arr);
    wprintf(L"结果为：%d", result);
    getchar();
}