package de.wisag.automation.micas.module.util;

import org.eclipse.core.runtime.Assert;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Constant;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.IncomingOffpageConnector;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.OutgoingOffpageConnector;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Reference;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.Task;

public class PageUtils {

    public static Constant createConstant(Page parentPage, ConstantAttribute attribute) {
        Constant constant = ModuleFactory.eINSTANCE.createConstant();
        constant.setOwningFragment(parentPage);
        BlockUtils.configureConstant(constant);
        OutputPort outputPort = constant.getOutputPorts().get(0);
        AttributeSpecification attributeSpecification = ModuleFactory.eINSTANCE.createAttributeSpecification();
        attributeSpecification.setAttribute(attribute);
        outputPort.setSignal(attributeSpecification);
        return constant;
    }

    public static OutgoingOffpageConnector createPageOutput(Page page) {
        OutgoingOffpageConnector offPageConn = ModuleFactory.eINSTANCE.createOutgoingOffpageConnector();
        offPageConn.setOwningFragment(page);
        BlockUtils.configureOutgoingOffpageConnector(offPageConn);
        return offPageConn;
    }

    public static IncomingOffpageConnector createPageInput(Page page, Attribute attribute) {
        IncomingOffpageConnector inPageConn = ModuleFactory.eINSTANCE.createIncomingOffpageConnector();
        inPageConn.setOwningFragment(page);
        BlockUtils.configureIncomingOffpageConnector(inPageConn);
        AttributeSpecification attributeSpecification = ModuleFactory.eINSTANCE.createAttributeSpecification();
        attributeSpecification.setAttribute(attribute);
        inPageConn.getFirstOutputPort().setSignal(attributeSpecification);
        return inPageConn;
    }

    public static Reference createReference(final Page parentPage, final ReferenceAttribute attribute) {
        final Reference reference = ModuleFactory.eINSTANCE.createReference();
        reference.setOwningFragment(parentPage);
        BlockUtils.configureReference(reference);
        final OutputPort outputPort = reference.getOutputPorts().get(0);
        final AttributeSpecification attributeSpecification = ModuleFactory.eINSTANCE.createAttributeSpecification();
        attributeSpecification.setAttribute(attribute);
        outputPort.setSignal(attributeSpecification);
        return reference;
    }

    public static Page createPage(String name, Task task) {
        Assert.isNotNull(name);
        Assert.isNotNull(task);
        Page page = ModuleFactory.eINSTANCE.createPage();
        page.setName(name);
        page.setTask(task);
        return page;
    }

    public static Connection createConnection(Page page, OutputPort sourcePort, InputPort targetPort) {
        Connection con = DMLFactory.eINSTANCE.createConnection();
        page.getConnections().add(con);
        con.setTarget(targetPort);
        con.setSource(sourcePort);
        return con;
    }

}
