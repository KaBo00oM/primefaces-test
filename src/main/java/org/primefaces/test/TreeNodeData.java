package org.primefaces.test;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author pr
 */
@Data
@AllArgsConstructor
public class TreeNodeData {

    private String level;
    private String cxParent;
    private String uuid;
}
