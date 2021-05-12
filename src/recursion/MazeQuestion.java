package recursion;

//迷宫问题的解决
public class MazeQuestion {
    public static void main(String[] args) {

        int[][] map = new int[8][7];  //创建8行7列的二维数组
        //给迷宫的四周加上墙
        for(int i = 0;i < 7;i++) {   //让第0行和第7行变成1.行不变,列变
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for(int i = 0;i < 8;i++) {   //让第0列和第6列变成1.列不变,行变
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //将4行3列和4行2列设置为墙
        map[3][1] = 1;
        map[3][2] = 1;

        setWay(map,1,1);

        for(int i = 0;i < 8;i++) {
            for (int j = 0;j < 7;j++) {
                System.out.print(map[i][j] + "   ");
            }
            System.out.println("   ");
        }




    }

    /**
     * @param map 迷宫
     * @param i 表示位置坐标
     * @param j map[i][j]  从map[1][1]开始找,找到map[6][5]的最短路径为结束.
     *          约定map[i][j] = 0表示该点没有走过, = 1 表示墙 ;为2表示是通路; = 3表示该点已经走过但是走不通
     *          迷宫的行走策略 下-->右-->上-->左,如果走不通就回溯
     * @return
     */
    public static boolean setWay(int[][] map,int i,int j) {
        if(map[6][5] == 2) {  //表示已经找到通路,递归结束
            return true;
        } else {
            if(map[i][j] == 0) {
                map[i][j] = 2;
                if(setWay(map,i + 1,j)) {
                    return true;
                } else if (setWay(map,i,j + 1)) {
                    return true;
                } else if (setWay(map,i - 1,j)) {
                    return true;
                } else if (setWay(map,i ,j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }

        }

    }

}
