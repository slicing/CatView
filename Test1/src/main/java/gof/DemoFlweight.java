package gof;

class Gazillion{
    private static int num = 0;
    private int col,row;
    Gazillion(int maxPerRow){
        row = num / maxPerRow;
        col = num % maxPerRow;
        num++;
    }

    void print(){
        System.out.print("  " +row + col);
    }

    static void makeMatrix(int rows,int cols){
        Gazillion[][] matrix = new Gazillion[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j =0;j<cols;j++){
                matrix[i][j] = new Gazillion(cols);
            }
        }
        printAll(rows,cols,matrix);
    }

    static void printAll(int rows,int cols,Gazillion[][] matrix){
        for (int i=0;i<rows;i++){
            for (int j =0;j<cols;j++){
                matrix[i][j].print();
            }
            System.out.println();
        }

    }
}


public class DemoFlweight {
    public static void main(String[] args) {
        Gazillion.makeMatrix(5,5);
    }
}
