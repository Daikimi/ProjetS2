import java.util.Iterator;

/**
 * @author "2103-Team"
 *
 */
public class PlateauIterator implements Iterator<Integer>{
	
	private int lg,col;
	private int[][] tableau;
	
	
	PlateauIterator(int[][] tableau){
		this.tableau=tableau;
		lg=tableau.length-1;
		col=tableau[0].length-1;
	}
	public boolean hasNext() {
		return (lg+col>0);
	}

	public Integer next() {	
		if (col>0) col--; else {lg--;col=tableau[0].length-1;}
		return tableau[lg][col];
	}
	@Override
	public void remove() {		
	}
	
}
