#pragma once

#include <iostream>
#include <algorithm>
#include <vector>
#include <exception>
template<typename T>
class myVector{

private:
	T* m_data = nullptr;
	
	size_t m_size = 0;
	size_t m_cap = 0;

public:

	myVector() {
		std::cout << "Allocated a space of two";
		ReAlloc(2);
	}	
	myVector(int cap) {
		std::cout << "Allocated a space of " << cap << std::endl;
		ReAlloc(cap);
	}

	~myVector() {
		std::cout << "Class destructor called\n";
		::operator delete(m_data, m_size * m_cap);
	}
	

	void ReAlloc(size_t newCapacity) {

		T* newBlock = (T*)::operator new(newCapacity * sizeof(T));
		
		for (size_t i = 0; i < m_size; ++i) {
			newBlock[i] = std::move(m_data[i]);
		}
				
		for (size_t i = 0; i < m_size; ++i) {
			m_data[i].~T();
		}

		::operator delete(m_data, m_cap * sizeof(T));

		m_data = newBlock;
		m_cap = newCapacity;
	}

	
	void add(T val) {
		if (m_size == m_cap) {
			ReAlloc(m_cap + 2);
			std::cout << "RECAPED for item " << val << "\n";
		}

		++m_size;
		m_data[m_size - 1] = val;
		

	}

	template<typename... Args>
	void add(T val, Args... args) {
		add(val);
		add(args...);
	}

	
	//remove index i;
	int remove(size_t index) {
		if (index < 0 || index >= m_size) 
			return -1;
	
		std::cout << "removing by index " << index << std::endl;

		size_t nxt;
		for (size_t i = index; i < m_size; ++i) {
			nxt = i + 1;
			if (nxt >= m_size)// next is now pointing to the last element of the resized vect
				break;
			m_data[i] = m_data[nxt];
		}
		m_data[m_size - 1].~T(); //delete last element
		m_size -= 1;
		return 0;
	}

	//remove a T value
	int removeElement(T value) {
		std::cout << "removing by element: " << value << "\n";
		int index = find(value);
		std::cout << "Element is at index: " << index << std::endl;

		if (index < 0)
			return -1;
	
		remove(size_t(index));
		return 0;
	}

	//remove all instances of an element
	
	void removeAll(T val) {
		while (removeElement(val) != -1) {
		};
	}



	//return index of an element. 
	size_t find(T value) {
		for (size_t i = 0; i < getSize(); ++i) {
			if (m_data[i] == value)
				return i;
		}
		return size_t(-1);
	}

	T* begin() const{
		return m_data;
	}	
	T* end()  const{
		return (m_data + m_size);
	}


	T& operator [] (int index) const {
		if (index < 0 || index >= m_size) 
			throw std::string("Out of bounds!");
		else
			return *(m_data + index);
		
	}

	void operator = (T val) {
		add(val);
	}	

	bool contains(const T& val) const {
		T* p = std::find(begin(), end(), val);
		if (p == end())
			return false;
		return true;

	}

	void reset() {

		for (size_t i = 0; i < m_size; ++i) {
			m_data[i].~T();
		}
		m_size = 0;
		
		ReAlloc(2);
	}

	//getters
	size_t getSize() const { return m_size; }

};