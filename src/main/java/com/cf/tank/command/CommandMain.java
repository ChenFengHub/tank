package com.cf.tank.command;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-09-02 07:07:54
 */
public class CommandMain {
    public static void main(String[] args) {
        Content content =  new Content("my name is cf");
        Command insertCommand = new InsertCommand(content);
        insertCommand.commit();
        insertCommand.callback();

        DeleteCommand deleteCommand = new DeleteCommand(content);
        deleteCommand.commit();
        deleteCommand.callback();
    }
}
class Content {
    String msg;
    public Content(String msg) {
        this.msg = msg;
    }
}
abstract class Command {
    public abstract void commit();
    public abstract void callback();
}
class InsertCommand extends Command {
    Content c;
    String strToInsert = "I insert";
    public InsertCommand(Content c) {
        this.c = c;
    }
    @Override
    public void commit() {
        c.msg = c.msg + strToInsert;
        System.out.println("res:" + c.msg);
    }
    @Override
    public void callback() {
        c.msg = c.msg.substring(0, c.msg.length() - strToInsert.length());
        System.out.println("res:" + c.msg);
    }
}
class DeleteCommand extends Command {
    Content c;
    String strToDelete;
    public DeleteCommand(Content c) {
        this.c = c;
    }
    @Override
    public void commit() {
        strToDelete = c.msg.substring(0, 5);
        c.msg = c.msg.substring(5, c.msg.length());
        System.out.println("res:" + c.msg);
    }
    @Override
    public void callback() {
        c.msg = strToDelete + c.msg;
        System.out.println("res:" + c.msg);
    }
}
