edit : main.o huffman.o pQueue.o
	gcc -o edit main.o huffman.o pQueue.o

main.o : huffman.h main.cpp
	gcc -c main.cpp

pQueue.o : pQueue.cpp pQueue.h
	gcc -c pQueue.cpp

huffman.o : huffman.cpp huffman.h
	gcc -c huffman.cpp

clean :
	rm edit main.o pQueue.o huffman.o
