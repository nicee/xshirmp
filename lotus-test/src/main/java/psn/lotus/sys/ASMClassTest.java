package psn.lotus.sys;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.junit.Test;

/**
 * @project lotus
 * @time 2016/10/24 11:18
 */
public class ASMClassTest {

    @Test
    public void asmGenerate() {
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE,
                "java/lang/String", null, "java/lang/String", new String[]{"java/lang/String"});

    }

}
