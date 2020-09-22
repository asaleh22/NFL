
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
    m.add(1, 2, 3, 4, 5);
    int f = 8;

    f.~T();
   
    
}

