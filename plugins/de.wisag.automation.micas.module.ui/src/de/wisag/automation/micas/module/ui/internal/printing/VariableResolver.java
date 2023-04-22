package de.wisag.automation.micas.module.ui.internal.printing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.Maps;

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Task;

public class VariableResolver {

    public static final String PROJECTNAME_PROPERTY = "PROJECTNAME";
    public static final String PAGECOUNT_PROPERTY = "PAGECOUNT";
    public static final String PAGENUMBER_PROPERTY = "PAGENUMBER";
    public static final String FQN_PAGENUMBER_PROPERTY = "PAGE::PAGENUMBER";
    public static final String FILENAME_PROPERTY = "FILENAME";
    public static final String PAGE_PREFIX = "PAGE::";
    public static final String TASK_PREFIX = "TASK::";
    public static final String MODULE_PREFIX = "MODULE::";

    private final Module module;
    private final Page page;
    private Map<String, String> overrides = Maps.newHashMap();
    private final String fileName;
    private final String projectName;

    public VariableResolver(String projectName, String fileName, Page page) {
        this.fileName = fileName;
        this.projectName = projectName;
        this.module = page.getTask().getModule();
        this.page = page;
    }

    public VariableResolver(String projectName, String fileName, Module module) {
        this.projectName = projectName;
        this.fileName = fileName;
        this.module = module;
        this.page = null;
    }

    public VariableResolver setOverrides(Map<String, String> overrides) {
        this.overrides.putAll(overrides);
        return this;
    }

    public String getProperty(String key) {
        return get(key);
    }

    public String get(final String variableName) {
        if (variableName.startsWith("${")) {
            return variableName;
        }
        if (overrides.containsKey(variableName)) {
            return overrides.get(variableName);
        }

        if (PROJECTNAME_PROPERTY.equals(variableName)) {
            return projectName;
        } else if (FILENAME_PROPERTY.equals(variableName)) {
            return fileName;
        } else if (PAGECOUNT_PROPERTY.equals(variableName)) {
            int i = 0;
            EList<Task> tasks = module.getTasks();
            for (Task task : tasks) {
                i += task.getPages().size();
            }
            return String.format("%d", Integer.valueOf(i));
        } else if (page != null
                && (PAGENUMBER_PROPERTY.equals(variableName) || FQN_PAGENUMBER_PROPERTY.equals(variableName))) {
            int i = 0;
            EList<Task> tasks = module.getTasks();
            for (Task task : tasks) {
                i = task.getPages().indexOf(getPage()) + 1;
            }
            return String.format("%d", Integer.valueOf(i));
        } else if (page != null && variableName.startsWith(PAGE_PREFIX)) {
            EStructuralFeature feature = getPage().eClass()
                    .getEStructuralFeature(variableName.replace(PAGE_PREFIX, ""));
            if (feature != null) {
                return toString(getPage().eGet(feature));
            }
        } else if (page != null && variableName.startsWith(TASK_PREFIX)) {
            EStructuralFeature feature = getPage().getTask().eClass()
                    .getEStructuralFeature(variableName.replace(TASK_PREFIX, ""));
            if (feature != null) {
                return toString(getPage().getTask().eGet(feature));
            }

        } else if (variableName.startsWith(MODULE_PREFIX)) {
            EStructuralFeature feature = module.eClass().getEStructuralFeature(variableName.replace(MODULE_PREFIX, ""));
            if (feature != null) {
                return toString(module.eGet(feature));
            }
        }
        return String.format("UNKNOWN:%s", variableName);

    }

    String toString(Object objectValue) {
        if (objectValue != null && objectValue instanceof Number) {
            return String.format("%d", objectValue);
        } else if (objectValue != null && objectValue instanceof String) {
            return (String) objectValue;
        } else if (objectValue != null && objectValue instanceof org.eclipse.emf.common.util.Enumerator) {
            org.eclipse.emf.common.util.Enumerator en = (org.eclipse.emf.common.util.Enumerator) objectValue;
            return en.getLiteral();
        } else if (objectValue != null && objectValue instanceof Date) {
            Date date = (Date) objectValue;
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            return sdf.format(date);
        }
        return String.valueOf(objectValue);

    }

    public Page getPage() {
        return page;
    }

    public String getFileName() {
        return fileName;
    }

}
