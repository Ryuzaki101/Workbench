package de.wisag.automation.micas.module.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.dml.registry.BlockTypeRegistry;
import org.eclipselabs.damos.dml.registry.IBlockTypeDescriptor;

public class BlockTypeDescriptorCache {
    private static BlockTypeDescriptorCache _instance = null;

    private static Map<String, IBlockTypeDescriptor> indexDescriptors(BlockTypeRegistry registry) {
        Map<String, IBlockTypeDescriptor> descriptorsByName = new HashMap<>();

        Collection<IBlockTypeDescriptor> descriptors = registry.getDescriptors();
        for (IBlockTypeDescriptor descriptor : descriptors) {
            descriptorsByName.put(descriptor.getName(), descriptor);
        }
        return descriptorsByName;
    }

    private Map<String, IBlockTypeDescriptor> descriptorsByName;

    public Collection<String> allNames() {
        return Collections.unmodifiableCollection(descriptorsByName.keySet());
    }

    public static synchronized BlockTypeDescriptorCache getInstance() {
        if (_instance == null) {
            synchronized (BlockTypeDescriptorCache.class) {
                _instance = new BlockTypeDescriptorCache();
                BlockTypeRegistry registry = BlockTypeRegistry.getInstance();
                _instance.descriptorsByName = indexDescriptors(registry);
            }
        }
        return _instance;
    }

    public static IBlockTypeDescriptor findBlockTypeDescriptor(String name) {
        return getInstance().descriptorsByName.get(name);
    }
}
