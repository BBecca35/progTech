import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;

public class RenderService{
	
	public String render(final String text){
		
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(90).height(15);
		builder.element(new PseudoText(text));
		ICanvas canvas = render.render(builder.build());
		return canvas.getText();
		
		
	}	
}