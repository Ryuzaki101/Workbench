package de.wisag.automation.micas.module.ui.forms;

import org.eclipse.gef.dnd.SimpleObjectTransfer;

public final class ModuleDiagramTransferType extends SimpleObjectTransfer {

    private static final ModuleDiagramTransferType INSTANCE = new ModuleDiagramTransferType();
    private static final String TYPE_NAME = ModuleDiagramTransferType.class.getName();
    private static final int TYPEID = registerType(TYPE_NAME);

    private ModuleDiagramTransferType() {
    }

    /**
     * Returns the singleton instance
     *
     * @return the singleton
     */
    public static ModuleDiagramTransferType getInstance() {
        return INSTANCE;
    }

    /**
     * Returns the <i>moduleDiagram</i> object.
     *
     * @return the moduleDiagram
     */
    public Object getModuleDiagram() {
        return getObject();
    }

    /**
     * @see org.eclipse.swt.dnd.Transfer#getTypeIds()
     */
    @Override
    protected int[] getTypeIds() {
        return new int[] { TYPEID };
    }

    /**
     * @see org.eclipse.swt.dnd.Transfer#getTypeNames()
     */
    @Override
    protected String[] getTypeNames() {
        return new String[] { TYPE_NAME };
    }

    /**
     * Sets the <i>moduleDiagram</i> Object.
     *
     * @param moduleDiagram
     *            the moduleDiagram
     */
    public void setModuleDiagram(Object moduleDiagram) {
        setObject(moduleDiagram);
    }

}