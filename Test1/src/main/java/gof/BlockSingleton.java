package gof;

public class BlockSingleton {
    private static BlockSingleton instance;

    private BlockSingleton(){ };
    static {
        try {
            instance = new BlockSingleton();
        }catch (Exception e){
            throw new RuntimeException("woring .....");
        }
    }
    public static BlockSingleton blockSingleton(){
        return BlockSingleton.instance;
    }
}
class BlockSingletonDD{
    public static void main(String[] args) {
        BlockSingleton blockSingleton = BlockSingleton.blockSingleton();
        System.out.println(blockSingleton);
    }
}
