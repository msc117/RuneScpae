package tasks;

import org.powerbot.script.methods.MethodProvider;
import org.powerbot.script.methods.MethodContext;

public abstract class Task extends MethodProvider {
	
	public Task(MethodContext ctx) {
		super(ctx);
	}
	
	public abstract boolean activate();
	public abstract void execute();
	
}
