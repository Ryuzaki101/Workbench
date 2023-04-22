/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Hardware Type</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareType()
 * @model
 * @generated
 */
public enum HardwareType implements Enumerator {
    /**
     * The '<em><b>ACXX</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #ACXX_VALUE
     * @generated
     * @ordered
     */
    ACXX(0, "ACXX", "ACXX"),
    /**
     * The '<em><b>ZPXX</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #ZPXX_VALUE
     * @generated
     * @ordered
     */
    ZPXX(1, "ZPXX", "ZPXX"),

    /**
     * The '<em><b>ERXX</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #ERXX_VALUE
     * @generated
     * @ordered
     */
    ERXX(2, "ERXX", "ERXX"),
    /**
     * The '<em><b>MBXX</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #MBXX_VALUE
     * @generated
     * @ordered
     */
    MBXX(3, "MBXX", "MBXX"),
    /**
     * The '<em><b>XX20</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #XX20_VALUE
     * @generated
     * @ordered
     */
    XX20(4, "XX20", "XX20"),
    /**
     * The '<em><b>WSXX</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #WSXX_VALUE
     * @generated
     * @ordered
     */
    WSXX(5, "WSXX", "WSXX"),
    /**
     * The '<em><b>UNKNOWN</b></em>' literal object. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #UNKNOWN_VALUE
     * @generated
     * @ordered
     */
    UNKNOWN(-1, "UNKNOWN", "UNKNOWN");

    /**
     * The '<em><b>ACXX</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ACXX</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #ACXX
     * @model
     * @generated
     * @ordered
     */
    public static final int ACXX_VALUE = 0;

    /**
     * The '<em><b>ZPXX</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ZPXX</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #ZPXX
     * @model
     * @generated
     * @ordered
     */
    public static final int ZPXX_VALUE = 1;

    /**
     * The '<em><b>ERXX</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ERXX</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #ERXX
     * @model
     * @generated
     * @ordered
     */
    public static final int ERXX_VALUE = 2;

    /**
     * The '<em><b>MBXX</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>MBXX</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #MBXX
     * @model
     * @generated
     * @ordered
     */
    public static final int MBXX_VALUE = 3;

    /**
     * The '<em><b>XX20</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>XX20</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #XX20
     * @model
     * @generated
     * @ordered
     */
    public static final int XX20_VALUE = 4;

    /**
     * The '<em><b>WSXX</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>WSXX</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #WSXX
     * @model
     * @generated
     * @ordered
     */
    public static final int WSXX_VALUE = 5;

    /**
     * The '<em><b>UNKNOWN</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>UNKNOWN</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #UNKNOWN
     * @model
     * @generated
     * @ordered
     */
    public static final int UNKNOWN_VALUE = -1;

    /**
     * An array of all the '<em><b>Hardware Type</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static final HardwareType[] VALUES_ARRAY = new HardwareType[] { ACXX, ZPXX, ERXX, MBXX, XX20, WSXX,
            UNKNOWN, };

    /**
     * A public read-only list of all the '<em><b>Hardware Type</b></em>'
     * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final List<HardwareType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Hardware Type</b></em>' literal with the specified
     * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param literal
     *            the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static HardwareType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            HardwareType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Hardware Type</b></em>' literal with the specified
     * name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param name
     *            the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static HardwareType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            HardwareType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Hardware Type</b></em>' literal with the specified
     * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static HardwareType get(int value) {
        switch (value) {
        case ACXX_VALUE:
            return ACXX;
        case ZPXX_VALUE:
            return ZPXX;
        case ERXX_VALUE:
            return ERXX;
        case MBXX_VALUE:
            return MBXX;
        case XX20_VALUE:
            return XX20;
        case WSXX_VALUE:
            return WSXX;
        case UNKNOWN_VALUE:
            return UNKNOWN;
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
    private HardwareType(int value, String name, String literal) {
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

} // HardwareType
