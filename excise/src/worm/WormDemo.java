package worm;

import java.util.Scanner;

public class WormDemo {
	public static void main(String[] args) {
		WormPanel pane = new WormPanel();
		
		Worm worm = pane.getWorm();
		Scanner in = new Scanner(System.in);
		while(true){
			pane.print();
			System.out.println(worm);
			String cmd = in.nextLine();
			if(cmd.equalsIgnoreCase("u")){
				worm.step(Worm.UP);
			}else if(cmd.equalsIgnoreCase("d")){
				worm.step(Worm.DOWN);
			} else if (cmd.equalsIgnoreCase("r")){
				worm.step(Worm.RIGHT);
			} else if(cmd.equalsIgnoreCase("l")){
				worm.step(Worm.LEFT);
			} else if (cmd.equalsIgnoreCase("q")){
				System.out.println("good bye!");
			} else {
				worm.step();
			}
			
		}
	}
}
