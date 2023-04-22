package de.wisag.automation.micas.hwmodules.test;

import static de.wisag.automation.micas.hwmodules.ModulesPersistentHelper.saveModules;
import static java.nio.file.Files.newOutputStream;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.Category;
import org.eclipselabs.damos.dml.ExpressionParameter;
import org.eclipselabs.damos.dml.ExpressionSpecification;
import org.eclipselabs.damos.dml.InoutputDefinition;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.registry.IBlockGroupDescriptor;
import org.eclipselabs.damos.dml.registry.IBlockTypeDescriptor;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.base.Strings;
import com.google.common.io.MoreFiles;

import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.HwmodulesFactory;
import de.wisag.automation.micas.hwmodules.HwmodulesPackage;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.hwmodules.MicasModules;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.ModulesPersistentHelper;
import de.wisag.automation.micas.hwmodules.Port;
import de.wisag.automation.micas.hwmodules.PortDataType;
import de.wisag.automation.micas.hwmodules.PortGroup;
import de.wisag.automation.micas.hwmodules.test.HWBlockTransform.BlockAndGroup;
import de.wisag.automation.micas.module.MicasDataTypeSpecification;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.util.BlockTypeDescriptorCache;
import de.wisag.automation.micas.module.util.BlockUtils;

public class HwModulesToBlockTest {

    @Test
    public void checkHwModulesMapping() {
        Module module = ModuleFactory.eINSTANCE.createModule();
        String uri = "bla.module";
        applyResource(module, uri);

        for (ModuleDefinition md : IHwModulesProvider.INSTANCE.getModules()) {
            String name = md.getName();
            if ("ENDE".equals(name)) {
                continue;
            }
            IBlockTypeDescriptor desc = BlockTypeDescriptorCache.findBlockTypeDescriptor(name);
            assertNotNull("Module not found '" + name + "'", desc);
            try {
                BlockType blockType = BlockUtils.getBlockType(module.eResource(), desc);
                assertNotNull("BlockType not created '" + name + "'", blockType);
            } catch (IllegalArgumentException e) {
                System.err.println("Could not find " + name);
            }
        }
    }

    private void applyResource(Module module, String uri) {
        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = resourceSet.createResource(URI.createURI(uri));
        resource.getContents().add(module);
    }

    private String toDmlXmiString(EObject eObject) {
        final ResourceSet resourceSet = new ResourceSetImpl();
        // resourceSet.getResource(uri, loadOnDemand)
        Resource xmiResource = resourceSet.createResource(URI.createURI("bla.dml"));
        xmiResource.getContents().add(eObject);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            Map<Object, Object> options = new HashMap<>();
            options.put(XMIResource.OPTION_ENCODING, StandardCharsets.UTF_8.name());
            xmiResource.save(outputStream, options);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new String(outputStream.toByteArray(), StandardCharsets.UTF_8);

    }

    @Test
    public void hwtypedefSaferToHwModulesMapping() {

    }

    @Test
    public void checkBlocksToHwModulesMapping() {
        Module module = ModuleFactory.eINSTANCE.createModule();
        applyResource(module, "bla.module");
        Collection<String> diagramBlockNames = BlockTypeDescriptorCache.getInstance().allNames();
        IHwModulesProvider hwModulesProvider = IHwModulesProvider.INSTANCE;
        for (String blockName : diagramBlockNames) {
            IBlockTypeDescriptor blockDescriptor = BlockTypeDescriptorCache.findBlockTypeDescriptor(blockName);

            blockDescriptor.getName();
            blockDescriptor.getQualifiedName();
            blockDescriptor.getUri();

            IBlockGroupDescriptor blockGroup = blockDescriptor.getGroup();
            blockGroup.getId();
            blockGroup.getName();
            blockGroup.getSupergroup();

            ModuleDefinition hwBlock = hwModulesProvider.findModuleByName(blockName);
            assertNotNull(hwBlock);
        }
        List<Bundle> bundles = Arrays.stream(FrameworkUtil.getBundle(getClass()).getBundleContext().getBundles())//
                .filter(b -> "de.wisag.automation.micas.diagram.core".equals(b.getSymbolicName())//
                        || "de.wisag.automation.micas.diagram.core.intern".equals(b.getSymbolicName()))//
                .collect(Collectors.toList());
        List<BlockType> blockTypes = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        bundles.forEach(b -> {
            Enumeration<URL> entries = b.findEntries("/", null, true);

            Collections.list(entries).stream().filter(u -> u.toExternalForm().endsWith(".dml")).forEach(u -> {
                ResourceSet resourceSet = new ResourceSetImpl();
                Resource resource = resourceSet.createResource(URI.createURI(u.toExternalForm()));
                // try to load the file into resource
                try {
                    resource.load(null);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                Optional<EObject> first = resource.getContents().stream().findFirst();
                Optional<BlockType> blockType = first//
                        .filter(BlockType.class::isInstance)//
                        .map(BlockType.class::cast);

                blockType.ifPresent(t -> {
                    blockTypes.add(t);
                });
                Optional<Category> category = Optional.empty();
                if (!blockType.isPresent()) {
                    category = first//
                            .filter(Category.class::isInstance)//
                            .map(Category.class::cast);

                }
                category.ifPresent(c -> categories.add(c));
            });
        });
        MicasModules micasModules;
        try {
            micasModules = load(ModulesPersistentHelper.class.getResourceAsStream("modules.hw"));
        } catch (IOException e1) {
            throw new UncheckedIOException(e1);
        }
        for (BlockType blockType : blockTypes) {
            EList<Category> belongingCategories = blockType.getBelongingCategories();
            if (belongingCategories.size() != 1) {
                System.out.println("more categories " + blockType);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(blockType.getName()).append("\n");
            sb.append("   " + blockType.getQualifiedName()).append("\n");
            sb.append("   Parameters :").append("\n");
            for (Parameter parameter : blockType.getParameters()) {
                if (parameter instanceof ExpressionParameter) {
                    ExpressionParameter expressionParameter = (ExpressionParameter) parameter;
                    String paramName = expressionParameter.getName();
                    ExpressionSpecification paramDefault = (ExpressionSpecification) expressionParameter
                            .getDefaultValue();
                    sb.append("    " + paramName + "=" + paramDefault.getExpression()).append("\n");

                } else {
                    sb.append("Other expression parameter : " + parameter).append("\n");
                }
            }
            EList<InputDefinition> inputDefinitions = blockType.getInputDefinitions();
            sb.append("   Input ports :").append("\n");

            for (InputDefinition inputDefinition : inputDefinitions) {
                sb.append(dumpInOut(5, inputDefinition)).append("\n");
            }
            sb.append("   Output ports :");
            for (OutputDefinition outputDefinition : blockType.getOutputDefinitions()) {
                sb.append(dumpInOut(5, outputDefinition)).append("\n");
            }
            if ("ENDE".equals(blockType.getName())) {
                continue;
            }

            ModuleDefinition block = micasModules.findModuleByName(blockType.getName());
            if (block == null) {
                System.out.println("------> HW Not fouund " + blockType.getName());
                continue;
            }
            EcoreUtil.resolveAll(block);

            IBlockTypeDescriptor descriptor = BlockTypeDescriptorCache.findBlockTypeDescriptor(blockType.getName());
            block.setGroupId(descriptor.getGroup().getId());
            EList<Category> belongingCategories2 = blockType.getBelongingCategories();
            Optional<Category> firstCategory = belongingCategories2.stream().findFirst();
            firstCategory.ifPresent(c -> {
                block.setCategory(c.getQualifiedName());
            });

            for (Parameter parameter : blockType.getParameters()) {
                if (parameter instanceof ExpressionParameter) {
                    ExpressionParameter expressionParameter = (ExpressionParameter) parameter;

                    ExpressionSpecification paramDefault = (ExpressionSpecification) expressionParameter
                            .getDefaultValue();
                    String paramName = expressionParameter.getName();
                    String value = paramDefault.getExpression();

                    de.wisag.automation.micas.hwmodules.Parameter hwParameter = HwmodulesFactory.eINSTANCE
                            .createParameter();
                    hwParameter.setName(paramName);
                    hwParameter.setValue(value);

                    block.getParameters().add(hwParameter);
                    sb.append("    " + paramName + "=" + value).append("\n");

                } else {
                    sb.append("Other expression parameter : " + parameter).append("\n");
                }
            }

            List<Port> inputs = block.getInputs().stream()
                    .filter(p -> !p.getAllowedPortDataTypes().contains(PortDataType.DIRECT_VALUE))
                    .collect(Collectors.toList());

            long inputGroupCount = inputs.stream().filter(PortGroup.class::isInstance).count();
            long inputDirectValue = inputs.stream()
                    .filter(p -> p.getAllowedPortDataTypes().contains(PortDataType.DIRECT_VALUE)).count();

            if (inputDefinitions.size() != inputs.size()) {
                System.out.println(block.getName());
                System.out.println("Groups :        " + inputGroupCount);
                System.out.println("Direct Values : " + inputDirectValue);
                System.out.println("inputcout differ diagram : " + inputDefinitions.size() + " hw: " + inputs.size());
            }
            EList<Port> outputs = block.getOutputs();
            long outputGroupCount = outputs.stream().filter(PortGroup.class::isInstance).count();
            long outputDirectValue = outputs.stream()
                    .filter(p -> p.getAllowedPortDataTypes().contains(PortDataType.DIRECT_VALUE)).count();
            if (blockType.getOutputDefinitions().size() != outputs.size()) {
                System.out.println(block.getName());
                System.out.println("Groups : " + outputGroupCount);
                System.out.println("Direct Values : " + outputDirectValue);
                System.out.println("outputcount differ diagram : " + blockType.getOutputDefinitions().size() + " hw: "
                        + outputs.size());
            }
        }

        try (OutputStream os = newOutputStream(Paths.get("C:/tmp/modules.hw"), TRUNCATE_EXISTING, CREATE)) {
            saveModules(micasModules, os);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        MicasModules micasModulesOld;
        try {
            micasModulesOld = load(ModulesPersistentHelper.class.getResourceAsStream("modules.hw"));
        } catch (IOException e1) {
            throw new UncheckedIOException(e1);
        }
        try (OutputStream os = newOutputStream(Paths.get("C:/tmp/modules_old.hw"), TRUNCATE_EXISTING, CREATE)) {
            saveModules(micasModulesOld, os);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        Path blockdirBase = Paths.get("C:\\tmp\\\\hwmodules");
        try {
            MoreFiles.createParentDirectories(blockdirBase);
        } catch (IOException e) {
            throw new UncheckedIOException("Creating block directories", e);
        }
        saveHwModules(readmodules("C:/tmp/modules.hw"), blockdirBase);

        MicasModules fixed = readmodules("C:/tmp/modules.hw");
        EList<ModuleDefinition> modules = fixed.getModules();
        Path base = Paths.get("C:\\tmp\\blocktypes");

        Category category = saveCategoryXmi(base);
        HWBlockTransform transform = new HWBlockTransform();
        for (ModuleDefinition m : modules) {
            if ("ENDE".equals(m.getName())) {
                continue;
            }
            BlockAndGroup b = transform.toBlockType(m, category);
            Path f = base.resolve(b.relativePath());
            try {
                MoreFiles.createParentDirectories(f);
            } catch (IOException e) {
                throw new UncheckedIOException("Creating block directories", e);
            }
            ResourceSet resourceSet = new ResourceSetImpl();
            Resource resource;
            try {
                URI resourceUri = URI.createURI(f.toUri().toURL().toExternalForm());
                resource = resourceSet.createResource(resourceUri);
            } catch (MalformedURLException e2) {
                throw new UncheckedIOException(e2);
            }
            // Get the first model element and cast it to the right type, in my
            // example everything is hierarchical included in this first node
            resource.getContents().add(b.getBlockType());
            // now save the content.
            try {
                Map<Object, Object> options = new HashMap<>();
                options.put(XMIResource.OPTION_ENCODING, StandardCharsets.UTF_8.name());
                resource.save(options);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }

    private MicasModules readmodules(String path) {
        MicasModules fixed = null;
        try (InputStream is = Files.newInputStream(Paths.get(path), StandardOpenOption.READ)) {
            fixed = load(is);
        } catch (IOException e) {
            throw new UncheckedIOException("Creating block directories", e);
        }
        return fixed;
    }

    private void resolve(ResourceSet resourceSet) {
        EList<Resource> resources = resourceSet.getResources();
        for (int i = 0; i < resources.size(); ++i) {
            Resource resource = resources.get(i);
            for (Iterator<EObject> j = resource.getAllContents(); j.hasNext();) {
                EObject eObject = j.next();
                for (Iterator<EObject> k = eObject.eCrossReferences().iterator(); k.hasNext();) {
                    k.next();
                }
            }
        }
    }

    public static MicasModules load(InputStream is) throws IOException {

        // Initialize the model
        HwmodulesPackage.eINSTANCE.eClass();

        // Register the XMI resource factory for the .website extension

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("mods", new XMIResourceFactoryImpl());

        // Obtain a new resource set
        ResourceSet resSet = new ResourceSetImpl();

        // Get the resource
        Resource resource = resSet.createResource(URI.createURI("micasmodules.mods"));
        resource.load(is, Collections.emptyMap());
        // Get the first model element and cast it to the right type, in my
        // example everything is hierarchical included in this first node
        System.out.println("resource object count" + resource.getContents().size());
        MicasModules micasModules = (MicasModules) resource.getContents().get(0);

        return micasModules;

    }

    protected void saveHwModules(MicasModules micasModules, Path base) {
        TreeIterator<Object> treeit = EcoreUtil.getAllContents(micasModules, true);
        BasicEList<HardwareTypeDefinition> types = ECollections.newBasicEList();
        BasicEList<ModuleDefinition> modules = ECollections.newBasicEList();
        int tdid = HwmodulesPackage.eINSTANCE.getHardwareTypeDefinition().getClassifierID();
        int mdid = HwmodulesPackage.eINSTANCE.getModuleDefinition().getClassifierID();

        while (treeit.hasNext()) {
            EObject object = (EObject) treeit.next();
            if (tdid == object.eClass().getClassifierID()) {
                types.add((HardwareTypeDefinition) object);
            } else if (mdid == object.eClass().getClassifierID()) {
                modules.add((ModuleDefinition) object);
            }

        }
        for (HardwareTypeDefinition hwtd : types) {
            saveHwTypeDefs(base.resolve("types"), hwtd, hwtd.getType().getName(), "type.hw");
        }
        for (ModuleDefinition moduleDefinition : modules) {
            String groupId = moduleDefinition.getGroupId();
            String shortGroupId = groupId.substring(groupId.lastIndexOf('.') + 1);
            saveHwTypeDefs(base.resolve("blocks").resolve(shortGroupId), moduleDefinition, moduleDefinition.getName(),
                    "block.hw");
        }
        saveHwTypeDefs(base, micasModules, "hwmodules", "hw");
    }

    protected void saveHwTypeDefs(Path base, EObject model, String name, String ext) {

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> opts = reg.getExtensionToFactoryMap();
        opts.put(ext, new XMIResourceFactoryImpl());

        // Obtain a new resource set
        ResourceSet resSet = new ResourceSetImpl();
        try {
            Files.createDirectories(base);
        } catch (IOException e) {
            throw new UncheckedIOException("Creating block directories", e);
        }
        // create a resource
        Resource resource;
        try {
            URI categoryUri = URI
                    .createURI(base.resolve(String.format("%s.%s", name, ext)).toUri().toURL().toExternalForm());
            resource = resSet.createResource(categoryUri);
        } catch (MalformedURLException e2) {
            throw new UncheckedIOException(e2);
        }
        // Get the first model element and cast it to the right type, in my
        // example everything is hierarchical included in this first node
        resource.getContents().add(model);
        // now save the content.
        try {
            Map<Object, Object> options = new HashMap<>();
            options.put(XMIResource.OPTION_ENCODING, StandardCharsets.UTF_8.name());
            resource.save(options);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private Category saveCategoryXmi(Path base) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<dml:Category xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:dml=\"http://www.eclipselabs.org/damos/DML/1.0.0\" xmi:id=\"_9k-qII2PEd-xLIzFfuJVQQ\" qualifiedName=\"de::wisag::automation::micas::library::Block\">\n"
                + "  <parameters xsi:type=\"dml:ExpressionParameter\" xmi:id=\"_-McSwI2PEd-xLIzFfuJVQQ\" name=\"index\"/>\n"
                + "</dml:Category>\n" + "");

        Category category = fromXMI(Category.class, sb.toString());
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> opts = reg.getExtensionToFactoryMap();
        opts.put("category.dml", new XMIResourceFactoryImpl());

        // Obtain a new resource set
        ResourceSet resSet = new ResourceSetImpl();

        // create a resource
        Resource resource;
        try {
            URI categoryUri = URI.createURI(base.resolve("Block.category.dml").toUri().toURL().toExternalForm());
            resource = resSet.createResource(categoryUri);
        } catch (MalformedURLException e2) {
            throw new UncheckedIOException(e2);
        }
        // Get the first model element and cast it to the right type, in my
        // example everything is hierarchical included in this first node
        resource.getContents().add(category);

        // now save the content.
        try {
            resource.save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return category;
    }

    private <T> T fromXMI(Class<T> type, String xmi) {
        XMIResource resource = new XMIResourceImpl(URI.createURI("Block.category.dml"));
        Map<Object, Object> options = new HashMap<>();
        options.put(XMIResource.OPTION_ENCODING, StandardCharsets.UTF_8.name());
        try (InputStream inputStream = new ByteArrayInputStream(xmi.getBytes(StandardCharsets.UTF_8))) {
            resource.load(inputStream, options);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return type.cast(resource.getContents().get(0));
    }

    private String dumpInOut(int indent, InoutputDefinition definition) {
        String name = definition.getName();
        MicasDataTypeSpecification dataType = (MicasDataTypeSpecification) definition.getDataType();
        StringBuilder sb = new StringBuilder();
        sb.append(Strings.repeat(" ", indent));
        sb.append(dataType.getDataType().getName());
        sb.append(" ");
        sb.append(name);
        boolean manyPorts = definition.isManyPorts();
        if (manyPorts) {
            sb.append(" ").append("many").append(" defaultCount=").append(definition.getDefaultPortCount());
            sb.append(" ").append("min=").append(definition.getMinimumPortCount());
            sb.append(" ").append("max=").append(definition.getMaximumPortCount());
        }
        return sb.toString();
    }

    @Test
    public void checkBlocksToHwModulesPortMapping() {
        IHwModulesProvider hwModulesProvider = IHwModulesProvider.INSTANCE;
        hwModulesProvider.getMicasModules();

    }
}
