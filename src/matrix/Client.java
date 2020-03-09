package matrix;

public class Client {

	public static void main(String[] args) throws ExceptMatrix {
		// TODO Auto-generated method stub
		DenseMatrix matrice = new DenseMatrix(3,3);
		matrice.write();
		System.out.print(matrice.toString());
		System.out.print(matrice.sum(matrice).toString());
	}
}
