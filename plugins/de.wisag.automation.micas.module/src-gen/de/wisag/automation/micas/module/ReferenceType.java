/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Reference Type</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see de.wisag.automation.micas.module.ModulePackage#getReferenceType()
 * @model
 * @generated
 */
public enum ReferenceType implements Enumerator {
    /**
     * The '<em><b>Fga Value</b></em>' literal object. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #FGA_VALUE_VALUE
     * @generated
     * @ordered
     */
    FGA_VALUE(1, "FgaValue", "FgaValue"),

    /**
     * The '<em><b>Fga Message Const</b></em>' literal object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #FGA_MESSAGE_CONST_VALUE
     * @generated
     * @ordered
     */
    FGA_MESSAGE_CONST(2, "FgaMessageConst", "FgaMessageConst"),

    /**
     * The '<em><b>Fga Measured Value</b></em>' literal object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #FGA_MEASURED_VALUE_VALUE
     * @generated
     * @ordered
     */
    FGA_MEASURED_VALUE(3, "FgaMeasuredValue", "FgaMeasuredValue"),

    /**
     * The '<em><b>Fga Analog Value</b></em>' literal object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #FGA_ANALOG_VALUE_VALUE
     * @generated
     * @ordered
     */
    FGA_ANALOG_VALUE(4, "FgaAnalogValue", "FgaAnalogValue");

    /**
     * The '<em><b>Fga Value</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Fga Value</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #FGA_VALUE
     * @model name="FgaValue"
     * @generated
     * @ordered
     */
    public static final int FGA_VALUE_VALUE = 1;

    /**
     * The '<em><b>Fga Message Const</b></em>' literal value. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Fga Message Const</b></em>' literal object
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #FGA_MESSAGE_CONST
     * @model name="FgaMessageConst"
     * @generated
     * @ordered
     */
    public static final int FGA_MESSAGE_CONST_VALUE = 2;

    /**
     * The '<em><b>Fga Measured Value</b></em>' literal value. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Fga Measured Value</b></em>' literal object
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #FGA_MEASURED_VALUE
     * @model name="FgaMeasuredValue"
     * @generated
     * @ordered
     */
    public static final int FGA_MEASURED_VALUE_VALUE = 3;

    /**
     * The '<em><b>Fga Analog Value</b></em>' literal value. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of '<em><b>Fga Analog Value</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #FGA_ANALOG_VALUE
     * @model name="FgaAnalogValue"
     * @generated
     * @ordered
     */
    public static final int FGA_ANALOG_VALUE_VALUE = 4;

    /**
     * An array of all the '<em><b>Reference Type</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static final ReferenceType[] VALUES_ARRAY = new ReferenceType[] { FGA_VALUE, FGA_MESSAGE_CONST,
            FGA_MEASURED_VALUE, FGA_ANALOG_VALUE, };

    /**
     * A public read-only list of all the '<em><b>Reference Type</b></em>'
     * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final List<ReferenceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Reference Type</b></em>' literal with the specified
     * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param literal
     *            the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static ReferenceType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ReferenceType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Reference Type</b></em>' literal with the specified
     * name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param name
     *            the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static ReferenceType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ReferenceType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Reference Type</b></em>' literal with the specified
     * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static ReferenceType get(int value) {
        switch (value) {
        case FGA_VALUE_VALUE:
            return FGA_VALUE;
        case FGA_MESSAGE_CONST_VALUE:
            return FGA_MESSAGE_CONST;
        case FGA_MEASURED_VALUE_VALUE:
            return FGA_MEASURED_VALUE;
        case FGA_ANALOG_VALUE_VALUE:
            return FGA_ANALOG_VALUE;
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
    private ReferenceType(int value, String name, String literal) {
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

} // ReferenceType
