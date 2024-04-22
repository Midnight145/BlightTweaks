package co.nidmight.blightcore.coremod.asm;

import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.IRETURN;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;

public class AWDisableChiselCompatEditor implements IAsmEditor {

    @Override
    public void edit(MethodNode method) {

        // Thanks to @SarahK#3425 for working on this, saved me a ton of time and
        // frustration.
        // This patch fixes a crash with the latest Blood Magic causing a conflict with
        // Chisel, which can't be updated for other reasons.

        AbstractInsnNode firstInstruction = method.instructions.getFirst();

        method.instructions.insertBefore(firstInstruction, new InsnNode(ICONST_0));
        method.instructions.insertBefore(firstInstruction, new InsnNode(IRETURN));
    }

    @Override
    public String getClassName() {
        return "WayofTime.alchemicalWizardry.common.bloodAltarUpgrade.CompatChecks";
    }

    @Override
    public String getMethodName() {
        return "checkChiselBlock";
    }

    @Override
    public String getMethodDesc() {
        return "(LWayofTime/alchemicalWizardry/api/BlockStack;Ljava/lang/String;)Z";
    }

}
