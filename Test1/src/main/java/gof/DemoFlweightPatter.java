package gof;
//享元模式
class Gazillion1{
    private static int num = 0;
    private int row,col;
    Gazillion1(int row){
        this.row = row;
    }

    void print(int col){
        System.out.print(" " + row + col);
    }
}

class FlyWeightFactory{
    private Gazillion1[] pool;
    public FlyWeightFactory(int maxRows){
        this.pool = new Gazillion1[maxRows];
    }

    public Gazillion1 getFlyWeight(int row){
        if(this.pool[row] == null){
            pool[row] = new Gazillion1(row);
        }
        return pool[row];
    }
}
public class DemoFlweightPatter {
    private static final int ROW = 5, COL = 10;
    public static void main(String[] args) {
        FlyWeightFactory flyWeightFactory = new FlyWeightFactory(ROW);
        for(int i = 0;i<ROW;i++){
            for(int j = 0;j<COL;j++){
                flyWeightFactory.getFlyWeight(i).print(j);
            }
            System.out.println();
        }
    }
}
