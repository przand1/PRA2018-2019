package quartz.scheduler;

import java.util.ArrayList;
import java.util.Collections;

public class HumanContainer {
    private ArrayList<Human> humanList;

    public HumanContainer() {
        humanList = new ArrayList<Human>();
    }
    public void addHuman(Human newHuman) {
        for (int i = 0; i < this.humanList.size(); i++) {
            if (this.humanList.get(i).getPesel() == newHuman.getPesel()) {
                this.humanList.set(i,newHuman);
                return;
            }
        }
    }

    public ArrayList<Human> getHumanList() {
        Collections.sort(this.humanList);
        return humanList;

    }
}
