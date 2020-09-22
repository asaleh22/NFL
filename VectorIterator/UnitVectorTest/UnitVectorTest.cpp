#include "pch.h"
#include "CppUnitTest.h"
#include "../VectorIterator/myVector.h"

using namespace Microsoft::VisualStudio::CppUnitTestFramework;

namespace UnitVectorTest
{
	TEST_CLASS(UnitVectorTest)
	{
	public:
		
			//Test: removing first element correctly realligns vector
		TEST_METHOD(remove) {
			myVector<int> m;
			m.add(1, 2, 3, 4);

			m.remove(0); //remove index 0

			Assert::AreEqual(m[0], 2);
			
			m.reset();

			m.add(1, 2, 3, 4);

			m.remove(1); //remove index 0

			Assert::AreEqual(m[1], 3);
			
			m.reset();

			m.add(1, 2, 3, 4);

			m.remove(1);

			Assert::AreEqual(m.getSize(), size_t(3));
		
			m.reset();

			m.remove(0);
			m.remove(0);
			m.remove(0);
		
			try {
				m[0]; //should throw an error
				
				Assert::Fail();
				
			}
			catch (std::string e) {
				std::cout << "In test case: " << e << "\n";
			}
			catch (std::exception e) {
				std::cout << e.what();
			}
			
		}
		


		//test if an empty container correctly blocks a remove
			
		TEST_METHOD(removeAll) {
			myVector<int> m;
			m.add(1, 3, 2, 4, 4, 2, 1, 1);
			m.removeAll(2);
			Assert::AreEqual(m.contains(2), false);
		}

		TEST_METHOD(add) {
			myVector<int> m;
			m.add(1, 2, 3, 4);
			bool t = (m.contains(1) && m.contains(2) && m.contains(3) && m.contains(4));
			Assert::AreEqual(t, true);
		}
		
		TEST_METHOD(removeElement) {

			myVector<int> n;
			myVector<std::string> m;
			myVector<double> d;
			myVector<const char*> c;

			n.add(1, 2, 3, 4, 5);

			m.add(std::string("hi"), std::string("how"), std::string("goes"), std::string("it"));

//			d.add(1.2, 3.2, 4.2, 5.55);

//			c.add("my", "char", "vector");
			
		//	n.removeElement(4);
			
		//	m.removeElement(std::string("how"));

	//		d.removeElement(3.2);

		//	c.removeElement("char");

			bool t = !n.contains(3);

			Assert::AreEqual(t, false);
		}
	};
}
