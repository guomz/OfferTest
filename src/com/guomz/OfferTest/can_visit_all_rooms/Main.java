package com.guomz.OfferTest.can_visit_all_rooms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 *
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 *
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        room1.add(1);
        room1.add(3);
        List<Integer> room2 = new ArrayList<>();
        room2.add(3);
        room2.add(0);
        room2.add(1);
        List<Integer> room3 = new ArrayList<>();
        room3.add(2);
        List<Integer> room4 = new ArrayList<>();
        room4.add(0);

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);

        Main main = new Main();
        boolean result = main.canVisitAllRooms(rooms);
        System.out.println(result);
    }

    /**
     * 思路为深度优先遍历，创建一个数组记录每个房间是否被访问过
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms){

        if (rooms == null || rooms.size() == 0){
            return false;
        }

        boolean isVisited[] = new boolean[rooms.size()];
        Set<Integer> roomSet = new HashSet<>(rooms.size());
        dfs(0, rooms, isVisited, roomSet);
        if (roomSet.size() == rooms.size()){
            return true;
        }
        return false;
    }

    /**
     * 对房间的每个钥匙进行dfs，若当前钥匙对应的房间被访问过则跳过
     * @param roomIndex
     * @param rooms
     * @param isVisited
     * @param roomSet
     */
    private void dfs(int roomIndex, List<List<Integer>> rooms, boolean isVisited[], Set<Integer> roomSet){
        roomSet.add(roomIndex);
        List<Integer> roomKeys = rooms.get(roomIndex);
        for (int i = 0; i < roomKeys.size(); i ++){
            int nextRoom = roomKeys.get(i);
            if (isVisited[nextRoom] == true){
                continue;
            }
            isVisited[nextRoom] = true;
            dfs(nextRoom, rooms, isVisited, roomSet);
        }
        return;
    }
}
