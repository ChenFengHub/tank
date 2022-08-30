package com.cf.tank.ASM;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-30 21:21:24
 */
public class ClassTransformer {
    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("com/cf/tank/ASM/Tank.class"));
        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ClassVisitor(ASM4, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                return new MethodVisitor(ASM4, mv) {
                    @Override
                    public void visitCode() {
                        // INVOKESTATIC-静态调用；对应类：TimeProxy；类里的方法：before；传参：()v；是否接口：否
                        // 加在前面，就是前置通知。AOP 就是通过 ASM 如此实现
                        visitMethodInsn(INVOKESTATIC, "TimeProxy", "before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };

        cr.accept(cv, 0);
        byte[] b2 = cw.toByteArray(); // b2 represents the same class as b1

        writeByteToDisk(b2);
    }

    public static void writeByteToDisk(byte[] b2) throws IOException {
        String path = (String) System.getProperties().get("user.dir");
        File f = new File(path + "/com/cf/tank/ASM/");
        f.mkdir();

        FileOutputStream fos = new FileOutputStream(new File(path + "/com/cf/tank/ASM/Tank_0.class"));
        fos.write(b2);
        fos.flush();
        fos.close();
    }
}
