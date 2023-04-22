/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Task Strategy</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see de.wisag.automation.micas.rt.RtPackage#getRtTaskStrategy()
 * @model
 * @generated
 */
public enum RtTaskStrategy implements Enumerator {
    /**
     * The '<em><b>CYCL</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #CYCL_VALUE
     * @generated
     * @ordered
     */
    CYCL(0, "CYCL", "CYCL"),

    /**
     * The '<em><b>EVNT</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #EVNT_VALUE
     * @generated
     * @ordered
     */
    EVNT(1, "EVNT", "EVNT"),

    /**
     * The '<em><b>BACK</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #BACK_VALUE
     * @generated
     * @ordered
     */
    BACK(2, "BACK", "BACK"),

    /**
     * The '<em><b>INIT</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #INIT_VALUE
     * @generated
     * @ordered
     */
    INIT(3, "INIT", "INIT");

    /**
     * The '<em><b>CYCL</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CYCL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #CYCL
     * @model
     * @generated
     * @ordered
     */
    public static final int CYCL_VALUE = 0;

    /**
     * The '<em><b>EVNT</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>EVNT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #EVNT
     * @model
     * @generated
     * @ordered
     */
    public static final int EVNT_VALUE = 1;

    /**
     * The '<em><b>BACK</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>BACK</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #BACK
     * @model
     * @generated
     * @ordered
     */
    public static final int BACK_VALUE = 2;

    /**
     * The '<em><b>INIT</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>INIT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #INIT
     * @model
     * @generated
     * @ordered
     */
    public static final int INIT_VALUE = 3;

    /**
     * An array of all the '<em><b>Task Strategy</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static final RtTaskStrategy[] VALUES_ARRAY = new RtTaskStrategy[] { CYCL, EVNT, BACK, INIT, };

    /**
     * A public read-only list of all the '<em><b>Task Strategy</b></em>'
     * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final List<RtTaskStrategy> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Task Strategy</b></em>' literal with the specified
     * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param literal
     *            the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static RtTaskStrategy get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            RtTaskStrategy result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Task Strategy</b></em>' literal with the specified
     * name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param name
     *            the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static RtTaskStrategy getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            RtTaskStrategy result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Task Strategy</b></em>' literal with the specified
     * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static RtTaskStrategy get(int value) {
        switch (value) {
        case CYCL_VALUE:
            return CYCL;
        case EVNT_VALUE:
            return EVNT;
        case BACK_VALUE:
            return BACK;
        case INIT_VALUE:
            return INIT;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    private RtTaskStrategy(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string
     * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }

} // RtTaskStrategy
