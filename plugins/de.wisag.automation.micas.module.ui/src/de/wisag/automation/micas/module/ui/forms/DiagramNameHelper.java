package de.wisag.automation.micas.module.ui.forms;

import org.apache.commons.lang.StringUtils;

import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Task;

public class DiagramNameHelper {

    public static boolean isUniqueName(Task task, String name) {
        boolean unique = true;
        for (Page page : task.getPages()) {
            if (StringUtils.equalsIgnoreCase(name, page.getName())) {
                unique = false;
                break;
            }
        }
        return unique;
    }

}
