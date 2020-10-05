
#include "myVector.h"

template<typename T>
void disp(const myVector<T>& obj) {
    for (size_t i = 0; i < obj.getSize(); ++i)
        std::cout << obj[i] << " ";
    std::cout << "\n";
}

int main()
{

    myVector<int> m;
    m.add(-1, 4, 44, 2, 434, 1, 3, 0);
    std::sort(m.begin(), m.end());
    disp(m);
    
}

