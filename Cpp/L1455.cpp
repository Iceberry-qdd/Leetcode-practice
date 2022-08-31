#include <stdlib.h>
#include <string.h>
#include <string>
#include <vector>
using namespace std;

vector<string> split(const string str)
{
    vector<string> words;
    int left = 0;
    for (int right = 0; right < str.size(); right++)
    {
        if (str[right] == ' ')
        {
            words.push_back(str.substr(left, right - left));
            left = right + 1;
        }
    }
    words.push_back(str.substr(left, str.size() - left));
    return words;
}

int isPrefixOfWord(string sentence, string searchWord)
{
    vector<string> words = split(sentence);
    for (int i = 0; i < words.size(); i++)
    {
        if (strncmp(words[i].c_str(), searchWord.c_str(), searchWord.size()) == 0)
        {
            return i + 1;
        }
    }
    return -1;
}

int main()
{
    printf("%d\n", isPrefixOfWord("i love eating burger", "burg"));
    return 0;
}