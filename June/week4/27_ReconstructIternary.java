/*
        Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
        reconstruct the itinerary in order. 
        All of the tickets belong to a man who departs from JFK. 
        Thus, the itinerary must begin with JFK.

        Note:

        1.      If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. 
                For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
        2.      All airports are represented by three capital letters (IATA code).
        3.      You may assume all tickets form at least one valid itinerary.
        4.      One must use all the tickets once and only once.

        Example 1:
        Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

        Example 2:
        Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
        Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
                But it is larger in lexical order.
*/

class Solution {
    
        private Map<String, List<String>> map = new HashMap();
        private List<String> route = new LinkedList();
        private int totalTickets = 0;
        private int usedTickets = 0;
        
        public List<String> findItinerary(List<List<String>> tickets) {
                if(tickets.size() == 0)
                        return route;
                //build graph
                for(int i = 0; i < tickets.size(); i++){
                        String source = tickets.get(i).get(0);
                        String dest   = tickets.get(i).get(1);
                        if(map.containsKey(source)){
                                map.get(source).add(dest); 
                        } else {
                                List<String> list = new LinkedList();
                                list.add(dest);
                                map.put(source, list);
                        }
                }
                
                //sort
                for(Map.Entry<String, List<String>> entry : map.entrySet()){
                        Collections.sort(entry.getValue());
                }
                
                totalTickets = tickets.size();
                route.add("JFK");
                dfs("JFK");
                return route;
        }
        
        private void dfs(String source){
                if(!map.containsKey(source)){
                        return;
                }
                List<String> list = map.get(source);
                int size = list.size();
                for(int i = 0 ; i < size; i++){
                        String dest = list.get(i);
                        
                        usedTickets++;
                        route.add(dest);
                        list.remove(i);
                        
                        dfs(dest);
                        
                        if(totalTickets == usedTickets) return;
                        usedTickets--;
                        route.remove(route.size() - 1);
                        list.add(i, dest);
                }
            
        }
        
}