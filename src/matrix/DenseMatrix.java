package matrix;

import utils.Clavier;

/**
 * @author amarc
 *
 */
public class DenseMatrix {

	private int nRow, nCol;
	private double vals[][];
	
	/**
	 * Method for create a new object
	 * @param void
	 */
	public DenseMatrix() {
		vals = new double[3][3];
		nRow = 3;
		nCol = 3;
	}
	
	
	/**
	 * 
	 * @param vals
	 */
	public DenseMatrix(double[][] vals) {
		super();
		this.vals = vals;
		this.nRow = vals.length;
		this.nCol = vals[0].length;
	}
	public DenseMatrix(int row, int col) {
		this.nRow = row;
		this.nCol = col;
		vals = new double[row][col];
	}
	
	public int getRowDimension() {
		return this.vals.length;
	}
	public int getColDimension() {
		return this.vals[0].length;
	}
	
	public double getElement(int row, int col) throws ExceptMatrix{
		if(row < nCol ) {
			if(row < nRow) {
				return vals[row][col];
			}
			else
				throw new ExceptMatrix("Row invalide");
		}
		else
			throw new ExceptMatrix("Col invalide");	
	}
	public void setElement(int row, int col, double number) throws ExceptMatrix{
		if(row < nCol ) {
			if(row < nRow) {
				vals[row][col] = number;
			}
			else
				throw new ExceptMatrix("Row invalide");
		}
		else
			throw new ExceptMatrix("Col invalide");	
	}
	
	public void write() {
		for(int row = 0 ; row < this.nRow ; row++ ) {
			for(int col = 0 ; col < this.nCol ; col++) {
				System.out.println("Add a number for : row" + row + " col " + col);
				vals[row][col] = Clavier.lireFloat();
			}
		}
	}
	
	public String toString() {
		String matrix = new String();
		for(int row = 0 ; row < this.nRow ; row++ ) {
			for(int col = 0 ; col < this.nCol ; col++) {
			matrix += vals[row][col] +", " ;
			}
			matrix += "\n";
		}
		
		return matrix;
	}
}
