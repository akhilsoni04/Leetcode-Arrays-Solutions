public class LongestRectangleMaxArea {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        long maxdiag = -1;
        long bestArea = 0;

        for(int [] rect: dimensions){
            long w = rect[0], h = rect[1];
            
            long d2 = w*w + h*h;
            long area = w*h;

            if(d2 > maxdiag){
                maxdiag = d2;
                bestArea =  area;
            }else if(d2 == maxdiag){
                bestArea = Math.max(bestArea, area);
            }
        }
        return (int)bestArea;
    }
}