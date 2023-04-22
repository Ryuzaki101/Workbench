/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.h86;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Record Type</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see de.wisag.automation.micas.h86.H86Package#getRecordType()
 * @model
 * @generated
 */
public enum RecordType implements Enumerator {
    /**
     * The '<em><b>DATA</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #DATA_VALUE
     * @generated
     * @ordered
     */
    DATA(0, "DATA", "DATA"),

    /**
     * The '<em><b>EOF</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #EOF_VALUE
     * @generated
     * @ordered
     */
    EOF(1, "EOF", "EOF"),

    /**
     * The '<em><b>EXTENDED SEGMENT ADDRESS</b></em>' literal object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #EXTENDED_SEGMENT_ADDRESS_VALUE
     * @generated
     * @ordered
     */
    EXTENDED_SEGMENT_ADDRESS(2, "EXTENDED_SEGMENT_ADDRESS", "EXTENDED_SEGMENT_ADDRESS"),

    /**
     * The '<em><b>START SEGMENT ADDRESS</b></em>' literal object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #START_SEGMENT_ADDRESS_VALUE
     * @generated
     * @ordered
     */
    START_SEGMENT_ADDRESS(3, "START_SEGMENT_ADDRESS", "START_SEGMENT_ADDRESS"),

    /**
     * The '<em><b>EXTENDED LINEAR ADDRESS</b></em>' literal object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #EXTENDED_LINEAR_ADDRESS_VALUE
     * @generated
     * @ordered
     */
    EXTENDED_LINEAR_ADDRESS(4, "EXTENDED_LINEAR_ADDRESS", "EXTENDED_LINEAR_ADDRESS"),

    /**
     * The '<em><b>START LINEAR ADDRESS</b></em>' literal object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #START_LINEAR_ADDRESS_VALUE
     * @generated
     * @ordered
     */
    START_LINEAR_ADDRESS(5, "START_LINEAR_ADDRESS", "START_LINEAR_ADDRESS");

    /**
     * The '<em><b>DATA</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DATA</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #DATA
     * @model
     * @generated
     * @ordered
     */
    public static final int DATA_VALUE = 0;

    /**
     * The '<em><b>EOF</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>EOF</b></em>' literal object isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #EOF
     * @model
     * @generated
     * @ordered
     */
    public static final int EOF_VALUE = 1;

    /**
     * The '<em><b>EXTENDED SEGMENT ADDRESS</b></em>' literal value. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>EXTENDED SEGMENT ADDRESS</b></em>' literal
     * object isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #EXTENDED_SEGMENT_ADDRESS
     * @model
     * @generated
     * @ordered
     */
    public static final int EXTENDED_SEGMENT_ADDRESS_VALUE = 2;

    /**
     * The '<em><b>START SEGMENT ADDRESS</b></em>' literal value. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>START SEGMENT ADDRESS</b></em>' literal object
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #START_SEGMENT_ADDRESS
     * @model
     * @generated
     * @ordered
     */
    public static final int START_SEGMENT_ADDRESS_VALUE = 3;

    /**
     * The '<em><b>EXTENDED LINEAR ADDRESS</b></em>' literal value. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>EXTENDED LINEAR ADDRESS</b></em>' literal
     * object isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #EXTENDED_LINEAR_ADDRESS
     * @model
     * @generated
     * @ordered
     */
    public static final int EXTENDED_LINEAR_ADDRESS_VALUE = 4;

    /**
     * The '<em><b>START LINEAR ADDRESS</b></em>' literal value. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>START LINEAR ADDRESS</b></em>' literal object
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #START_LINEAR_ADDRESS
     * @model
     * @generated
     * @ordered
     */
    public static final int START_LINEAR_ADDRESS_VALUE = 5;

    /**
     * An array of all the '<em><b>Record Type</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static final RecordType[] VALUES_ARRAY = new RecordType[] { DATA, EOF, EXTENDED_SEGMENT_ADDRESS,
            START_SEGMENT_ADDRESS, EXTENDED_LINEAR_ADDRESS, START_LINEAR_ADDRESS, };

    /**
     * A public read-only list of all the '<em><b>Record Type</b></em>'
     * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final List<RecordType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Record Type</b></em>' literal with the specified
     * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param literal
     *            the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static RecordType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            RecordType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Record Type</b></em>' literal with the specified
     * name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param name
     *            the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static RecordType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            RecordType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Record Type</b></em>' literal with the specified
     * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static RecordType get(int value) {
        switch (value) {
        case DATA_VALUE:
            return DATA;
        case EOF_VALUE:
            return EOF;
        case EXTENDED_SEGMENT_ADDRESS_VALUE:
            return EXTENDED_SEGMENT_ADDRESS;
        case START_SEGMENT_ADDRESS_VALUE:
            return START_SEGMENT_ADDRESS;
        case EXTENDED_LINEAR_ADDRESS_VALUE:
            return EXTENDED_LINEAR_ADDRESS;
        case START_LINEAR_ADDRESS_VALUE:
            return START_LINEAR_ADDRESS;
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
    private RecordType(int value, String name, String literal) {
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

} // RecordType
