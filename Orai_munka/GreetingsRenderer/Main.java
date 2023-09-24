public class Main{
	
	public static void main(String[] arg){
		GreetingsGenerator generator = new GreetingsGenerator();
		RenderService renderer = new RenderService();
		System.out.println(renderer.render(generator.generateGreetings("Uram")));
	}
}
