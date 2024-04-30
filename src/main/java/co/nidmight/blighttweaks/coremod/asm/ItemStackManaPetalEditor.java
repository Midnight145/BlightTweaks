package co.nidmight.blighttweaks.coremod.asm;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class ItemStackManaPetalEditor implements IAsmEditor {

    private boolean isObfuscated = false;
    private String nbtSymbol = "";

    public ItemStackManaPetalEditor(boolean isObfuscated) {
        this.isObfuscated = isObfuscated;
        this.nbtSymbol = getCorrectSymbol("net/minecraft/nbt/NBTTagCompound", "dh");
    }

    @Override
    public void edit(MethodNode method) {
        AbstractInsnNode firstInstruction = method.instructions.getFirst();
        if (firstInstruction == null) {
            throw new RuntimeException("BlightCore failed to find an injection point to remap mana petals.");
        }
        method.instructions.insertBefore(firstInstruction, new VarInsnNode(ALOAD, 1));
        MethodInsnNode methodInstruction = new MethodInsnNode(
            INVOKESTATIC,
            "co/nidmight/blighttweaks/coremod/support/ManaPetalRemapSupport",
            "remapManaPetal",
            "(L" + nbtSymbol + ";)V",
            false);
        method.instructions.insertBefore(firstInstruction, methodInstruction);

    }

    @Override
    public String getClassName() {
        return "net.minecraft.item.ItemStack";
    }

    @Override
    public String getMethodName() {
        return getCorrectSymbol("readFromNBT", "c");
    }

    @Override
    public String getMethodDesc() {
        return "(L" + nbtSymbol + ";)V";
    }

    private String getCorrectSymbol(String deobfuscated, String obfuscated) {
        return isObfuscated ? obfuscated : deobfuscated;
    }
}
