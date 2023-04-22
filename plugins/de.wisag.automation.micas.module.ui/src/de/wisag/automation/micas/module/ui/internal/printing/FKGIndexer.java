package de.wisag.automation.micas.module.ui.internal.printing;

import static de.wisag.automation.micas.common.WellknownSpecialBlocks.FKG;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.util.DMLSwitch;

import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.util.ModuleUtil;
import de.wisag.automation.micas.module.util.Row;

public class FKGIndexer {
    private final Module module;

    public FKGIndexer(Module module) {
        super();
        this.module = module;
    }

    public Module getModule() {
        return module;
    }

    Multimap<Page, FKGDescription> buildIndex() {
        List<FKGDescription> fkgDescriptions = Lists.transform(indexFkgs(module),
                new Function<Block, FKGDescription>() {
                    @Override
                    public FKGDescription apply(Block block) {
                        String name = block.getName();
                        String priority = ModuleUtil.getArgumentValue(block, "index");
                        List<Row> supportingPoints = ModuleUtil.parseSupportingPoints(block);
                        return new FKGDescription(name, Integer.parseInt(priority), supportingPoints,
                                (Page) block.getEnclosingFragment());
                    }
                });
        final Multimap<Page, FKGDescription> result = ArrayListMultimap.create();
        for (FKGDescription fkgDescription : fkgDescriptions) {
            result.put(fkgDescription.getPage(), fkgDescription);
        }
        return result;
    }

    List<Block> indexFkgs(Module module) {
        final List<Block> fkgsByPage = Lists.newArrayList();
        TreeIterator<Object> allContents = EcoreUtil.getAllContents(module, true);
        DMLSwitch<Object> dmlSwitch = new DMLSwitch<Object>() {
            @Override
            public Object caseBlock(Block block) {
                if (FKG.equals(block.getType().getName())) {
                    fkgsByPage.add(block);
                }
                return null;
            };
        };
        while (allContents.hasNext()) {
            dmlSwitch.doSwitch((EObject) allContents.next());
        }
        return fkgsByPage;
    }

    public static Multimap<Page, FKGDescription> buildIndex(Module module) {
        return new FKGIndexer(module).buildIndex();
    }

}
