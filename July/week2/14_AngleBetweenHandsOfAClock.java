/*
        Given two numbers, hour and minutes. 
        Return the smaller angle (in degrees) formed between the hour and the minute hand.

        Example 1:
        Input: hour = 12, minutes = 30
        Output: 165

        Example 2:
        Input: hour = 3, minutes = 30
        Output: 75

        Example 3:
        Input: hour = 3, minutes = 15
        Output: 7.5

        Example 4:
        Input: hour = 4, minutes = 50
        Output: 155

        Example 5:
        Input: hour = 12, minutes = 0
        Output: 0
        

        Constraints:

                1 <= hour <= 12
                0 <= minutes <= 59
                Answers within 10^-5 of the actual value will be accepted as correct.
*/
class Solution {
        public double angleClock(int hour, int minutes) {
                // hour hand takes 12 hours to complete 360 deg
                // so 360/12 = 30 deg per hour and 30/60 = 0.5 deg per min
                double hourAngle = (hour * 30) + (minutes * 0.5);
                // minute hand takes 60 mins to complete 360
                // 360/60 = 6 deg per min
                double minAngle = minutes * 6; 
                double angle = Math.abs(hourAngle - minAngle);
                return angle > 180 ? 360.0 - angle : angle;
        }
}