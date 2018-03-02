package psn.lotus.sys;

import org.junit.Test;
import org.springframework.asm.ClassWriter;
import org.springframework.asm.Opcodes;

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
