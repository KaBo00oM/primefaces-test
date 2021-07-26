package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Data;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {
    
    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;

    private DefaultTreeNode root1;
    private DefaultTreeNode root2;
    
    @PostConstruct  
    public void init() {
        string = "Tree Table Test";
        initTree_1();
        initTree_2();
    }

    private void initTree_1(){
        root1 = new DefaultTreeNode(new TreeNodeData("Root", "-", UUID.randomUUID().toString()));

        DefaultTreeNode root1_lvl1_0 = new DefaultTreeNode(new TreeNodeData("Level 1", "root1", UUID.randomUUID()+"-0"), root1);
        DefaultTreeNode root1_lvl1_1 = new DefaultTreeNode(new TreeNodeData("Level 1", "root1", UUID.randomUUID()+"-1"), root1);

        new DefaultTreeNode(new TreeNodeData("Level 2", "root1_lvl1_0", UUID.randomUUID()+"-0"), root1_lvl1_0);
        new DefaultTreeNode(new TreeNodeData("Level 2", "root1_lvl1_0", UUID.randomUUID()+"-1"), root1_lvl1_0);

        new DefaultTreeNode(new TreeNodeData("Level 2", "root1_lvl1_1", UUID.randomUUID()+"-0"), root1_lvl1_1);
        new DefaultTreeNode(new TreeNodeData("Level 2", "root1_lvl1_1", UUID.randomUUID()+"-1"), root1_lvl1_1);

    }

    private void initTree_2() {
        root2 = new DefaultTreeNode(new TreeNodeData("Root", "-", UUID.randomUUID().toString()));

        DefaultTreeNode root2_lvl1_0 = new DefaultTreeNode(new TreeNodeData("Level 1", "root2", UUID.randomUUID()+"-0"), root2);
        new DefaultTreeNode(new TreeNodeData("Level 1", "root2", UUID.randomUUID()+"-1"), root2);
        new DefaultTreeNode(new TreeNodeData("Level 1", "root2", UUID.randomUUID()+"-2"), root2);

        List<TreeNode> treeNodeList_Children_0 = new ArrayList<>();
        treeNodeList_Children_0.add(new DefaultTreeNode(new TreeNodeData("Level 2", "root2_lvl1_0", UUID.randomUUID()+"-0")));
        treeNodeList_Children_0.add(new DefaultTreeNode(new TreeNodeData("Level 2", "root2_lvl1_0", UUID.randomUUID()+"-1")));

        root2_lvl1_0.setChildren(treeNodeList_Children_0);

    }

}
