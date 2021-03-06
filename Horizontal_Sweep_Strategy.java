import java.util.ArrayList;

public class Horizontal_Sweep_Strategy implements Search_Strategy{

	@Override
	public String toString() {
		return "Horizontal_Sweep_Strategy";
	}
	@Override
	public Results Search(Board board) {
		Results finals = new Results();
		ArrayList<Integer> carrierList = new ArrayList<>();
		ArrayList<Integer> subList = new ArrayList<>();
		int counter = 0;
		int counter2 = 0;
		for (int j = 0; j < board.getHeight(); j++) {
			for (int i = 0; i < board.getWidth(); i++) {
				if (board.Shot(i, j) == 1) {
					carrierList.add(i);
					carrierList.add(j);
					counter++;
				}
				if (board.Shot(i,  j) == 2) {
					subList.add(i);
					subList.add(j);
					counter++;
				}
				if (counter == 8) {
					break;
				}
				counter2++;
			}
		}
		carrierList = Sort_Method(carrierList);
		subList = Sort_Method(subList);
		finals.array[0] = carrierList.get(0);
		finals.array[1] = carrierList.get(1);
		finals.array[2] = carrierList.get(carrierList.size()-2);
		finals.array[3] = carrierList.get(carrierList.size()-1);
		finals.array[4] = subList.get(0);
		finals.array[5] = subList.get(1);
		finals.array[6] = subList.get(subList.size()-2);
		finals.array[7] = subList.get(subList.size()-1);
		finals.searched = counter2;
		return finals;
	}
	public ArrayList<Integer> Sort_Method (ArrayList<Integer> m) {
		int x1, y1, x2, y2;
		for(int i = 0; i < m.size()-2; i+=2) {
			for(int j = 2; j < m.size()-i; j+=2) {
				x1 = m.get(j-2);
				y1 = m.get(j-1);
				x2 = m.get(j);
				y2 = m.get(j+1);
				if(x2 < x1) {
					m.set(j-2, x2);
					m.set(j-1, y2);
					m.set(j, x1);
					m.set(j+1, y1);
				}
				else if(x2 == x1) {
					
					if(y2 < y1) {
						m.set(j-2, x2);
						m.set(j-1, y2);
						m.set(j, x1);
						m.set(j+1, y1);
					}
				}
			}
		}
		return m;
	}
}
