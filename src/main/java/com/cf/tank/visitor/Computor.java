package com.cf.tank.visitor;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-30 07:07:40
 */
public class Computor {
    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void accept(Visitor v) {
        this.cpu.accept(v);
        this.memory.accept(v);
        this.board.accept(v);
    }
    public double totalPrice() {
        return cpu.getPrice() + memory.getPrice() + board.getPrice();
    }

    public static void main(String[] args) {
        Computor computor = new Computor();
        PersonalVisitor p = new PersonalVisitor();
        computor.accept(p);
        System.out.println("个人购买电脑打折后的价格：" + p.totalPrice);

        CorpVisitor c = new CorpVisitor();
        computor.accept(c);
        System.out.println("企业用户购买电脑打折后的价格：" + c.totalPrice);
        System.out.println("原价：" + computor.totalPrice());
    }

}
abstract class ComputerPart {
    abstract void accept(Visitor v);
    abstract double getPrice();
}
class CPU extends ComputerPart {

    @Override
    void accept(Visitor v) {
        v.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}
class Memory extends ComputerPart {

    @Override
    void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}
class Board extends ComputerPart {

    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 100;
    }
}

interface Visitor {
    void visitCpu(CPU cpu);
    void visitMemory(Memory memory);
    void visitBoard(Board board);
}

class PersonalVisitor implements Visitor {
    double totalPrice = 0.0;

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.9;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.95;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice() * 0.95;
    }
}

class CorpVisitor implements Visitor {
    double totalPrice = 0.0;

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.6;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.65;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice() * 0.75;
    }
}