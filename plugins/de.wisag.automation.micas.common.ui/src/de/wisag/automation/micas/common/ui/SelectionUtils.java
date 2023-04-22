package de.wisag.automation.micas.common.ui;

import java.lang.reflect.Array;
import java.util.Iterator;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

public class SelectionUtils {
    public static <T> T singleSelection(Class<T> type, ISelection selection) {
        if (selection == null) {
            return null;
        }
        if (!(selection instanceof IStructuredSelection)) {
            return null;
        }

        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
        if (structuredSelection.isEmpty()) {
            return null;
        }
        Object value = structuredSelection.getFirstElement();
        if (!type.isInstance(value)) {
            return null;
        }
        return type.cast(value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] multiSelection(Class<T> type, ISelection selection) {
        if (selection == null) {
            return (T[]) Array.newInstance(type, 0);
        }
        if (!(selection instanceof IStructuredSelection)) {
            return (T[]) Array.newInstance(type, 0);
        }

        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
        if (structuredSelection.isEmpty()) {
            return (T[]) Array.newInstance(type, 0);
        }
        T[] elements = (T[]) Array.newInstance(type, structuredSelection.size());

        int i = 0;
        for (Iterator<?> it = structuredSelection.iterator(); it.hasNext();) {
            Object item = it.next();
            elements[i++] = type.isInstance(item) ? type.cast(item) : null;
        }
        return elements;
    }

    public static boolean isMulti(ISelection selection) {
        if (selection == null) {
            return false;
        }
        if (!(selection instanceof IStructuredSelection)) {
            return false;
        }
        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
        return structuredSelection.size() > 1;

    }

}
