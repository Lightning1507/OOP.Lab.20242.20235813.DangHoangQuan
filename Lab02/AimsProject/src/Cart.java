
public class Cart {
	private int qtyOrdered=0; 
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered<MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++; 
			System.out.println("The disc has been added");
		}
		else System.out.println("The cart is almost full");
	}
	// Cach 1
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc has been added");
            } else {
                System.out.println("The cart is almost full");
                break;
            }
        }
    }
    
	// Cach 2
//    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
//        for (DigitalVideoDisc disc : dvds) {
//            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
//                itemsOrdered[qtyOrdered] = disc;
//                qtyOrdered++;
//                System.out.println("The disc has been added");
//            } else {
//                System.out.println("The cart is almost full");
//                break; 
//            }
//        }
//    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1); 
        addDigitalVideoDisc(dvd2);
    }
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int idx = -1; 
		for (int i=0;i<qtyOrdered;++i) {
			if (itemsOrdered[i].equals(disc)) {
				idx=i;
				break;
			}
		}
		if (idx!=-1) {
			for (int i=idx; i<qtyOrdered-1;++i) {
				itemsOrdered[i] = itemsOrdered[i+1];
			}
			itemsOrdered[qtyOrdered-1]=null;
			qtyOrdered--;
			System.out.println("The disc has been removed");
		}
		else {
			System.out.println("The disc is not found in the cart");
		}
	}
	public float totalCost() {
		float sum=0;
		for (int i=0;i<qtyOrdered;++i) {
			sum+=itemsOrdered[i].getCost();
		}
		return sum;
	}
	public void getDetail() {
		System.out.println("The current cart: ");
		for (int i=0;i<qtyOrdered;++i) {
			System.out.print(itemsOrdered[i].getTitle());
			System.out.print(", ");
			System.out.print(itemsOrdered[i].getCategory()); 
			System.out.print(", ");
			System.out.print(itemsOrdered[i].getDirector()); 
			System.out.print(", ");
			System.out.print(itemsOrdered[i].getLength()); 
			System.out.print(", ");
			System.out.print(itemsOrdered[i].getCost()); 
			System.out.println();
		}
	}
}
