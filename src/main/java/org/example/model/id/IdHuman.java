package org.example.model.id;

import org.example.model.Human;
import org.example.model.Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class IdHuman extends IdCreator{
    private final Tree <Human> tree;
    private String id;
    private Integer counter;
    {
        counter = 1;
    }

    public IdHuman(Tree<Human> tree, String id) {
        this.tree = tree;
        this.id = id;
    }

    @Override
    public String creatorId() {
        if (id.equals("")){
            while (true) {
                boolean flag = false;
                for (int i = 0; i < tree.getExistingIds().size(); i++) {
                    if (Integer.parseInt(new ArrayList<>(Arrays.asList(tree.getExistingIds().get(i)
                            .split(":")) ).get(1)) == counter) {
                        flag = true;
                    }
                }
                if (flag) {
                    counter++;
                } else {
                    return id = "id:" + counter;
                }
            }
        } else {
            return id;
        }
    }
}
