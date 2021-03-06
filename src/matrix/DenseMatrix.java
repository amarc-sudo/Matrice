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
		if(row < nRow ) {
			if(col < nCol) {
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
		if(row < nRow ) {
			if(col < nCol) {
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
	 * [0, 0]
	 * [0, 0]
	 */
	public String toString() {
		String matrix = new String();
		for(int row = 0 ; row < this.nRow ; row++ ) {
			matrix += "[ ";
			for(int col = 0 ; col < this.nCol ; col++) {
			matrix += vals[row][col] +", " ;
			}
			matrix += " ]\n";
		}
		
		return matrix;
	}
	/**
	 * A method for do the sum of two matrix with same dimension
	 * @param b
	 * @return
	 * @throws ExceptMatrix
	 */
	public DenseMatrix sum(DenseMatrix b) throws ExceptMatrix{
		if(b.getRowDimension() == this.getRowDimension() && b.getColDimension() == this.getColDimension()) {
			DenseMatrix returnMatrix = new DenseMatrix(this.nRow, this.nCol);
			for(int row = 0 ; row < this.nRow ; row++ ) {
				for(int col = 0 ; col < this.nCol ; col++) {
					returnMatrix.setElement(row, col, this.getElement(row, col)+b.getElement(row, col));
				}
			}
			return returnMatrix;
		}
		else
			throw new ExceptMatrix("The dimesion of the two matrix is not same");
	}
	/**
	 * substract matrix b to this matrix
	 * @param b
	 * @return
	 * @throws ExceptMatrix
	 */
	public DenseMatrix minus(DenseMatrix b) throws ExceptMatrix{
		if(b.getRowDimension() == this.getRowDimension() && b.getColDimension() == this.getColDimension()) {
			DenseMatrix returnMatrix = new DenseMatrix(this.nRow, this.nCol);
			for(int row = 0 ; row < this.nRow ; row++ ) {
				for(int col = 0 ; col < this.nCol ; col++) {
					returnMatrix.setElement(row, col, this.getElement(row, col)-b.getElement(row, col));
				}
			}
			return returnMatrix;
		}
		else
			throw new ExceptMatrix("The dimesion of the two matrix is not same");
	}
	/**
	 * method for multiply this matrice by a Scalaire
	 * @param s
	 * @return
	 * @throws ExceptMatrix
	 */
	public DenseMatrix mult(double s) throws ExceptMatrix {

		DenseMatrix returnMatrix = new DenseMatrix(this.nRow, this.nCol);
		for(int row = 0 ; row < this.nRow ; row++ ) {
			for(int col = 0 ; col < this.nCol ; col++) {
				returnMatrix.setElement(row, col, this.getElement(row, col)*s);
			}
		}
		return returnMatrix;
		
	}
	/**
	 * Transpose this matrix
	 * @return
	 * @throws ExceptMatrix
	 */
	public DenseMatrix transpose() throws ExceptMatrix {
		DenseMatrix returnMatrix = new DenseMatrix(this.nCol, this.nRow);
		for(int row = 0 ; row < this.nRow ; row++ ) {
			for(int col = 0 ; col < this.nCol ; col++) {
				returnMatrix.setElement(col, row, this.getElement(row, col));
			}
		}
		return returnMatrix;
		
	}
}
