package mid2.collection.map.test.member;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MemberRepository {
    private static final Map<String, Member> memberMap = new HashMap<>();

    public void save(Member member) {
        memberMap.put(member.getId(), member);
    }

    public Member findById(String id) {
        return memberMap.get(id);
    }

    public Member findByName(String name) {
        for (Member member : memberMap.values()) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public void remove(String id) {
        memberMap.remove(id);
    }
}
