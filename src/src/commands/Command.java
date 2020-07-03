package src.commands;

public interface Command {

    public void Execute(String ... args) throws Exception;
}
