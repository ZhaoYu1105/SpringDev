package dhome.spi;

public class MultiProcessor implements MessageProcessor {

	@Override
	public String getName() {
		return "Multi";
	}

	@Override
	public boolean processor() {
		return false;
	}

}
