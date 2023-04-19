package practice.twoDimensionalArray;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';


    public static char[][] getTwoDimensionalArray(int size) {

        char [][] symbols = new char[size][size];
        for(int i = 0; i < symbols.length; i++){
            for (int j = 0; j < symbols[i].length; j++) {
                if (j == i || j == symbols.length - 1 - i) {
                    symbols[i][j] = SYMBOL;
                } else {
                    symbols[i][j] = ' ';
                }
            }
        }
        return symbols;
    }
}

//TODO: Написать метод, который создаст двумерный массив char заданного размера.
// массив должен содержать символ SYMBOL по диагоналям, пример для size = 3
// [X,  , X]
// [ , X,  ]
// [X,  , X]
