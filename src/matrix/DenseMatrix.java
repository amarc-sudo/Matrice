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
	 * Constructor get a array of vals
	 * @param vals
	 */
	public DenseMatrix(double[][] vals) {
		super();
		this.vals = vals;
		this.nRow = vals.length;
		this.nCol = vals[0].length;
	}
	/**
	 * Constructor for creating a matrix of 
	 * @param row
	 * @param col
	 */
	public DenseMatrix(int row, int col) {
		this.nRow = row;
		this.nCol = col;
		vals = new double[row][col];
	}
	
	/**
	 * get the row lenght
	 * @return
	 */
	public int getRowDimension() {
		return this.vals.length;
	}
	/**
	 * get the col lenght
	 * @return
	 */
	public int getColDimension() {
		return this.vals[0].length;
	}
	/**
	 * Get a element in a position row,col
	 * @param row
	 * @param col
	 * @return
	 * @throws ExceptMatrix
	 */
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
	/**
	 * Set a element in a position row, col
	 * @param row
	 * @param col
	 * @param number
	 * @throws ExceptMatrix
	 */
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
	/**
	 * Write a matrix whith terminal
	 */
	public void write() {
		for(int row = 0 ; row < this.nRow ; row++ ) {
			for(int col = 0 ; col < this.nCol ; col++) {
				System.out.println("Add a number for : row" + row + " col " + col);
				vals[row][col] = Clavier.lireFloat();
			}
		}
	}
	/**
	 * Return a string of format :
	 * 0, 0
	 * 0, 0
	 */
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
