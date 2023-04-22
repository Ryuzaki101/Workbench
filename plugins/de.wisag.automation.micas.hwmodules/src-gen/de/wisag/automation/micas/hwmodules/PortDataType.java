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
 * '<em><b>Port Data Type</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getPortDataType()
 * @model
 * @generated
 */
public enum PortDataType implements Enumerator {
    /**
     * The '<em><b>WORD CONST</b></em>' literal object. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #WORD_CONST_VALUE
     * @generated
     * @ordered
     */
    WORD_CONST(0, "WORD_CONST", "WORD_CONST"),

    /**
     * The '<em><b>WORD VAR</b></em>' literal object. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #WORD_VAR_VALUE
     * @generated
     * @ordered
     */
    WORD_VAR(1, "WORD_VAR", "WORD_VAR"),

    /**
     * The '<em><b>FLOAT CONST</b></em>' literal object. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #FLOAT_CONST_VALUE
     * @generated
     * @ordered
     */
    FLOAT_CONST(2, "FLOAT_CONST", "FLOAT_CONST"),

    /**
     * The '<em><b>FLOAT VAR</b></em>' literal object. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #FLOAT_VAR_VALUE
     * @generated
     * @ordered
     */
    FLOAT_VAR(3, "FLOAT_VAR", "FLOAT_VAR"),

    /**
     * The '<em><b>FGA VALUE</b></em>' literal object. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #FGA_VALUE_VALUE
     * @generated
     * @ordered
     */
    FGA_VALUE(4, "FGA_VALUE", "FGA_VALUE"),

    /**
     * The '<em><b>FGA MESSAGE CONST</b></em>' literal object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #FGA_MESSAGE_CONST_VALUE
     * @generated
     * @ordered
     */
    FGA_MESSAGE_CONST(5, "FGA_MESSAGE_CONST", "FGA_MESSAGE_CONST"),

    /**
     * The '<em><b>FGA MEASURED VALUE</b></em>' literal object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #FGA_MEASURED_VALUE_VALUE
     * @generated
     * @ordered
     */
    FGA_MEASURED_VALUE(6, "FGA_MEASURED_VALUE", "FGA_MEASURED_VALUE"),

    /**
     * The '<em><b>FGA ANALOG VALUE</b></em>' literal object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #FGA_ANALOG_VALUE_VALUE
     * @generated
     * @ordered
     */
    FGA_ANALOG_VALUE(7, "FGA_ANALOG_VALUE", "FGA_ANALOG_VALUE"),

    /**
     * The '<em><b>DIRECT VALUE</b></em>' literal object. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #DIRECT_VALUE_VALUE
     * @generated
     * @ordered
     */
    DIRECT_VALUE(8, "DIRECT_VALUE", "DIRECT_VALUE");

    /**
     * The '<em><b>WORD CONST</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>WORD CONST</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #WORD_CONST
     * @model
     * @generated
     * @ordered
     */
    public static final int WORD_CONST_VALUE = 0;

    /**
     * The '<em><b>WORD VAR</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>WORD VAR</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #WORD_VAR
     * @model
     * @generated
     * @ordered
     */
    public static final int WORD_VAR_VALUE = 1;

    /**
     * The '<em><b>FLOAT CONST</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FLOAT CONST</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #FLOAT_CONST
     * @model
     * @generated
     * @ordered
     */
    public static final int FLOAT_CONST_VALUE = 2;

    /**
     * The '<em><b>FLOAT VAR</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FLOAT VAR</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #FLOAT_VAR
     * @model
     * @generated
     * @ordered
     */
    public static final int FLOAT_VAR_VALUE = 3;

    /**
     * The '<em><b>FGA VALUE</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FGA VALUE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #FGA_VALUE
     * @model
     * @generated
     * @ordered
     */
    public static final int FGA_VALUE_VALUE = 4;

    /**
     * The '<em><b>FGA MESSAGE CONST</b></em>' literal value. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FGA MESSAGE CONST</b></em>' literal object
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #FGA_MESSAGE_CONST
     * @model
     * @generated
     * @ordered
     */
    public static final int FGA_MESSAGE_CONST_VALUE = 5;

    /**
     * The '<em><b>FGA MEASURED VALUE</b></em>' literal value. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FGA MEASURED VALUE</b></em>' literal object
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #FGA_MEASURED_VALUE
     * @model
     * @generated
     * @ordered
     */
    public static final int FGA_MEASURED_VALUE_VALUE = 6;

    /**
     * The '<em><b>FGA ANALOG VALUE</b></em>' literal value. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of '<em><b>FGA ANALOG VALUE</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #FGA_ANALOG_VALUE
     * @model
     * @generated
     * @ordered
     */
    public static final int FGA_ANALOG_VALUE_VALUE = 7;

    /**
     * The '<em><b>DIRECT VALUE</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DIRECT VALUE</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #DIRECT_VALUE
     * @model
     * @generated
     * @ordered
     */
    public static final int DIRECT_VALUE_VALUE = 8;

    /**
     * An array of all the '<em><b>Port Data Type</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static final PortDataType[] VALUES_ARRAY = new PortDataType[] { WORD_CONST, WORD_VAR, FLOAT_CONST,
            FLOAT_VAR, FGA_VALUE, FGA_MESSAGE_CONST, FGA_MEASURED_VALUE, FGA_ANALOG_VALUE, DIRECT_VALUE, };

    /**
     * A public read-only list of all the '<em><b>Port Data Type</b></em>'
     * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final List<PortDataType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Port Data Type</b></em>' literal with the specified
     * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param literal
     *            the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PortDataType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PortDataType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Port Data Type</b></em>' literal with the specified
     * name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param name
     *            the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PortDataType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PortDataType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Port Data Type</b></em>' literal with the specified
     * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PortDataType get(int value) {
        switch (value) {
        case WORD_CONST_VALUE:
            return WORD_CONST;
        case WORD_VAR_VALUE:
            return WORD_VAR;
        case FLOAT_CONST_VALUE:
            return FLOAT_CONST;
        case FLOAT_VAR_VALUE:
            return FLOAT_VAR;
        case FGA_VALUE_VALUE:
            return FGA_VALUE;
        case FGA_MESSAGE_CONST_VALUE:
            return FGA_MESSAGE_CONST;
        case FGA_MEASURED_VALUE_VALUE:
            return FGA_MEASURED_VALUE;
        case FGA_ANALOG_VALUE_VALUE:
            return FGA_ANALOG_VALUE;
        case DIRECT_VALUE_VALUE:
            return DIRECT_VALUE;
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
    private PortDataType(int value, String name, String literal) {
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

} // PortDataType
