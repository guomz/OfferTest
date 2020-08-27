package com.guomz.OfferTest.find_Itinerary;

import java.util.*;

/**
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 * 说明:
 *
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 *
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 *
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {

        Main m = new Main();
        List<String> list1 = Arrays.asList("JFK","SFO");
        List<String> list2 = Arrays.asList("JFK","ATL");
        List<String> list3 = Arrays.asList("SFO","ATL");
        List<String> list4 = Arrays.asList("ATL","JFK");
        List<String> list5 = Arrays.asList("ATL","SFO");
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(list1);
        tickets.add(list2);
        tickets.add(list3);
        tickets.add(list4);
        tickets.add(list5);
        m.findItinerary(tickets);
    }

    Map<String, PriorityQueue<String>> ticketMap = new HashMap<>();
    LinkedList<String> wayPath = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0 || tickets.get(0).size() == 0){
            return new ArrayList<>();
        }

        for (List<String> strList: tickets){
            String start = strList.get(0);
            String end = strList.get(1);
            if (ticketMap.containsKey(start)){
                ticketMap.get(start).offer(end);
            }else {
                PriorityQueue<String> destPath = new PriorityQueue<>();
                destPath.offer(end);
                ticketMap.put(start, destPath);
            }
        }
        dfsWay("JFK");
        Collections.reverse(wayPath);
        return wayPath;
    }

    private void dfsWay(String position){
        //map不存在该节点则说明进入死路
        //若该节点的队列长度已经为空则说明循环回来后也走到了尽头，即机票全部遍历完成
        //由于题目说明肯定存在一条路径，所以死路一定是最后一个票
        while (ticketMap.containsKey(position) && ticketMap.get(position).size() > 0){
            String nextPos = ticketMap.get(position).poll();
            dfsWay(nextPos);
        }
        wayPath.add(position);
    }
}
