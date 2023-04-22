package de.wisag.automation.micas.diagram.ui.editparts;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.editpolicies.NonRotatableTransformEditPolicy;
import org.eclipselabs.damos.diagram.ui.properties.ParametersPropertySectionDelegate;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.ExpressionSpecification;

import de.wisag.automation.micas.common.WellknownSpecialBlocks;
import de.wisag.automation.micas.diagram.ui.ISpecialBlockNames;
import de.wisag.automation.micas.diagram.ui.editpolicies.InputPortCountEditPolicy;
import de.wisag.automation.micas.diagram.ui.editpolicies.OutputPortCountEditPolicy;
import de.wisag.automation.micas.diagram.ui.figures.BlockFigure;
import de.wisag.automation.micas.module.util.IBlockConstants;
import de.wisag.automation.micas.module.util.ModuleUtil;

public class BlockEditPart extends RectangularBlockEditPart {

    private BlockFigure blockFigure;

    public BlockEditPart(View view) {
        super(view);
    }

    @Override
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(IEditPolicyRoles.TRANSFORM_ROLE, new NonRotatableTransformEditPolicy());
        installEditPolicy(IEditPolicyRoles.INPUT_PORT_COUNT_ROLE, new InputPortCountEditPolicy());
        installEditPolicy(IEditPolicyRoles.OUTPUT_PORT_COUNT_ROLE, new OutputPortCountEditPolicy());
    }

    @Override
    protected void refreshVisuals() {
        super.refreshVisuals();
        refreshHeader();
        refreshIndex();
    }

    protected void refreshHeader() {
        final Block block = getBlock();
        if (block != null) {
            blockFigure.setHeaderText(formatHeaderText(block));
        }
    }

    private String formatHeaderText(final Block block) {
        String typeName = block.getType().getName();
        String number = "";
        if (WellknownSpecialBlocks.REGLER.equals(typeName)) {
            number = ModuleUtil.getArgumentValue(block, ModuleUtil.REGLER_PROP_NUMBER);
        } else if (WellknownSpecialBlocks.UREG.equals(typeName)) {
            number = ModuleUtil.getArgumentValue(block, ModuleUtil.REGLER_PROP_NUMBER);
        } else if (WellknownSpecialBlocks.SOLKEN.equals(typeName)) {

            number = ModuleUtil.getArgumentValue(block, ModuleUtil.SOLKEN_PROP_NUMBER);
        }
        // krm : 05/2014 dont show instancename
        String text = String.format("%s", typeName);
        if (!StringUtils.isEmpty(number)) {
            text = String.format("%s (%s)", typeName, number);
        }
        return text;
    }

    protected void refreshIndex() {
        Block block = getBlock();
        if (block != null) {
            String index = block.getArgumentStringValue(IBlockConstants.PARAMETER__INDEX);
            if (index != null) {
                try {
                    blockFigure.setIndex(Integer.parseInt(index));
                } catch (NumberFormatException e) {
                    blockFigure.setIndex(-1);
                }
            }
        }
    }

    private Block getBlock() {
        EObject semanticElement = resolveSemanticElement();
        if (semanticElement instanceof Block) {
            Block block = (Block) semanticElement;
            return block;
        } else {
            return null;
        }
    }

    @Override
    protected NodeFigure createMainFigure() {
        blockFigure = new BlockFigure();
        return blockFigure;
    }

    @Override
    protected void handleNotificationEvent(Notification notification) {
        if (notification.getFeature() == DMLPackage.Literals.COMPONENT__NAME) {
            refreshHeader();
        } else if (notification.getFeature() == DMLPackage.Literals.ARGUMENT__VALUE) {
            refreshHeader();
            refreshIndex();
        }
        super.handleNotificationEvent(notification);

    }

    @Override
    public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
        EObject semanticElement = resolveSemanticElement();
        // should not happen, but if a block was deleted
        if (semanticElement == null || semanticElement.eClass().getClassifierID() != DMLPackage.BLOCK) {
            return super.getAdapter(key);
        }
        Block block = (Block) semanticElement;
        if (key == ParametersPropertySectionDelegate.class && block != null
                && StringUtils.contains(block.getName(), ISpecialBlockNames.FKG_NAME)) {
            return null; // Do not show parameters property section
        }
        return super.getAdapter(key);
    }

    @Override
    protected void addSemanticListeners() {
        super.addSemanticListeners();
        Block block = getBlock();
        String typeName = block.getType().getName();
        ExpressionSpecification spec = null;
        if (WellknownSpecialBlocks.REGLER.equals(typeName) || WellknownSpecialBlocks.UREG.equals(typeName)) {
            spec = ModuleUtil.getExpressionSpecification(block, ModuleUtil.REGLER_PROP_NUMBER);
        } else if (WellknownSpecialBlocks.SOLKEN.equals(typeName)) {
            spec = ModuleUtil.getExpressionSpecification(block, ModuleUtil.SOLKEN_PROP_NUMBER);
        }
        if (spec != null) {
            addListenerFilter(ExpressionSpecification.class.getCanonicalName(), this, spec);
        }
    }

    @Override
    protected void removeSemanticListeners() {
        // TODO Auto-generated method stub
        super.removeSemanticListeners();
        removeListenerFilter(ExpressionSpecification.class.getCanonicalName());
    }

}
