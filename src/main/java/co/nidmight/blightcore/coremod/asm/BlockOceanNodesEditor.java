package co.nidmight.blightcore.coremod.asm;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.IFEQ;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.RETURN;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class BlockOceanNodesEditor implements IAsmEditor {

    @Override
    public void edit(MethodNode method) {
        AbstractInsnNode firstInstruction = method.instructions.getFirst();

        method.instructions.insertBefore(firstInstruction, new VarInsnNode(ALOAD, 0));
        method.instructions.insertBefore(firstInstruction, new VarInsnNode(ILOAD, 1));
        method.instructions.insertBefore(firstInstruction, new VarInsnNode(ILOAD, 3));
        MethodInsnNode methodInstruction = new MethodInsnNode(
            INVOKESTATIC,
            "co/nidmight/blightcore/support/ThaumcraftAsmSupport",
            "checkNodeSpawnBiome",
            "(Lnet/minecraft/world/World;II)Z",
            false);
        method.instructions.insertBefore(firstInstruction, methodInstruction);

        LabelNode returnToMethod = new LabelNode();
        method.instructions.insertBefore(firstInstruction, new JumpInsnNode(IFEQ, returnToMethod));
        method.instructions.insertBefore(firstInstruction, new InsnNode(RETURN));
        method.instructions.insertBefore(firstInstruction, returnToMethod);
    }

    @Override
    public String getClassName() {
        return "thaumcraft.common.lib.world.ThaumcraftWorldGenerator";
    }

    @Override
    public String getMethodName() {
        return "createRandomNodeAt";
    }

    @Override
    public String getMethodDesc() {
        return "(Lnet/minecraft/world/World;IIILjava/util/Random;ZZZ)V";
    }
}
