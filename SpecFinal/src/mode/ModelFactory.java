package mode;

public class ModelFactory {
	public static Mode creatMode(int index) {
		switch (index) {
		case 0:
			return new SelectMode();
		case 1:
			return new AssociationMode();
		case 2:
			return new GeneralizationMode();
		case 3:
			return new CompositionMode();
		case 4:
			return new ClassMode();
		case 5:
			return new UseCaseMode();
		default:
			return null;
		}
	}
}
