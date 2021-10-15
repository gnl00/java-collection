package com.demo.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * ConcreteMediator
 *
 * @author gnl
 */

public class ConcreteMediator implements Mediator {

    private Map<String, Colleague> colleagueMap;
    private Map<String, String> memberMap;

    public ConcreteMediator() {
        this.colleagueMap = new HashMap();
        this.memberMap = new HashMap();
    }

    @Override
    public void register(Colleague colleague, String name) {
        colleagueMap.put(name, colleague);

        if (colleague instanceof CommonMember) {
            memberMap.put("common", name);
        } else if (colleague instanceof  VipMember) {
            memberMap.put("vip", name);
        }

    }

    @Override
    public void getMessage(String colleagueName) {
        if (colleagueMap.get(colleagueName) instanceof CommonMember) {
            String member = memberMap.get("common");
            colleagueMap.get(member).sendText();
        }
        if (colleagueMap.get(colleagueName) instanceof VipMember) {
            String member = memberMap.get("vip");
            colleagueMap.get(member).sendText();
            colleagueMap.get(member).sendPicture();

        }
    }
}
