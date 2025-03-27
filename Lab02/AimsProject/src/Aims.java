
public class Aims {
	public static void main (String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		anOrder.getDetail();
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction","George Lucas",87,24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		anOrder.getDetail();
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation",18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		anOrder.getDetail();
		
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		
		anOrder.getDetail();
		
		anOrder.removeDigitalVideoDisc(dvd3);
		anOrder.getDetail();
	}
}
