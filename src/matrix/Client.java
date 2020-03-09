package matrix;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DenseMatrix matrice = new DenseMatrix(3,3);
		matrice.write();
		System.out.print(matrice.toString());
	}

}
