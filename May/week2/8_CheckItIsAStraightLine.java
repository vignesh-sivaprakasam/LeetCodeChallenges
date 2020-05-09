/*
        You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

                Example 1:
                Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
                Output: true

                Example 2:
                Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
                Output: false
                

                Constraints:
                *  2 <= coordinates.length <= 1000
                *  coordinates[i].length == 2
                *  -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
                *  coordinates contains no duplicate point.
*/

class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            int[] point1 = coordinates[0];
            int[] point2 = coordinates[1];
            int slope = findSlope(point1, point2);
            for(int i = 1; i < coordinates.length; i++){
                point2 = coordinates[i];
                int newSlope = findSlope(point1, point2);
                if(slope != newSlope){
                    return false;
                }
            }
            return true;
        }
        
        private int findSlope(int[] point1, int[] point2){
            if(point2[1] == point1[1]){
                return 0;
            }
            return (point2[0] - point1[0]) / (point2[1] - point1[1]);
        }
}