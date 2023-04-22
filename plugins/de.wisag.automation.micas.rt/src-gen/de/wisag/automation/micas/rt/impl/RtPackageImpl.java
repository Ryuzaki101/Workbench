/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.wisag.automation.micas.hwmodules.HwmodulesPackage;
import de.wisag.automation.micas.rt.RtCommentModuleInvocation;
import de.wisag.automation.micas.rt.RtConstant;
import de.wisag.automation.micas.rt.RtDirectValue;
import de.wisag.automation.micas.rt.RtFactory;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtHeadModule;
import de.wisag.automation.micas.rt.RtHwType;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtReferenceConstant;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtSymbolAccess;
import de.wisag.automation.micas.rt.RtSymbolAccessType;
import de.wisag.automation.micas.rt.RtTask;
import de.wisag.automation.micas.rt.RtTaskInfo;
import de.wisag.automation.micas.rt.RtTaskStrategy;
import de.wisag.automation.micas.rt.RtVariable;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class RtPackageImpl extends EPackageImpl implements RtPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtModuleEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtTaskEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtSymbolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtConstantEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtVariableEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtWordConstantEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtFloatConstantEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtDirectValueEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtWordVariableEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtFloatVariableEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtModuleInvocationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtCommentModuleInvocationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtReferenceConstantEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtSymbolAccessEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtHeadModuleEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rtTaskInfoEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum rtTaskStrategyEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum rtHwTypeEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum rtSymbolAccessTypeEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.wisag.automation.micas.rt.RtPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private RtPackageImpl() {
        super(eNS_URI, RtFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize {@link RtPackage#eINSTANCE} when that
     * field is accessed. Clients should not invoke it directly. Instead, they
     * should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static RtPackage init() {
        if (isInited) {
            return (RtPackage) EPackage.Registry.INSTANCE.getEPackage(RtPackage.eNS_URI);
        }

        // Obtain or create and register package
        RtPackageImpl theRtPackage = (RtPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RtPackageImpl
                ? EPackage.Registry.INSTANCE.get(eNS_URI)
                : new RtPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        HwmodulesPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theRtPackage.createPackageContents();

        // Initialize created meta-data
        theRtPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theRtPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(RtPackage.eNS_URI, theRtPackage);
        return theRtPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtModule() {
        return rtModuleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtModule_Symbols() {
        return (EReference) rtModuleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_DataSegmentAddress() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtModule_Tasks() {
        return (EReference) rtModuleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_StartSegmentAddress() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_FirstTaskSegmentAddress() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_HeadModuleSegmentAddress() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_DataSegmentCheckSum() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_WordConstOffset() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_FloatConstOffset() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_WordVarOffset() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_FloatVarOffset() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_EndOfFloatVars() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_DataSegment() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_HwType() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_FieldBus() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_PastValuesOffset() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_PastValuesLastOffset() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_TasksCheckSum() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtModule_HeadModul() {
        return (EReference) rtModuleEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_HeadModuleSegment() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(19);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_SourceModificationStamp() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(20);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_SourceName() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(21);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_SourceChecksum() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(22);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_Comments() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(23);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModule_StartSegment() {
        return (EAttribute) rtModuleEClass.getEStructuralFeatures().get(24);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtTask() {
        return rtTaskEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtTask_Module() {
        return (EReference) rtTaskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtTask_ModuleInvocations() {
        return (EReference) rtTaskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtTask_Id() {
        return (EAttribute) rtTaskEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtTask_CyclTime() {
        return (EAttribute) rtTaskEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtTask_Segment() {
        return (EAttribute) rtTaskEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtTask_PastValuesOffset() {
        return (EAttribute) rtTaskEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtTask_Strategy() {
        return (EAttribute) rtTaskEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtTask_Data() {
        return (EAttribute) rtTaskEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtTask_Runtime() {
        return (EAttribute) rtTaskEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtTask_PastValuesCount() {
        return (EAttribute) rtTaskEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtTask_Comment() {
        return (EAttribute) rtTaskEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtSymbol() {
        return rtSymbolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtSymbol_Address() {
        return (EAttribute) rtSymbolEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtSymbol_Name() {
        return (EAttribute) rtSymbolEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtSymbol_Module() {
        return (EReference) rtSymbolEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtSymbol_Accessors() {
        return (EReference) rtSymbolEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtSymbol_Index() {
        return (EAttribute) rtSymbolEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtConstant() {
        return rtConstantEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtVariable() {
        return rtVariableEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtWordConstant() {
        return rtWordConstantEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtWordConstant_Value() {
        return (EAttribute) rtWordConstantEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtFloatConstant() {
        return rtFloatConstantEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtFloatConstant_Value() {
        return (EAttribute) rtFloatConstantEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtDirectValue() {
        return rtDirectValueEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtDirectValue_Value() {
        return (EAttribute) rtDirectValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtWordVariable() {
        return rtWordVariableEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtWordVariable_Value() {
        return (EAttribute) rtWordVariableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtFloatVariable() {
        return rtFloatVariableEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtFloatVariable_Value() {
        return (EAttribute) rtFloatVariableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtModuleInvocation() {
        return rtModuleInvocationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtModuleInvocation_Arguments() {
        return (EReference) rtModuleInvocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtModuleInvocation_Task() {
        return (EReference) rtModuleInvocationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModuleInvocation_Name() {
        return (EAttribute) rtModuleInvocationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModuleInvocation_Index() {
        return (EAttribute) rtModuleInvocationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModuleInvocation_Opcode() {
        return (EAttribute) rtModuleInvocationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModuleInvocation_PastValuesCount() {
        return (EAttribute) rtModuleInvocationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtModuleInvocation_Runtime() {
        return (EAttribute) rtModuleInvocationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtCommentModuleInvocation() {
        return rtCommentModuleInvocationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtCommentModuleInvocation_Text() {
        return (EAttribute) rtCommentModuleInvocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtReferenceConstant() {
        return rtReferenceConstantEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtReferenceConstant_Col() {
        return (EAttribute) rtReferenceConstantEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtReferenceConstant_Row() {
        return (EAttribute) rtReferenceConstantEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtReferenceConstant_Type() {
        return (EAttribute) rtReferenceConstantEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtSymbolAccess() {
        return rtSymbolAccessEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtSymbolAccess_Symbol() {
        return (EReference) rtSymbolAccessEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtSymbolAccess_ModuleInvocation() {
        return (EReference) rtSymbolAccessEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtSymbolAccess_Type() {
        return (EAttribute) rtSymbolAccessEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtHeadModule() {
        return rtHeadModuleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtHeadModule_Module() {
        return (EReference) rtHeadModuleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtHeadModule_TaskInfos() {
        return (EReference) rtHeadModuleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtHeadModule_Magic0() {
        return (EAttribute) rtHeadModuleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtHeadModule_Magic1() {
        return (EAttribute) rtHeadModuleEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtHeadModule_TaskCount() {
        return (EAttribute) rtHeadModuleEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRtTaskInfo() {
        return rtTaskInfoEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRtTaskInfo_Task() {
        return (EReference) rtTaskInfoEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRtTaskInfo_ConvertedStrategy() {
        return (EAttribute) rtTaskInfoEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getRtTaskStrategy() {
        return rtTaskStrategyEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getRtHwType() {
        return rtHwTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getRtSymbolAccessType() {
        return rtSymbolAccessTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtFactory getRtFactory() {
        return (RtFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to
     * have no affect on any invocation but its first. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) {
            return;
        }
        isCreated = true;

        // Create classes and their features
        rtModuleEClass = createEClass(RT_MODULE);
        createEReference(rtModuleEClass, RT_MODULE__SYMBOLS);
        createEAttribute(rtModuleEClass, RT_MODULE__DATA_SEGMENT_ADDRESS);
        createEReference(rtModuleEClass, RT_MODULE__TASKS);
        createEAttribute(rtModuleEClass, RT_MODULE__START_SEGMENT_ADDRESS);
        createEAttribute(rtModuleEClass, RT_MODULE__FIRST_TASK_SEGMENT_ADDRESS);
        createEAttribute(rtModuleEClass, RT_MODULE__HEAD_MODULE_SEGMENT_ADDRESS);
        createEAttribute(rtModuleEClass, RT_MODULE__DATA_SEGMENT_CHECK_SUM);
        createEAttribute(rtModuleEClass, RT_MODULE__TASKS_CHECK_SUM);
        createEAttribute(rtModuleEClass, RT_MODULE__WORD_CONST_OFFSET);
        createEAttribute(rtModuleEClass, RT_MODULE__FLOAT_CONST_OFFSET);
        createEAttribute(rtModuleEClass, RT_MODULE__WORD_VAR_OFFSET);
        createEAttribute(rtModuleEClass, RT_MODULE__FLOAT_VAR_OFFSET);
        createEAttribute(rtModuleEClass, RT_MODULE__END_OF_FLOAT_VARS);
        createEAttribute(rtModuleEClass, RT_MODULE__DATA_SEGMENT);
        createEAttribute(rtModuleEClass, RT_MODULE__HW_TYPE);
        createEAttribute(rtModuleEClass, RT_MODULE__FIELD_BUS);
        createEAttribute(rtModuleEClass, RT_MODULE__PAST_VALUES_OFFSET);
        createEAttribute(rtModuleEClass, RT_MODULE__PAST_VALUES_LAST_OFFSET);
        createEReference(rtModuleEClass, RT_MODULE__HEAD_MODUL);
        createEAttribute(rtModuleEClass, RT_MODULE__HEAD_MODULE_SEGMENT);
        createEAttribute(rtModuleEClass, RT_MODULE__SOURCE_MODIFICATION_STAMP);
        createEAttribute(rtModuleEClass, RT_MODULE__SOURCE_NAME);
        createEAttribute(rtModuleEClass, RT_MODULE__SOURCE_CHECKSUM);
        createEAttribute(rtModuleEClass, RT_MODULE__COMMENTS);
        createEAttribute(rtModuleEClass, RT_MODULE__START_SEGMENT);

        rtTaskEClass = createEClass(RT_TASK);
        createEReference(rtTaskEClass, RT_TASK__MODULE);
        createEReference(rtTaskEClass, RT_TASK__MODULE_INVOCATIONS);
        createEAttribute(rtTaskEClass, RT_TASK__ID);
        createEAttribute(rtTaskEClass, RT_TASK__CYCL_TIME);
        createEAttribute(rtTaskEClass, RT_TASK__SEGMENT);
        createEAttribute(rtTaskEClass, RT_TASK__PAST_VALUES_OFFSET);
        createEAttribute(rtTaskEClass, RT_TASK__STRATEGY);
        createEAttribute(rtTaskEClass, RT_TASK__DATA);
        createEAttribute(rtTaskEClass, RT_TASK__RUNTIME);
        createEAttribute(rtTaskEClass, RT_TASK__PAST_VALUES_COUNT);
        createEAttribute(rtTaskEClass, RT_TASK__COMMENT);

        rtSymbolEClass = createEClass(RT_SYMBOL);
        createEAttribute(rtSymbolEClass, RT_SYMBOL__ADDRESS);
        createEAttribute(rtSymbolEClass, RT_SYMBOL__NAME);
        createEReference(rtSymbolEClass, RT_SYMBOL__MODULE);
        createEReference(rtSymbolEClass, RT_SYMBOL__ACCESSORS);
        createEAttribute(rtSymbolEClass, RT_SYMBOL__INDEX);

        rtConstantEClass = createEClass(RT_CONSTANT);

        rtVariableEClass = createEClass(RT_VARIABLE);

        rtWordConstantEClass = createEClass(RT_WORD_CONSTANT);
        createEAttribute(rtWordConstantEClass, RT_WORD_CONSTANT__VALUE);

        rtFloatConstantEClass = createEClass(RT_FLOAT_CONSTANT);
        createEAttribute(rtFloatConstantEClass, RT_FLOAT_CONSTANT__VALUE);

        rtDirectValueEClass = createEClass(RT_DIRECT_VALUE);
        createEAttribute(rtDirectValueEClass, RT_DIRECT_VALUE__VALUE);

        rtWordVariableEClass = createEClass(RT_WORD_VARIABLE);
        createEAttribute(rtWordVariableEClass, RT_WORD_VARIABLE__VALUE);

        rtFloatVariableEClass = createEClass(RT_FLOAT_VARIABLE);
        createEAttribute(rtFloatVariableEClass, RT_FLOAT_VARIABLE__VALUE);

        rtModuleInvocationEClass = createEClass(RT_MODULE_INVOCATION);
        createEReference(rtModuleInvocationEClass, RT_MODULE_INVOCATION__ARGUMENTS);
        createEReference(rtModuleInvocationEClass, RT_MODULE_INVOCATION__TASK);
        createEAttribute(rtModuleInvocationEClass, RT_MODULE_INVOCATION__NAME);
        createEAttribute(rtModuleInvocationEClass, RT_MODULE_INVOCATION__INDEX);
        createEAttribute(rtModuleInvocationEClass, RT_MODULE_INVOCATION__OPCODE);
        createEAttribute(rtModuleInvocationEClass, RT_MODULE_INVOCATION__PAST_VALUES_COUNT);
        createEAttribute(rtModuleInvocationEClass, RT_MODULE_INVOCATION__RUNTIME);

        rtCommentModuleInvocationEClass = createEClass(RT_COMMENT_MODULE_INVOCATION);
        createEAttribute(rtCommentModuleInvocationEClass, RT_COMMENT_MODULE_INVOCATION__TEXT);

        rtReferenceConstantEClass = createEClass(RT_REFERENCE_CONSTANT);
        createEAttribute(rtReferenceConstantEClass, RT_REFERENCE_CONSTANT__COL);
        createEAttribute(rtReferenceConstantEClass, RT_REFERENCE_CONSTANT__ROW);
        createEAttribute(rtReferenceConstantEClass, RT_REFERENCE_CONSTANT__TYPE);

        rtSymbolAccessEClass = createEClass(RT_SYMBOL_ACCESS);
        createEReference(rtSymbolAccessEClass, RT_SYMBOL_ACCESS__SYMBOL);
        createEReference(rtSymbolAccessEClass, RT_SYMBOL_ACCESS__MODULE_INVOCATION);
        createEAttribute(rtSymbolAccessEClass, RT_SYMBOL_ACCESS__TYPE);

        rtHeadModuleEClass = createEClass(RT_HEAD_MODULE);
        createEReference(rtHeadModuleEClass, RT_HEAD_MODULE__MODULE);
        createEReference(rtHeadModuleEClass, RT_HEAD_MODULE__TASK_INFOS);
        createEAttribute(rtHeadModuleEClass, RT_HEAD_MODULE__MAGIC0);
        createEAttribute(rtHeadModuleEClass, RT_HEAD_MODULE__MAGIC1);
        createEAttribute(rtHeadModuleEClass, RT_HEAD_MODULE__TASK_COUNT);

        rtTaskInfoEClass = createEClass(RT_TASK_INFO);
        createEReference(rtTaskInfoEClass, RT_TASK_INFO__TASK);
        createEAttribute(rtTaskInfoEClass, RT_TASK_INFO__CONVERTED_STRATEGY);

        // Create enums
        rtTaskStrategyEEnum = createEEnum(RT_TASK_STRATEGY);
        rtHwTypeEEnum = createEEnum(RT_HW_TYPE);
        rtSymbolAccessTypeEEnum = createEEnum(RT_SYMBOL_ACCESS_TYPE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) {
            return;
        }
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        HwmodulesPackage theHwmodulesPackage = (HwmodulesPackage) EPackage.Registry.INSTANCE
                .getEPackage(HwmodulesPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        rtConstantEClass.getESuperTypes().add(this.getRtSymbol());
        rtVariableEClass.getESuperTypes().add(this.getRtSymbol());
        rtWordConstantEClass.getESuperTypes().add(this.getRtConstant());
        rtFloatConstantEClass.getESuperTypes().add(this.getRtConstant());
        rtDirectValueEClass.getESuperTypes().add(this.getRtSymbol());
        rtWordVariableEClass.getESuperTypes().add(this.getRtVariable());
        rtFloatVariableEClass.getESuperTypes().add(this.getRtVariable());
        rtCommentModuleInvocationEClass.getESuperTypes().add(this.getRtModuleInvocation());
        rtReferenceConstantEClass.getESuperTypes().add(this.getRtConstant());

        // Initialize classes and features; add operations and parameters
        initEClass(rtModuleEClass, RtModule.class, "RtModule", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRtModule_Symbols(), this.getRtSymbol(), this.getRtSymbol_Module(), "symbols", null, 0, -1,
                RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        getRtModule_Symbols().getEKeys().add(this.getRtSymbol_Address());
        initEAttribute(getRtModule_DataSegmentAddress(), ecorePackage.getEInt(), "dataSegmentAddress", null, 0, 1,
                RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getRtModule_Tasks(), this.getRtTask(), this.getRtTask_Module(), "tasks", null, 0, -1,
                RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_StartSegmentAddress(), ecorePackage.getEInt(), "startSegmentAddress", null, 0, 1,
                RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_FirstTaskSegmentAddress(), ecorePackage.getEInt(), "firstTaskSegmentAddress", null,
                0, 1, RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_HeadModuleSegmentAddress(), ecorePackage.getEInt(), "headModuleSegmentAddress", null,
                0, 1, RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_DataSegmentCheckSum(), ecorePackage.getEInt(), "dataSegmentCheckSum", "-1", 0, 1,
                RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_TasksCheckSum(), ecorePackage.getEInt(), "tasksCheckSum", "-1", 0, 1, RtModule.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_WordConstOffset(), ecorePackage.getEInt(), "wordConstOffset", null, 0, 1,
                RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_FloatConstOffset(), ecorePackage.getEInt(), "floatConstOffset", null, 0, 1,
                RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_WordVarOffset(), ecorePackage.getEInt(), "wordVarOffset", null, 0, 1, RtModule.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_FloatVarOffset(), ecorePackage.getEInt(), "floatVarOffset", null, 0, 1,
                RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_EndOfFloatVars(), ecorePackage.getEInt(), "endOfFloatVars", null, 0, 1,
                RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_DataSegment(), ecorePackage.getEByteArray(), "dataSegment", null, 0, 1,
                RtModule.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_HwType(), this.getRtHwType(), "hwType", "AC40", 0, 1, RtModule.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_FieldBus(), ecorePackage.getEInt(), "fieldBus", null, 0, 1, RtModule.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_PastValuesOffset(), ecorePackage.getEInt(), "pastValuesOffset", null, 0, 1,
                RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_PastValuesLastOffset(), ecorePackage.getEInt(), "pastValuesLastOffset", "0", 0, 1,
                RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getRtModule_HeadModul(), this.getRtHeadModule(), this.getRtHeadModule_Module(), "headModul",
                null, 0, 1, RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_HeadModuleSegment(), ecorePackage.getEByteArray(), "headModuleSegment", null, 0, 1,
                RtModule.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_SourceModificationStamp(), ecorePackage.getELong(), "sourceModificationStamp", null,
                0, 1, RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_SourceName(), ecorePackage.getEString(), "sourceName", null, 0, 1, RtModule.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_SourceChecksum(), ecorePackage.getEString(), "sourceChecksum", null, 0, 1,
                RtModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_Comments(), ecorePackage.getEString(), "comments", null, 0, -1, RtModule.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModule_StartSegment(), ecorePackage.getEByteArray(), "startSegment", null, 0, 1,
                RtModule.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        addEOperation(rtModuleEClass, this.getRtWordConstant(), "getWordConstants", 0, -1, IS_UNIQUE, IS_ORDERED);

        addEOperation(rtModuleEClass, this.getRtWordVariable(), "getWordVariables", 0, -1, IS_UNIQUE, IS_ORDERED);

        addEOperation(rtModuleEClass, this.getRtFloatConstant(), "getFloatConstants", 0, -1, IS_UNIQUE, IS_ORDERED);

        addEOperation(rtModuleEClass, this.getRtFloatVariable(), "getFloatVariables", 0, -1, IS_UNIQUE, IS_ORDERED);

        addEOperation(rtModuleEClass, this.getRtReferenceConstant(), "getReferences", 0, -1, IS_UNIQUE, IS_ORDERED);

        EOperation op = addEOperation(rtModuleEClass, null, "addSymbol", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getRtSymbol(), "symbol", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = addEOperation(rtModuleEClass, this.getRtSymbol(), "getSymbol", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEInt(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = addEOperation(rtModuleEClass, ecorePackage.getEBoolean(), "haveSymbol", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEInt(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

        addEOperation(rtModuleEClass, ecorePackage.getEInt(), "getModuleChecksum", 0, 1, IS_UNIQUE, IS_ORDERED);

        addEOperation(rtModuleEClass, ecorePackage.getEInt(), "calculateProgramSize", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(rtTaskEClass, RtTask.class, "RtTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRtTask_Module(), this.getRtModule(), this.getRtModule_Tasks(), "module", null, 0, 1,
                RtTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRtTask_ModuleInvocations(), this.getRtModuleInvocation(), this.getRtModuleInvocation_Task(),
                "moduleInvocations", null, 0, -1, RtTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtTask_Id(), ecorePackage.getEInt(), "id", null, 0, 1, RtTask.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtTask_CyclTime(), ecorePackage.getEInt(), "cyclTime", null, 0, 1, RtTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtTask_Segment(), ecorePackage.getEInt(), "segment", null, 0, 1, RtTask.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtTask_PastValuesOffset(), ecorePackage.getEInt(), "pastValuesOffset", null, 0, 1,
                RtTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtTask_Strategy(), this.getRtTaskStrategy(), "strategy", null, 0, 1, RtTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtTask_Data(), ecorePackage.getEByteArray(), "data", null, 0, 1, RtTask.class, IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtTask_Runtime(), ecorePackage.getEInt(), "runtime", "0", 0, 1, RtTask.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtTask_PastValuesCount(), ecorePackage.getEInt(), "pastValuesCount", "0", 0, 1, RtTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtTask_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, RtTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rtSymbolEClass, RtSymbol.class, "RtSymbol", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRtSymbol_Address(), ecorePackage.getEInt(), "address", null, 0, 1, RtSymbol.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtSymbol_Name(), ecorePackage.getEString(), "name", null, 0, 1, RtSymbol.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRtSymbol_Module(), this.getRtModule(), this.getRtModule_Symbols(), "module", null, 0, 1,
                RtSymbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRtSymbol_Accessors(), this.getRtSymbolAccess(), this.getRtSymbolAccess_Symbol(), "accessors",
                null, 0, -1, RtSymbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtSymbol_Index(), ecorePackage.getEInt(), "index", "-1", 0, 1, RtSymbol.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(rtSymbolEClass, ecorePackage.getEString(), "getDisplayName", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(rtConstantEClass, RtConstant.class, "RtConstant", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(rtVariableEClass, RtVariable.class, "RtVariable", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(rtWordConstantEClass, RtWordConstant.class, "RtWordConstant", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRtWordConstant_Value(), ecorePackage.getEInt(), "value", null, 0, 1, RtWordConstant.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rtFloatConstantEClass, RtFloatConstant.class, "RtFloatConstant", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRtFloatConstant_Value(), ecorePackage.getEDouble(), "value", null, 0, 1,
                RtFloatConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(rtDirectValueEClass, RtDirectValue.class, "RtDirectValue", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRtDirectValue_Value(), ecorePackage.getEInt(), "value", null, 0, 1, RtDirectValue.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rtWordVariableEClass, RtWordVariable.class, "RtWordVariable", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRtWordVariable_Value(), ecorePackage.getEInt(), "value", null, 0, 1, RtWordVariable.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rtFloatVariableEClass, RtFloatVariable.class, "RtFloatVariable", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRtFloatVariable_Value(), ecorePackage.getEFloat(), "value", null, 0, 1, RtFloatVariable.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rtModuleInvocationEClass, RtModuleInvocation.class, "RtModuleInvocation", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRtModuleInvocation_Arguments(), this.getRtSymbolAccess(),
                this.getRtSymbolAccess_ModuleInvocation(), "arguments", null, 0, -1, RtModuleInvocation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRtModuleInvocation_Task(), this.getRtTask(), this.getRtTask_ModuleInvocations(), "task", null,
                0, 1, RtModuleInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModuleInvocation_Name(), ecorePackage.getEString(), "name", null, 0, 1,
                RtModuleInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModuleInvocation_Index(), ecorePackage.getEInt(), "index", null, 0, 1,
                RtModuleInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModuleInvocation_Opcode(), ecorePackage.getEInt(), "opcode", "-1", 0, 1,
                RtModuleInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModuleInvocation_PastValuesCount(), ecorePackage.getEInt(), "pastValuesCount", "-1", 0, 1,
                RtModuleInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtModuleInvocation_Runtime(), ecorePackage.getEInt(), "runtime", "0", 0, 1,
                RtModuleInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(rtCommentModuleInvocationEClass, RtCommentModuleInvocation.class, "RtCommentModuleInvocation",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRtCommentModuleInvocation_Text(), ecorePackage.getEString(), "text", null, 0, 1,
                RtCommentModuleInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rtReferenceConstantEClass, RtReferenceConstant.class, "RtReferenceConstant", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRtReferenceConstant_Col(), ecorePackage.getEInt(), "col", null, 0, 1,
                RtReferenceConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtReferenceConstant_Row(), ecorePackage.getEInt(), "row", null, 0, 1,
                RtReferenceConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtReferenceConstant_Type(), theHwmodulesPackage.getPortDataType(), "type", null, 0, 1,
                RtReferenceConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rtSymbolAccessEClass, RtSymbolAccess.class, "RtSymbolAccess", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRtSymbolAccess_Symbol(), this.getRtSymbol(), this.getRtSymbol_Accessors(), "symbol", null, 0,
                1, RtSymbolAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRtSymbolAccess_ModuleInvocation(), this.getRtModuleInvocation(),
                this.getRtModuleInvocation_Arguments(), "moduleInvocation", null, 0, 1, RtSymbolAccess.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtSymbolAccess_Type(), this.getRtSymbolAccessType(), "type", null, 0, 1, RtSymbolAccess.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rtHeadModuleEClass, RtHeadModule.class, "RtHeadModule", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRtHeadModule_Module(), this.getRtModule(), this.getRtModule_HeadModul(), "module", null, 0, 1,
                RtHeadModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRtHeadModule_TaskInfos(), this.getRtTaskInfo(), null, "taskInfos", null, 0, -1,
                RtHeadModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtHeadModule_Magic0(), ecorePackage.getEInt(), "magic0", null, 0, 1, RtHeadModule.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtHeadModule_Magic1(), ecorePackage.getEInt(), "magic1", null, 0, 1, RtHeadModule.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtHeadModule_TaskCount(), ecorePackage.getEInt(), "taskCount", null, 0, 1, RtHeadModule.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rtTaskInfoEClass, RtTaskInfo.class, "RtTaskInfo", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRtTaskInfo_Task(), this.getRtTask(), null, "task", null, 0, 1, RtTaskInfo.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRtTaskInfo_ConvertedStrategy(), ecorePackage.getEInt(), "convertedStrategy", null, 0, 1,
                RtTaskInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(rtTaskStrategyEEnum, RtTaskStrategy.class, "RtTaskStrategy");
        addEEnumLiteral(rtTaskStrategyEEnum, RtTaskStrategy.CYCL);
        addEEnumLiteral(rtTaskStrategyEEnum, RtTaskStrategy.EVNT);
        addEEnumLiteral(rtTaskStrategyEEnum, RtTaskStrategy.BACK);
        addEEnumLiteral(rtTaskStrategyEEnum, RtTaskStrategy.INIT);

        initEEnum(rtHwTypeEEnum, RtHwType.class, "RtHwType");
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.AC40);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.AR11);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.AR20);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.ER11);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.ER12);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.GW12);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.GW13);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.GW14);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.MB11);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.SP11);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.SP20);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.ZM12);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.ZM13);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.ZM14);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.ZM15);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.ZP12);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.ZP13);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.AR10);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.ZP10);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.ZP20);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.MB10);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.SP10);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.AR12);
        addEEnumLiteral(rtHwTypeEEnum, RtHwType.AC60);

        initEEnum(rtSymbolAccessTypeEEnum, RtSymbolAccessType.class, "RtSymbolAccessType");
        addEEnumLiteral(rtSymbolAccessTypeEEnum, RtSymbolAccessType.READ);
        addEEnumLiteral(rtSymbolAccessTypeEEnum, RtSymbolAccessType.WRITE);

        // Create resource
        createResource(eNS_URI);
    }

} // RtPackageImpl
