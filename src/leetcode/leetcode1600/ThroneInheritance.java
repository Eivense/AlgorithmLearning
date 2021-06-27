package leetcode.leetcode1600;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * 1600. 皇位继承顺序
 *
 * https://leetcode-cn.com/problems/throne-inheritance/
 *
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 *
 *
 * @author Eivense
 * @date 2021/6/20 3:29 下午
 *
 */
public class ThroneInheritance {

    private String kingName;

    private Set<String> death = new HashSet<>();
    private Map<String, List<String>> tree = new HashMap<>();

    public ThroneInheritance(String kingName) {
        this.kingName=kingName;
        tree.put(kingName, new LinkedList<>());
    }

    public void birth(String parentName, String childName) {
        tree.get(parentName).add(childName);
        tree.put(childName, new LinkedList<>());
    }

    public void death(String name) {
        this.death.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        dfs(kingName, result);
        return result;
    }

    public void dfs(String name, List<String> result) {
        List<String> children = tree.get(name);
        if (children == null) {
            return;
        }
        if (!death.contains(name)) {
            result.add(name);
        }
        for (String child : children) {
            dfs(child, result);
        }
    }

    public static void main(String[] args) {
        ThroneInheritance t= new ThroneInheritance("king"); // 继承顺序：king
        t.birth("king", "clyde");
        t.death("king");
        t.birth("clyde", "shannon");
        t.getInheritanceOrder();
        t.birth("shannon", "scott");
        t.death ("clyde");
        t.getInheritanceOrder();


    }
}
