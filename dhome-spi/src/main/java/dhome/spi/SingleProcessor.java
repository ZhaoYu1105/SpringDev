package dhome.spi;

public class SingleProcessor implements MessageProcessor {

	@Override
	public String getName() {
		return "Single";
	}

	@Override
	public boolean processor() {
		return false;
	}

}
