
package csc223.vn;
public class FUber {
    public static float euclidean(float x1, float y1, float x2, float y2) {
        float diffX = x2 - x1;
        float diffY = y2 - y1;
        return(float) Math.sqrt((diffX *diffX) + (diffY * diffY));
    }
    public static float manhattan(float x1, float y1, float x2, float y2) {
        float diffX = Math.abs(x2 - x1);
        float diffY = Math.abs(y2 - y1);
        return diffX + diffY;
    }
    public static void main(String[] args) {
        float x1 = 3, y1 = 4;
        float x2 = 7, y2 = 1;

        System.out.println("Euclidean distance: " + euclidean(x1, y1, x2, y2));
        System.out.println("Manhattan distance: " + manhattan(x1, y1, x2, y2));
    }
    
}
