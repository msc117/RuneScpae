package tasks;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Item;

public class Burn extends Task {
	private int treeId;
	public Burn(MethodContext ctx, int inputId) {
		super(ctx);
		treeId = inputId;
	}
	
	@Override
	public boolean activate() {
		//code to check if possible
		return !ctx.backpack.select().id(treeId).isEmpty() && ctx.players.local().getAnimation() != -1;
	}
	
	@Override
	public void execute() {
		//code to execute burn
		for(Item i : ctx.backpack.id(treeId)) {
			i.interact("Light");
			sleep(200);
		}
	}
}
